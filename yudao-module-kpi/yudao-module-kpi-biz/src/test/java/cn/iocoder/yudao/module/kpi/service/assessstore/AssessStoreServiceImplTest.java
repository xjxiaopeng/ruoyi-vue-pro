package cn.iocoder.yudao.module.kpi.service.assessstore;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.annotation.Resource;

import cn.iocoder.yudao.framework.test.core.ut.BaseDbUnitTest;

import cn.iocoder.yudao.module.kpi.controller.admin.assessstore.vo.*;
import cn.iocoder.yudao.module.kpi.dal.dataobject.assessstore.AssessStoreDO;
import cn.iocoder.yudao.module.kpi.dal.mysql.assessstore.AssessStoreMapper;
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
* {@link AssessStoreServiceImpl} 的单元测试类
*
* @author 芋道源码
*/
@Import(AssessStoreServiceImpl.class)
public class AssessStoreServiceImplTest extends BaseDbUnitTest {

    @Resource
    private AssessStoreServiceImpl assessStoreService;

    @Resource
    private AssessStoreMapper assessStoreMapper;

    @Test
    public void testCreateAssessStore_success() {
        // 准备参数
        AssessStoreCreateReqVO reqVO = randomPojo(AssessStoreCreateReqVO.class);

        // 调用
        Long assessStoreId = assessStoreService.createAssessStore(reqVO);
        // 断言
        assertNotNull(assessStoreId);
        // 校验记录的属性是否正确
        AssessStoreDO assessStore = assessStoreMapper.selectById(assessStoreId);
        assertPojoEquals(reqVO, assessStore);
    }

