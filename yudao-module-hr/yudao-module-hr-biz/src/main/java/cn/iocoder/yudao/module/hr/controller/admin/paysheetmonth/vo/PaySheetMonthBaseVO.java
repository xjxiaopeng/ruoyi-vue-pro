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
import javax.validation.constraints.*;

/**
* 月工资 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class PaySheetMonthBaseVO {

    @Schema(description = "工资表名称", required = true, example = "赵六")
    @NotNull(message = "工资表名称不能为空")
    private String wageName;

    @Schema(description = "姓名", required = true, example = "芋艿")
    @NotNull(message = "姓名不能为空")
    private String nickname;

    @Schema(description = "部门", required = true, example = "王五")
    @NotNull(message = "部门不能为空")
    private String deptName;

    @Schema(description = "基本工资")
    private BigDecimal basePay;

    @Schema(description = "绩效工资")
    private BigDecimal meritPay;

    @Schema(description = "加班工资")
    private BigDecimal overtimePay;

    @Schema(description = "高温补贴")
    private BigDecimal hightemperatureSubsidy;

    @Schema(description = "补助")
    private BigDecimal allowance;

    @Schema(description = "餐补")
    private BigDecimal lunchSubsides;

    @Schema(description = "事假")
    private BigDecimal personalLeave;

    @Schema(description = "病假")
    private BigDecimal sickLeave;

    @Schema(description = "其他")
    private BigDecimal rests;

    @Schema(description = "住房公积金")
    private BigDecimal housingFund;

    @Schema(description = "养老保险")
    private BigDecimal oldageInsurance;

    @Schema(description = "医疗保险")
    private BigDecimal medicalInsurance;

    @Schema(description = "失业保险")
    private BigDecimal unemploymentInsurance;

    @Schema(description = "工伤保险")
    private BigDecimal njuryInsurance;

}
