package cn.iocoder.yudao.module.kpi.controller.admin.assessstaffitem;

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

import cn.iocoder.yudao.module.kpi.controller.admin.assessstaffitem.vo.*;
import cn.iocoder.yudao.module.kpi.dal.dataobject.assessstaffitem.AssessStaffItemDO;
import cn.iocoder.yudao.module.kpi.convert.assessstaffitem.AssessStaffItemConvert;
import cn.iocoder.yudao.module.kpi.service.assessstaffitem.AssessStaffItemService;

@Tag(name = "管理后台 - 考核评分")
@RestController
@RequestMapping("/kpi/assess-staff-item")
@Validated
public class AssessStaffItemController {

    @Resource
    private AssessStaffItemService assessStaffItemService;

    @PostMapping("/create")
    @Operation(summary = "创建考核评分")
    @PreAuthorize("@ss.hasPermission('kpi:assess-staff-item:create')")
    public CommonResult<Long> createAssessStaffItem(@Valid @RequestBody AssessStaffItemCreateReqVO createReqVO) {
        return success(assessStaffItemService.createAssessStaffItem(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新考核评分")
    @PreAuthorize("@ss.hasPermission('kpi:assess-staff-item:update')")
    public CommonResult<Boolean> updateAssessStaffItem(@Valid @RequestBody AssessStaffItemUpdateReqVO updateReqVO) {
        assessStaffItemService.updateAssessStaffItem(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除考核评分")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('kpi:assess-staff-item:delete')")
    public CommonResult<Boolean> deleteAssessStaffItem(@RequestParam("id") Long id) {
        assessStaffItemService.deleteAssessStaffItem(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得考核评分")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('kpi:assess-staff-item:query')")
    public CommonResult<AssessStaffItemRespVO> getAssessStaffItem(@RequestParam("id") Long id) {
        AssessStaffItemDO assessStaffItem = assessStaffItemService.getAssessStaffItem(id);
        return success(AssessStaffItemConvert.INSTANCE.convert(assessStaffItem));
    }

    @GetMapping("/list")
    @Operation(summary = "获得考核评分列表")
    @Parameter(name = "ids", description = "编号列表", required = true, example = "1024,2048")
    @PreAuthorize("@ss.hasPermission('kpi:assess-staff-item:query')")
    public CommonResult<List<AssessStaffItemRespVO>> getAssessStaffItemList(@Valid AssessStaffItemListReqVO itemListReqVO) {
        List<AssessStaffItemDO> list = assessStaffItemService.getselectItemList(itemListReqVO);
        return success(AssessStaffItemConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @Operation(summary = "获得考核评分分页")
    @PreAuthorize("@ss.hasPermission('kpi:assess-staff-item:query')")
    public CommonResult<PageResult<AssessStaffItemRespVO>> getAssessStaffItemPage(@Valid AssessStaffItemPageReqVO pageVO) {
        PageResult<AssessStaffItemDO> pageResult = assessStaffItemService.getAssessStaffItemPage(pageVO);
        return success(AssessStaffItemConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出考核评分 Excel")
    @PreAuthorize("@ss.hasPermission('kpi:assess-staff-item:export')")
    @OperateLog(type = EXPORT)
    public void exportAssessStaffItemExcel(@Valid AssessStaffItemExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<AssessStaffItemDO> list = assessStaffItemService.getAssessStaffItemList(exportReqVO);
        // 导出 Excel
        List<AssessStaffItemExcelVO> datas = AssessStaffItemConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "考核评分.xls", "数据", AssessStaffItemExcelVO.class, datas);
    }

}
