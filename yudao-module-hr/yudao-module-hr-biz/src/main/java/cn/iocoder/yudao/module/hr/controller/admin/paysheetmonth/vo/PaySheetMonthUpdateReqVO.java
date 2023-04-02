package cn.iocoder.yudao.module.hr.controller.admin.paysheetmonth.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import javax.validation.constraints.*;

@Schema(description = "管理后台 - 月工资更新 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class PaySheetMonthUpdateReqVO extends PaySheetMonthBaseVO {

    @Schema(description = "主键ID", required = true, example = "339")
    @NotNull(message = "主键ID不能为空")
    private Long id;

}
