package cn.iocoder.yudao.module.kpi.dal.mysql.assesstodolist;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.kpi.dal.dataobject.assessissue.AssessIssueDO;
import cn.iocoder.yudao.module.kpi.dal.dataobject.assesstodolist.AssessTodolistDO;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.kpi.controller.admin.assesstodolist.vo.*;

/**
 * 考核待办 Mapper
 *
 * @author 肖鹏
 */
@Mapper
public interface AssessTodolistMapper extends BaseMapperX<AssessTodolistDO> {

    default PageResult<AssessTodolistDO> selectPage(AssessTodolistPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<AssessTodolistDO>()
                .eqIfPresent(AssessTodolistDO::getIssueId, reqVO.getIssueId())
                .likeIfPresent(AssessTodolistDO::getAssessTitle, reqVO.getAssessTitle())
                .eqIfPresent(AssessTodolistDO::getStaff, reqVO.getStaff())
                .betweenIfPresent(AssessTodolistDO::getStaffTime, reqVO.getStaffTime())
                .eqIfPresent(AssessTodolistDO::getStaffStatus, reqVO.getStaffStatus())
                .eqIfPresent(AssessTodolistDO::getReviewer, reqVO.getReviewer())
                .betweenIfPresent(AssessTodolistDO::getReviewerTime, reqVO.getReviewerTime())
                .eqIfPresent(AssessTodolistDO::getReviewerStatus, reqVO.getReviewerStatus())
                .eqIfPresent(AssessTodolistDO::getDecider, reqVO.getDecider())
                .betweenIfPresent(AssessTodolistDO::getDeciderTime, reqVO.getDeciderTime())
                .eqIfPresent(AssessTodolistDO::getDeciderStatus, reqVO.getDeciderStatus())
                .betweenIfPresent(AssessTodolistDO::getAssessStartTime, reqVO.getAssessStartTime())
                .betweenIfPresent(AssessTodolistDO::getAssessEndTime, reqVO.getAssessEndTime())
                .eqIfPresent(AssessTodolistDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(AssessTodolistDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(AssessTodolistDO::getId));
    }

    default List<AssessTodolistDO> selectList(AssessTodolistExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<AssessTodolistDO>()
                .eqIfPresent(AssessTodolistDO::getIssueId, reqVO.getIssueId())
                .eqIfPresent(AssessTodolistDO::getAssessTitle, reqVO.getAssessTitle())
                .eqIfPresent(AssessTodolistDO::getStaff, reqVO.getStaff())
                .betweenIfPresent(AssessTodolistDO::getStaffTime, reqVO.getStaffTime())
                .eqIfPresent(AssessTodolistDO::getStaffStatus, reqVO.getStaffStatus())
                .eqIfPresent(AssessTodolistDO::getReviewer, reqVO.getReviewer())
                .betweenIfPresent(AssessTodolistDO::getReviewerTime, reqVO.getReviewerTime())
                .eqIfPresent(AssessTodolistDO::getReviewerStatus, reqVO.getReviewerStatus())
                .eqIfPresent(AssessTodolistDO::getDecider, reqVO.getDecider())
                .betweenIfPresent(AssessTodolistDO::getDeciderTime, reqVO.getDeciderTime())
                .eqIfPresent(AssessTodolistDO::getDeciderStatus, reqVO.getDeciderStatus())
                .betweenIfPresent(AssessTodolistDO::getAssessStartTime, reqVO.getAssessStartTime())
                .betweenIfPresent(AssessTodolistDO::getAssessEndTime, reqVO.getAssessEndTime())
                .eqIfPresent(AssessTodolistDO::getStatus, reqVO.getStatus())
                .betweenIfPresent(AssessTodolistDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(AssessTodolistDO::getId));
    }

  default  void deleteByTitle(String title){
      delete(new LambdaQueryWrapperX<AssessTodolistDO>()
              .eq(AssessTodolistDO::getAssessTitle, title));
  }

    /**
     * @param issueId
     * @param update
     * @return
     */
    //default int updateStatusAndStaffByIssueId(Long issueId, String staff,AssessTodolistDO update) {
    //    return update(update, new QueryWrapper<AssessTodolistDO>()
    //            .eq("issue_id", issueId)
    //            .eq("staff",staff));
    //}
    default List<AssessTodolistDO> selectByAssessTitle(String assessTitle) {
        return (selectList(new LambdaQueryWrapperX<AssessTodolistDO>()
                .eqIfPresent(AssessTodolistDO::getAssessTitle,assessTitle)
        ));
    }
}
