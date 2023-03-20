package cn.iocoder.yudao.module.kpi.service.assesstodolist;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import org.springframework.validation.annotation.Validated;

import java.util.*;
import cn.iocoder.yudao.module.kpi.controller.admin.assesstodolist.vo.*;
import cn.iocoder.yudao.module.kpi.dal.dataobject.assesstodolist.AssessTodolistDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

import cn.iocoder.yudao.module.kpi.convert.assesstodolist.AssessTodolistConvert;
import cn.iocoder.yudao.module.kpi.dal.mysql.assesstodolist.AssessTodolistMapper;

import static cn.iocoder.yudao.framework.common.exception.util.ServiceExceptionUtil.exception;
import static cn.iocoder.yudao.module.kpi.enums.ErrorCodeConstants.*;

/**
 * 考核待办 Service 实现类
 *
 * @author 肖鹏
 */
@Service
@Validated
public class AssessTodolistServiceImpl implements AssessTodolistService {

    @Resource
    private AssessTodolistMapper assessTodolistMapper;

    @Override
    public Long createAssessTodolist(AssessTodolistCreateReqVO createReqVO) {
        // 插入
        AssessTodolistDO assessTodolist = AssessTodolistConvert.INSTANCE.convert(createReqVO);
        assessTodolistMapper.insert(assessTodolist);
        // 返回
        return assessTodolist.getId();
    }

    @Override
    public void updateAssessTodolist(AssessTodolistUpdateReqVO updateReqVO) {
        // 校验存在
        validateAssessTodolistExists(updateReqVO.getId());
        // 更新
        AssessTodolistDO updateObj = AssessTodolistConvert.INSTANCE.convert(updateReqVO);
        assessTodolistMapper.updateById(updateObj);
    }

    @Override
    public void deleteAssessTodolist(Long id) {
        // 校验存在
        validateAssessTodolistExists(id);
        // 删除
        assessTodolistMapper.deleteById(id);
    }

    private void validateAssessTodolistExists(Long id) {
        if (assessTodolistMapper.selectById(id) == null) {
            throw exception(ASSESS_TODOLIST_NOT_EXISTS);
        }
    }

    @Override
    public AssessTodolistDO getAssessTodolist(Long id) {
        return assessTodolistMapper.selectById(id);
    }

    @Override
    public List<AssessTodolistDO> getAssessTodolistList(Collection<Long> ids) {
        return assessTodolistMapper.selectBatchIds(ids);
    }

    @Override
    public PageResult<AssessTodolistDO> getAssessTodolistPage(AssessTodolistPageReqVO pageReqVO) {
        return assessTodolistMapper.selectPage(pageReqVO);
    }

    @Override
    public List<AssessTodolistDO> getAssessTodolistList(AssessTodolistExportReqVO exportReqVO) {
        return assessTodolistMapper.selectList(exportReqVO);
    }

}
