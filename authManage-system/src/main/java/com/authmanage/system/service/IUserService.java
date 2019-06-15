package com.authmanage.system.service;

import com.authmanage.system.domain.UserBean;

/**
 * @date 2019/6/11 11:12
 */
public interface IUserService{
    UserBean getUser(String userName);
}
