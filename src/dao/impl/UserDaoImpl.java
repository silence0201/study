package dao.impl;

import dao.UserDao;
import entity.User;
import org.hibernate.Session;
import tools.HibernateTool;

/**
 * Description: UserDaoImpl
 * Author: silence
 * Update: silence(2016-06-30 10:13)
 */
public class UserDaoImpl implements UserDao {
    @Override
    //根据id获取用户的信息
    public User getByID(Integer userID) {
        Session session = HibernateTool.getSession() ;
        User user = (User) session.get(User.class,userID) ;
        return user;
    }
}
