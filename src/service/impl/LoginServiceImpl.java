package service.impl;

import dao.UserDao;
import dao.impl.UserDaoImpl;
import entity.User;
import service.LoginService;

/**
 * Created by 孙瑜 on 2016/6/30.
 */
public class LoginServiceImpl implements LoginService{
    public boolean getUserInfo(Integer userID, String password){
        UserDao userDao = new UserDaoImpl();
        User user = userDao.getByID(userID);
        if(user == null){
            return false;
        }else {
            if(!user.getPassword().equals(password)){
                return false;
            }
        }
        return true;
    }
}
