package cn.iocoder.yudao.module.kpi.dal.dataobject.assessstore;

import lombok.*;
import java.util.*;
import java.time.LocalDateTime;
import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.*;
import cn.iocoder.yudao.framework.mybatis.core.dataobject.BaseDO;

/**
 * 考核指标库 DO
 *
 * @author 芋道源码
 */
@TableName("kpi_assess_store")
@KeySequence("kpi_assess_store_seq") // 用于 Oracle、PostgreSQL、Kingbase、DB2、H2 数据库的主键自增。如果是 MySQL 等数据库，可不写。
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AssessStoreDO extends BaseDO {

    /**
     * 主键ID
     */
    @TableId
    private Long id;
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
     * 备注
     */
    private String remark;
    /**
     * 岗位编号
     */
    private Long postId;
    /**
     * 指标状态（0正常 1停用）
     */
    private Integer status;
    /**
     * 是否必选（0必选 1可选）
     */
    private Integer fixed;

}
