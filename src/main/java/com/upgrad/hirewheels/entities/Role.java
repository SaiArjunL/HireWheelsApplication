package com.upgrad.hirewheels.entities;
import javax.persistence.*;
import java.util.Set;

@Entity
public class Role {

    @Id
    @GeneratedValue
    @Column(name = "role_id")
    private int roleId;

    @Column(name = "role_name", nullable = false, unique = true)
    private String roleName;

    @OneToMany (mappedBy = "role", fetch = FetchType.EAGER, cascade =  {CascadeType.ALL})
    private Set<Users> users;

    public Role(int roleId, String roleName) {
        this.roleId = roleId;
        this.roleName = roleName;

    }

    public Role() {
    }

    public Set<Users> getUsers() {
        return users;
    }

    public void setUsers(Set<Users> users) {
        this.users = users;
    }

    public int getRoleId() {
        return roleId;
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Override
    public String toString() {
        return "Role{roleId="+roleId
                +", roleName="+roleName
                +"}";
    }
}
