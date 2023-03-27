package cn.iocoder.yudao.module.hr.convert.paysheetbase;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.iocoder.yudao.module.hr.controller.admin.paysheetbase.vo.*;
import cn.iocoder.yudao.module.hr.dal.dataobject.paysheetbase.PaySheetBaseDO;

/**
 * 工资基础 Convert
 *
 * @author 肖鹏
 */
@Mapper
public interface PaySheetBaseConvert {

    PaySheetBaseConvert INSTANCE = Mappers.getMapper(PaySheetBaseConvert.class);

    PaySheetBaseDO convert(PaySheetBaseCreateReqVO bean);

    PaySheetBaseDO convert(PaySheetBaseUpdateReqVO bean);

    PaySheetBaseRespVO convert(PaySheetBaseDO bean);

    List<PaySheetBaseRespVO> convertList(List<PaySheetBaseDO> list);

    PageResult<PaySheetBaseRespVO> convertPage(PageResult<PaySheetBaseDO> page);

    List<PaySheetBaseExcelVO> convertList02(List<PaySheetBaseDO> list);

}
