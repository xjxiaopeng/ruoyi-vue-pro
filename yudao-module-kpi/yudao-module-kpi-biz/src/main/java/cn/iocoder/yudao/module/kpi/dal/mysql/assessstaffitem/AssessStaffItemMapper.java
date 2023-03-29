package cn.iocoder.yudao.module.kpi.dal.mysql.assessstaffitem;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.kpi.dal.dataobject.assessstaffitem.AssessStaffItemDO;
import cn.iocoder.yudao.module.kpi.dal.dataobject.assesstodolist.AssessTodolistDO;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.kpi.controller.admin.assessstaffitem.vo.*;

/**
 * 考核评分 Mapper
 *
 * @author 肖鹏
 */
@Mapper
public interface AssessStaffItemMapper extends BaseMapperX<AssessStaffItemDO> {


    default void deleteByTitle(String title) {
        delete(new LambdaQueryWrapperX<AssessStaffItemDO>()
                .eq(AssessStaffItemDO::getAssessTitle, title));
    }

    default PageResult<AssessStaffItemDO> selectPage(AssessStaffItemPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<AssessStaffItemDO>()
                .eqIfPresent(AssessStaffItemDO::getIssueId, reqVO.getIssueId())
                .eqIfPresent(AssessStaffItemDO::getTodolistId, reqVO.getTodolistId())
                .eqIfPresent(AssessStaffItemDO::getAssessTitle, reqVO.getAssessTitle())
                .eqIfPresent(AssessStaffItemDO::getTitle, reqVO.getTitle())
                .eqIfPresent(AssessStaffItemDO::getStandard, reqVO.getStandard())
                .eqIfPresent(AssessStaffItemDO::getScore, reqVO.getScore())
                .eqIfPresent(AssessStaffItemDO::getStaff, reqVO.getStaff())
                .betweenIfPresent(AssessStaffItemDO::getStaffTime, reqVO.getStaffTime())
                .eqIfPresent(AssessStaffItemDO::getStaffCompleteStatus, reqVO.getStaffCompleteStatus())
                .eqIfPresent(AssessStaffItemDO::getStaffScore, reqVO.getStaffScore())
                .eqIfPresent(AssessStaffItemDO::getStaffRemark, reqVO.getStaffRemark())
                .eqIfPresent(AssessStaffItemDO::getReviewer, reqVO.getReviewer())
                .betweenIfPresent(AssessStaffItemDO::getReviewerTime, reqVO.getReviewerTime())
                .eqIfPresent(AssessStaffItemDO::getReviewerCompleteStatus, reqVO.getReviewerCompleteStatus())
                .eqIfPresent(AssessStaffItemDO::getReviewerScore, reqVO.getReviewerScore())
                .eqIfPresent(AssessStaffItemDO::getReviewerRemark, reqVO.getReviewerRemark())
                .eqIfPresent(AssessStaffItemDO::getDecider, reqVO.getDecider())
                .betweenIfPresent(AssessStaffItemDO::getDeciderTime, reqVO.getDeciderTime())
                .eqIfPresent(AssessStaffItemDO::getDeciderCompleteStatus, reqVO.getDeciderCompleteStatus())
                .eqIfPresent(AssessStaffItemDO::getDeciderScore, reqVO.getDeciderScore())
                .eqIfPresent(AssessStaffItemDO::getDeciderRemark, reqVO.getDeciderRemark())
                .eqIfPresent(AssessStaffItemDO::getPost, reqVO.getPost())
                .eqIfPresent(AssessStaffItemDO::getStatus, reqVO.getStatus())
                .eqIfPresent(AssessStaffItemDO::getFixed, reqVO.getFixed())
                .betweenIfPresent(AssessStaffItemDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(AssessStaffItemDO::getId));
    }

