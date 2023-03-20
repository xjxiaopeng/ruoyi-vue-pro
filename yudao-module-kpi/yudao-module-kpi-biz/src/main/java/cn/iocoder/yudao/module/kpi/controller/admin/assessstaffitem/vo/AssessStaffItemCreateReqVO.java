package cn.iocoder.yudao.module.kpi.controller.admin.assessstaffitem.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.*;

@Schema(description = "管理后台 - 考核评分创建 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class AssessStaffItemCreateReqVO extends AssessStaffItemBaseVO {

}
