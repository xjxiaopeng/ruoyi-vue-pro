package cn.iocoder.yudao.module.kpi.controller.admin.assessstore;

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
import java.util.*;
import java.io.IOException;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

import cn.iocoder.yudao.framework.excel.core.util.ExcelUtils;

import cn.iocoder.yudao.framework.operatelog.core.annotations.OperateLog;
import static cn.iocoder.yudao.framework.operatelog.core.enums.OperateTypeEnum.*;

import cn.iocoder.yudao.module.kpi.controller.admin.assessstore.vo.*;
import cn.iocoder.yudao.module.kpi.dal.dataobject.assessstore.AssessStoreDO;
import cn.iocoder.yudao.module.kpi.convert.assessstore.AssessStoreConvert;
import cn.iocoder.yudao.module.kpi.service.assessstore.AssessStoreService;

@Tag(name = "管理后台 - 考核指标库")
@RestController
@RequestMapping("/kpi/assess-store")
@Validated
public class AssessStoreController {

    @Resource
    private AssessStoreService assessStoreService;

    @PostMapping("/create")
    @Operation(summary = "创建考核指标库")
    @PreAuthorize("@ss.hasPermission('kpi:assess-store:create')")
    public CommonResult<Long> createAssessStore(@Valid @RequestBody AssessStoreCreateReqVO createReqVO) {
        return success(assessStoreService.createAssessStore(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新考核指标库")
    @PreAuthorize("@ss.hasPermission('kpi:assess-store:update')")
    public CommonResult<Boolean> updateAssessStore(@Valid @RequestBody AssessStoreUpdateReqVO updateReqVO) {
        assessStoreService.updateAssessStore(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除考核指标库")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('kpi:assess-store:delete')")
    public CommonResult<Boolean> deleteAssessStore(@RequestParam("id") Long id) {
        assessStoreService.deleteAssessStore(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得考核指标库")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('kpi:assess-store:query')")
    public CommonResult<AssessStoreRespVO> getAssessStore(@RequestParam("id") Long id) {
        AssessStoreDO assessStore = assessStoreService.getAssessStore(id);
        return success(AssessStoreConvert.INSTANCE.convert(assessStore));
    }

    @GetMapping("/list")
    @Operation(summary = "获得考核指标库列表")
    @Parameter(name = "ids", description = "编号列表", required = true, example = "1024,2048")
    @PreAuthorize("@ss.hasPermission('kpi:assess-store:query')")
    public CommonResult<List<AssessStoreRespVO>> getAssessStoreList(@RequestParam("ids") Collection<Long> ids) {
        List<AssessStoreDO> list = assessStoreService.getAssessStoreList(ids);
        return success(AssessStoreConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @Operation(summary = "获得考核指标库分页")
    @PreAuthorize("@ss.hasPermission('kpi:assess-store:query')")
    public CommonResult<PageResult<AssessStoreRespVO>> getAssessStorePage(@Valid AssessStorePageReqVO pageVO) {
        PageResult<AssessStoreDO> pageResult = assessStoreService.getAssessStorePage(pageVO);
        return success(AssessStoreConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出考核指标库 Excel")
    @PreAuthorize("@ss.hasPermission('kpi:assess-store:export')")
    @OperateLog(type = EXPORT)
    public void exportAssessStoreExcel(@Valid AssessStoreExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<AssessStoreDO> list = assessStoreService.getAssessStoreList(exportReqVO);
        // 导出 Excel
        List<AssessStoreExcelVO> datas = AssessStoreConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "考核指标库.xls", "数据", AssessStoreExcelVO.class, datas);
    }

}
