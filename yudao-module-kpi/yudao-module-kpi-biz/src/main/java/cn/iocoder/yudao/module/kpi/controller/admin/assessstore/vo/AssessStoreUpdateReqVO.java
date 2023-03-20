package cn.iocoder.yudao.module.kpi.controller.admin.assessstore.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import javax.validation.constraints.*;

@Schema(description = "管理后台 - 考核指标库更新 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class AssessStoreUpdateReqVO extends AssessStoreBaseVO {

    @Schema(description = "主键ID", required = true, example = "32088")
    @NotNull(message = "主键ID不能为空")
    private Long id;

}
