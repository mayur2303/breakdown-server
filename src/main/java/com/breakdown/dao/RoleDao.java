package com.breakdown.dao;

import com.breakdown.entity.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleDao extends CrudRepository<Role, Long> {

    Role findByRole(String role);

}
