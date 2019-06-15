package com.authmanage.system.service.impl;

import com.authmanage.DataSource;
import com.authmanage.system.domain.UserBean;
import com.authmanage.system.service.IUserService;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @date 2019/6/11 11:14
 */
@Service
public class UserServiceImpl implements IUserService {
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
}
