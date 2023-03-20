package cn.iocoder.yudao.module.kpi.controller.admin.assessissue;

import cn.iocoder.yudao.module.kpi.controller.admin.assessstaffitem.vo.AssessStaffItemCreateReqVO;
import cn.iocoder.yudao.module.kpi.controller.admin.assesstodolist.vo.AssessTodolistCreateReqVO;
import cn.iocoder.yudao.module.kpi.dal.dataobject.assessstore.AssessStoreDO;
import cn.iocoder.yudao.module.kpi.service.assessstaffitem.AssessStaffItemService;
import cn.iocoder.yudao.module.kpi.service.assessstore.AssessStoreService;
import cn.iocoder.yudao.module.kpi.service.assesstodolist.AssessTodolistService;
import cn.iocoder.yudao.module.system.api.user.AdminUserApi;
import cn.iocoder.yudao.module.system.service.dept.PostService;
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

import cn.iocoder.yudao.module.kpi.controller.admin.assessissue.vo.*;
import cn.iocoder.yudao.module.kpi.dal.dataobject.assessissue.AssessIssueDO;
import cn.iocoder.yudao.module.kpi.convert.assessissue.AssessIssueConvert;
import cn.iocoder.yudao.module.kpi.service.assessissue.AssessIssueService;

@Tag(name = "管理后台 - 考核发布")
@RestController
@RequestMapping("/kpi/assess-issue")
@Validated
public class AssessIssueController {

    @Resource
    private AssessIssueService assessIssueService;

    @Resource
    private AssessStoreService assessStoreService;
    @Resource
    private AssessTodolistService assessTodolistService;
    @Resource
    private AdminUserApi adminUserApi;
    @Resource
    private AssessStaffItemService assessStaffItemService;
    @Resource
    private PostService postService;

    @PostMapping("/create")
    @Operation(summary = "创建考核发布")
    @PreAuthorize("@ss.hasPermission('kpi:assess-issue:create')")
    public CommonResult<Long> createAssessIssue(@Valid @RequestBody AssessIssueCreateReqVO createReqVO) {
        return success(assessIssueService.createAssessIssue(createReqVO));
    }

    @PutMapping("/update")
    @Operation(summary = "更新考核发布")
    @PreAuthorize("@ss.hasPermission('kpi:assess-issue:update')")
    public CommonResult<Boolean> updateAssessIssue(@Valid @RequestBody AssessIssueUpdateReqVO updateReqVO) {
        assessIssueService.updateAssessIssue(updateReqVO);
        return success(true);
    }

    @DeleteMapping("/delete")
    @Operation(summary = "删除考核发布")
    @Parameter(name = "id", description = "编号", required = true)
    @PreAuthorize("@ss.hasPermission('kpi:assess-issue:delete')")
    public CommonResult<Boolean> deleteAssessIssue(@RequestParam("id") Long id) {
        assessIssueService.deleteAssessIssue(id);
        return success(true);
    }

    @GetMapping("/get")
    @Operation(summary = "获得考核发布")
    @Parameter(name = "id", description = "编号", required = true, example = "1024")
    @PreAuthorize("@ss.hasPermission('kpi:assess-issue:query')")
    public CommonResult<AssessIssueRespVO> getAssessIssue(@RequestParam("id") Long id) {
        AssessIssueDO assessIssue = assessIssueService.getAssessIssue(id);
        return success(AssessIssueConvert.INSTANCE.convert(assessIssue));
    }

    @GetMapping("/list")
    @Operation(summary = "获得考核发布列表")
    @Parameter(name = "ids", description = "编号列表", required = true, example = "1024,2048")
    @PreAuthorize("@ss.hasPermission('kpi:assess-issue:query')")
    public CommonResult<List<AssessIssueRespVO>> getAssessIssueList(@RequestParam("ids") Collection<Long> ids) {
        List<AssessIssueDO> list = assessIssueService.getAssessIssueList(ids);
        return success(AssessIssueConvert.INSTANCE.convertList(list));
    }

    @GetMapping("/page")
    @Operation(summary = "获得考核发布分页")
    @PreAuthorize("@ss.hasPermission('kpi:assess-issue:query')")
    public CommonResult<PageResult<AssessIssueRespVO>> getAssessIssuePage(@Valid AssessIssuePageReqVO pageVO) {
        PageResult<AssessIssueDO> pageResult = assessIssueService.getAssessIssuePage(pageVO);
        return success(AssessIssueConvert.INSTANCE.convertPage(pageResult));
    }

