package cn.iocoder.yudao.module.kpi.controller.admin.assessissue.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - 考核发布 Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class AssessIssueRespVO extends AssessIssueBaseVO {

    @Schema(description = "主键ID", required = true, example = "32082")
    private Long id;

    @Schema(description = "创建时间", required = true)
    private LocalDateTime createTime;

}
