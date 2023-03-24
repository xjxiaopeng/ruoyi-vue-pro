package cn.iocoder.yudao.module.system.controller.admin.user.vo.user;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Schema(description = "管理后台 - 用户精简信息 UserPostRespVO")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserPostRespVO {
    @Schema(description = "用户编号", required = true, example = "1024")
    private Long id;

    @Schema(description = "用户昵称", required = true, example = "芋道")
    private String nickname;

    @Schema(description = "岗位编号数组", example = "1")
    private Set<Long> postIds;

}
