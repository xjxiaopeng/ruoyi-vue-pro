package cn.iocoder.yudao.module.hr.controller.admin.paysheetbase.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

@Schema(description = "管理后台 - 工资基础 Excel 导出 Request VO，参数和 PaySheetBasePageReqVO 是一致的")
@Data
public class PaySheetBaseExportReqVO {

    @Schema(description = "用户ID", example = "3485")
    private Long userId;

    @Schema(description = "部门ID", example = "24093")
    private Long deptId;



}
