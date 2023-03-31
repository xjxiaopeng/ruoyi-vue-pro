package cn.iocoder.yudao.module.hr.controller.admin.paysheetbase;

import cn.iocoder.yudao.framework.common.enums.CommonStatusEnum;
import cn.iocoder.yudao.framework.excel.core.util.ExcelUtils;
import cn.iocoder.yudao.module.system.dal.dataobject.user.AdminUserDO;
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

import cn.iocoder.yudao.framework.operatelog.core.annotations.OperateLog;

import static cn.iocoder.yudao.framework.operatelog.core.enums.OperateTypeEnum.*;

import cn.iocoder.yudao.module.hr.controller.admin.paysheetbase.vo.*;
import cn.iocoder.yudao.module.hr.dal.dataobject.paysheetbase.PaySheetBaseDO;
import cn.iocoder.yudao.module.hr.convert.paysheetbase.PaySheetBaseConvert;
import cn.iocoder.yudao.module.hr.service.paysheetbase.PaySheetBaseService;

@Tag(name = "管理后台 - 工资基础")
@RestController
@RequestMapping("/hr/pay-sheet-base")
@Validated
public class PaySheetBaseController {

    @Resource
    private PaySheetBaseService paySheetBaseService;

    @Resource
    private AdminUserService userService;

    @PostMapping("/create")
    @Operation(summary = "创建工资基础")
    @PreAuthorize("@ss.hasPermission('hr:pay-sheet-base:create')")
    public CommonResult<Boolean> createPaySheetBase(/*@Valid @RequestBody PaySheetBaseCreateReqVO createReqVO*/) {
        PaySheetBaseCreateReqVO createReqVO=new PaySheetBaseCreateReqVO();
        List<AdminUserDO> userListByStatus = userService.getUserListByStatus(CommonStatusEnum.ENABLE.getStatus());
        for (AdminUserDO adminUserDO : userListByStatus) {
            //for (AdminUserDO userDO : userService.getUserListByNickname(adminUserDO.getNickname())) {
                if (!adminUserDO.getUsername().equals("admin")) {
                    createReqVO.setUserId(adminUserDO.getId());
                    createReqVO.setDeptId(adminUserDO.getDeptId());
                    createReqVO.setNickname(adminUserDO.getNickname());
                    createReqVO.setBasePay(BigDecimal.valueOf(0));
                    createReqVO.setMeritPay(BigDecimal.valueOf(0));
                    createReqVO.setOvertimePay(BigDecimal.valueOf(0));
                    createReqVO.setHightemperatureSubsidy(BigDecimal.valueOf(0));
                    createReqVO.setAllowance(BigDecimal.valueOf(0));
                    createReqVO.setLunchSubsides(BigDecimal.valueOf(0));
                    createReqVO.setPersonalLeave(BigDecimal.valueOf(0));
                    createReqVO.setSickLeave(BigDecimal.valueOf(0));
                    createReqVO.setRests(BigDecimal.valueOf(0));
                    createReqVO.setHousingFund(BigDecimal.valueOf(0));
                    createReqVO.setOldageInsurance(BigDecimal.valueOf(0));
                    createReqVO.setMedicalInsurance(BigDecimal.valueOf(0));
                    createReqVO.setUnemploymentInsurance(BigDecimal.valueOf(0));
                    createReqVO.setNjuryInsurance(BigDecimal.valueOf(0));
                    paySheetBaseService.createPaySheetBase(createReqVO);
                }

            }

        //}
        return success(true);
    }

    @PutMapping("/update")
    @Operation(summary = "更新工资基础")
    @PreAuthorize("@ss.hasPermission('hr:pay-sheet-base:update')")
    public CommonResult<Boolean> updatePaySheetBase(@Valid @RequestBody PaySheetBaseUpdateReqVO updateReqVO) {
        paySheetBaseService.updatePaySheetBase(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除工资基础")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('hr:pay-sheet-base:delete')")
    public CommonResult<Boolean> deletePaySheetBase(@RequestParam("id") Long id) {
        paySheetBaseService.deletePaySheetBase(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得工资基础")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('hr:pay-sheet-base:query')")
    public CommonResult<PaySheetBaseRespVO> getPaySheetBase(@RequestParam("id") Long id) {
        PaySheetBaseDO paySheetBase = paySheetBaseService.getPaySheetBase(id);
        return success(PaySheetBaseConvert.INSTANCE.convert(paySheetBase));
    }

    @GetMapping("/list")
    @Operation(summary = "获得工资基础列表")
    @Parameter(name = "ids", description = "编号列表", required = true, example = "1024,2048")
    @PreAuthorize("@ss.hasPermission('hr:pay-sheet-base:query')")
    public CommonResult<List<PaySheetBaseRespVO>> getPaySheetBaseList(@RequestParam("ids") Collection<Long> ids) {
        List<PaySheetBaseDO> list = paySheetBaseService.getPaySheetBaseList(ids);
        return success(PaySheetBaseConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @Operation(summary = "获得工资基础分页")
    @PreAuthorize("@ss.hasPermission('hr:pay-sheet-base:query')")
    public CommonResult<PageResult<PaySheetBaseRespVO>> getPaySheetBasePage(@Valid PaySheetBasePageReqVO pageVO) {
        PageResult<PaySheetBaseDO> pageResult = paySheetBaseService.getPaySheetBasePage(pageVO);
        return success(PaySheetBaseConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出工资基础 Excel")
    @PreAuthorize("@ss.hasPermission('hr:pay-sheet-base:export')")
    @OperateLog(type = EXPORT)
    public void exportPaySheetBaseExcel(@Valid PaySheetBaseExportReqVO exportReqVO,
                                        HttpServletResponse response) throws IOException {
        List<PaySheetBaseDO> list = paySheetBaseService.getPaySheetBaseList(exportReqVO);
        // 导出 Excel
        List<PaySheetBaseExcelVO> datas = PaySheetBaseConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "工资基础.xls", "数据", PaySheetBaseExcelVO.class, datas);
    }

}
