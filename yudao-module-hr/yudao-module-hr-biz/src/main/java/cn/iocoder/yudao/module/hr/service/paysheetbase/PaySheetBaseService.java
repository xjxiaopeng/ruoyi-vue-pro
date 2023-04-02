package cn.iocoder.yudao.module.hr.service.paysheetbase;

import java.util.*;
import javax.validation.*;
import cn.iocoder.yudao.module.hr.controller.admin.paysheetbase.vo.*;
import cn.iocoder.yudao.module.hr.dal.dataobject.paysheetbase.PaySheetBaseDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 工资基础 Service 接口
 *
 * @author 肖鹏
 */
public interface PaySheetBaseService {

    /**
     * 创建工资基础
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createPaySheetBase(@Valid PaySheetBaseCreateReqVO createReqVO);

    /**
     * 更新工资基础
     *
     * @param updateReqVO 更新信息
     */
    void updatePaySheetBase(@Valid PaySheetBaseUpdateReqVO updateReqVO);

    /**
     * 删除工资基础
     *
     * @param id 编号
     */
    void deletePaySheetBase(Long id);

    /**
     * 获得工资基础
     *
     * @param id 编号
     * @return 工资基础
     */
    PaySheetBaseDO getPaySheetBase(Long id);

    /**
     * 获得工资基础列表
     *
     * @param ids 编号
     * @return 工资基础列表
     */
    List<PaySheetBaseDO> getPaySheetBaseList(Collection<Long> ids);

    /**
     * 获得工资基础列表
     *
     */
    List<PaySheetBaseDO> getPaySheetBaseListAll();

    /**
     * 获得工资基础分页
     *
     * @param pageReqVO 分页查询
     * @return 工资基础分页
     */
    PageResult<PaySheetBaseDO> getPaySheetBasePage(PaySheetBasePageReqVO pageReqVO);

    /**
     * 获得工资基础列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 工资基础列表
     */
    List<PaySheetBaseDO> getPaySheetBaseList(PaySheetBaseExportReqVO exportReqVO);

}
