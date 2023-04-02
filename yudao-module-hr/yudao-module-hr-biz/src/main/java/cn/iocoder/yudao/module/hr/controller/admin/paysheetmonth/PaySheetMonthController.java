package cn.iocoder.yudao.module.hr.controller.admin.paysheetmonth;

import cn.iocoder.yudao.framework.common.enums.CommonStatusEnum;
import cn.iocoder.yudao.module.hr.controller.admin.paysheetbase.vo.PaySheetBaseCreateReqVO;
import cn.iocoder.yudao.module.hr.dal.dataobject.paysheetbase.PaySheetBaseDO;
import cn.iocoder.yudao.module.hr.service.paysheetbase.PaySheetBaseService;
import cn.iocoder.yudao.module.system.dal.dataobject.user.AdminUserDO;
import cn.iocoder.yudao.module.system.service.dept.DeptService;
import cn.iocoder.yudao.module.system.service.user.AdminUserService;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Operation;

import javax.validation.constraints.*;
import javax.validation.*;
import javax.servlet.http.*;
import java.math.BigDecimal;
import java.util.*;
import java.io.IOException;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

import cn.iocoder.yudao.framework.excel.core.util.ExcelUtils;

import cn.iocoder.yudao.framework.operatelog.core.annotations.OperateLog;
import static cn.iocoder.yudao.framework.operatelog.core.enums.OperateTypeEnum.*;

import cn.iocoder.yudao.module.hr.controller.admin.paysheetmonth.vo.*;
import cn.iocoder.yudao.module.hr.dal.dataobject.paysheetmonth.PaySheetMonthDO;
import cn.iocoder.yudao.module.hr.convert.paysheetmonth.PaySheetMonthConvert;
import cn.iocoder.yudao.module.hr.service.paysheetmonth.PaySheetMonthService;

@Tag(name = "管理后台 - 月工资")
@RestController
@RequestMapping("/hr/pay-sheet-month")
@Validated
public class PaySheetMonthController {

    @Resource
    private PaySheetMonthService paySheetMonthService;

    @Resource
    private PaySheetBaseService paySheetBaseService;
    @Resource
    private AdminUserService userService;

    @Resource
    private DeptService deptService;
    @PostMapping("/create")
    @Operation(summary = "创建月工资")
    @PreAuthorize("@ss.hasPermission('hr:pay-sheet-month:create')")
    public CommonResult<Boolean> createPaySheetMonth(/*@Valid @RequestBody PaySheetMonthCreateReqVO createReqVO*/) {
        Calendar now = Calendar.getInstance();
        PaySheetMonthCreateReqVO createReqVO=new PaySheetMonthCreateReqVO();
        for (PaySheetBaseDO paySheetBaseDO : paySheetBaseService.getPaySheetBaseListAll()) {
            createReqVO.setWageName(now.get(Calendar.YEAR)+"年"+(now.get(Calendar.MONTH) + 1) + "月");
            createReqVO.setNickname(userService.getUser(paySheetBaseDO.getUserId()).getNickname());
            createReqVO.setDeptName(deptService.getDept(paySheetBaseDO.getDeptId()).getName());
            createReqVO.setBasePay(paySheetBaseDO.getBasePay());
            createReqVO.setMeritPay(paySheetBaseDO.getMeritPay());
            createReqVO.setOvertimePay(paySheetBaseDO.getOvertimePay());
            createReqVO.setHightemperatureSubsidy(paySheetBaseDO.getHightemperatureSubsidy());
            createReqVO.setAllowance(paySheetBaseDO.getAllowance());
            createReqVO.setLunchSubsides(paySheetBaseDO.getLunchSubsides());
            createReqVO.setPersonalLeave(paySheetBaseDO.getPersonalLeave());
            createReqVO.setSickLeave(paySheetBaseDO.getSickLeave());
            createReqVO.setRests(paySheetBaseDO.getRests());
            createReqVO.setHousingFund(paySheetBaseDO.getHousingFund());
            createReqVO.setOldageInsurance(paySheetBaseDO.getOldageInsurance());
            createReqVO.setMedicalInsurance(paySheetBaseDO.getMedicalInsurance());
            createReqVO.setUnemploymentInsurance(paySheetBaseDO.getUnemploymentInsurance());
            createReqVO.setNjuryInsurance(paySheetBaseDO.getNjuryInsurance());
            paySheetMonthService.createPaySheetMonth(createReqVO);
        }
        return success(true);
    }

    @PutMapping("/update")
    @Operation(summary = "更新月工资")
    @PreAuthorize("@ss.hasPermission('hr:pay-sheet-month:update')")
    public CommonResult<Boolean> updatePaySheetMonth(@Valid @RequestBody PaySheetMonthUpdateReqVO updateReqVO) {
        paySheetMonthService.updatePaySheetMonth(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除月工资")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('hr:pay-sheet-month:delete')")
    public CommonResult<Boolean> deletePaySheetMonth(@RequestParam("id") Long id) {
        paySheetMonthService.deletePaySheetMonth(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得月工资")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('hr:pay-sheet-month:query')")
    public CommonResult<PaySheetMonthRespVO> getPaySheetMonth(@RequestParam("id") Long id) {
        PaySheetMonthDO paySheetMonth = paySheetMonthService.getPaySheetMonth(id);
        return success(PaySheetMonthConvert.INSTANCE.convert(paySheetMonth));
    }

    @GetMapping("/list")
    @Operation(summary = "获得月工资列表")
    @Parameter(name = "ids", description = "编号列表", required = true, example = "1024,2048")
    @PreAuthorize("@ss.hasPermission('hr:pay-sheet-month:query')")
    public CommonResult<List<PaySheetMonthRespVO>> getPaySheetMonthList(@RequestParam("ids") Collection<Long> ids) {
        List<PaySheetMonthDO> list = paySheetMonthService.getPaySheetMonthList(ids);
        return success(PaySheetMonthConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @Operation(summary = "获得月工资分页")
    @PreAuthorize("@ss.hasPermission('hr:pay-sheet-month:query')")
    public CommonResult<PageResult<PaySheetMonthRespVO>> getPaySheetMonthPage(@Valid PaySheetMonthPageReqVO pageVO) {
        PageResult<PaySheetMonthDO> pageResult = paySheetMonthService.getPaySheetMonthPage(pageVO);
        return success(PaySheetMonthConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出月工资 Excel")
    @PreAuthorize("@ss.hasPermission('hr:pay-sheet-month:export')")
    @OperateLog(type = EXPORT)
    public void exportPaySheetMonthExcel(@Valid PaySheetMonthExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<PaySheetMonthDO> list = paySheetMonthService.getPaySheetMonthList(exportReqVO);
        // 导出 Excel
        List<PaySheetMonthExcelVO> datas = PaySheetMonthConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "月工资.xls", "数据", PaySheetMonthExcelVO.class, datas);
    }

}
