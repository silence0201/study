package dao;

import entity.User;

/**
 * Description: UserDao
 * Author: silence
 * Update: silence(2016-06-30 07:55)
 */
public interface UserDao {
    //根据用户id获取用户信息
    public abstract User getByID(Integer userID) ;
}
