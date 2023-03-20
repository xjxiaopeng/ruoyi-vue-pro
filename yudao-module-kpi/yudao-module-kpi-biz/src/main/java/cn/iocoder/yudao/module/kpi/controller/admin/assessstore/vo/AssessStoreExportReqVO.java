package cn.iocoder.yudao.module.kpi.controller.admin.assessstore.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import cn.iocoder.yudao.framework.common.pojo.PageParam;
import java.time.LocalDateTime;
import org.springframework.format.annotation.DateTimeFormat;

import static cn.iocoder.yudao.framework.common.util.date.DateUtils.FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND;

@Schema(description = "管理后台 - 考核指标库 Excel 导出 Request VO，参数和 AssessStorePageReqVO 是一致的")
@Data
public class AssessStoreExportReqVO {

    @Schema(description = "考核指标")
    private String title;

    @Schema(description = "考核标准")
    private String standard;

    @Schema(description = "考核分值")
    private Byte score;

    @Schema(description = "备注", example = "你猜")
    private String remark;

    @Schema(description = "岗位编号", example = "27484")
    private Long postId;

    @Schema(description = "指标状态（0正常 1停用）", example = "1")
    private Byte status;

    @Schema(description = "是否必选（0必选 1可选）")
    private Byte fixed;

    @Schema(description = "创建时间")
    @DateTimeFormat(pattern = FORMAT_YEAR_MONTH_DAY_HOUR_MINUTE_SECOND)
    private LocalDateTime[] createTime;

}
