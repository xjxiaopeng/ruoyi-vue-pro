package cn.iocoder.yudao.module.kpi.dal.dataobject.assessstaffitem;

import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 考核评分 DO
 *
 * @author 肖鹏
 */
@TableName("kpi_assess_staff_item")
@KeySequence("kpi_assess_staff_item_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AssessStaffItemDO extends BaseDO {

    /**
     * 主键ID
     */
    @TableId
    private Long id;
    /**
     * 考核发布ID
     */
    private Long issueId;
    /**
     * 考核待办ID
     */
    private Long todolistId;
    /**
     * 考核名称
     */
    private String assessTitle;
    /**
     * 考核指标
     */
    private String title;
    /**
     * 考核标准
     */
    private String standard;
    /**
     * 考核分值
     */
    private Integer score;
    /**
     * 自评人
     */
    private String staff;
    /**
     * 自评日期
     */
    private LocalDateTime staffTime;
    /**
     * 自评完成状态（1未完成 2部分完成 3完成 ）
     */
    private Integer staffCompleteStatus;
    /**
     * 自评分值
     */
    private Integer staffScore;
    /**
     * 自评备注
     */
    private String staffRemark;
    /**
     * 考评人
     */
    private String reviewer;
    /**
     * 考评日期
     */
    private LocalDateTime reviewerTime;
    /**
     * 考评完成状态（1未完成 2部分完成 3完成 ）
     */
    private Integer reviewerCompleteStatus;
    /**
     * 考评分值
     */
    private Integer reviewerScore;
    /**
     * 考评备注
     */
    private String reviewerRemark;
    /**
     * 终评人
     */
    private String decider;
    /**
     * 终评日期
     */
    private LocalDateTime deciderTime;
    /**
     * 终评完成状态（1未完成 2部分完成 3完成 ）
     */
    private Integer deciderCompleteStatus;
    /**
     * 考评分值
     */
    private Integer deciderScore;
    /**
     * 终评备注
     */
    private String deciderRemark;
    /**
     * 岗位
     */
    private String post;
    /**
     * 考核状态（1自评 2考评 3终评 4考核结束）
     */
    private Integer status;
    /**
     * 是否必选（0必选 1可选）
     */
    private Integer fixed;

}