    default List<AssessStaffItemDO> selectList(AssessStaffItemExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<AssessStaffItemDO>()
                .eqIfPresent(AssessStaffItemDO::getIssueId, reqVO.getIssueId())
                .eqIfPresent(AssessStaffItemDO::getTodolistId, reqVO.getTodolistId())
                .eqIfPresent(AssessStaffItemDO::getAssessTitle, reqVO.getAssessTitle())
                .eqIfPresent(AssessStaffItemDO::getTitle, reqVO.getTitle())
                .eqIfPresent(AssessStaffItemDO::getStandard, reqVO.getStandard())
                .eqIfPresent(AssessStaffItemDO::getScore, reqVO.getScore())
                .eqIfPresent(AssessStaffItemDO::getStaff, reqVO.getStaff())
                .betweenIfPresent(AssessStaffItemDO::getStaffTime, reqVO.getStaffTime())
                .eqIfPresent(AssessStaffItemDO::getStaffCompleteStatus, reqVO.getStaffCompleteStatus())
                .eqIfPresent(AssessStaffItemDO::getStaffScore, reqVO.getStaffScore())
                .eqIfPresent(AssessStaffItemDO::getStaffRemark, reqVO.getStaffRemark())
                .eqIfPresent(AssessStaffItemDO::getReviewer, reqVO.getReviewer())
                .betweenIfPresent(AssessStaffItemDO::getReviewerTime, reqVO.getReviewerTime())
                .eqIfPresent(AssessStaffItemDO::getReviewerCompleteStatus, reqVO.getReviewerCompleteStatus())
                .eqIfPresent(AssessStaffItemDO::getReviewerScore, reqVO.getReviewerScore())
                .eqIfPresent(AssessStaffItemDO::getReviewerRemark, reqVO.getReviewerRemark())
                .eqIfPresent(AssessStaffItemDO::getDecider, reqVO.getDecider())
                .betweenIfPresent(AssessStaffItemDO::getDeciderTime, reqVO.getDeciderTime())
                .eqIfPresent(AssessStaffItemDO::getDeciderCompleteStatus, reqVO.getDeciderCompleteStatus())
                .eqIfPresent(AssessStaffItemDO::getDeciderScore, reqVO.getDeciderScore())
                .eqIfPresent(AssessStaffItemDO::getDeciderRemark, reqVO.getDeciderRemark())
                .eqIfPresent(AssessStaffItemDO::getPost, reqVO.getPost())
                .eqIfPresent(AssessStaffItemDO::getStatus, reqVO.getStatus())
                .eqIfPresent(AssessStaffItemDO::getFixed, reqVO.getFixed())
                .betweenIfPresent(AssessStaffItemDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(AssessStaffItemDO::getId));
    }
    default List<AssessStaffItemDO> selectItemList(AssessStaffItemListReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<AssessStaffItemDO>()
                .eqIfPresent(AssessStaffItemDO::getIssueId, reqVO.getIssueId())
                .eqIfPresent(AssessStaffItemDO::getTodolistId, reqVO.getTodolistId())
                .eqIfPresent(AssessStaffItemDO::getAssessTitle, reqVO.getAssessTitle())
                .eqIfPresent(AssessStaffItemDO::getStaff, reqVO.getStaff())
                .eqIfPresent(AssessStaffItemDO::getStaffCompleteStatus, reqVO.getStaffCompleteStatus())
                .eqIfPresent(AssessStaffItemDO::getReviewer, reqVO.getReviewer())
                .eqIfPresent(AssessStaffItemDO::getReviewerCompleteStatus, reqVO.getReviewerCompleteStatus())
                .eqIfPresent(AssessStaffItemDO::getDecider, reqVO.getDecider())
                .eqIfPresent(AssessStaffItemDO::getDeciderCompleteStatus, reqVO.getDeciderCompleteStatus())
                .eqIfPresent(AssessStaffItemDO::getStatus, reqVO.getStatus())
                .orderByDesc(AssessStaffItemDO::getId));
    }
  /*  default int updateStatusAndStaffByIssueId(Long issueId, String staff,AssessStaffItemDO update) {
        return update(update, new QueryWrapper<AssessStaffItemDO>()
                .eq("issue_id", issueId)
                .eq("staff",staff));
    }*/
    default List<AssessStaffItemDO> selectByAssessTitle(String assessTitle) {
        return (selectList(new LambdaQueryWrapperX<AssessStaffItemDO>()
                .eqIfPresent(AssessStaffItemDO::getAssessTitle,assessTitle)
        ));
    }

}
