package cn.iocoder.yudao.module.hr.dal.mysql.paysheetmonth;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.hr.dal.dataobject.paysheetmonth.PaySheetMonthDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.hr.controller.admin.paysheetmonth.vo.*;

/**
 * 月工资 Mapper
 *
 * @author 肖鹏
 */
@Mapper
public interface PaySheetMonthMapper extends BaseMapperX<PaySheetMonthDO> {

    default PageResult<PaySheetMonthDO> selectPage(PaySheetMonthPageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<PaySheetMonthDO>()
                .likeIfPresent(PaySheetMonthDO::getWageName, reqVO.getWageName())
                .likeIfPresent(PaySheetMonthDO::getNickname, reqVO.getNickname())
                .likeIfPresent(PaySheetMonthDO::getDeptName, reqVO.getDeptName())
                .orderByDesc(PaySheetMonthDO::getId));
    }

    default List<PaySheetMonthDO> selectList(PaySheetMonthExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<PaySheetMonthDO>()
                .likeIfPresent(PaySheetMonthDO::getWageName, reqVO.getWageName())
                .likeIfPresent(PaySheetMonthDO::getNickname, reqVO.getNickname())
                .likeIfPresent(PaySheetMonthDO::getDeptName, reqVO.getDeptName())
                .orderByDesc(PaySheetMonthDO::getId));
    }

}
