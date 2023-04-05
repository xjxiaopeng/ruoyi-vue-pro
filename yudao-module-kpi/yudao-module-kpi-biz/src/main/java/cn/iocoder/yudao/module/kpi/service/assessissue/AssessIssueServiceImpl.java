package cn.iocoder.yudao.module.kpi.service.assessissue;

import cn.iocoder.yudao.module.kpi.dal.dataobject.assesstodolist.AssessTodolistDO;
import cn.iocoder.yudao.module.kpi.dal.mysql.assessstaffitem.AssessStaffItemMapper;
import cn.iocoder.yudao.module.kpi.dal.mysql.assesstodolist.AssessTodolistMapper;
import cn.iocoder.yudao.module.system.dal.dataobject.dept.PostDO;
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
import static cn.iocoder.yudao.module.system.enums.ErrorCodeConstants.POST_NAME_DUPLICATE;
import static cn.iocoder.yudao.module.system.enums.ErrorCodeConstants.POST_NOT_FOUND;

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
    @Resource
    private AssessTodolistMapper assessTodolistMapper;

    @Resource
    private AssessStaffItemMapper assessStaffItemMapper;

    @Override
    public Long createAssessIssue(AssessIssueCreateReqVO createReqVO) {
        // 校验正确性
        validateAssessForCreateOrUpdate(null, createReqVO.getAssessTitle());
        // 插入
        AssessIssueDO assessIssue = AssessIssueConvert.INSTANCE.convert(createReqVO);
        assessIssueMapper.insert(assessIssue);
        // 返回
        return assessIssue.getId();
    }
    private void validateAssessForCreateOrUpdate(Long id, String name) {
        // 校验自己存在
        validateAssessExists(id);
        // 校验考核名的唯一性
        validateAssessNameUnique(id, name);
    }
    private void validateAssessExists(Long id) {
        if (id == null) {
            return;
        }
        if (assessIssueMapper.selectById(id) == null) {
            throw exception(POST_NOT_FOUND);
        }
    }
    private void validateAssessNameUnique(Long id, String name) {
        AssessIssueDO AssessIssue = assessIssueMapper.selectByName(name);
        if (AssessIssue == null) {
            return;
        }
        // 如果 id 为空，说明不用比较是否为相同 id 的考核名称
        if (id == null) {
            throw exception(ASSESS_NAME_DUPLICATE);
        }
        if (!AssessIssue.getId().equals(id)) {
            throw exception(ASSESS_NAME_DUPLICATE);
        }
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
    public void deleteAssessIssue(Long id,String title) {
        // 校验存在
        validateAssessIssueExists(id);
        // 删除考核发布
        assessIssueMapper.deleteByTitleAndId(id,title);
        //删除考核待办表
        assessTodolistMapper.deleteByTitle(title);
        //删除考核评分表
        assessStaffItemMapper.deleteByTitle(title);
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
    public List<AssessIssueDO> getAssessIssueLists() {
        return assessIssueMapper.selectLists();
    }
    @Override
    public void updateAssessIssueStatus(Long id, Integer status) {
        AssessIssueDO updateObj = new AssessIssueDO();
        updateObj.setId(id);
        updateObj.setStatus(status);
        assessIssueMapper.updateById(updateObj);

    }
}
