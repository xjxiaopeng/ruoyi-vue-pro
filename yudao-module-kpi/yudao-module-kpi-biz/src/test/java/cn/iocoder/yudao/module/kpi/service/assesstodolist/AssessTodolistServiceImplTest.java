package cn.iocoder.yudao.module.kpi.service.assesstodolist;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.annotation.Resource;

import cn.iocoder.yudao.framework.test.core.ut.BaseDbUnitTest;

import cn.iocoder.yudao.module.kpi.controller.admin.assesstodolist.vo.*;
import cn.iocoder.yudao.module.kpi.dal.dataobject.assesstodolist.AssessTodolistDO;
import cn.iocoder.yudao.module.kpi.dal.mysql.assesstodolist.AssessTodolistMapper;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import javax.annotation.Resource;
import org.springframework.context.annotation.Import;
import java.util.*;
import java.time.LocalDateTime;

import static cn.hutool.core.util.RandomUtil.*;
import static cn.iocoder.yudao.module.kpi.enums.ErrorCodeConstants.*;
import static cn.iocoder.yudao.framework.test.core.util.AssertUtils.*;
import static cn.iocoder.yudao.framework.test.core.util.RandomUtils.*;
import static cn.iocoder.yudao.framework.common.util.date.LocalDateTimeUtils.*;
import static cn.iocoder.yudao.framework.common.util.object.ObjectUtils.*;
import static cn.iocoder.yudao.framework.common.util.date.DateUtils.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
* {@link AssessTodolistServiceImpl} 的单元测试类
*
* @author 肖鹏
*/
@Import(AssessTodolistServiceImpl.class)
public class AssessTodolistServiceImplTest extends BaseDbUnitTest {

    @Resource
    private AssessTodolistServiceImpl assessTodolistService;

    @Resource
    private AssessTodolistMapper assessTodolistMapper;

    @Test
    public void testCreateAssessTodolist_success() {
        // 准备参数
        AssessTodolistCreateReqVO reqVO = randomPojo(AssessTodolistCreateReqVO.class);

        // 调用
        Long assessTodolistId = assessTodolistService.createAssessTodolist(reqVO);
        // 断言
        assertNotNull(assessTodolistId);
        // 校验记录的属性是否正确
        AssessTodolistDO assessTodolist = assessTodolistMapper.selectById(assessTodolistId);
        assertPojoEquals(reqVO, assessTodolist);
    }

