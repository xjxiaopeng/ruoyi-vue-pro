package cn.iocoder.yudao.module.kpi.controller.admin.assessstaffitem.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import javax.validation.constraints.*;

@Schema(description = "管理后台 - 考核评分更新 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class AssessStaffItemUpdateReqVO extends AssessStaffItemBaseVO {

    @Schema(description = "主键ID", required = true, example = "6246")
    @NotNull(message = "主键ID不能为空")
    private Long id;

}
