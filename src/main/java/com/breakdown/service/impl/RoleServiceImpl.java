package com.breakdown.service.impl;

import com.breakdown.dao.RoleDao;
import com.breakdown.entity.Role;
import com.breakdown.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service(value = "roleService")
public class RoleServiceImpl implements RoleService {

    @Autowired
    private RoleDao roleDao;

    @Override
    public List<Role> findAll(){
        List<Role> roleList = new ArrayList<>();
        roleDao.findAll().iterator().forEachRemaining(roleList::add);
        return roleList;
    }
}
