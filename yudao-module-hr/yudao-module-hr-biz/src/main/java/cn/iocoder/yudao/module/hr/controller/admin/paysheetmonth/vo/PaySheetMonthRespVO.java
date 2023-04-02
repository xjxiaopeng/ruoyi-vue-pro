package cn.iocoder.yudao.module.hr.controller.admin.paysheetmonth.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.time.LocalDateTime;

@Schema(description = "管理后台 - 月工资 Response VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class PaySheetMonthRespVO extends PaySheetMonthBaseVO {

    @Schema(description = "主键ID", required = true, example = "339")
    private Long id;

}
