package cn.iocoder.yudao.module.hr.controller.admin.paysheetbase.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

@Schema(description = "管理后台 - 工资基础分页 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class PaySheetBasePageReqVO extends PageParam {

    @Schema(description = "用户ID", example = "3485")
    private Long userId;

    @Schema(description = "部门ID", example = "24093")
    private Long deptId;

    @Schema(description = "用户昵称", example = "张三")
    private String nickname;

}
