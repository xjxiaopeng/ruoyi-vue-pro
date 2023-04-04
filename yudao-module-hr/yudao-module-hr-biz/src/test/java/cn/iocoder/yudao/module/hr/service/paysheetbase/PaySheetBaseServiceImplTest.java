package cn.iocoder.yudao.module.hr.service.paysheetbase;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.annotation.Resource;

import cn.iocoder.yudao.framework.test.core.ut.BaseDbUnitTest;

import cn.iocoder.yudao.module.hr.controller.admin.paysheetbase.vo.*;
import cn.iocoder.yudao.module.hr.dal.dataobject.paysheetbase.PaySheetBaseDO;
import cn.iocoder.yudao.module.hr.dal.mysql.paysheetbase.PaySheetBaseMapper;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import javax.annotation.Resource;
import org.springframework.context.annotation.Import;
import java.util.*;
import java.time.LocalDateTime;

import static cn.hutool.core.util.RandomUtil.*;
import static cn.iocoder.yudao.module.hr.enums.ErrorCodeConstants.*;
import static cn.iocoder.yudao.framework.test.core.util.AssertUtils.*;
import static cn.iocoder.yudao.framework.test.core.util.RandomUtils.*;
import static cn.iocoder.yudao.framework.common.util.date.LocalDateTimeUtils.*;
import static cn.iocoder.yudao.framework.common.util.object.ObjectUtils.*;
import static cn.iocoder.yudao.framework.common.util.date.DateUtils.*;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

/**
* {@link PaySheetBaseServiceImpl} 的单元测试类
*
* @author 肖鹏
*/
@Import(PaySheetBaseServiceImpl.class)
public class PaySheetBaseServiceImplTest extends BaseDbUnitTest {

    @Resource
    private PaySheetBaseServiceImpl paySheetBaseService;

    @Resource
    private PaySheetBaseMapper paySheetBaseMapper;

    @Test
    public void testCreatePaySheetBase_success() {
        // 准备参数
        PaySheetBaseCreateReqVO reqVO = randomPojo(PaySheetBaseCreateReqVO.class);

        // 调用
        Long paySheetBaseId = paySheetBaseService.createPaySheetBase(reqVO);
        // 断言
        assertNotNull(paySheetBaseId);
        // 校验记录的属性是否正确
        PaySheetBaseDO paySheetBase = paySheetBaseMapper.selectById(paySheetBaseId);
        assertPojoEquals(reqVO, paySheetBase);
    }

    @Test
    public void testUpdatePaySheetBase_success() {
        // mock 数据
        PaySheetBaseDO dbPaySheetBase = randomPojo(PaySheetBaseDO.class);
        paySheetBaseMapper.insert(dbPaySheetBase);// @Sql: 先插入出一条存在的数据
        // 准备参数
        PaySheetBaseUpdateReqVO reqVO = randomPojo(PaySheetBaseUpdateReqVO.class, o -> {
            o.setId(dbPaySheetBase.getId()); // 设置更新的 ID
        });

        // 调用
        paySheetBaseService.updatePaySheetBase(reqVO);
        // 校验是否更新正确
        PaySheetBaseDO paySheetBase = paySheetBaseMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, paySheetBase);
    }

    @Test
    public void testUpdatePaySheetBase_notExists() {
        // 准备参数
        PaySheetBaseUpdateReqVO reqVO = randomPojo(PaySheetBaseUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> paySheetBaseService.updatePaySheetBase(reqVO), PAY_SHEET_BASE_NOT_EXISTS);
    }

    @Test
    public void testDeletePaySheetBase_success() {
        // mock 数据
        PaySheetBaseDO dbPaySheetBase = randomPojo(PaySheetBaseDO.class);
        paySheetBaseMapper.insert(dbPaySheetBase);// @Sql: 先插入出一条存在的数据
        // 准备参数
        Long id = dbPaySheetBase.getId();

        // 调用
        paySheetBaseService.deletePaySheetBase(id);
       // 校验数据不存在了
       assertNull(paySheetBaseMapper.selectById(id));
    }

    @Test
    public void testDeletePaySheetBase_notExists() {
        // 准备参数
        Long id = randomLongId();

        // 调用, 并断言异常
        assertServiceException(() -> paySheetBaseService.deletePaySheetBase(id), PAY_SHEET_BASE_NOT_EXISTS);
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetPaySheetBasePage() {
       // mock 数据
       PaySheetBaseDO dbPaySheetBase = randomPojo(PaySheetBaseDO.class, o -> { // 等会查询到
           o.setUserId(null);
           o.setDeptId(null);
       });
       paySheetBaseMapper.insert(dbPaySheetBase);
       // 测试 userId 不匹配
       paySheetBaseMapper.insert(cloneIgnoreId(dbPaySheetBase, o -> o.setUserId(null)));
       // 测试 deptId 不匹配
       paySheetBaseMapper.insert(cloneIgnoreId(dbPaySheetBase, o -> o.setDeptId(null)));
       // 测试 nickname 不匹配
       // 准备参数
       PaySheetBasePageReqVO reqVO = new PaySheetBasePageReqVO();
       reqVO.setUserId(null);
       reqVO.setDeptId(null);

       // 调用
       PageResult<PaySheetBaseDO> pageResult = paySheetBaseService.getPaySheetBasePage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbPaySheetBase, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetPaySheetBaseList() {
       // mock 数据
       PaySheetBaseDO dbPaySheetBase = randomPojo(PaySheetBaseDO.class, o -> { // 等会查询到
           o.setUserId(null);
           o.setDeptId(null);
       });
       paySheetBaseMapper.insert(dbPaySheetBase);
       // 测试 userId 不匹配
       paySheetBaseMapper.insert(cloneIgnoreId(dbPaySheetBase, o -> o.setUserId(null)));
       // 测试 deptId 不匹配
       paySheetBaseMapper.insert(cloneIgnoreId(dbPaySheetBase, o -> o.setDeptId(null)));
       // 测试 nickname 不匹配
       // 准备参数
       PaySheetBaseExportReqVO reqVO = new PaySheetBaseExportReqVO();
       reqVO.setUserId(null);
       reqVO.setDeptId(null);

       // 调用
       List<PaySheetBaseDO> list = paySheetBaseService.getPaySheetBaseList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbPaySheetBase, list.get(0));
    }

}
