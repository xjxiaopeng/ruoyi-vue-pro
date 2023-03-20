package cn.iocoder.yudao.module.kpi.controller.admin.assessissue.vo;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Schema(description ="管理后台 - 考核发布更新状态 Request VO")
@Data
public class AssessIssueUpdateStatusReqVO {
    @Schema(description = "考核编号", required = true, example = "1024")
    @NotNull(message = "考核编号不能为空")
    private Long id;

    @Schema(description = "状态", required = true, example = "1")
    @NotNull(message = "状态不能为空")
    private Integer status;
}