    @Test
    public void testUpdateAssessTodolist_success() {
        // mock 数据
        AssessTodolistDO dbAssessTodolist = randomPojo(AssessTodolistDO.class);
        assessTodolistMapper.insert(dbAssessTodolist);// @Sql: 先插入出一条存在的数据
        // 准备参数
        AssessTodolistUpdateReqVO reqVO = randomPojo(AssessTodolistUpdateReqVO.class, o -> {
            o.setId(dbAssessTodolist.getId()); // 设置更新的 ID
        });

        // 调用
        assessTodolistService.updateAssessTodolist(reqVO);
        // 校验是否更新正确
        AssessTodolistDO assessTodolist = assessTodolistMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, assessTodolist);
    }

    @Test
    public void testUpdateAssessTodolist_notExists() {
        // 准备参数
        AssessTodolistUpdateReqVO reqVO = randomPojo(AssessTodolistUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> assessTodolistService.updateAssessTodolist(reqVO), ASSESS_TODOLIST_NOT_EXISTS);
    }

    @Test
    public void testDeleteAssessTodolist_success() {
        // mock 数据
        AssessTodolistDO dbAssessTodolist = randomPojo(AssessTodolistDO.class);
        assessTodolistMapper.insert(dbAssessTodolist);// @Sql: 先插入出一条存在的数据
        // 准备参数
        Long id = dbAssessTodolist.getId();

        // 调用
        assessTodolistService.deleteAssessTodolist(id);
       // 校验数据不存在了
       assertNull(assessTodolistMapper.selectById(id));
    }

    @Test
    public void testDeleteAssessTodolist_notExists() {
        // 准备参数
        Long id = randomLongId();

        // 调用, 并断言异常
        assertServiceException(() -> assessTodolistService.deleteAssessTodolist(id), ASSESS_TODOLIST_NOT_EXISTS);
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetAssessTodolistPage() {
       // mock 数据
       AssessTodolistDO dbAssessTodolist = randomPojo(AssessTodolistDO.class, o -> { // 等会查询到
           o.setIssueId(null);
           o.setAssessTitle(null);
           o.setStaff(null);
           o.setStaffTime(null);
           o.setStaffStatus(null);
           o.setReviewer(null);
           o.setReviewerTime(null);
           o.setReviewerStatus(null);
           o.setDecider(null);
           o.setDeciderTime(null);
           o.setDeciderStatus(null);
           o.setAssessStartTime(null);
           o.setAssessEndTime(null);
           o.setStatus(null);
           o.setCreateTime(null);
       });
       assessTodolistMapper.insert(dbAssessTodolist);
       // 测试 issueId 不匹配
       assessTodolistMapper.insert(cloneIgnoreId(dbAssessTodolist, o -> o.setIssueId(null)));
       // 测试 assessTitle 不匹配
       assessTodolistMapper.insert(cloneIgnoreId(dbAssessTodolist, o -> o.setAssessTitle(null)));
       // 测试 staff 不匹配
       assessTodolistMapper.insert(cloneIgnoreId(dbAssessTodolist, o -> o.setStaff(null)));
       // 测试 staffTime 不匹配
       assessTodolistMapper.insert(cloneIgnoreId(dbAssessTodolist, o -> o.setStaffTime(null)));
       // 测试 staffStatus 不匹配
       assessTodolistMapper.insert(cloneIgnoreId(dbAssessTodolist, o -> o.setStaffStatus(null)));
       // 测试 reviewer 不匹配
       assessTodolistMapper.insert(cloneIgnoreId(dbAssessTodolist, o -> o.setReviewer(null)));
       // 测试 reviewerTime 不匹配
       assessTodolistMapper.insert(cloneIgnoreId(dbAssessTodolist, o -> o.setReviewerTime(null)));
       // 测试 reviewerStatus 不匹配
       assessTodolistMapper.insert(cloneIgnoreId(dbAssessTodolist, o -> o.setReviewerStatus(null)));
       // 测试 decider 不匹配
       assessTodolistMapper.insert(cloneIgnoreId(dbAssessTodolist, o -> o.setDecider(null)));
       // 测试 deciderTime 不匹配
       assessTodolistMapper.insert(cloneIgnoreId(dbAssessTodolist, o -> o.setDeciderTime(null)));
       // 测试 deciderStatus 不匹配
       assessTodolistMapper.insert(cloneIgnoreId(dbAssessTodolist, o -> o.setDeciderStatus(null)));
       // 测试 assessStartTime 不匹配
       assessTodolistMapper.insert(cloneIgnoreId(dbAssessTodolist, o -> o.setAssessStartTime(null)));
       // 测试 assessEndTime 不匹配
       assessTodolistMapper.insert(cloneIgnoreId(dbAssessTodolist, o -> o.setAssessEndTime(null)));
       // 测试 status 不匹配
       assessTodolistMapper.insert(cloneIgnoreId(dbAssessTodolist, o -> o.setStatus(null)));
       // 测试 createTime 不匹配
       assessTodolistMapper.insert(cloneIgnoreId(dbAssessTodolist, o -> o.setCreateTime(null)));
       // 准备参数
       AssessTodolistPageReqVO reqVO = new AssessTodolistPageReqVO();
       reqVO.setIssueId(null);
       reqVO.setAssessTitle(null);
       reqVO.setStaff(null);
       reqVO.setStaffTime(buildBetweenTime(2023, 2, 1, 2023, 2, 28));
       reqVO.setStaffStatus(null);
       reqVO.setReviewer(null);
       reqVO.setReviewerTime(buildBetweenTime(2023, 2, 1, 2023, 2, 28));
       reqVO.setReviewerStatus(null);
       reqVO.setDecider(null);
       reqVO.setDeciderTime(buildBetweenTime(2023, 2, 1, 2023, 2, 28));
       reqVO.setDeciderStatus(null);
       reqVO.setAssessStartTime(buildBetweenTime(2023, 2, 1, 2023, 2, 28));
       reqVO.setAssessEndTime(buildBetweenTime(2023, 2, 1, 2023, 2, 28));
       reqVO.setStatus(null);
       reqVO.setCreateTime(buildBetweenTime(2023, 2, 1, 2023, 2, 28));

       // 调用
       PageResult<AssessTodolistDO> pageResult = assessTodolistService.getAssessTodolistPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbAssessTodolist, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetAssessTodolistList() {
       // mock 数据
       AssessTodolistDO dbAssessTodolist = randomPojo(AssessTodolistDO.class, o -> { // 等会查询到
           o.setIssueId(null);
           o.setAssessTitle(null);
           o.setStaff(null);
           o.setStaffTime(null);
           o.setStaffStatus(null);
           o.setReviewer(null);
           o.setReviewerTime(null);
           o.setReviewerStatus(null);
           o.setDecider(null);
           o.setDeciderTime(null);
           o.setDeciderStatus(null);
           o.setAssessStartTime(null);
           o.setAssessEndTime(null);
           o.setStatus(null);
           o.setCreateTime(null);
       });
       assessTodolistMapper.insert(dbAssessTodolist);
       // 测试 issueId 不匹配
       assessTodolistMapper.insert(cloneIgnoreId(dbAssessTodolist, o -> o.setIssueId(null)));
       // 测试 assessTitle 不匹配
       assessTodolistMapper.insert(cloneIgnoreId(dbAssessTodolist, o -> o.setAssessTitle(null)));
       // 测试 staff 不匹配
       assessTodolistMapper.insert(cloneIgnoreId(dbAssessTodolist, o -> o.setStaff(null)));
       // 测试 staffTime 不匹配
       assessTodolistMapper.insert(cloneIgnoreId(dbAssessTodolist, o -> o.setStaffTime(null)));
       // 测试 staffStatus 不匹配
       assessTodolistMapper.insert(cloneIgnoreId(dbAssessTodolist, o -> o.setStaffStatus(null)));
       // 测试 reviewer 不匹配
       assessTodolistMapper.insert(cloneIgnoreId(dbAssessTodolist, o -> o.setReviewer(null)));
       // 测试 reviewerTime 不匹配
       assessTodolistMapper.insert(cloneIgnoreId(dbAssessTodolist, o -> o.setReviewerTime(null)));
       // 测试 reviewerStatus 不匹配
       assessTodolistMapper.insert(cloneIgnoreId(dbAssessTodolist, o -> o.setReviewerStatus(null)));
       // 测试 decider 不匹配
       assessTodolistMapper.insert(cloneIgnoreId(dbAssessTodolist, o -> o.setDecider(null)));
       // 测试 deciderTime 不匹配
       assessTodolistMapper.insert(cloneIgnoreId(dbAssessTodolist, o -> o.setDeciderTime(null)));
       // 测试 deciderStatus 不匹配
       assessTodolistMapper.insert(cloneIgnoreId(dbAssessTodolist, o -> o.setDeciderStatus(null)));
       // 测试 assessStartTime 不匹配
       assessTodolistMapper.insert(cloneIgnoreId(dbAssessTodolist, o -> o.setAssessStartTime(null)));
       // 测试 assessEndTime 不匹配
       assessTodolistMapper.insert(cloneIgnoreId(dbAssessTodolist, o -> o.setAssessEndTime(null)));
       // 测试 status 不匹配
       assessTodolistMapper.insert(cloneIgnoreId(dbAssessTodolist, o -> o.setStatus(null)));
       // 测试 createTime 不匹配
       assessTodolistMapper.insert(cloneIgnoreId(dbAssessTodolist, o -> o.setCreateTime(null)));
       // 准备参数
       AssessTodolistExportReqVO reqVO = new AssessTodolistExportReqVO();
       reqVO.setIssueId(null);
       reqVO.setAssessTitle(null);
       reqVO.setStaff(null);
       reqVO.setStaffTime(buildBetweenTime(2023, 2, 1, 2023, 2, 28));
       reqVO.setStaffStatus(null);
       reqVO.setReviewer(null);
       reqVO.setReviewerTime(buildBetweenTime(2023, 2, 1, 2023, 2, 28));
       reqVO.setReviewerStatus(null);
       reqVO.setDecider(null);
       reqVO.setDeciderTime(buildBetweenTime(2023, 2, 1, 2023, 2, 28));
       reqVO.setDeciderStatus(null);
       reqVO.setAssessStartTime(buildBetweenTime(2023, 2, 1, 2023, 2, 28));
       reqVO.setAssessEndTime(buildBetweenTime(2023, 2, 1, 2023, 2, 28));
       reqVO.setStatus(null);
       reqVO.setCreateTime(buildBetweenTime(2023, 2, 1, 2023, 2, 28));

       // 调用
       List<AssessTodolistDO> list = assessTodolistService.getAssessTodolistList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbAssessTodolist, list.get(0));
    }

}
