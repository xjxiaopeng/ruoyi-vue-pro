package cn.iocoder.yudao.module.hr.service.paysheetbase;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.iocoder.yudao.module.hr.controller.admin.paysheetbase.vo.*;
import cn.iocoder.yudao.module.hr.dal.dataobject.paysheetbase.PaySheetBaseDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.iocoder.yudao.module.hr.convert.paysheetbase.PaySheetBaseConvert;
import cn.iocoder.yudao.module.hr.dal.mysql.paysheetbase.PaySheetBaseMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.hr.enums.ErrorCodeConstants.*;

/**
 * 工资基础 Service 实现类
 *
 * @author 肖鹏
 */
@Service
@Validated
public class PaySheetBaseServiceImpl implements PaySheetBaseService {

    @Resource
    private PaySheetBaseMapper paySheetBaseMapper;

    @Override
    public Long createPaySheetBase(PaySheetBaseCreateReqVO createReqVO) {
        // 插入
        PaySheetBaseDO paySheetBase = PaySheetBaseConvert.INSTANCE.convert(createReqVO);
        paySheetBaseMapper.insert(paySheetBase);
        // 返回
        return paySheetBase.getId();
    }

    @Override
    public void updatePaySheetBase(PaySheetBaseUpdateReqVO updateReqVO) {
        // 校验存在
        validatePaySheetBaseExists(updateReqVO.getId());
        // 更新
        PaySheetBaseDO updateObj = PaySheetBaseConvert.INSTANCE.convert(updateReqVO);
        paySheetBaseMapper.updateById(updateObj);
    }

    @Override
    public void deletePaySheetBase(Long id) {
        // 校验存在
        validatePaySheetBaseExists(id);
        // 删除
        paySheetBaseMapper.deleteById(id);
    }

    private void validatePaySheetBaseExists(Long id) {
        if (paySheetBaseMapper.selectById(id) == null) {
            throw exception(PAY_SHEET_BASE_NOT_EXISTS);
        }
    }

    @Override
    public PaySheetBaseDO getPaySheetBase(Long id) {
        return paySheetBaseMapper.selectById(id);
    }

    @Override
    public List<PaySheetBaseDO> getPaySheetBaseList(Collection<Long> ids) {
        return paySheetBaseMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<PaySheetBaseDO> getPaySheetBasePage(PaySheetBasePageReqVO pageReqVO) {
        return paySheetBaseMapper.selectPage(pageReqVO);
    }

    @Override
    public List<PaySheetBaseDO> getPaySheetBaseList(PaySheetBaseExportReqVO exportReqVO) {
        return paySheetBaseMapper.selectList(exportReqVO);
    }

}
