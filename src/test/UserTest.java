package test;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import entity.User;

/**
 * Description: UserTest
 * Author: silence
 * Update: silence(2016-06-30 10:20)
 */
public class UserTest {
    public static void main(String[] args) {
        UserDao userDao = new UserDaoImpl() ;
        User user = userDao.getByID(40001) ;
        System.out.println(user);
    }
}
