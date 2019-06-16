package com.authmanage.system.service.impl;

import com.authmanage.DataSource;
import com.authmanage.system.domain.SysUser;
import com.authmanage.system.domain.UserBean;
import com.authmanage.system.mapper.SysUserMapper;
import com.authmanage.system.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @date 2019/6/11 11:14
 */
@Service
@CacheConfig(cacheNames = "businessCache")
public class SysUserServiceImpl implements ISysUserService {

    @Autowired
    SysUserMapper userMapper;

    @Override
    public UserBean getUser(String userName) {
        // 没有此用户直接返回null
        if (!DataSource.getData().containsKey(userName)) {
            return null;
        }

        UserBean user = new UserBean();
        Map<String, String> detail = DataSource.getData().get(userName);

        user.setUsername(userName);
        user.setPassword(detail.get("password"));
        user.setRole(detail.get("role"));
        user.setPermission(detail.get("permission"));
        return user;
    }

    /**
     * 通过用户名查询用户
     *
     * @param userName 用户名
     * @return 用户对象信息
     */
    @Override
    @Cacheable
    public SysUser selectUserByLoginName(String userName) {
        return userMapper.selectUserByLoginName(userName);
    }

    /**
     * 通过手机号码查询用户
     *
     * @param phoneNumber 手机号码
     * @return 用户对象信息
     */
    @Override
    public SysUser selectUserByPhoneNumber(String phoneNumber) {
        return userMapper.selectUserByPhoneNumber(phoneNumber);
    }

    /**
     * 通过邮箱查询用户
     *
     * @param email 邮箱
     * @return 用户对象信息
     */
    @Override
    public SysUser selectUserByEmail(String email) {
        return userMapper.selectUserByEmail(email);
    }

    /**
     * 通过用户ID查询用户
     *
     * @param userId 用户ID
     * @return 用户对象信息
     */
    @Override
    public SysUser selectUserById(Long userId) {
        return userMapper.selectUserById(userId);
    }
}
