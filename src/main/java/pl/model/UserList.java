package pl.model;

import org.springframework.stereotype.Component;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.util.ArrayList;
import java.util.List;


@Component
@RequestScoped
@ManagedBean(name = "userlist")
public class UserList {

    public List<User> users = new ArrayList<>();

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public void addUser(User user) {
        this.users.add(user);
    }

    public void editUser(User user) {
        this.users.set(findUser(user), user);
    }

    public int findUser(User user) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() == user.getId()) {
                return i;
            }
        }
        return -1;
    }

}
