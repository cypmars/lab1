package com.polytech.repository;

import com.polytech.business.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Cyprien on 18/04/2017.
 */
public interface RoleRepository extends JpaRepository<Role, Long> {
}
