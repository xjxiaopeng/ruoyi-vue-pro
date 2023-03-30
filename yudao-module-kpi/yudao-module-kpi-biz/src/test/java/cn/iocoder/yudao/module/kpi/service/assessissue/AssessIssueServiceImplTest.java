package cn.iocoder.yudao.module.kpi.service.assessissue;

import jdk.jpackage.internal.Log;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.annotation.Resource;

import cn.iocoder.yudao.framework.test.core.ut.BaseDbUnitTest;

import cn.iocoder.yudao.module.kpi.controller.admin.assessissue.vo.*;
import cn.iocoder.yudao.module.kpi.dal.dataobject.assessissue.AssessIssueDO;
import cn.iocoder.yudao.module.kpi.dal.mysql.assessissue.AssessIssueMapper;
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
* {@link AssessIssueServiceImpl} 的单元测试类
*
* @author 芋道源码
*/
@Import(AssessIssueServiceImpl.class)
public class AssessIssueServiceImplTest extends BaseDbUnitTest {

    @Resource
    private AssessIssueServiceImpl assessIssueService;

    @Resource
    private AssessIssueMapper assessIssueMapper;

    @Test
    public void testCreateAssessIssue_success() {
        // 准备参数
        AssessIssueCreateReqVO reqVO = randomPojo(AssessIssueCreateReqVO.class);

        // 调用
        Long assessIssueId = assessIssueService.createAssessIssue(reqVO);
        // 断言
        assertNotNull(assessIssueId);
        // 校验记录的属性是否正确
        AssessIssueDO assessIssue = assessIssueMapper.selectById(assessIssueId);
        assertPojoEquals(reqVO, assessIssue);
    }

