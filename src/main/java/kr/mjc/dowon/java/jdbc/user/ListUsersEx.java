package kr.mjc.dowon.java.jdbc.user;

import java.util.List;

public class ListUsersEx {
    public static void main(String[] args) {
        UserDao userDao = new UserDaoImplUsingDbUtils();
        List<User> userList = userDao.listUsers(0, 20);
        for (User user : userList) {
            System.out.println(user);
        }
    }
}