package cn.iocoder.yudao.module.kpi.controller.admin.assessstore.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.*;

@Schema(description = "管理后台 - 考核指标库创建 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class AssessStoreCreateReqVO extends AssessStoreBaseVO {

}
