package cn.iocoder.yudao.module.kpi.controller.admin.assessissue.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.*;

@Schema(description = "管理后台 - 考核发布创建 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class AssessIssueCreateReqVO extends AssessIssueBaseVO {

}
