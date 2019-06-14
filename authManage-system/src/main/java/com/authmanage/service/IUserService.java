package com.authmanage.service;

import com.authmanage.domain.UserBean;

/**
 * @date 2019/6/11 11:12
 */
public interface IUserService{
    UserBean getUser(String userName);
}
