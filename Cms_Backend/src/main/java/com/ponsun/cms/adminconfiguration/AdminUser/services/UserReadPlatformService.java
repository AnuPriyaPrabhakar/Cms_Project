package com.ponsun.cms.adminconfiguration.AdminUser.services;


import com.ponsun.cms.adminconfiguration.AdminUser.domain.User;

import java.util.List;

public interface UserReadPlatformService {

    User fetchUserById(Integer id);
    List<User> fetchAllUsers();
}
