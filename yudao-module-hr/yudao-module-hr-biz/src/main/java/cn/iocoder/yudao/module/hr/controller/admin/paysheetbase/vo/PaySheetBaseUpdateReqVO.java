package cn.iocoder.yudao.module.hr.controller.admin.paysheetbase.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import javax.validation.constraints.*;

@Schema(description = "管理后台 - 工资基础更新 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class PaySheetBaseUpdateReqVO extends PaySheetBaseBaseVO {

    @Schema(description = "主键ID", required = true, example = "17328")
    @NotNull(message = "主键ID不能为空")
    private Long id;

}