    @Test
    public void testUpdateAssessStore_success() {
        // mock 数据
        AssessStoreDO dbAssessStore = randomPojo(AssessStoreDO.class);
        assessStoreMapper.insert(dbAssessStore);// @Sql: 先插入出一条存在的数据
        // 准备参数
        AssessStoreUpdateReqVO reqVO = randomPojo(AssessStoreUpdateReqVO.class, o -> {
            o.setId(dbAssessStore.getId()); // 设置更新的 ID
        });

        // 调用
        assessStoreService.updateAssessStore(reqVO);
        // 校验是否更新正确
        AssessStoreDO assessStore = assessStoreMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, assessStore);
    }

    @Test
    public void testUpdateAssessStore_notExists() {
        // 准备参数
        AssessStoreUpdateReqVO reqVO = randomPojo(AssessStoreUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> assessStoreService.updateAssessStore(reqVO), ASSESS_STORE_NOT_EXISTS);
    }

    @Test
    public void testDeleteAssessStore_success() {
        // mock 数据
        AssessStoreDO dbAssessStore = randomPojo(AssessStoreDO.class);
        assessStoreMapper.insert(dbAssessStore);// @Sql: 先插入出一条存在的数据
        // 准备参数
        Long id = dbAssessStore.getId();

        // 调用
        assessStoreService.deleteAssessStore(id);
       // 校验数据不存在了
       assertNull(assessStoreMapper.selectById(id));
    }

    @Test
    public void testDeleteAssessStore_notExists() {
        // 准备参数
        Long id = randomLongId();

        // 调用, 并断言异常
        assertServiceException(() -> assessStoreService.deleteAssessStore(id), ASSESS_STORE_NOT_EXISTS);
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetAssessStorePage() {
       // mock 数据
       AssessStoreDO dbAssessStore = randomPojo(AssessStoreDO.class, o -> { // 等会查询到
           o.setTitle(null);
           o.setStandard(null);
           o.setScore(null);
           o.setRemark(null);
           o.setPostId(null);
           o.setStatus(null);
           o.setFixed(null);
           o.setCreateTime(null);
       });
       assessStoreMapper.insert(dbAssessStore);
       // 测试 title 不匹配
       assessStoreMapper.insert(cloneIgnoreId(dbAssessStore, o -> o.setTitle(null)));
       // 测试 standard 不匹配
       assessStoreMapper.insert(cloneIgnoreId(dbAssessStore, o -> o.setStandard(null)));
       // 测试 score 不匹配
       assessStoreMapper.insert(cloneIgnoreId(dbAssessStore, o -> o.setScore(null)));
       // 测试 remark 不匹配
       assessStoreMapper.insert(cloneIgnoreId(dbAssessStore, o -> o.setRemark(null)));
       // 测试 postId 不匹配
       assessStoreMapper.insert(cloneIgnoreId(dbAssessStore, o -> o.setPostId(null)));
       // 测试 status 不匹配
       assessStoreMapper.insert(cloneIgnoreId(dbAssessStore, o -> o.setStatus(null)));
       // 测试 fixed 不匹配
       assessStoreMapper.insert(cloneIgnoreId(dbAssessStore, o -> o.setFixed(null)));
       // 测试 createTime 不匹配
       assessStoreMapper.insert(cloneIgnoreId(dbAssessStore, o -> o.setCreateTime(null)));
       // 准备参数
       AssessStorePageReqVO reqVO = new AssessStorePageReqVO();
       reqVO.setTitle(null);
       reqVO.setStandard(null);
       reqVO.setScore(null);
       reqVO.setRemark(null);
       reqVO.setPostId(null);
       reqVO.setStatus(null);
       reqVO.setFixed(null);
       reqVO.setCreateTime(buildBetweenTime(2023, 2, 1, 2023, 2, 28));

       // 调用
       PageResult<AssessStoreDO> pageResult = assessStoreService.getAssessStorePage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbAssessStore, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetAssessStoreList() {
       // mock 数据
       AssessStoreDO dbAssessStore = randomPojo(AssessStoreDO.class, o -> { // 等会查询到
           o.setTitle(null);
           o.setStandard(null);
           o.setScore(null);
           o.setRemark(null);
           o.setPostId(null);
           o.setStatus(null);
           o.setFixed(null);
           o.setCreateTime(null);
       });
       assessStoreMapper.insert(dbAssessStore);
       // 测试 title 不匹配
       assessStoreMapper.insert(cloneIgnoreId(dbAssessStore, o -> o.setTitle(null)));
       // 测试 standard 不匹配
       assessStoreMapper.insert(cloneIgnoreId(dbAssessStore, o -> o.setStandard(null)));
       // 测试 score 不匹配
       assessStoreMapper.insert(cloneIgnoreId(dbAssessStore, o -> o.setScore(null)));
       // 测试 remark 不匹配
       assessStoreMapper.insert(cloneIgnoreId(dbAssessStore, o -> o.setRemark(null)));
       // 测试 postId 不匹配
       assessStoreMapper.insert(cloneIgnoreId(dbAssessStore, o -> o.setPostId(null)));
       // 测试 status 不匹配
       assessStoreMapper.insert(cloneIgnoreId(dbAssessStore, o -> o.setStatus(null)));
       // 测试 fixed 不匹配
       assessStoreMapper.insert(cloneIgnoreId(dbAssessStore, o -> o.setFixed(null)));
       // 测试 createTime 不匹配
       assessStoreMapper.insert(cloneIgnoreId(dbAssessStore, o -> o.setCreateTime(null)));
       // 准备参数
       AssessStoreExportReqVO reqVO = new AssessStoreExportReqVO();
       reqVO.setTitle(null);
       reqVO.setStandard(null);
       reqVO.setScore(null);
       reqVO.setRemark(null);
       reqVO.setPostId(null);
       reqVO.setStatus(null);
       reqVO.setFixed(null);
       reqVO.setCreateTime(buildBetweenTime(2023, 2, 1, 2023, 2, 28));

       // 调用
       List<AssessStoreDO> list = assessStoreService.getAssessStoreList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbAssessStore, list.get(0));
    }

}
