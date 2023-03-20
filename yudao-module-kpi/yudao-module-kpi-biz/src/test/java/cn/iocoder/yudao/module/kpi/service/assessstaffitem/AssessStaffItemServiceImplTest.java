package cn.iocoder.yudao.module.kpi.service.assessstaffitem;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.annotation.Resource;

import cn.iocoder.yudao.framework.test.core.ut.BaseDbUnitTest;

import cn.iocoder.yudao.module.kpi.controller.admin.assessstaffitem.vo.*;
import cn.iocoder.yudao.module.kpi.dal.dataobject.assessstaffitem.AssessStaffItemDO;
import cn.iocoder.yudao.module.kpi.dal.mysql.assessstaffitem.AssessStaffItemMapper;
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
* {@link AssessStaffItemServiceImpl} 的单元测试类
*
* @author 肖鹏
*/
@Import(AssessStaffItemServiceImpl.class)
public class AssessStaffItemServiceImplTest extends BaseDbUnitTest {

    @Resource
    private AssessStaffItemServiceImpl assessStaffItemService;

    @Resource
    private AssessStaffItemMapper assessStaffItemMapper;

    @Test
    public void testCreateAssessStaffItem_success() {
        // 准备参数
        AssessStaffItemCreateReqVO reqVO = randomPojo(AssessStaffItemCreateReqVO.class);

        // 调用
        Long assessStaffItemId = assessStaffItemService.createAssessStaffItem(reqVO);
        // 断言
        assertNotNull(assessStaffItemId);
        // 校验记录的属性是否正确
        AssessStaffItemDO assessStaffItem = assessStaffItemMapper.selectById(assessStaffItemId);
        assertPojoEquals(reqVO, assessStaffItem);
    }

