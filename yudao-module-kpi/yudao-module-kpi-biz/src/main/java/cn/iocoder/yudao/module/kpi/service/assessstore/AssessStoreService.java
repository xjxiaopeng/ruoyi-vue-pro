package cn.iocoder.yudao.module.kpi.service.assessstore;

import java.util.*;
import javax.validation.*;
import cn.iocoder.yudao.module.kpi.controller.admin.assessstore.vo.*;
import cn.iocoder.yudao.module.kpi.dal.dataobject.assessstore.AssessStoreDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 考核指标库 Service 接口
 *
 * @author 芋道源码
 */
public interface AssessStoreService {

    /**
     * 创建考核指标库
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createAssessStore(@Valid AssessStoreCreateReqVO createReqVO);

    /**
     * 更新考核指标库
     *
     * @param updateReqVO 更新信息
     */
    void updateAssessStore(@Valid AssessStoreUpdateReqVO updateReqVO);

    /**
     * 删除考核指标库
     *
     * @param id 编号
     */
    void deleteAssessStore(Long id);

    /**
     * 获得考核指标库
     *
     * @param id 编号
     * @return 考核指标库
     */
    AssessStoreDO getAssessStore(Long id);

    /**
     * 获得考核指标库列表
     *
     * @param ids 编号
     * @return 考核指标库列表
     */
    List<AssessStoreDO> getAssessStoreList(Collection<Long> ids);

    /**
     * 获得考核指标库分页
     *
     * @param pageReqVO 分页查询
     * @return 考核指标库分页
     */
    PageResult<AssessStoreDO> getAssessStorePage(AssessStorePageReqVO pageReqVO);

    /**
     * 获得考核指标库列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 考核指标库列表
     */
    List<AssessStoreDO> getAssessStoreList(AssessStoreExportReqVO exportReqVO);

    /**
     * 根据postId和fixed查询考核数据
     * @param postId
     * @param fixed
     * @return
     */
    List<AssessStoreDO> selectList(Long postId, Integer fixed);
}
