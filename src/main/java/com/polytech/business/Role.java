package com.polytech.business;

import javax.persistence.*;
import java.util.Set;

/**
 * Created by Cyprien on 18/04/2017.
 */
@Entity
@Table(name = "ROLE")
public class Role {
    private long id;
    private String name;
    private Set<User> users;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @ManyToMany(mappedBy = "ROLES")
    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
