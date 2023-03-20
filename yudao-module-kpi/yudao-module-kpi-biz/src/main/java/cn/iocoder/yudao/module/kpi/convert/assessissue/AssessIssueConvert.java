package cn.iocoder.yudao.module.kpi.convert.assessissue;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.iocoder.yudao.module.kpi.controller.admin.assessissue.vo.*;
import cn.iocoder.yudao.module.kpi.dal.dataobject.assessissue.AssessIssueDO;

/**
 * 考核发布 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface AssessIssueConvert {

    AssessIssueConvert INSTANCE = Mappers.getMapper(AssessIssueConvert.class);

    AssessIssueDO convert(AssessIssueCreateReqVO bean);

    AssessIssueDO convert(AssessIssueUpdateReqVO bean);

    AssessIssueRespVO convert(AssessIssueDO bean);

    List<AssessIssueRespVO> convertList(List<AssessIssueDO> list);

    PageResult<AssessIssueRespVO> convertPage(PageResult<AssessIssueDO> page);

    List<AssessIssueExcelVO> convertList02(List<AssessIssueDO> list);

}
