package cn.iocoder.yudao.module.kpi.service.assessissue;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.iocoder.yudao.module.kpi.controller.admin.assessissue.vo.*;
import cn.iocoder.yudao.module.kpi.dal.dataobject.assessissue.AssessIssueDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.iocoder.yudao.module.kpi.convert.assessissue.AssessIssueConvert;
import cn.iocoder.yudao.module.kpi.dal.mysql.assessissue.AssessIssueMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.kpi.enums.ErrorCodeConstants.*;

/**
 * 考核发布 Service 实现类
 *
 * @author 芋道源码
 */
@Service
@Validated
public class AssessIssueServiceImpl implements AssessIssueService {

    @Resource
    private AssessIssueMapper assessIssueMapper;

    @Override
    public Long createAssessIssue(AssessIssueCreateReqVO createReqVO) {
        // 插入
        AssessIssueDO assessIssue = AssessIssueConvert.INSTANCE.convert(createReqVO);
        assessIssueMapper.insert(assessIssue);
        // 返回
        return assessIssue.getId();
    }

    @Override
    public void updateAssessIssue(AssessIssueUpdateReqVO updateReqVO) {
        // 校验存在
        validateAssessIssueExists(updateReqVO.getId());
        // 更新
        AssessIssueDO updateObj = AssessIssueConvert.INSTANCE.convert(updateReqVO);
        assessIssueMapper.updateById(updateObj);
    }

    @Override
    public void deleteAssessIssue(Long id) {
        // 校验存在
        validateAssessIssueExists(id);
        // 删除
        assessIssueMapper.deleteById(id);
    }

    private void validateAssessIssueExists(Long id) {
        if (assessIssueMapper.selectById(id) == null) {
            throw exception(ASSESS_ISSUE_NOT_EXISTS);
        }
    }

    @Override
    public AssessIssueDO getAssessIssue(Long id) {
        return assessIssueMapper.selectById(id);
    }

    @Override
    public List<AssessIssueDO> getAssessIssueList(Collection<Long> ids) {
        return assessIssueMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<AssessIssueDO> getAssessIssuePage(AssessIssuePageReqVO pageReqVO) {
        return assessIssueMapper.selectPage(pageReqVO);
    }

    @Override
    public List<AssessIssueDO> getAssessIssueList(AssessIssueExportReqVO exportReqVO) {
        return assessIssueMapper.selectList(exportReqVO);
    }

    @Override
    public void updateAssessIssueStatus(Long id, Integer status) {
        AssessIssueDO updateObj = new AssessIssueDO();
        updateObj.setId(id);
        updateObj.setStatus(status);
        assessIssueMapper.updateById(updateObj);
    }
}
