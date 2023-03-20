package cn.iocoder.yudao.module.kpi.convert.assessstore;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.iocoder.yudao.module.kpi.controller.admin.assessstore.vo.*;
import cn.iocoder.yudao.module.kpi.dal.dataobject.assessstore.AssessStoreDO;

/**
 * 考核指标库 Convert
 *
 * @author 芋道源码
 */
@Mapper
public interface AssessStoreConvert {

    AssessStoreConvert INSTANCE = Mappers.getMapper(AssessStoreConvert.class);

    AssessStoreDO convert(AssessStoreCreateReqVO bean);

    AssessStoreDO convert(AssessStoreUpdateReqVO bean);

    AssessStoreRespVO convert(AssessStoreDO bean);

    List<AssessStoreRespVO> convertList(List<AssessStoreDO> list);

    PageResult<AssessStoreRespVO> convertPage(PageResult<AssessStoreDO> page);

    List<AssessStoreExcelVO> convertList02(List<AssessStoreDO> list);

}
