/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hongl
 */
public class UserDAO {
    List<User> ls= new ArrayList<>();
    //
    public UserDAO(){
        ls.add((new User("admin","123",true)));
        ls.add(new User("tung","123",true));
     
    }
    public boolean  checkLogin(String username,String password){
        for (User u : ls) {
            if(u.getUsername().equals(username)
                    &&u.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }
}
