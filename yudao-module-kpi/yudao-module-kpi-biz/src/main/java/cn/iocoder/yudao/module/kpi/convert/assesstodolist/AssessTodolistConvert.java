package cn.iocoder.yudao.module.kpi.convert.assesstodolist;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.iocoder.yudao.module.kpi.controller.admin.assesstodolist.vo.*;
import cn.iocoder.yudao.module.kpi.dal.dataobject.assesstodolist.AssessTodolistDO;

/**
 * 考核待办 Convert
 *
 * @author 肖鹏
 */
@Mapper
public interface AssessTodolistConvert {

    AssessTodolistConvert INSTANCE = Mappers.getMapper(AssessTodolistConvert.class);

    AssessTodolistDO convert(AssessTodolistCreateReqVO bean);

    AssessTodolistDO convert(AssessTodolistUpdateReqVO bean);

    AssessTodolistRespVO convert(AssessTodolistDO bean);

    List<AssessTodolistRespVO> convertList(List<AssessTodolistDO> list);

    PageResult<AssessTodolistRespVO> convertPage(PageResult<AssessTodolistDO> page);

    List<AssessTodolistExcelVO> convertList02(List<AssessTodolistDO> list);

}
