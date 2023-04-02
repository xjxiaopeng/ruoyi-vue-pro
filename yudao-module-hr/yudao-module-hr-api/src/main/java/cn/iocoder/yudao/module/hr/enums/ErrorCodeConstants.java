package cn.iocoder.yudao.module.hr.enums;

import cn.iocoder.yudao.framework.common.exception.ErrorCode;

public interface ErrorCodeConstants {
    ErrorCode PAY_SHEET_BASE_NOT_EXISTS = new ErrorCode(1899000000, "工资基础不存在");
    ErrorCode PAY_SHEET_MONTH_NOT_EXISTS = new ErrorCode(1899000100, "月工资不存在");
}