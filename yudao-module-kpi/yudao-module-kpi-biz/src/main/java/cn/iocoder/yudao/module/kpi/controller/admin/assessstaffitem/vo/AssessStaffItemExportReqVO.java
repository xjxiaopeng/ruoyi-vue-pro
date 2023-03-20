package cn.iocoder.yudao.module.kpi.controller.admin.assessstaffitem.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import java.time.LocalDateTime;
import org.springframework.format.annotation.DateTimeFormat;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 考核评分 Excel 导出 Request VO，参数和 AssessStaffItemPageReqVO 是一致的")
@Data
public class AssessStaffItemExportReqVO {

    @Schema(description = "考核发布ID", example = "8719")
    private Long issueId;

    @Schema(description = "考核待办ID", example = "28996")
    private Long todolistId;

    @Schema(description = "考核名称")
    private String assessTitle;

    @Schema(description = "考核指标")
    private String title;

    @Schema(description = "考核标准")
    private String standard;

    @Schema(description = "考核分值")
    private Integer score;

    @Schema(description = "自评人")
    private String staff;

    @Schema(description = "自评日期")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] staffTime;

    @Schema(description = "自评完成状态（1未完成 2部分完成 3完成 ）", example = "2")
    private Integer staffCompleteStatus;

    @Schema(description = "自评分值")
    private Integer staffScore;

    @Schema(description = "自评备注", example = "你猜")
    private String staffRemark;

    @Schema(description = "考评人")
    private String reviewer;

    @Schema(description = "考评日期")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] reviewerTime;

    @Schema(description = "考评完成状态（1未完成 2部分完成 3完成 ）", example = "1")
    private Integer reviewerCompleteStatus;

    @Schema(description = "考评分值")
    private Integer reviewerScore;

    @Schema(description = "考评备注", example = "你说的对")
    private String reviewerRemark;

    @Schema(description = "终评人")
    private String decider;

    @Schema(description = "终评日期")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] deciderTime;

    @Schema(description = "终评完成状态（1未完成 2部分完成 3完成 ）", example = "1")
    private Integer deciderCompleteStatus;

    @Schema(description = "考评分值")
    private Integer deciderScore;

    @Schema(description = "终评备注", example = "随便")
    private String deciderRemark;

    @Schema(description = "岗位")
    private String post;

    @Schema(description = "考核状态（1自评 2考评 3终评 4考核结束）", example = "1")
    private Integer status;

    @Schema(description = "是否必选（0必选 1可选）")
    private Integer fixed;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
