package cn.iocoder.yudao.module.hr.controller.app;


import cn.iocoder.yudao.framework.common.pojo.CommonResult;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.v3.oas.annotations.Operation;
import static cn.iocoder.yudao.framework.common.pojo.CommonResult.success;

@Tag(name = "人力资源 App - Test")
@RestController
@RequestMapping("/hr/test")
@Validated
public class AppHrTestController {
    @GetMapping("/get")
    @Operation(summary = "获取 test 信息")
    public CommonResult<String> get() {
        return success("true");
    }

}
