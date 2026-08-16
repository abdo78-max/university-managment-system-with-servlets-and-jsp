/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package services;

import dao.UserDao;
import data.Role;
import data.User;
import java.sql.Connection;

/**
 *
 * @author Compu City
 */
public class UserService {

    private UserDao userDao;
    private Connection connect;

    public UserService(Connection connect) {
        userDao = new UserDao(connect);
    }

    public int addUser(User user) {
        return userDao.addUser(user);
    }
    public User getUser(User user)
    {
        return userDao.getUser(user);
    }
}
