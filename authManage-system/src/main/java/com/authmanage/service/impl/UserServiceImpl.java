package com.authmanage.service.impl;

import com.authmanage.domain.User;
import com.authmanage.mapper.UserMapper;
import com.authmanage.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * @date 2019/6/11 11:14
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements IUserService {
}
