package site.syzhou.domain;

import java.io.Serializable;
import java.util.List;

public class Role implements Serializable {
    private int rid;
    private String roleName;
    private String roleDesc;
    private List<User> users;

    @Override
    public String toString() {
        return "Role{" +
                "id=" + rid +
                ", roleName='" + roleName + '\'' +
                ", roleDesc='" + roleDesc + '\'' +
                ", users=" + users +
                '}';
    }

    public int getId() {
        return rid;
    }

    public void setId(int id) {
        this.rid = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public String getRoleDesc() {
        return roleDesc;
    }

    public void setRoleDesc(String roleDesc) {
        this.roleDesc = roleDesc;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
