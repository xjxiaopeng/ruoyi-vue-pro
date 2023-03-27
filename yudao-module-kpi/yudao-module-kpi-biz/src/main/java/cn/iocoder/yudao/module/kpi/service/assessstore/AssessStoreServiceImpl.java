package cn.iocoder.yudao.module.kpi.service.assessstore;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.iocoder.yudao.module.kpi.controller.admin.assessstore.vo.*;
import cn.iocoder.yudao.module.kpi.dal.dataobject.assessstore.AssessStoreDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.iocoder.yudao.module.kpi.convert.assessstore.AssessStoreConvert;
import cn.iocoder.yudao.module.kpi.dal.mysql.assessstore.AssessStoreMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.kpi.enums.ErrorCodeConstants.*;

/**
 * 考核指标库 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class AssessStoreServiceImpl implements AssessStoreService {

    @Resource
    private AssessStoreMapper assessStoreMapper;

    @Override
    public Long createAssessStore(AssessStoreCreateReqVO createReqVO) {
        // 插入
        AssessStoreDO assessStore = AssessStoreConvert.INSTANCE.convert(createReqVO);
        assessStoreMapper.insert(assessStore);
        // 返回
        return assessStore.getId();
    }

    @Override
    public void updateAssessStore(AssessStoreUpdateReqVO updateReqVO) {
        // 校验存在
        validateAssessStoreExists(updateReqVO.getId());
        // 更新
        AssessStoreDO updateObj = AssessStoreConvert.INSTANCE.convert(updateReqVO);
        assessStoreMapper.updateById(updateObj);
    }

    @Override
    public void deleteAssessStore(Long id) {
        // 校验存在
        validateAssessStoreExists(id);
        // 删除
        assessStoreMapper.deleteById(id);
    }

    private void validateAssessStoreExists(Long id) {
        if (assessStoreMapper.selectById(id) == null) {
            throw exception(ASSESS_STORE_NOT_EXISTS);
        }
    }

    @Override
    public AssessStoreDO getAssessStore(Long id) {
        return assessStoreMapper.selectById(id);
    }

    @Override
    public List<AssessStoreDO> getAssessStoreList(Collection<Long> ids) {
        return assessStoreMapper.selectBatchIds(ids);
    }

    @Override
    public List<AssessStoreDO> getAssessStoreLists(AssessStoreListReqVO listReqVO) {
        return assessStoreMapper.selectLists(listReqVO);
    }
    @Override
    public PageResult<AssessStoreDO> getAssessStorePage(AssessStorePageReqVO pageReqVO) {
        return assessStoreMapper.selectPage(pageReqVO);
    }

    @Override
    public List<AssessStoreDO> getAssessStoreList(AssessStoreExportReqVO exportReqVO) {
        return assessStoreMapper.selectList(exportReqVO);
    }

    @Override
    public List<AssessStoreDO> selectList(Long postId, Integer fixed) {
        return assessStoreMapper.selectList(postId,fixed);
    }
}
