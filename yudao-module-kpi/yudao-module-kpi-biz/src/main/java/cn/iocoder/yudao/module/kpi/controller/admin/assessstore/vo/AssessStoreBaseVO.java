package cn.iocoder.yudao.module.kpi.controller.admin.assessstore.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import javax.validation.constraints.*;

/**
* 考核指标库 Base VO，提供给添加、修改、详细的子 VO 使用
* 如果子 VO 存在差异的字段，请不要添加到这里，影响 Swagger 文档生成
*/
@Data
public class AssessStoreBaseVO {

    @Schema(description = "考核指标", required = true)
    @NotNull(message = "考核指标不能为空")
    private String title;

    @Schema(description = "考核标准", required = true)
    @NotNull(message = "考核标准不能为空")
    private String standard;

    @Schema(description = "考核分值", required = true)
    @NotNull(message = "考核分值不能为空")
    private Integer score;

    @Schema(description = "备注", example = "你猜")
    private String remark;

    @Schema(description = "岗位编号", required = true, example = "27484")
    @NotNull(message = "岗位编号不能为空")
    private Long postId;

    @Schema(description = "指标状态（0正常 1停用）", required = true, example = "1")
    @NotNull(message = "指标状态（0正常 1停用）不能为空")
    private Integer status;

    @Schema(description = "是否必选（0必选 1可选）", required = true)
    @NotNull(message = "是否必选（0必选 1可选）不能为空")
    private Integer fixed;

}
