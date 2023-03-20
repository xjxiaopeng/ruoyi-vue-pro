package cn.iocoder.yudao.module.kpi.service.assesstodolist;

import java.util.*;
import javax.validation.*;
import cn.iocoder.yudao.module.kpi.controller.admin.assesstodolist.vo.*;
import cn.iocoder.yudao.module.kpi.dal.dataobject.assesstodolist.AssessTodolistDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 考核待办 Service 接口
 *
 * @author 肖鹏
 */
public interface AssessTodolistService {

    /**
     * 创建考核待办
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createAssessTodolist(@Valid AssessTodolistCreateReqVO createReqVO);

    /**
     * 更新考核待办
     *
     * @param updateReqVO 更新信息
     */
    void updateAssessTodolist(@Valid AssessTodolistUpdateReqVO updateReqVO);

    /**
     * 删除考核待办
     *
     * @param id 编号
     */
    void deleteAssessTodolist(Long id);

    /**
     * 获得考核待办
     *
     * @param id 编号
     * @return 考核待办
     */
    AssessTodolistDO getAssessTodolist(Long id);

    /**
     * 获得考核待办列表
     *
     * @param ids 编号
     * @return 考核待办列表
     */
    List<AssessTodolistDO> getAssessTodolistList(Collection<Long> ids);

    /**
     * 获得考核待办分页
     *
     * @param pageReqVO 分页查询
     * @return 考核待办分页
     */
    PageResult<AssessTodolistDO> getAssessTodolistPage(AssessTodolistPageReqVO pageReqVO);

    /**
     * 获得考核待办列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 考核待办列表
     */
    List<AssessTodolistDO> getAssessTodolistList(AssessTodolistExportReqVO exportReqVO);

}
