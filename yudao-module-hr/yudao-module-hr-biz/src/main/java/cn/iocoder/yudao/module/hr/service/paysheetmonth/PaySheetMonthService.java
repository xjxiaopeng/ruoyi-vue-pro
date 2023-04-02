package cn.iocoder.yudao.module.hr.service.paysheetmonth;

import java.util.*;
import javax.validation.*;
import cn.iocoder.yudao.module.hr.controller.admin.paysheetmonth.vo.*;
import cn.iocoder.yudao.module.hr.dal.dataobject.paysheetmonth.PaySheetMonthDO;
import cn.iocoder.yudao.framework.common.pojo.PageResult;

/**
 * 月工资 Service 接口
 *
 * @author 肖鹏
 */
public interface PaySheetMonthService {

    /**
     * 创建月工资
     *
     * @param createReqVO 创建信息
     * @return 编号
     */
    Long createPaySheetMonth(@Valid PaySheetMonthCreateReqVO createReqVO);

    /**
     * 更新月工资
     *
     * @param updateReqVO 更新信息
     */
    void updatePaySheetMonth(@Valid PaySheetMonthUpdateReqVO updateReqVO);

    /**
     * 删除月工资
     *
     * @param id 编号
     */
    void deletePaySheetMonth(Long id);

    /**
     * 获得月工资
     *
     * @param id 编号
     * @return 月工资
     */
    PaySheetMonthDO getPaySheetMonth(Long id);

    /**
     * 获得月工资列表
     *
     * @param ids 编号
     * @return 月工资列表
     */
    List<PaySheetMonthDO> getPaySheetMonthList(Collection<Long> ids);

    /**
     * 获得月工资分页
     *
     * @param pageReqVO 分页查询
     * @return 月工资分页
     */
    PageResult<PaySheetMonthDO> getPaySheetMonthPage(PaySheetMonthPageReqVO pageReqVO);

    /**
     * 获得月工资列表, 用于 Excel 导出
     *
     * @param exportReqVO 查询条件
     * @return 月工资列表
     */
    List<PaySheetMonthDO> getPaySheetMonthList(PaySheetMonthExportReqVO exportReqVO);

}
