package com.xyx.common.user.controller.rest;

import java.util.Date;

import com.xyx.common.user.service.TUserService;
import com.xyx.common.util.result.Result;
import com.xyx.index12306.model.user.dto.*;
import com.xyx.index12306.model.user.entry.TUser;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/user/userInfo")
@RestController
public class ApiUserController {
    @Autowired
    TUserService tUserService;

    @PostMapping("/api/user-service/register")
    public Result<UserRegisterRespDTO> register(@RequestBody @Valid UserRegisterReqDTO requestParam) {
        UserRegisterRespDTO data = tUserService.register(requestParam);
        return Result.ok(data);
    }
    /**
     * 用户登录
     */
    @PostMapping("/api/user-service/v1/login")
    public Result<UserLoginRespDTO> login(@RequestBody UserLoginReqDTO requestParam) {
        return Result.ok(tUserService.login(requestParam));
    }

    /**
     * 检查用户名是否已存在
     */
    @GetMapping("/api/user-service/has-username")
    public Result<Boolean> hasUsername(@RequestParam("username") @NotEmpty String username) {
        return Result.ok(tUserService.hasUsername(username));
    }

    /**
     * 修改用户
     */
    @PostMapping("/api/user-service/update")
    public Result<Void> update(@RequestBody @Valid UserUpdateReqDTO requestParam) {
        tUserService.updateTUser(requestParam);
        return Result.ok();
    }
    /**
     * 通过 Token 检查用户是否登录
     */
    @GetMapping("/api/user-service/check-login")
    public Result<UserLoginRespDTO> checkLogin(@RequestParam("accessToken") String accessToken) {
        UserLoginRespDTO result = tUserService.checkLogin(accessToken);
        return Result.ok(result);
    }
    /**
     * 用户退出登录
     */
    @GetMapping("/api/user-service/logout")
    public Result<Void> logout(@RequestParam(required = false) String accessToken) {
        tUserService.logout(accessToken);
        return Result.ok();
    }
    /**
     * 根据用户名查询用户信息
     */
    @GetMapping("/api/user-service/query")
    public Result<UserQueryRespDTO> queryUserByUsername(@RequestParam("username") @NotEmpty String username) {
        return Result.ok(tUserService.queryUserByUsername(username));
    }

    /**
     * 根据用户名查询用户无脱敏信息
     */
    @GetMapping("/api/user-service/actual/query")
    public Result<UserQueryActualRespDTO> queryActualUserByUsername(@RequestParam("username") @NotEmpty String username) {
        return Result.ok(tUserService.queryActualUserByUsername(username));
    }
    /**
     * 注销用户
     */
    @PostMapping("/api/user-service/deletion")
    public Result<Void> deletion(@RequestBody @Valid UserDeletionReqDTO requestParam) {
        tUserService.deletion(requestParam);
        return Result.ok();
    }






























}
