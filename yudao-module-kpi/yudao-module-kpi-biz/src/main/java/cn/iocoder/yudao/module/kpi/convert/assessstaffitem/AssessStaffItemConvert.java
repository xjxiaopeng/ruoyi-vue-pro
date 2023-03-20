package cn.iocoder.yudao.module.kpi.convert.assessstaffitem;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.iocoder.yudao.module.kpi.controller.admin.assessstaffitem.vo.*;
import cn.iocoder.yudao.module.kpi.dal.dataobject.assessstaffitem.AssessStaffItemDO;

/**
 * 考核评分 Convert
 *
 * @author 肖鹏
 */
@Mapper
public interface AssessStaffItemConvert {

    AssessStaffItemConvert INSTANCE = Mappers.getMapper(AssessStaffItemConvert.class);

    AssessStaffItemDO convert(AssessStaffItemCreateReqVO bean);

    AssessStaffItemDO convert(AssessStaffItemUpdateReqVO bean);

    AssessStaffItemRespVO convert(AssessStaffItemDO bean);

    List<AssessStaffItemRespVO> convertList(List<AssessStaffItemDO> list);

    PageResult<AssessStaffItemRespVO> convertPage(PageResult<AssessStaffItemDO> page);

    List<AssessStaffItemExcelVO> convertList02(List<AssessStaffItemDO> list);

}
