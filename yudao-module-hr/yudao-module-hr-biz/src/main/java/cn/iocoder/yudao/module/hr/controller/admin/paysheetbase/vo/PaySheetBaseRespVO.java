package cn.iocoder.yudao.module.hr.controller.admin.paysheetbase.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - 工资基础 Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class PaySheetBaseRespVO extends PaySheetBaseBaseVO {

    @Schema(description = "主键ID", required = true, example = "17328")
    private Long id;

    @Schema(description = "创建时间", required = true)
    private LocalDateTime createTime;

}
