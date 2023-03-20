package cn.iocoder.yudao.module.kpi.controller.admin.assessissue.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import java.time.LocalDateTime;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 考核发布 Excel VO
 *
 * @author 芋道源码
 */
@Data
public class AssessIssueExcelVO {

    @ExcelProperty("主键ID")
    private Long id;

    @ExcelProperty("考核名称")
    private String assessTitle;

    @ExcelProperty("用户编号数组")
    private Set<Long> userIds;

    @ExcelProperty("考评人")
    private String reviewer;

    @ExcelProperty("终评人")
    private String decider;

    @ExcelProperty("考核开始时间")
    private LocalDateTime assessStartTime;

    @ExcelProperty("考核结束时间")
    private LocalDateTime assessEndTime;

    @ExcelProperty("发布状态（1未发布 0发布）")
    private Integer status;

    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}