    @Test
    public void testUpdateAssessStaffItem_success() {
        // mock 数据
        AssessStaffItemDO dbAssessStaffItem = randomPojo(AssessStaffItemDO.class);
        assessStaffItemMapper.insert(dbAssessStaffItem);// @Sql: 先插入出一条存在的数据
        // 准备参数
        AssessStaffItemUpdateReqVO reqVO = randomPojo(AssessStaffItemUpdateReqVO.class, o -> {
            o.setId(dbAssessStaffItem.getId()); // 设置更新的 ID
        });

        // 调用
        assessStaffItemService.updateAssessStaffItem(reqVO);
        // 校验是否更新正确
        AssessStaffItemDO assessStaffItem = assessStaffItemMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, assessStaffItem);
    }

    @Test
    public void testUpdateAssessStaffItem_notExists() {
        // 准备参数
        AssessStaffItemUpdateReqVO reqVO = randomPojo(AssessStaffItemUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> assessStaffItemService.updateAssessStaffItem(reqVO), ASSESS_STAFF_ITEM_NOT_EXISTS);
    }

    @Test
    public void testDeleteAssessStaffItem_success() {
        // mock 数据
        AssessStaffItemDO dbAssessStaffItem = randomPojo(AssessStaffItemDO.class);
        assessStaffItemMapper.insert(dbAssessStaffItem);// @Sql: 先插入出一条存在的数据
        // 准备参数
        Long id = dbAssessStaffItem.getId();

        // 调用
        assessStaffItemService.deleteAssessStaffItem(id);
       // 校验数据不存在了
       assertNull(assessStaffItemMapper.selectById(id));
    }

    @Test
    public void testDeleteAssessStaffItem_notExists() {
        // 准备参数
        Long id = randomLongId();

        // 调用, 并断言异常
        assertServiceException(() -> assessStaffItemService.deleteAssessStaffItem(id), ASSESS_STAFF_ITEM_NOT_EXISTS);
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetAssessStaffItemPage() {
       // mock 数据
       AssessStaffItemDO dbAssessStaffItem = randomPojo(AssessStaffItemDO.class, o -> { // 等会查询到
           o.setIssueId(null);
           o.setTodolistId(null);
           o.setAssessTitle(null);
           o.setTitle(null);
           o.setStandard(null);
           o.setScore(null);
           o.setStaff(null);
           o.setStaffTime(null);
           o.setStaffCompleteStatus(null);
           o.setStaffScore(null);
           o.setStaffRemark(null);
           o.setReviewer(null);
           o.setReviewerTime(null);
           o.setReviewerCompleteStatus(null);
           o.setReviewerScore(null);
           o.setReviewerRemark(null);
           o.setDecider(null);
           o.setDeciderTime(null);
           o.setDeciderCompleteStatus(null);
           o.setDeciderScore(null);
           o.setDeciderRemark(null);
           o.setPost(null);
           o.setStatus(null);
           o.setFixed(null);
           o.setCreateTime(null);
       });
       assessStaffItemMapper.insert(dbAssessStaffItem);
       // 测试 issueId 不匹配
       assessStaffItemMapper.insert(cloneIgnoreId(dbAssessStaffItem, o -> o.setIssueId(null)));
       // 测试 todolistId 不匹配
       assessStaffItemMapper.insert(cloneIgnoreId(dbAssessStaffItem, o -> o.setTodolistId(null)));
       // 测试 assessTitle 不匹配
       assessStaffItemMapper.insert(cloneIgnoreId(dbAssessStaffItem, o -> o.setAssessTitle(null)));
       // 测试 title 不匹配
       assessStaffItemMapper.insert(cloneIgnoreId(dbAssessStaffItem, o -> o.setTitle(null)));
       // 测试 standard 不匹配
       assessStaffItemMapper.insert(cloneIgnoreId(dbAssessStaffItem, o -> o.setStandard(null)));
       // 测试 score 不匹配
       assessStaffItemMapper.insert(cloneIgnoreId(dbAssessStaffItem, o -> o.setScore(null)));
       // 测试 staff 不匹配
       assessStaffItemMapper.insert(cloneIgnoreId(dbAssessStaffItem, o -> o.setStaff(null)));
       // 测试 staffTime 不匹配
       assessStaffItemMapper.insert(cloneIgnoreId(dbAssessStaffItem, o -> o.setStaffTime(null)));
       // 测试 staffCompleteStatus 不匹配
       assessStaffItemMapper.insert(cloneIgnoreId(dbAssessStaffItem, o -> o.setStaffCompleteStatus(null)));
       // 测试 staffScore 不匹配
       assessStaffItemMapper.insert(cloneIgnoreId(dbAssessStaffItem, o -> o.setStaffScore(null)));
       // 测试 staffRemark 不匹配
       assessStaffItemMapper.insert(cloneIgnoreId(dbAssessStaffItem, o -> o.setStaffRemark(null)));
       // 测试 reviewer 不匹配
       assessStaffItemMapper.insert(cloneIgnoreId(dbAssessStaffItem, o -> o.setReviewer(null)));
       // 测试 reviewerTime 不匹配
       assessStaffItemMapper.insert(cloneIgnoreId(dbAssessStaffItem, o -> o.setReviewerTime(null)));
       // 测试 reviewerCompleteStatus 不匹配
       assessStaffItemMapper.insert(cloneIgnoreId(dbAssessStaffItem, o -> o.setReviewerCompleteStatus(null)));
       // 测试 reviewerScore 不匹配
       assessStaffItemMapper.insert(cloneIgnoreId(dbAssessStaffItem, o -> o.setReviewerScore(null)));
       // 测试 reviewerRemark 不匹配
       assessStaffItemMapper.insert(cloneIgnoreId(dbAssessStaffItem, o -> o.setReviewerRemark(null)));
       // 测试 decider 不匹配
       assessStaffItemMapper.insert(cloneIgnoreId(dbAssessStaffItem, o -> o.setDecider(null)));
       // 测试 deciderTime 不匹配
       assessStaffItemMapper.insert(cloneIgnoreId(dbAssessStaffItem, o -> o.setDeciderTime(null)));
       // 测试 deciderCompleteStatus 不匹配
       assessStaffItemMapper.insert(cloneIgnoreId(dbAssessStaffItem, o -> o.setDeciderCompleteStatus(null)));
       // 测试 deciderScore 不匹配
       assessStaffItemMapper.insert(cloneIgnoreId(dbAssessStaffItem, o -> o.setDeciderScore(null)));
       // 测试 deciderRemark 不匹配
       assessStaffItemMapper.insert(cloneIgnoreId(dbAssessStaffItem, o -> o.setDeciderRemark(null)));
       // 测试 post 不匹配
       assessStaffItemMapper.insert(cloneIgnoreId(dbAssessStaffItem, o -> o.setPost(null)));
       // 测试 status 不匹配
       assessStaffItemMapper.insert(cloneIgnoreId(dbAssessStaffItem, o -> o.setStatus(null)));
       // 测试 fixed 不匹配
       assessStaffItemMapper.insert(cloneIgnoreId(dbAssessStaffItem, o -> o.setFixed(null)));
       // 测试 createTime 不匹配
       assessStaffItemMapper.insert(cloneIgnoreId(dbAssessStaffItem, o -> o.setCreateTime(null)));
       // 准备参数
       AssessStaffItemPageReqVO reqVO = new AssessStaffItemPageReqVO();
       reqVO.setIssueId(null);
       reqVO.setTodolistId(null);
       reqVO.setAssessTitle(null);
       reqVO.setTitle(null);
       reqVO.setStandard(null);
       reqVO.setScore(null);
       reqVO.setStaff(null);
       reqVO.setStaffTime(buildBetweenTime(2023, 2, 1, 2023, 2, 28));
       reqVO.setStaffCompleteStatus(null);
       reqVO.setStaffScore(null);
       reqVO.setStaffRemark(null);
       reqVO.setReviewer(null);
       reqVO.setReviewerTime(buildBetweenTime(2023, 2, 1, 2023, 2, 28));
       reqVO.setReviewerCompleteStatus(null);
       reqVO.setReviewerScore(null);
       reqVO.setReviewerRemark(null);
       reqVO.setDecider(null);
       reqVO.setDeciderTime(buildBetweenTime(2023, 2, 1, 2023, 2, 28));
       reqVO.setDeciderCompleteStatus(null);
       reqVO.setDeciderScore(null);
       reqVO.setDeciderRemark(null);
       reqVO.setPost(null);
       reqVO.setStatus(null);
       reqVO.setFixed(null);
       reqVO.setCreateTime(buildBetweenTime(2023, 2, 1, 2023, 2, 28));

       // 调用
       PageResult<AssessStaffItemDO> pageResult = assessStaffItemService.getAssessStaffItemPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbAssessStaffItem, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetAssessStaffItemList() {
       // mock 数据
       AssessStaffItemDO dbAssessStaffItem = randomPojo(AssessStaffItemDO.class, o -> { // 等会查询到
           o.setIssueId(null);
           o.setTodolistId(null);
           o.setAssessTitle(null);
           o.setTitle(null);
           o.setStandard(null);
           o.setScore(null);
           o.setStaff(null);
           o.setStaffTime(null);
           o.setStaffCompleteStatus(null);
           o.setStaffScore(null);
           o.setStaffRemark(null);
           o.setReviewer(null);
           o.setReviewerTime(null);
           o.setReviewerCompleteStatus(null);
           o.setReviewerScore(null);
           o.setReviewerRemark(null);
           o.setDecider(null);
           o.setDeciderTime(null);
           o.setDeciderCompleteStatus(null);
           o.setDeciderScore(null);
           o.setDeciderRemark(null);
           o.setPost(null);
           o.setStatus(null);
           o.setFixed(null);
           o.setCreateTime(null);
       });
       assessStaffItemMapper.insert(dbAssessStaffItem);
       // 测试 issueId 不匹配
       assessStaffItemMapper.insert(cloneIgnoreId(dbAssessStaffItem, o -> o.setIssueId(null)));
       // 测试 todolistId 不匹配
       assessStaffItemMapper.insert(cloneIgnoreId(dbAssessStaffItem, o -> o.setTodolistId(null)));
       // 测试 assessTitle 不匹配
       assessStaffItemMapper.insert(cloneIgnoreId(dbAssessStaffItem, o -> o.setAssessTitle(null)));
       // 测试 title 不匹配
       assessStaffItemMapper.insert(cloneIgnoreId(dbAssessStaffItem, o -> o.setTitle(null)));
       // 测试 standard 不匹配
       assessStaffItemMapper.insert(cloneIgnoreId(dbAssessStaffItem, o -> o.setStandard(null)));
       // 测试 score 不匹配
       assessStaffItemMapper.insert(cloneIgnoreId(dbAssessStaffItem, o -> o.setScore(null)));
       // 测试 staff 不匹配
       assessStaffItemMapper.insert(cloneIgnoreId(dbAssessStaffItem, o -> o.setStaff(null)));
       // 测试 staffTime 不匹配
       assessStaffItemMapper.insert(cloneIgnoreId(dbAssessStaffItem, o -> o.setStaffTime(null)));
       // 测试 staffCompleteStatus 不匹配
       assessStaffItemMapper.insert(cloneIgnoreId(dbAssessStaffItem, o -> o.setStaffCompleteStatus(null)));
       // 测试 staffScore 不匹配
       assessStaffItemMapper.insert(cloneIgnoreId(dbAssessStaffItem, o -> o.setStaffScore(null)));
       // 测试 staffRemark 不匹配
       assessStaffItemMapper.insert(cloneIgnoreId(dbAssessStaffItem, o -> o.setStaffRemark(null)));
       // 测试 reviewer 不匹配
       assessStaffItemMapper.insert(cloneIgnoreId(dbAssessStaffItem, o -> o.setReviewer(null)));
       // 测试 reviewerTime 不匹配
       assessStaffItemMapper.insert(cloneIgnoreId(dbAssessStaffItem, o -> o.setReviewerTime(null)));
       // 测试 reviewerCompleteStatus 不匹配
       assessStaffItemMapper.insert(cloneIgnoreId(dbAssessStaffItem, o -> o.setReviewerCompleteStatus(null)));
       // 测试 reviewerScore 不匹配
       assessStaffItemMapper.insert(cloneIgnoreId(dbAssessStaffItem, o -> o.setReviewerScore(null)));
       // 测试 reviewerRemark 不匹配
       assessStaffItemMapper.insert(cloneIgnoreId(dbAssessStaffItem, o -> o.setReviewerRemark(null)));
       // 测试 decider 不匹配
       assessStaffItemMapper.insert(cloneIgnoreId(dbAssessStaffItem, o -> o.setDecider(null)));
       // 测试 deciderTime 不匹配
       assessStaffItemMapper.insert(cloneIgnoreId(dbAssessStaffItem, o -> o.setDeciderTime(null)));
       // 测试 deciderCompleteStatus 不匹配
       assessStaffItemMapper.insert(cloneIgnoreId(dbAssessStaffItem, o -> o.setDeciderCompleteStatus(null)));
       // 测试 deciderScore 不匹配
       assessStaffItemMapper.insert(cloneIgnoreId(dbAssessStaffItem, o -> o.setDeciderScore(null)));
       // 测试 deciderRemark 不匹配
       assessStaffItemMapper.insert(cloneIgnoreId(dbAssessStaffItem, o -> o.setDeciderRemark(null)));
       // 测试 post 不匹配
       assessStaffItemMapper.insert(cloneIgnoreId(dbAssessStaffItem, o -> o.setPost(null)));
       // 测试 status 不匹配
       assessStaffItemMapper.insert(cloneIgnoreId(dbAssessStaffItem, o -> o.setStatus(null)));
       // 测试 fixed 不匹配
       assessStaffItemMapper.insert(cloneIgnoreId(dbAssessStaffItem, o -> o.setFixed(null)));
       // 测试 createTime 不匹配
       assessStaffItemMapper.insert(cloneIgnoreId(dbAssessStaffItem, o -> o.setCreateTime(null)));
       // 准备参数
       AssessStaffItemExportReqVO reqVO = new AssessStaffItemExportReqVO();
       reqVO.setIssueId(null);
       reqVO.setTodolistId(null);
       reqVO.setAssessTitle(null);
       reqVO.setTitle(null);
       reqVO.setStandard(null);
       reqVO.setScore(null);
       reqVO.setStaff(null);
       reqVO.setStaffTime(buildBetweenTime(2023, 2, 1, 2023, 2, 28));
       reqVO.setStaffCompleteStatus(null);
       reqVO.setStaffScore(null);
       reqVO.setStaffRemark(null);
       reqVO.setReviewer(null);
       reqVO.setReviewerTime(buildBetweenTime(2023, 2, 1, 2023, 2, 28));
       reqVO.setReviewerCompleteStatus(null);
       reqVO.setReviewerScore(null);
       reqVO.setReviewerRemark(null);
       reqVO.setDecider(null);
       reqVO.setDeciderTime(buildBetweenTime(2023, 2, 1, 2023, 2, 28));
       reqVO.setDeciderCompleteStatus(null);
       reqVO.setDeciderScore(null);
       reqVO.setDeciderRemark(null);
       reqVO.setPost(null);
       reqVO.setStatus(null);
       reqVO.setFixed(null);
       reqVO.setCreateTime(buildBetweenTime(2023, 2, 1, 2023, 2, 28));

       // 调用
       List<AssessStaffItemDO> list = assessStaffItemService.getAssessStaffItemList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbAssessStaffItem, list.get(0));
    }

}
