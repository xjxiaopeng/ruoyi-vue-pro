package cn.iocoder.yudao.module.kpi.controller.admin.assessstore.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - 考核指标库 Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class AssessStoreRespVO extends AssessStoreBaseVO {

    @Schema(description = "主键ID", required = true, example = "32088")
    private Long id;

    @Schema(description = "创建时间", required = true)
    private LocalDateTime createTime;

}
