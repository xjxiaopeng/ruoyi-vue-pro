package cn.iocoder.yudao.module.kpi.dal.dataobject.assesstodolist;

import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 考核待办 DO
 *
 * @author 肖鹏
 */
@TableName("kpi_assess_todolist")
@KeySequence("kpi_assess_todolist_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AssessTodolistDO extends BaseDO {

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
     * 考核名称
     */
    private String assessTitle;
    /**
     * 自评人
     */
    private String staff;
    /**
     * 自评日期
     */
    private LocalDateTime staffTime;
    /**
     * 自评状态（1待办 0已办 2 无）
     */
    private Integer staffStatus;
    /**
     * 考评人
     */
    private String reviewer;
    /**
     * 考评日期
     */
    private LocalDateTime reviewerTime;
    /**
     * 考评状态（1待办 0已办 2 无）
     */
    private Integer reviewerStatus;
    /**
     * 终评人
     */
    private String decider;
    /**
     * 终评日期
     */
    private LocalDateTime deciderTime;
    /**
     * 终评状态（1待办 0已办 2 无）
     */
    private Integer deciderStatus;

    /**
     * 备注
     */
    private  String remark;

    /**
     * 考核开始时间
     */
    private LocalDateTime assessStartTime;
    /**
     * 考核结束时间
     */
    private LocalDateTime assessEndTime;
    /**
     * 待办状态（1自评 2考评 3终评 4考核结束）
     */
    private Integer status;

}
