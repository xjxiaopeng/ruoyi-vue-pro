package cn.iocoder.yudao.module.kpi.job;

import cn.iocoder.yudao.framework.common.pojo.PageResult;
import cn.iocoder.yudao.framework.quartz.core.handler.JobHandler;
import cn.iocoder.yudao.framework.tenant.core.job.TenantJob;
import cn.iocoder.yudao.module.kpi.dal.dataobject.assessissue.AssessIssueDO;
import cn.iocoder.yudao.module.kpi.service.assessissue.AssessIssueService;
import cn.iocoder.yudao.module.system.api.logger.LoginLogApi;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.List;


@Component
@TenantJob // 多租户
@Slf4j
public class KpiTimeoutJob implements JobHandler {
    @Resource
    private AssessIssueService assessIssueService;

    @Override
    public String execute(String param) throws Exception {
        LocalDateTime nowTime = LocalDateTime.now();
        List<AssessIssueDO> assessIssues = assessIssueService.getAssessIssueLists();
        for (AssessIssueDO assessIssueDO : assessIssues) {
            LocalDateTime assessEndTime = assessIssueDO.getAssessEndTime();
            log.info("当有的时间为" + nowTime);
            log.info("考核设置的到期时间为：" + assessEndTime);
            if (nowTime.isBefore(assessEndTime)) {
                log.info("当前的时间在考核到期时间之前，考核不能停止");
            } else {
                log.info("当前的时间在考核到期时间之后，考核需要停止");
                assessIssueService.updateAssessIssueStatus(1L, 1);
                log.info("考核已停止！");
            }
        }
        log.info("执行成功！");
        return "执行成功！";
    }
}
