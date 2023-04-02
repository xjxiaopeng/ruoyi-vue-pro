package cn.iocoder.yudao.module.hr.controller.admin.paysheetmonth.vo;

import lombok.*;
import java.util.*;
import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.*;

@Schema(description = "管理后台 - 月工资创建 Request VO")
@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class PaySheetMonthCreateReqVO extends PaySheetMonthBaseVO {

}
