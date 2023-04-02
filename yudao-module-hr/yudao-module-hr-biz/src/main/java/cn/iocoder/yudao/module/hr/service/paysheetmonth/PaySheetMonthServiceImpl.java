package cn.iocoder.yudao.module.hr.service.paysheetmonth;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.iocoder.yudao.module.hr.controller.admin.paysheetmonth.vo.*;
import cn.iocoder.yudao.module.hr.dal.dataobject.paysheetmonth.PaySheetMonthDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.iocoder.yudao.module.hr.convert.paysheetmonth.PaySheetMonthConvert;
import cn.iocoder.yudao.module.hr.dal.mysql.paysheetmonth.PaySheetMonthMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.hr.enums.ErrorCodeConstants.*;

/**
 * 月工资 Service 实现类
 *
 * @author 肖鹏
 */
@Service
@Validated
public class PaySheetMonthServiceImpl implements PaySheetMonthService {

    @Resource
    private PaySheetMonthMapper paySheetMonthMapper;

    @Override
    public Long createPaySheetMonth(PaySheetMonthCreateReqVO createReqVO) {
        // 插入
        PaySheetMonthDO paySheetMonth = PaySheetMonthConvert.INSTANCE.convert(createReqVO);
        paySheetMonthMapper.insert(paySheetMonth);
        // 返回
        return paySheetMonth.getId();
    }

    @Override
    public void updatePaySheetMonth(PaySheetMonthUpdateReqVO updateReqVO) {
        // 校验存在
        validatePaySheetMonthExists(updateReqVO.getId());
        // 更新
        PaySheetMonthDO updateObj = PaySheetMonthConvert.INSTANCE.convert(updateReqVO);
        paySheetMonthMapper.updateById(updateObj);
    }

    @Override
    public void deletePaySheetMonth(Long id) {
        // 校验存在
        validatePaySheetMonthExists(id);
        // 删除
        paySheetMonthMapper.deleteById(id);
    }

    private void validatePaySheetMonthExists(Long id) {
        if (paySheetMonthMapper.selectById(id) == null) {
            throw exception(PAY_SHEET_MONTH_NOT_EXISTS);
        }
    }

    @Override
    public PaySheetMonthDO getPaySheetMonth(Long id) {
        return paySheetMonthMapper.selectById(id);
    }

    @Override
    public List<PaySheetMonthDO> getPaySheetMonthList(Collection<Long> ids) {
        return paySheetMonthMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<PaySheetMonthDO> getPaySheetMonthPage(PaySheetMonthPageReqVO pageReqVO) {
        return paySheetMonthMapper.selectPage(pageReqVO);
    }

    @Override
    public List<PaySheetMonthDO> getPaySheetMonthList(PaySheetMonthExportReqVO exportReqVO) {
        return paySheetMonthMapper.selectList(exportReqVO);
    }

}
