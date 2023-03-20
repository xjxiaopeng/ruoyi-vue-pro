package cn.iocoder.yudao.module.kpi.controller.admin.assessstaffitem.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import javax.validation.constraints.*;
import org.springframework.format.annotation.DateTimeFormat;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

/**
* 考核评分 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class AssessStaffItemBaseVO {

    @Schema(description = "考核发布ID", required = true, example = "8719")
    @NotNull(message = "考核发布ID不能为空")
    private Long issueId;

    @Schema(description = "考核待办ID", required = true, example = "28996")
    @NotNull(message = "考核待办ID不能为空")
    private Long todolistId;

    @Schema(description = "考核名称", required = true)
    @NotNull(message = "考核名称不能为空")
    private String assessTitle;

    @Schema(description = "考核指标", required = true)
    @NotNull(message = "考核指标不能为空")
    private String title;

    @Schema(description = "考核标准", required = true)
    @NotNull(message = "考核标准不能为空")
    private String standard;

    @Schema(description = "考核分值", required = true)
    @NotNull(message = "考核分值不能为空")
    private Integer score;

    @Schema(description = "自评人", required = true)
    @NotNull(message = "自评人不能为空")
    private String staff;

    @Schema(description = "自评日期")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime staffTime;

    @Schema(description = "自评完成状态（1未完成 2部分完成 3完成 ）", required = true, example = "2")
    @NotNull(message = "自评完成状态（1未完成 2部分完成 3完成 ）不能为空")
    private Integer staffCompleteStatus;

    @Schema(description = "自评分值", required = true)
    @NotNull(message = "自评分值不能为空")
    private Integer staffScore;

    @Schema(description = "自评备注", example = "你猜")
    private String staffRemark;

    @Schema(description = "考评人", required = true)
    @NotNull(message = "考评人不能为空")
    private String reviewer;

    @Schema(description = "考评日期")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime reviewerTime;

    @Schema(description = "考评完成状态（1未完成 2部分完成 3完成 ）", required = true, example = "1")
    @NotNull(message = "考评完成状态（1未完成 2部分完成 3完成 ）不能为空")
    private Integer reviewerCompleteStatus;

    @Schema(description = "考评分值", required = true)
    @NotNull(message = "考评分值不能为空")
    private Integer reviewerScore;

    @Schema(description = "考评备注", example = "你说的对")
    private String reviewerRemark;

    @Schema(description = "终评人", required = true)
    @NotNull(message = "终评人不能为空")
    private String decider;

    @Schema(description = "终评日期")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime deciderTime;

    @Schema(description = "终评完成状态（1未完成 2部分完成 3完成 ）", required = true, example = "1")
    @NotNull(message = "终评完成状态（1未完成 2部分完成 3完成 ）不能为空")
    private Integer deciderCompleteStatus;

    @Schema(description = "考评分值", required = true)
    @NotNull(message = "考评分值不能为空")
    private Integer deciderScore;

    @Schema(description = "终评备注", example = "随便")
    private String deciderRemark;

    @Schema(description = "岗位", required = true)
    @NotNull(message = "岗位不能为空")
    private String post;

    @Schema(description = "考核状态（1自评 2考评 3终评 4考核结束）", required = true, example = "1")
    @NotNull(message = "考核状态（1自评 2考评 3终评 4考核结束）不能为空")
    private Integer status;

    @Schema(description = "是否必选（0必选 1可选）", required = true)
    @NotNull(message = "是否必选（0必选 1可选）不能为空")
    private Integer fixed;

}
