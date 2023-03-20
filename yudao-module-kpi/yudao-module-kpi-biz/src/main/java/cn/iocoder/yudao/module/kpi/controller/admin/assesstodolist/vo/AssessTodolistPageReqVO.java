package cn.iocoder.yudao.module.kpi.controller.admin.assesstodolist.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import org.springframework.format.annotation.DateTimeFormat;
import java.time.LocalDateTime;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 考核待办分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class AssessTodolistPageReqVO extends PageParam {

    @Schema(description = "考核发布ID", example = "2212")
    private Long issueId;

    @Schema(description = "考核名称")
    private String assessTitle;

    @Schema(description = "自评人")
    private String staff;

    @Schema(description = "自评日期")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] staffTime;

    @Schema(description = "自评状态（1待办 0已办 2 无）", example = "2")
    private Integer staffStatus;

    @Schema(description = "考评人")
    private String reviewer;

    @Schema(description = "考评日期")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] reviewerTime;

    @Schema(description = "考评状态（1待办 0已办 2 无）", example = "2")
    private Integer reviewerStatus;

    @Schema(description = "终评人")
    private String decider;

    @Schema(description = "终评日期")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] deciderTime;

    @Schema(description = "终评状态（1待办 0已办 2 无）", example = "2")
    private Integer deciderStatus;

    @Schema(description = "考核开始时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] assessStartTime;

    @Schema(description = "考核结束时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] assessEndTime;

    @Schema(description = "待办状态（1自评 2考评 3终评 4考核结束）", example = "1")
    private Integer status;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
