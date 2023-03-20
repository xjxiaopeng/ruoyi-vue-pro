package cn.iocoder.yudao.module.kpi.controller.admin.assessissue.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import javax.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

/**
* 考核发布 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class AssessIssueBaseVO {

    @Schema(description = "考核名称", required = true)
    @NotNull(message = "考核名称不能为空")
    private String assessTitle;

    @Schema(description = "用户编号数组")
    private Set<Long> userIds;

    @Schema(description = "考评人")
    private String reviewer;

    @Schema(description = "终评人")
    private String decider;

    @Schema(description = "考核开始时间", required = true)
    @NotNull(message = "考核开始时间不能为空")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime assessStartTime;

    @Schema(description = "考核结束时间", required = true)
    @NotNull(message = "考核结束时间不能为空")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime assessEndTime;

    @Schema(description = "发布状态（1未发布 0发布）", required = true, example = "1")
    @NotNull(message = "发布状态（1未发布 0发布）不能为空")
    private Integer status;

}
