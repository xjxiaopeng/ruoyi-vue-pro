package cn.iocoder.yudao.module.kpi.dal.mysql.assessissue;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.kpi.dal.dataobject.assessissue.AssessIssueDO;
import cn.iocoder.yudao.module.system.dal.dataobject.dept.PostDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.kpi.controller.admin.assessissue.vo.*;

/**
 * 考核发布 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface AssessIssueMapper extends BaseMapperX<AssessIssueDO> {

    default PageResult<AssessIssueDO> selectPage(AssessIssuePageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<AssessIssueDO>()
                .likeIfPresent(AssessIssueDO::getAssessTitle, reqVO.getAssessTitle())
                .eqIfPresent(AssessIssueDO::getUserIds, reqVO.getUserIds())
                .eqIfPresent(AssessIssueDO::getReviewer, reqVO.getReviewer())
                .eqIfPresent(AssessIssueDO::getDecider, reqVO.getDecider())
                .betweenIfPresent(AssessIssueDO::getAssessStartTime, reqVO.getAssessStartTime())
                .betweenIfPresent(AssessIssueDO::getAssessEndTime, reqVO.getAssessEndTime())
                .eqIfPresent(AssessIssueDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(AssessIssueDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(AssessIssueDO::getId));
    }

    default List<AssessIssueDO> selectList(AssessIssueExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<AssessIssueDO>()
                .eqIfPresent(AssessIssueDO::getAssessTitle, reqVO.getAssessTitle())
                .eqIfPresent(AssessIssueDO::getUserIds, reqVO.getUserIds())
                .eqIfPresent(AssessIssueDO::getReviewer, reqVO.getReviewer())
                .eqIfPresent(AssessIssueDO::getDecider, reqVO.getDecider())
                .betweenIfPresent(AssessIssueDO::getAssessStartTime, reqVO.getAssessStartTime())
                .betweenIfPresent(AssessIssueDO::getAssessEndTime, reqVO.getAssessEndTime())
                .eqIfPresent(AssessIssueDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(AssessIssueDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(AssessIssueDO::getId));
    }

    /**
     * @param name
     * @return
     */
    default AssessIssueDO selectByName(String name) {
        return selectOne(AssessIssueDO::getAssessTitle, name);
    }

}
