package cn.iocoder.yudao.module.kpi.dal.mysql.assessstore;

import java.util.*;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.mybatis.core.query.LambdaQueryWrapperX;
import cn.iocoder.yudao.framework.mybatis.core.mapper.BaseMapperX;
import cn.iocoder.yudao.module.kpi.dal.dataobject.assessstore.AssessStoreDO;
import org.apache.ibatis.annotations.Mapper;
import cn.iocoder.yudao.module.kpi.controller.admin.assessstore.vo.*;

/**
 * 考核指标库 Mapper
 *
 * @author 芋道源码
 */
@Mapper
public interface AssessStoreMapper extends BaseMapperX<AssessStoreDO> {

    default PageResult<AssessStoreDO> selectPage(AssessStorePageReqVO reqVO) {
        return selectPage(reqVO, new LambdaQueryWrapperX<AssessStoreDO>()
                .eqIfPresent(AssessStoreDO::getTitle, reqVO.getTitle())
                .eqIfPresent(AssessStoreDO::getStandard, reqVO.getStandard())
                .eqIfPresent(AssessStoreDO::getScore, reqVO.getScore())
                .eqIfPresent(AssessStoreDO::getRemark, reqVO.getRemark())
                .eqIfPresent(AssessStoreDO::getPostId, reqVO.getPostId())
                .eqIfPresent(AssessStoreDO::getStatus, reqVO.getStatus())
                .or()
                .eq(AssessStoreDO::getFixed, reqVO.getFixed())
                //.eqIfPresent(AssessStoreDO::getFixed, reqVO.getFixed())
                .orderByAsc(AssessStoreDO::getId));
    }

    default List<AssessStoreDO> selectList(AssessStoreExportReqVO reqVO) {
        return selectList(new LambdaQueryWrapperX<AssessStoreDO>()
                .eqIfPresent(AssessStoreDO::getTitle, reqVO.getTitle())
                .eqIfPresent(AssessStoreDO::getStandard, reqVO.getStandard())
                .eqIfPresent(AssessStoreDO::getScore, reqVO.getScore())
                .eqIfPresent(AssessStoreDO::getRemark, reqVO.getRemark())
                .eqIfPresent(AssessStoreDO::getPostId, reqVO.getPostId())
                .eqIfPresent(AssessStoreDO::getStatus, reqVO.getStatus())
                .eqIfPresent(AssessStoreDO::getFixed, reqVO.getFixed())
                .betweenIfPresent(AssessStoreDO::getCreateTime, reqVO.getCreateTime())
                .orderByDesc(AssessStoreDO::getId));
    }
    default List<AssessStoreDO> selectList(Long postId,Integer fixed) {
        return selectList(new LambdaQueryWrapperX<AssessStoreDO>()
                .eqIfPresent(AssessStoreDO::getPostId, postId)
                .or()
                .eq(AssessStoreDO::getFixed, fixed)
                .orderByDesc(AssessStoreDO::getId));
    }

    default List<AssessStoreDO> selectLists(AssessStoreListReqVO listReqVO) {
        return selectList(new LambdaQueryWrapperX<AssessStoreDO>()
                .eqIfPresent(AssessStoreDO::getStatus, listReqVO.getStatus())
                .eqIfPresent(AssessStoreDO::getPostId, listReqVO.getPostId())
                .or()
                .eq(AssessStoreDO::getFixed, listReqVO.getFixed())
                .orderByAsc(AssessStoreDO::getId));
    }
}
