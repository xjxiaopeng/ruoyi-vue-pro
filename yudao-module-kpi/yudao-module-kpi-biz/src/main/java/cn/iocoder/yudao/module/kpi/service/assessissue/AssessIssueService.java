package cn.iocoder.yudao.module.kpi.service.assessissue;

import java.util.*;
import javax.validation.*;
import cn.iocoder.yudao.module.kpi.controller.admin.assessissue.vo.*;
import cn.iocoder.yudao.module.kpi.dal.dataobject.assessissue.AssessIssueDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 考核发布 Service 接口
 *
 * @author 芋道源码
 */
public interface AssessIssueService {

    /**
     * 创建考核发布
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createAssessIssue(@Valid AssessIssueCreateReqVO createReqVO);

    /**
     * 更新考核发布
     *
     * @param updateReqVO 更新信息
     */
    void updateAssessIssue(@Valid AssessIssueUpdateReqVO updateReqVO);

    /**
     * 删除考核发布
     *
     * @param id 编号
     */
    void deleteAssessIssue(Long id,String title);

    /**
     * 获得考核发布
     *
     * @param id 编号
     * @return 考核发布
     */
    AssessIssueDO getAssessIssue(Long id);

    /**
     * 获得考核发布列表
     *
     * @param ids 编号
     * @return 考核发布列表
     */
    List<AssessIssueDO> getAssessIssueList(Collection<Long> ids);

    /**
     * 获得考核发布分页
     *
     * @param pageReqVO 分页查询
     * @return 考核发布分页
     */
    PageResult<AssessIssueDO> getAssessIssuePage(AssessIssuePageReqVO pageReqVO);

    /**
     * 获得考核发布列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 考核发布列表
     */
    List<AssessIssueDO> getAssessIssueList(AssessIssueExportReqVO exportReqVO);

    List<AssessIssueDO> getAssessIssueLists();



    /**
     *
     * @param id  考核发布id
     * @param status  考核发布状态
     */

    void updateAssessIssueStatus(Long id, Integer status);
}
