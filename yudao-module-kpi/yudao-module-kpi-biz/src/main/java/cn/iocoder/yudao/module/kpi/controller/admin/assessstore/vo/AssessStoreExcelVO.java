package cn.iocoder.yudao.module.kpi.controller.admin.assessstore.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 考核指标库 Excel VO
 *
 * @author 芋道源码
 */
@Data
public class AssessStoreExcelVO {

    @ExcelProperty("主键ID")
    private Long id;

    @ExcelProperty("考核指标")
    private String title;

    @ExcelProperty("考核标准")
    private String standard;

    @ExcelProperty("考核分值")
    private Integer score;

    @ExcelProperty("备注")
    private String remark;

    @ExcelProperty("岗位编号")
    private Long postId;

    @ExcelProperty("指标状态（0正常 1停用）")
    private Integer status;

    @ExcelProperty("是否必选（0必选 1可选）")
    private Integer fixed;

    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}
