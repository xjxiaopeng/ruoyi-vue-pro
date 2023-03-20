package cn.iocoder.yudao.module.kpi.controller.admin.assesstodolist.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - 考核待办 Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class AssessTodolistRespVO extends AssessTodolistBaseVO {

    @Schema(description = "主键ID", required = true, example = "11921")
    private Long id;

    @Schema(description = "创建时间", required = true)
    private LocalDateTime createTime;

}
