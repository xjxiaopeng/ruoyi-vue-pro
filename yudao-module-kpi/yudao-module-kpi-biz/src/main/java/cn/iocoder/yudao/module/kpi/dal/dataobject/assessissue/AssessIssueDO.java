package cn.iocoder.yudao.module.kpi.dal.dataobject.assessissue;

import cn.iocoder.yudao.framework.mybatis.core.type.JsonLongSetTypeHandler;
import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 考核发布 DO
 *
 * @author 芋道源码
 */
@TableName(value = "kpi_assess_issue",autoResultMap = true)
@KeySequence("kpi_assess_issue_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AssessIssueDO extends BaseDO {

    /**
     * 主键ID
     */
    @TableId
    private Long id;
    /**
     * 考核名称
     */
    private String assessTitle;
    /**
     * 用户编号数组
     */
    @TableField(typeHandler = JsonLongSetTypeHandler.class)
    private Set<Long> userIds;
    /**
     * 考评人
     */
    private String reviewer;
    /**
     * 终评人
     */
    private String decider;
    /**
     * 考核开始时间
     */
    private LocalDateTime assessStartTime;
    /**
     * 考核结束时间
     */
    private LocalDateTime assessEndTime;
    /**
     * 发布状态（1未发布 0发布）
     */
    private Integer status;

}
