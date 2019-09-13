package pl.model;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@Component
@RequestScoped
@ManagedBean(name = "user")
public class User {

    private Long id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private String token;

    private UserList userList;

    @Autowired
    public User(UserList userList) {
        this.userList = userList;
    }

    public User() {
    }

    public User(Long id, String username, String password, String firstName, String lastName) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public void addUser(){
        User user = new User(id,username,password,firstName,lastName);
        if(userList.findUser(user)<0){
            userList.addUser(user);
        }else{
            userList.editUser(user);
        }
        clearForm();
    }

    //clear form values
    private void clearForm() {
        setFirstName("");
        setLastName("");
        setId(null);
        setPassword("");
        setUsername("");
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

}
