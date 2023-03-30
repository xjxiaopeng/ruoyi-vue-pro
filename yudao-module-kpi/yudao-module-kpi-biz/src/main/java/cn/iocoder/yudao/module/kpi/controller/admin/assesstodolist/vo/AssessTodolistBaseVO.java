package cn.iocoder.yudao.module.kpi.controller.admin.assesstodolist.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import javax.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

/**
* 考核待办 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class AssessTodolistBaseVO {

    @Schema(description = "考核发布ID", required = true, example = "2212")
    @NotNull(message = "考核发布ID不能为空")
    private Long issueId;

    @Schema(description = "考核名称", required = true)
    @NotNull(message = "考核名称不能为空")
    private String assessTitle;

    @Schema(description = "自评人")
    private String staff;

    @Schema(description = "自评日期")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime staffTime;

    @Schema(description = "自评状态（1待办 0已办 2 无）", required = true, example = "2")
    @NotNull(message = "自评状态（1待办 0已办 2 无）不能为空")
    private Integer staffStatus;

    @Schema(description = "考评人")
    private String reviewer;

    @Schema(description = "考评日期")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime reviewerTime;

    @Schema(description = "考评状态（1待办 0已办 2 无）", required = true, example = "2")
    @NotNull(message = "考评状态（1待办 0已办 2 无）不能为空")
    private Integer reviewerStatus;

    @Schema(description = "终评人")
    private String decider;

    @Schema(description = "终评日期")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime deciderTime;

    @Schema(description = "终评状态（1待办 0已办 2 无）", required = true, example = "2")
    @NotNull(message = "终评状态（1待办 0已办 2 无）不能为空")
    private Integer deciderStatus;

    @Schema(description = "备注", required = true, example = "2")
    private  String remark;
    @Schema(description = "考核开始时间", required = true)
    @NotNull(message = "考核开始时间不能为空")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime assessStartTime;

    @Schema(description = "考核结束时间", required = true)
    @NotNull(message = "考核结束时间不能为空")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime assessEndTime;

    @Schema(description = "待办状态（1自评 2考评 3终评 4考核结束）", required = true, example = "1")
    @NotNull(message = "待办状态（1自评 2考评 3终评 4考核结束）不能为空")
    private Integer status;

}
