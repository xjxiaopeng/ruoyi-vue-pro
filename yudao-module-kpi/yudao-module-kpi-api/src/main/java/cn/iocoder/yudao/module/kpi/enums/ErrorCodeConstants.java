package cn.iocoder.yudao.module.kpi.enums;// TODO 待办：请将下面的错误码复制到 yudao-module-kpi-api 模块的 ErrorCodeConstants 类中。注意，请给“TODO 补充编号”设置一个错误码编号！！！

import cn.iocoder.yudao.framework.common.exception.ErrorCode;

// ========== 考核指标库 TODO 补充编号 ==========
public interface ErrorCodeConstants {
    ErrorCode ASSESS_STORE_NOT_EXISTS = new ErrorCode(1999000000, "考核指标库不存在");
    ErrorCode ASSESS_ISSUE_NOT_EXISTS = new ErrorCode(1999000100, "考核发布不存在");
    ErrorCode ASSESS_TODOLIST_NOT_EXISTS = new ErrorCode(1999000200, "考核待办不存在");
    ErrorCode ASSESS_STAFF_ITEM_NOT_EXISTS = new ErrorCode(1999000300, "考核评分不存在");
}
