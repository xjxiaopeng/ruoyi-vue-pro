package cn.iocoder.yudao.module.kpi.controller.admin.assesstodolist;

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

import cn.iocoder.yudao.module.kpi.controller.admin.assesstodolist.vo.*;
import cn.iocoder.yudao.module.kpi.dal.dataobject.assesstodolist.AssessTodolistDO;
import cn.iocoder.yudao.module.kpi.convert.assesstodolist.AssessTodolistConvert;
import cn.iocoder.yudao.module.kpi.service.assesstodolist.AssessTodolistService;

@Tag(name = "管理后台 - 考核待办")
@RestController
@RequestMapping("/kpi/assess-todolist")
@Validated
public class AssessTodolistController {

    @Resource
    private AssessTodolistService assessTodolistService;

    @PostMapping("/create")
    @Operation(summary = "创建考核待办")
    @PreAuthorize("@ss.hasPermission('kpi:assess-todolist:create')")
    public CommonResult<Long> createAssessTodolist(@Valid @RequestBody AssessTodolistCreateReqVO createReqVO) {
        return success(assessTodolistService.createAssessTodolist(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新考核待办")
    @PreAuthorize("@ss.hasPermission('kpi:assess-todolist:update')")
    public CommonResult<Boolean> updateAssessTodolist(@Valid @RequestBody AssessTodolistUpdateReqVO updateReqVO) {
        assessTodolistService.updateAssessTodolist(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除考核待办")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('kpi:assess-todolist:delete')")
    public CommonResult<Boolean> deleteAssessTodolist(@RequestParam("id") Long id) {
        assessTodolistService.deleteAssessTodolist(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得考核待办")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('kpi:assess-todolist:query')")
    public CommonResult<AssessTodolistRespVO> getAssessTodolist(@RequestParam("id") Long id) {
        AssessTodolistDO assessTodolist = assessTodolistService.getAssessTodolist(id);
        return success(AssessTodolistConvert.INSTANCE.convert(assessTodolist));
    }

    @GetMapping("/list")
    @Operation(summary = "获得考核待办列表")
    @Parameter(name = "ids", description = "编号列表", required = true, example = "1024,2048")
    @PreAuthorize("@ss.hasPermission('kpi:assess-todolist:query')")
    public CommonResult<List<AssessTodolistRespVO>> getAssessTodolistList(@RequestParam("ids") Collection<Long> ids) {
        List<AssessTodolistDO> list = assessTodolistService.getAssessTodolistList(ids);
        return success(AssessTodolistConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @Operation(summary = "获得考核待办分页")
    @PreAuthorize("@ss.hasPermission('kpi:assess-todolist:query')")
    public CommonResult<PageResult<AssessTodolistRespVO>> getAssessTodolistPage(@Valid AssessTodolistPageReqVO pageVO) {
        PageResult<AssessTodolistDO> pageResult = assessTodolistService.getAssessTodolistPage(pageVO);
        return success(AssessTodolistConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出考核待办 Excel")
    @PreAuthorize("@ss.hasPermission('kpi:assess-todolist:export')")
    @OperateLog(type = EXPORT)
    public void exportAssessTodolistExcel(@Valid AssessTodolistExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<AssessTodolistDO> list = assessTodolistService.getAssessTodolistList(exportReqVO);
        // 导出 Excel
        List<AssessTodolistExcelVO> datas = AssessTodolistConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "考核待办.xls", "数据", AssessTodolistExcelVO.class, datas);
    }

}
