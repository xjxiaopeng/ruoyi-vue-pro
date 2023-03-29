package cn.iocoder.yudao.module.kpi.controller.admin.assessissue.vo;


import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Schema(description ="管理后台 -id和 删除考核标题 Request VO")
@Data
public class AssessIssueDeleteReqVO {
    @Schema(description = "考核编号", required = true, example = "1024")
    @NotNull(message = "考核编号不能为空")
    private Long id;

    @Schema(description = "考核名称", required = true)
    @NotNull(message = "考核名称不能为空")
    private String assessTitle;
}
