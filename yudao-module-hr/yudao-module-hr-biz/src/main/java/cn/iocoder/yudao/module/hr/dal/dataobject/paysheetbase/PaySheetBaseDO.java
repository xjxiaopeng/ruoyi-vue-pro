package cn.iocoder.yudao.module.hr.dal.dataobject.paysheetbase;

import lombok.*;
import java.util.*;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 工资基础 DO
 *
 * @author 肖鹏
 */
@TableName("hr_pay_sheet_base")
@KeySequence("hr_pay_sheet_base_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PaySheetBaseDO extends BaseDO {

    /**
     * 主键ID
     */
    @TableId
    private Long id;
    /**
     * 用户ID
     */
    private Long userId;
    /**
     * 部门ID
     */
    private Long deptId;
    /**
     * 部门名称
     */
    private String deptName;
    /**
     * 用户昵称
     */
    private String nickname;
    /**
     * 基本工资
     */
    private BigDecimal basePay;
    /**
     * 绩效工资
     */
    private BigDecimal meritPay;
    /**
     * 加班工资
     */
    private BigDecimal overtimePay;
    /**
     * 高温补贴
     */
    private BigDecimal hightemperatureSubsidy;
    /**
     * 补助
     */
    private BigDecimal allowance;
    /**
     * 餐补
     */
    private BigDecimal lunchSubsides;
    /**
     * 事假
     */
    private BigDecimal personalLeave;
    /**
     * 病假
     */
    private BigDecimal sickLeave;
    /**
     * 其他
     */
    private BigDecimal rests;
    /**
     * 住房公积金
     */
    private BigDecimal housingFund;
    /**
     * 养老保险
     */
    private BigDecimal oldageInsurance;
    /**
     * 医疗保险
     */
    private BigDecimal medicalInsurance;
    /**
     * 失业保险
     */
    private BigDecimal unemploymentInsurance;
    /**
     * 工伤保险
     */
    private BigDecimal njuryInsurance;

}
