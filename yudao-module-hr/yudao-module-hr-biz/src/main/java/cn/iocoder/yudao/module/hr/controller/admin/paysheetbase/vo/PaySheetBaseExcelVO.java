package cn.iocoder.yudao.module.hr.controller.admin.paysheetbase.vo;

import com.alibaba.excel.annotation.ExcelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 工资基础 Excel VO
 *
 * @author 肖鹏
 */
@Data
public class PaySheetBaseExcelVO {

    @ExcelProperty("主键ID")
    private Long id;

    @ExcelProperty("用户ID")
    private Long userId;

    @ExcelProperty("部门ID")
    private Long deptId;

    @ExcelProperty("部门名称")
    private String deptName;

    @ExcelProperty("用户昵称")
    private String nickname;

    @ExcelProperty("基本工资")
    private BigDecimal basePay;

    @ExcelProperty("绩效工资")
    private BigDecimal meritPay;

    @ExcelProperty("加班工资")
    private BigDecimal overtimePay;

    @ExcelProperty("高温补贴")
    private BigDecimal hightemperatureSubsidy;

    @ExcelProperty("补助")
    private BigDecimal allowance;

    @ExcelProperty("餐补")
    private BigDecimal lunchSubsides;

    @ExcelProperty("事假")
    private BigDecimal personalLeave;

    @ExcelProperty("病假")
    private BigDecimal sickLeave;

    @ExcelProperty("其他")
    private BigDecimal rests;

    @ExcelProperty("住房公积金")
    private BigDecimal housingFund;

    @ExcelProperty("养老保险")
    private BigDecimal oldageInsurance;

    @ExcelProperty("医疗保险")
    private BigDecimal medicalInsurance;

    @ExcelProperty("失业保险")
    private BigDecimal unemploymentInsurance;

    @ExcelProperty("工伤保险")
    private BigDecimal njuryInsurance;

    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}
