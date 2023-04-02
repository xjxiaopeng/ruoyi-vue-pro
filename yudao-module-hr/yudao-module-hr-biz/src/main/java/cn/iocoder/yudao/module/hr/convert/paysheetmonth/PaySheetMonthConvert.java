package cn.iocoder.yudao.module.hr.convert.paysheetmonth;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import cn.iocoder.yudao.module.hr.controller.admin.paysheetmonth.vo.*;
import cn.iocoder.yudao.module.hr.dal.dataobject.paysheetmonth.PaySheetMonthDO;

/**
 * 月工资 Convert
 *
 * @author 肖鹏
 */
@Mapper
public interface PaySheetMonthConvert {

    PaySheetMonthConvert INSTANCE = Mappers.getMapper(PaySheetMonthConvert.class);

    PaySheetMonthDO convert(PaySheetMonthCreateReqVO bean);

    PaySheetMonthDO convert(PaySheetMonthUpdateReqVO bean);

    PaySheetMonthRespVO convert(PaySheetMonthDO bean);

    List<PaySheetMonthRespVO> convertList(List<PaySheetMonthDO> list);

    PageResult<PaySheetMonthRespVO> convertPage(PageResult<PaySheetMonthDO> page);

    List<PaySheetMonthExcelVO> convertList02(List<PaySheetMonthDO> list);

}
