package cn.iocoder.yudao.module.kpi.service.assessstaffitem;

import java.util.*;
import javax.validation.*;
import cn.iocoder.yudao.module.kpi.controller.admin.assessstaffitem.vo.*;
import cn.iocoder.yudao.module.kpi.dal.dataobject.assessstaffitem.AssessStaffItemDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 考核评分 Service 接口
 *
 * @author 肖鹏
 */
public interface AssessStaffItemService {

    /**
     * 创建考核评分
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createAssessStaffItem(@Valid AssessStaffItemCreateReqVO createReqVO);

    /**
     * 更新考核评分
     *
     * @param updateReqVO 更新信息
     */
    void updateAssessStaffItem(@Valid AssessStaffItemUpdateReqVO updateReqVO);

    /**
     * 删除考核评分
     *
     * @param id 编号
     */
    void deleteAssessStaffItem(Long id);

    /**
     * 获得考核评分
     *
     * @param id 编号
     * @return 考核评分
     */
    AssessStaffItemDO getAssessStaffItem(Long id);

    /**
     * 获得考核评分列表
     *
     * @param ids 编号
     * @return 考核评分列表
     */
    List<AssessStaffItemDO> getAssessStaffItemList(Collection<Long> ids);

    /**
     * 获得考核评分分页
     *
     * @param pageReqVO 分页查询
     * @return 考核评分分页
     */
    PageResult<AssessStaffItemDO> getAssessStaffItemPage(AssessStaffItemPageReqVO pageReqVO);

    /**
     * 获得考核评分列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 考核评分列表
     */
    List<AssessStaffItemDO> getAssessStaffItemList(AssessStaffItemExportReqVO exportReqVO);
    List<AssessStaffItemDO> getselectItemList(AssessStaffItemListReqVO reqVO);
}
