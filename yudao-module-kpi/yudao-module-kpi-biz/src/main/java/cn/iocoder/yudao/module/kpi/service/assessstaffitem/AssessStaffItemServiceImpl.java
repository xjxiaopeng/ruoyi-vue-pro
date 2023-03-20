package cn.iocoder.yudao.module.kpi.service.assessstaffitem;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.iocoder.yudao.module.kpi.controller.admin.assessstaffitem.vo.*;
import cn.iocoder.yudao.module.kpi.dal.dataobject.assessstaffitem.AssessStaffItemDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.iocoder.yudao.module.kpi.convert.assessstaffitem.AssessStaffItemConvert;
import cn.iocoder.yudao.module.kpi.dal.mysql.assessstaffitem.AssessStaffItemMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.kpi.enums.ErrorCodeConstants.*;

/**
 * 考核评分 Service 实现类
 *
 * @author 肖鹏
 */
@Service
@Validated
public class AssessStaffItemServiceImpl implements AssessStaffItemService {

    @Resource
    private AssessStaffItemMapper assessStaffItemMapper;

    @Override
    public Long createAssessStaffItem(AssessStaffItemCreateReqVO createReqVO) {
        // 插入
        AssessStaffItemDO assessStaffItem = AssessStaffItemConvert.INSTANCE.convert(createReqVO);
        assessStaffItemMapper.insert(assessStaffItem);
        // 返回
        return assessStaffItem.getId();
    }

    @Override
    public void updateAssessStaffItem(AssessStaffItemUpdateReqVO updateReqVO) {
        // 校验存在
        validateAssessStaffItemExists(updateReqVO.getId());
        // 更新
        AssessStaffItemDO updateObj = AssessStaffItemConvert.INSTANCE.convert(updateReqVO);
        assessStaffItemMapper.updateById(updateObj);
    }

    @Override
    public void deleteAssessStaffItem(Long id) {
        // 校验存在
        validateAssessStaffItemExists(id);
        // 删除
        assessStaffItemMapper.deleteById(id);
    }

    private void validateAssessStaffItemExists(Long id) {
        if (assessStaffItemMapper.selectById(id) == null) {
            throw exception(ASSESS_STAFF_ITEM_NOT_EXISTS);
        }
    }

    @Override
    public AssessStaffItemDO getAssessStaffItem(Long id) {
        return assessStaffItemMapper.selectById(id);
    }

    @Override
    public List<AssessStaffItemDO> getAssessStaffItemList(Collection<Long> ids) {
        return assessStaffItemMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<AssessStaffItemDO> getAssessStaffItemPage(AssessStaffItemPageReqVO pageReqVO) {
        return assessStaffItemMapper.selectPage(pageReqVO);
    }

    @Override
    public List<AssessStaffItemDO> getAssessStaffItemList(AssessStaffItemExportReqVO exportReqVO) {
        return assessStaffItemMapper.selectList(exportReqVO);
    }

    @Override
    public List<AssessStaffItemDO> getselectItemList(AssessStaffItemListReqVO reqVO) {
        return assessStaffItemMapper.selectItemList(reqVO);
    }

}
