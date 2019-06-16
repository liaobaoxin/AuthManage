package com.authmanage.framework.shiro.realm;

import com.authmanage.framework.shiro.Utils.ShiroUtils;
import com.authmanage.system.domain.SysMenu;
import com.authmanage.system.domain.SysRole;
import com.authmanage.system.domain.SysUser;
import com.authmanage.system.domain.UserBean;
import com.authmanage.framework.shiro.jwt.JWTToken;
import com.authmanage.framework.shiro.jwt.JWTUtil;
import com.authmanage.system.service.ISysUserService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @date 2019/6/14 15:28
 */
public class UserRealm extends AuthorizingRealm {


    @Autowired
    ISysUserService sysUserService;

    /**
     * 大坑！，必须重写此方法，不然Shiro会报错
     */
    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JWTToken;
    }

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        ShiroUtils.getSysUser().getRoles().stream().forEach(role->simpleAuthorizationInfo.addRole(role.getRoleKey()));
        ShiroUtils.getSysUser().getMenus().stream().forEach(menu->simpleAuthorizationInfo.addStringPermission(menu.getPerms()));
        return simpleAuthorizationInfo;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken auth) throws AuthenticationException {
        String token = (String) auth.getCredentials();
        // 解密获得username，用于和数据库进行对比
        String username = JWTUtil.getUsername(token);
        if (username == null) {
            throw new AuthenticationException("token invalid");
        }

        SysUser sysUser = sysUserService.selectUserByLoginName(username);
        if (sysUser == null) {
            throw new AuthenticationException("User didn't existed!");
        }

        if (!JWTUtil.verify(token, username, sysUser.getPassword())) {
            throw new AuthenticationException("Username or password error");
        }

        return new SimpleAuthenticationInfo(sysUser, token, getName());
    }

    /**
     * 清理缓存权限
     */
    public void clearCachedAuthorizationInfo() {
        this.clearCachedAuthorizationInfo(SecurityUtils.getSubject().getPrincipals());
    }
}
