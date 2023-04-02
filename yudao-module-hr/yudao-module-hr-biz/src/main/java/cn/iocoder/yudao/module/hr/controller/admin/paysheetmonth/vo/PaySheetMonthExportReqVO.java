package cn.iocoder.yudao.module.hr.controller.admin.paysheetmonth.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;

@Schema(description = "管理后台 - 月工资 Excel 导出 Request VO，参数和 PaySheetMonthPageReqVO 是一致的")
@Data
public class PaySheetMonthExportReqVO {

    @Schema(description = "工资表名称", example = "赵六")
    private String wageName;

    @Schema(description = "姓名", example = "芋艿")
    private String nickname;

    @Schema(description = "部门", example = "王五")
    private String deptName;

}