    @GetMapping("/export-excel")
    @Operation(summary = "导出考核发布 Excel")
    @PreAuthorize("@ss.hasPermission('kpi:assess-issue:export')")
    @OperateLog(type = EXPORT)
    public void exportAssessIssueExcel(@Valid AssessIssueExportReqVO exportReqVO,
              HttpServletResponse response) throws IOException {
        List<AssessIssueDO> list = assessIssueService.getAssessIssueList(exportReqVO);
        // 导出 Excel
        List<AssessIssueExcelVO> datas = AssessIssueConvert.INSTANCE.convertList02(list);
        ExcelUtils.write(response, "考核发布.xls", "数据", AssessIssueExcelVO.class, datas);
    }
    @PutMapping("/update-status")
    @Operation(summary ="修改考核发布状态")
    @PreAuthorize("@ss.hasPermission('kpi:assess-issue:update')")
    public CommonResult<Boolean> updateAssessIssueStatus(@Valid @RequestBody AssessIssueUpdateStatusReqVO reqVO) {
        assessIssueService.updateAssessIssueStatus(reqVO.getId(), reqVO.getStatus());
        if (reqVO.getStatus() == 0) {
            //生成考核待办表数据
            AssessTodolistCreateReqVO assessTodolistCreateReqVOO = new AssessTodolistCreateReqVO();
            AssessStaffItemCreateReqVO assessStaffItemCreateReqVO = new AssessStaffItemCreateReqVO();
            AssessIssueDO assessIssue = assessIssueService.getAssessIssue(reqVO.getId());
            for (Long userid : assessIssue.getUserIds()) {
                assessTodolistCreateReqVOO.setIssueId(reqVO.getId());
                assessTodolistCreateReqVOO.setAssessTitle(assessIssue.getAssessTitle());
                assessTodolistCreateReqVOO.setStaff(adminUserApi.getUser(userid).getNickname());
                assessTodolistCreateReqVOO.setStaffStatus(1);
                assessTodolistCreateReqVOO.setReviewer(assessIssue.getReviewer());
                assessTodolistCreateReqVOO.setReviewerStatus(2);
                assessTodolistCreateReqVOO.setDecider(assessIssue.getDecider());
                assessTodolistCreateReqVOO.setDeciderStatus(2);
                assessTodolistCreateReqVOO.setAssessStartTime(assessIssue.getAssessStartTime());
                assessTodolistCreateReqVOO.setAssessEndTime(assessIssue.getAssessEndTime());
                assessTodolistCreateReqVOO.setStatus(1);
                //生成考核待办表数据
                Long todoId = assessTodolistService.createAssessTodolist(assessTodolistCreateReqVOO);
                //通过用户ID查找岗位IDS 遍历岗位IDS
                for (Long postId : adminUserApi.getUser(userid).getPostIds()) {
                    //根据岗位编号和是否必选查询考核存储库表
                    List<AssessStoreDO> assessStoreS = assessStoreService.selectList(postId, 0);
                    //遍历考核指标库表
                    for (AssessStoreDO assessStoreDO:assessStoreS) {
                        //将考核存储库中的数据插入到考核评分表
                        assessStaffItemCreateReqVO.setIssueId(assessIssue.getId());
                        assessStaffItemCreateReqVO.setTodolistId(todoId);
                        assessStaffItemCreateReqVO.setAssessTitle(assessIssue.getAssessTitle());
                        assessStaffItemCreateReqVO.setTitle(assessStoreDO.getTitle());
                        assessStaffItemCreateReqVO.setStandard(assessStoreDO.getStandard());
                        assessStaffItemCreateReqVO.setScore(assessStoreDO.getScore());

                        assessStaffItemCreateReqVO.setStaff(adminUserApi.getUser(userid).getNickname());
                        assessStaffItemCreateReqVO.setStaffCompleteStatus(0);
                        assessStaffItemCreateReqVO.setStaffScore(assessStoreDO.getScore());

                        assessStaffItemCreateReqVO.setReviewer(assessIssue.getReviewer());
                        assessStaffItemCreateReqVO.setReviewerCompleteStatus(0);
                        assessStaffItemCreateReqVO.setReviewerScore(assessStoreDO.getScore());

                        assessStaffItemCreateReqVO.setDecider(assessIssue.getDecider());
                        assessStaffItemCreateReqVO.setDeciderCompleteStatus(0);
                        assessStaffItemCreateReqVO.setDeciderScore(assessStoreDO.getScore());
                        assessStaffItemCreateReqVO.setPost(postService.getPost(postId).getName());

                        assessStaffItemCreateReqVO.setStatus(1);

                        assessStaffItemCreateReqVO.setFixed(assessStoreDO.getFixed());
                        assessStaffItemService.createAssessStaffItem(assessStaffItemCreateReqVO);

                    }
                }

            }
//生成绩效考核评分表


        }
        ;
        return success(true);
    }

}
