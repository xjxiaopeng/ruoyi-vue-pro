package cn.iocoder.yudao.module.kpi.controller.admin.assessstaffitem.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import java.time.LocalDateTime;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 考核评分 Excel VO
 *
 * @author 肖鹏
 */
@Data
public class AssessStaffItemExcelVO {

    @ExcelProperty("主键ID")
    private Long id;

    @ExcelProperty("考核发布ID")
    private Long issueId;

    @ExcelProperty("考核待办ID")
    private Long todolistId;

    @ExcelProperty("考核名称")
    private String assessTitle;

    @ExcelProperty("考核指标")
    private String title;

    @ExcelProperty("考核标准")
    private String standard;

    @ExcelProperty("考核分值")
    private Integer score;

    @ExcelProperty("自评人")
    private String staff;

    @ExcelProperty("自评日期")
    private LocalDateTime staffTime;

    @ExcelProperty("自评完成状态（1未完成 2部分完成 3完成 ）")
    private Integer staffCompleteStatus;

    @ExcelProperty("自评分值")
    private Integer staffScore;

    @ExcelProperty("自评备注")
    private String staffRemark;

    @ExcelProperty("考评人")
    private String reviewer;

    @ExcelProperty("考评日期")
    private LocalDateTime reviewerTime;

    @ExcelProperty("考评完成状态（1未完成 2部分完成 3完成 ）")
    private Integer reviewerCompleteStatus;

    @ExcelProperty("考评分值")
    private Integer reviewerScore;

    @ExcelProperty("考评备注")
    private String reviewerRemark;

    @ExcelProperty("终评人")
    private String decider;

    @ExcelProperty("终评日期")
    private LocalDateTime deciderTime;

    @ExcelProperty("终评完成状态（1未完成 2部分完成 3完成 ）")
    private Integer deciderCompleteStatus;

    @ExcelProperty("考评分值")
    private Integer deciderScore;

    @ExcelProperty("终评备注")
    private String deciderRemark;

    @ExcelProperty("岗位")
    private String post;

    @ExcelProperty("考核状态（1自评 2考评 3终评 4考核结束）")
    private Integer status;

    @ExcelProperty("是否必选（0必选 1可选）")
    private Integer fixed;

    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}