    @Test
    public void testUpdateAssessIssue_success() {
        // mock 数据
        AssessIssueDO dbAssessIssue = randomPojo(AssessIssueDO.class);
        assessIssueMapper.insert(dbAssessIssue);// @Sql: 先插入出一条存在的数据
        // 准备参数
        AssessIssueUpdateReqVO reqVO = randomPojo(AssessIssueUpdateReqVO.class, o -> {
            o.setId(dbAssessIssue.getId()); // 设置更新的 ID
        });

        // 调用
        assessIssueService.updateAssessIssue(reqVO);
        // 校验是否更新正确
        AssessIssueDO assessIssue = assessIssueMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, assessIssue);
    }

    @Test
    public void testUpdateAssessIssue_notExists() {
        // 准备参数
        AssessIssueUpdateReqVO reqVO = randomPojo(AssessIssueUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> assessIssueService.updateAssessIssue(reqVO), ASSESS_ISSUE_NOT_EXISTS);
    }

    @Test
    public void testDeleteAssessIssue_success() {
        // mock 数据
        AssessIssueDO dbAssessIssue = randomPojo(AssessIssueDO.class);
        assessIssueMapper.insert(dbAssessIssue);// @Sql: 先插入出一条存在的数据
        // 准备参数
        Long id = dbAssessIssue.getId();
        String title=dbAssessIssue.getAssessTitle();
        // 调用
        assessIssueService.deleteAssessIssue(id,title);
       // 校验数据不存在了
       assertNull(assessIssueMapper.selectById(id));
    }

    @Test
    public void testDeleteAssessIssue_notExists() {
        // 准备参数
        Long id = randomLongId();
        String title= "123";
        // 调用, 并断言异常
        assertServiceException(() -> assessIssueService.deleteAssessIssue(id,title), ASSESS_ISSUE_NOT_EXISTS);
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetAssessIssuePage() {
       // mock 数据
       AssessIssueDO dbAssessIssue = randomPojo(AssessIssueDO.class, o -> { // 等会查询到
           o.setAssessTitle(null);
           o.setUserIds(null);
           o.setReviewer(null);
           o.setDecider(null);
           o.setAssessStartTime(null);
           o.setAssessEndTime(null);
           o.setStatus(null);
           o.setCreateTime(null);
       });
       assessIssueMapper.insert(dbAssessIssue);
       // 测试 assessTitle 不匹配
       assessIssueMapper.insert(cloneIgnoreId(dbAssessIssue, o -> o.setAssessTitle(null)));
       // 测试 userIds 不匹配
       assessIssueMapper.insert(cloneIgnoreId(dbAssessIssue, o -> o.setUserIds(null)));
       // 测试 reviewer 不匹配
       assessIssueMapper.insert(cloneIgnoreId(dbAssessIssue, o -> o.setReviewer(null)));
       // 测试 decider 不匹配
       assessIssueMapper.insert(cloneIgnoreId(dbAssessIssue, o -> o.setDecider(null)));
       // 测试 assessStartTime 不匹配
       assessIssueMapper.insert(cloneIgnoreId(dbAssessIssue, o -> o.setAssessStartTime(null)));
       // 测试 assessEndTime 不匹配
       assessIssueMapper.insert(cloneIgnoreId(dbAssessIssue, o -> o.setAssessEndTime(null)));
       // 测试 status 不匹配
       assessIssueMapper.insert(cloneIgnoreId(dbAssessIssue, o -> o.setStatus(null)));
       // 测试 createTime 不匹配
       assessIssueMapper.insert(cloneIgnoreId(dbAssessIssue, o -> o.setCreateTime(null)));
       // 准备参数
       AssessIssuePageReqVO reqVO = new AssessIssuePageReqVO();
       reqVO.setAssessTitle(null);
       reqVO.setUserIds(null);
       reqVO.setReviewer(null);
       reqVO.setDecider(null);
       reqVO.setAssessStartTime(buildBetweenTime(2023, 2, 1, 2023, 2, 28));
       reqVO.setAssessEndTime(buildBetweenTime(2023, 2, 1, 2023, 2, 28));
       reqVO.setStatus(null);
       reqVO.setCreateTime(buildBetweenTime(2023, 2, 1, 2023, 2, 28));

       // 调用
       PageResult<AssessIssueDO> pageResult = assessIssueService.getAssessIssuePage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbAssessIssue, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetAssessIssueList() {
       // mock 数据
       AssessIssueDO dbAssessIssue = randomPojo(AssessIssueDO.class, o -> { // 等会查询到
           o.setAssessTitle(null);
           o.setUserIds(null);
           o.setReviewer(null);
           o.setDecider(null);
           o.setAssessStartTime(null);
           o.setAssessEndTime(null);
           o.setStatus(null);
           o.setCreateTime(null);
       });
       assessIssueMapper.insert(dbAssessIssue);
       // 测试 assessTitle 不匹配
       assessIssueMapper.insert(cloneIgnoreId(dbAssessIssue, o -> o.setAssessTitle(null)));
       // 测试 userIds 不匹配
       assessIssueMapper.insert(cloneIgnoreId(dbAssessIssue, o -> o.setUserIds(null)));
       // 测试 reviewer 不匹配
       assessIssueMapper.insert(cloneIgnoreId(dbAssessIssue, o -> o.setReviewer(null)));
       // 测试 decider 不匹配
       assessIssueMapper.insert(cloneIgnoreId(dbAssessIssue, o -> o.setDecider(null)));
       // 测试 assessStartTime 不匹配
       assessIssueMapper.insert(cloneIgnoreId(dbAssessIssue, o -> o.setAssessStartTime(null)));
       // 测试 assessEndTime 不匹配
       assessIssueMapper.insert(cloneIgnoreId(dbAssessIssue, o -> o.setAssessEndTime(null)));
       // 测试 status 不匹配
       assessIssueMapper.insert(cloneIgnoreId(dbAssessIssue, o -> o.setStatus(null)));
       // 测试 createTime 不匹配
       assessIssueMapper.insert(cloneIgnoreId(dbAssessIssue, o -> o.setCreateTime(null)));
       // 准备参数
       AssessIssueExportReqVO reqVO = new AssessIssueExportReqVO();
       reqVO.setAssessTitle(null);
       reqVO.setUserIds(null);
       reqVO.setReviewer(null);
       reqVO.setDecider(null);
       reqVO.setAssessStartTime(buildBetweenTime(2023, 2, 1, 2023, 2, 28));
       reqVO.setAssessEndTime(buildBetweenTime(2023, 2, 1, 2023, 2, 28));
       reqVO.setStatus(null);
       reqVO.setCreateTime(buildBetweenTime(2023, 2, 1, 2023, 2, 28));

       // 调用
       List<AssessIssueDO> list = assessIssueService.getAssessIssueList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbAssessIssue, list.get(0));
    }

}
