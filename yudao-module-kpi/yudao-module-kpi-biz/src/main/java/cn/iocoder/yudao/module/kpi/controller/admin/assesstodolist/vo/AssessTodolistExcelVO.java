package cn.iocoder.yudao.module.kpi.controller.admin.assesstodolist.vo;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import java.time.LocalDateTime;

import com.alibaba.excel.annotation.ExcelProperty;

/**
 * 考核待办 Excel VO
 *
 * @author 肖鹏
 */
@Data
public class AssessTodolistExcelVO {

    @ExcelProperty("主键ID")
    private Long id;

    @ExcelProperty("考核发布ID")
    private Long issueId;

    @ExcelProperty("考核名称")
    private String assessTitle;

    @ExcelProperty("自评人")
    private String staff;

    @ExcelProperty("自评日期")
    private LocalDateTime staffTime;

    @ExcelProperty("自评状态（1待办 0已办 2 无）")
    private Integer staffStatus;

    @ExcelProperty("考评人")
    private String reviewer;

    @ExcelProperty("考评日期")
    private LocalDateTime reviewerTime;

    @ExcelProperty("考评状态（1待办 0已办 2 无）")
    private Integer reviewerStatus;

    @ExcelProperty("终评人")
    private String decider;

    @ExcelProperty("终评日期")
    private LocalDateTime deciderTime;

    @ExcelProperty("终评状态（1待办 0已办 2 无）")
    private Integer deciderStatus;

    @ExcelProperty("考核开始时间")
    private LocalDateTime assessStartTime;

    @ExcelProperty("考核结束时间")
    private LocalDateTime assessEndTime;

    @ExcelProperty("待办状态（1自评 2考评 3终评 4考核结束）")
    private Integer status;

    @ExcelProperty("创建时间")
    private LocalDateTime createTime;

}
