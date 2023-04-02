package cn.iocoder.yudao.module.hr.controller.admin.paysheetmonth.vo;

import io.swagger.v3.oas.annotations.media.Schema;
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

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 月工资 Excel VO
 *
 * @author 肖鹏
 */
@Data
public class PaySheetMonthExcelVO {

    @ExcelProperty("主键ID")
    private Long id;

    @ExcelProperty("工资表名称")
    private String wageName;

    @ExcelProperty("姓名")
    private String nickname;

    @ExcelProperty("部门")
    private String deptName;

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

}
