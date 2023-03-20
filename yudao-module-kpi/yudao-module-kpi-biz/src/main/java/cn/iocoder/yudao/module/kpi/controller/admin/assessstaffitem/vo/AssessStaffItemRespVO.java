package cn.iocoder.yudao.module.kpi.controller.admin.assessstaffitem.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - 考核评分 Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class AssessStaffItemRespVO extends AssessStaffItemBaseVO {

    @Schema(description = "主键ID", required = true, example = "6246")
    private Long id;

    @Schema(description = "创建时间", required = true)
    private LocalDateTime createTime;

}
