package cn.iocoder.yudao.module.hr.service.paysheetmonth;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.mock.mockito.MockBean;

import javax.annotation.Resource;

import cn.iocoder.yudao.framework.test.core.ut.BaseDbUnitTest;

import cn.iocoder.yudao.module.hr.controller.admin.paysheetmonth.vo.*;
import cn.iocoder.yudao.module.hr.dal.dataobject.paysheetmonth.PaySheetMonthDO;
import cn.iocoder.yudao.module.hr.dal.mysql.paysheetmonth.PaySheetMonthMapper;
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
* {@link PaySheetMonthServiceImpl} 的单元测试类
*
* @author 肖鹏
*/
@Import(PaySheetMonthServiceImpl.class)
public class PaySheetMonthServiceImplTest extends BaseDbUnitTest {

    @Resource
    private PaySheetMonthServiceImpl paySheetMonthService;

    @Resource
    private PaySheetMonthMapper paySheetMonthMapper;

    @Test
    public void testCreatePaySheetMonth_success() {
        // 准备参数
        PaySheetMonthCreateReqVO reqVO = randomPojo(PaySheetMonthCreateReqVO.class);

        // 调用
        Long paySheetMonthId = paySheetMonthService.createPaySheetMonth(reqVO);
        // 断言
        assertNotNull(paySheetMonthId);
        // 校验记录的属性是否正确
        PaySheetMonthDO paySheetMonth = paySheetMonthMapper.selectById(paySheetMonthId);
        assertPojoEquals(reqVO, paySheetMonth);
    }

    @Test
    public void testUpdatePaySheetMonth_success() {
        // mock 数据
        PaySheetMonthDO dbPaySheetMonth = randomPojo(PaySheetMonthDO.class);
        paySheetMonthMapper.insert(dbPaySheetMonth);// @Sql: 先插入出一条存在的数据
        // 准备参数
        PaySheetMonthUpdateReqVO reqVO = randomPojo(PaySheetMonthUpdateReqVO.class, o -> {
            o.setId(dbPaySheetMonth.getId()); // 设置更新的 ID
        });

        // 调用
        paySheetMonthService.updatePaySheetMonth(reqVO);
        // 校验是否更新正确
        PaySheetMonthDO paySheetMonth = paySheetMonthMapper.selectById(reqVO.getId()); // 获取最新的
        assertPojoEquals(reqVO, paySheetMonth);
    }

    @Test
    public void testUpdatePaySheetMonth_notExists() {
        // 准备参数
        PaySheetMonthUpdateReqVO reqVO = randomPojo(PaySheetMonthUpdateReqVO.class);

        // 调用, 并断言异常
        assertServiceException(() -> paySheetMonthService.updatePaySheetMonth(reqVO), PAY_SHEET_MONTH_NOT_EXISTS);
    }

    @Test
    public void testDeletePaySheetMonth_success() {
        // mock 数据
        PaySheetMonthDO dbPaySheetMonth = randomPojo(PaySheetMonthDO.class);
        paySheetMonthMapper.insert(dbPaySheetMonth);// @Sql: 先插入出一条存在的数据
        // 准备参数
        Long id = dbPaySheetMonth.getId();

        // 调用
        paySheetMonthService.deletePaySheetMonth(id);
       // 校验数据不存在了
       assertNull(paySheetMonthMapper.selectById(id));
    }

    @Test
    public void testDeletePaySheetMonth_notExists() {
        // 准备参数
        Long id = randomLongId();

        // 调用, 并断言异常
        assertServiceException(() -> paySheetMonthService.deletePaySheetMonth(id), PAY_SHEET_MONTH_NOT_EXISTS);
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetPaySheetMonthPage() {
       // mock 数据
       PaySheetMonthDO dbPaySheetMonth = randomPojo(PaySheetMonthDO.class, o -> { // 等会查询到
           o.setWageName(null);
           o.setNickname(null);
           o.setDeptName(null);
       });
       paySheetMonthMapper.insert(dbPaySheetMonth);
       // 测试 wageName 不匹配
       paySheetMonthMapper.insert(cloneIgnoreId(dbPaySheetMonth, o -> o.setWageName(null)));
       // 测试 nickname 不匹配
       paySheetMonthMapper.insert(cloneIgnoreId(dbPaySheetMonth, o -> o.setNickname(null)));
       // 测试 deptName 不匹配
       paySheetMonthMapper.insert(cloneIgnoreId(dbPaySheetMonth, o -> o.setDeptName(null)));
       // 准备参数
       PaySheetMonthPageReqVO reqVO = new PaySheetMonthPageReqVO();
       reqVO.setWageName(null);
       reqVO.setNickname(null);
       reqVO.setDeptName(null);

       // 调用
       PageResult<PaySheetMonthDO> pageResult = paySheetMonthService.getPaySheetMonthPage(reqVO);
       // 断言
       assertEquals(1, pageResult.getTotal());
       assertEquals(1, pageResult.getList().size());
       assertPojoEquals(dbPaySheetMonth, pageResult.getList().get(0));
    }

    @Test
    @Disabled  // TODO 请修改 null 为需要的值，然后删除 @Disabled 注解
    public void testGetPaySheetMonthList() {
       // mock 数据
       PaySheetMonthDO dbPaySheetMonth = randomPojo(PaySheetMonthDO.class, o -> { // 等会查询到
           o.setWageName(null);
           o.setNickname(null);
           o.setDeptName(null);
       });
       paySheetMonthMapper.insert(dbPaySheetMonth);
       // 测试 wageName 不匹配
       paySheetMonthMapper.insert(cloneIgnoreId(dbPaySheetMonth, o -> o.setWageName(null)));
       // 测试 nickname 不匹配
       paySheetMonthMapper.insert(cloneIgnoreId(dbPaySheetMonth, o -> o.setNickname(null)));
       // 测试 deptName 不匹配
       paySheetMonthMapper.insert(cloneIgnoreId(dbPaySheetMonth, o -> o.setDeptName(null)));
       // 准备参数
       PaySheetMonthExportReqVO reqVO = new PaySheetMonthExportReqVO();
       reqVO.setWageName(null);
       reqVO.setNickname(null);
       reqVO.setDeptName(null);

       // 调用
       List<PaySheetMonthDO> list = paySheetMonthService.getPaySheetMonthList(reqVO);
       // 断言
       assertEquals(1, list.size());
       assertPojoEquals(dbPaySheetMonth, list.get(0));
    }

}
