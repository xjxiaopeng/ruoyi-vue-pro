package cn.iocoder.yudao.module.kpi.controller.admin.assessstaffitem.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Schema(description = "管理后台 - 考核评分列表根据考核状态和评分状态获取评分列表 Request VO")
@Data
public class AssessStaffItemListReqVO {

    @Schema(description ="考核发布ID", required = true, example = "2443")
    //@NotNull(message = "考核发布ID不能为空")
    private Long issueId;

    @Schema(description = "考核待办ID", required = true, example = "28883")
    //@NotNull(message = "考核待办ID不能为空")
    private Long todolistId;

    @Schema(description = "考核名称", required = true, example = "考核名称")
    //@NotNull(message = "考核名称不能为空")
    private String assessTitle;

    @Schema(description = "自评人", required = true)
    //@NotNull(message = "自评人不能为空")
    private String staff;

    @Schema(description = "自评完成状态（1未完成 2部分完成 3完成 ）", required = true, example = "1")
    //@NotNull(message = "自评完成状态（1未完成 2部分完成 3完成 ）不能为空")
    private Integer staffCompleteStatus;

    @Schema(description = "考评人", required = true)
    //@NotNull(message = "考评人不能为空")
    private String reviewer;

    @Schema(description = "考评完成状态（1未完成 2部分完成 3完成 ）", required = true, example = "2")
    //@NotNull(message = "考评完成状态（1未完成 2部分完成 3完成 ）不能为空")
    private Integer reviewerCompleteStatus;

    @Schema(description = "终评人", required = true)
    //@NotNull(message = "终评人不能为空")
    private String decider;

    @Schema(description = "终评完成状态（1未完成 2部分完成 3完成 ）", required = true, example = "2")
    //@NotNull(message = "终评完成状态（1未完成 2部分完成 3完成 ）不能为空")
    private Integer deciderCompleteStatus;


    @Schema(description = "考核状态（1自评 2考评 3终评 4考核结束）", example = "2")
    private Integer status;

}

