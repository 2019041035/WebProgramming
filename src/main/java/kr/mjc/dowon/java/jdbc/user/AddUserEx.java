package kr.mjc.dowon.java.jdbc.user;

import kr.mjc.dowon.java.jdbc.DataAccessException;

public class AddUserEx {
    public static void main(String[] args) {
        UserDao userDao = new UserDaoImplUsingDbUtils();
        User user = new User();
        user.setEmail("dowon@gmail.com");
        user.setPassword("dowon");
        user.setName("정도원");
        try {
            userDao.addUser(user);
            System.out.format("사용자를 추가했습니다 : %s\n", user);
        } catch (DataAccessException e) {
            System.err.println(e.getMessage());
        }
    }
}
