package cn.iocoder.yudao.module.hr.dal.mysql.paysheetbase;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.hr.dal.dataobject.paysheetbase.PaySheetBaseDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.hr.controller.admin.paysheetbase.vo.*;

/**
 * 工资基础 Mapper
 *
 * @author 肖鹏
 */
@Mapper
public interface PaySheetBaseMapper extends BaseMapperX<PaySheetBaseDO> {

    default PageResult<PaySheetBaseDO> selectPage(PaySheetBasePageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<PaySheetBaseDO>()
                .eqIfPresent(PaySheetBaseDO::getUserId, reqVO.getUserId())
                .eqIfPresent(PaySheetBaseDO::getDeptId, reqVO.getDeptId())
                .likeIfPresent(PaySheetBaseDO::getNickname, reqVO.getNickname())
                .orderByDesc(PaySheetBaseDO::getId));
    }

    default List<PaySheetBaseDO> selectList(PaySheetBaseExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<PaySheetBaseDO>()
                .eqIfPresent(PaySheetBaseDO::getUserId, reqVO.getUserId())
                .eqIfPresent(PaySheetBaseDO::getDeptId, reqVO.getDeptId())
                .likeIfPresent(PaySheetBaseDO::getNickname, reqVO.getNickname())
                .orderByDesc(PaySheetBaseDO::getId));
    }

}
