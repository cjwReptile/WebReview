package service.ServiceImpl;

import dao.userDao;
import model.UserBean;
import service.UserService;
/**
 * Created by hasee on 2017/4/9.
 */
public class UserServiceImpl implements UserService{
    userDao userDao=new userDao();
    UserBean user=null;
    @Override
    public boolean login(UserBean userBean) {
       user= userDao.login(userBean);
       if(user==null){
           return false;
       }
       if(userBean.getPassWord().equals(user.getPassWord())){
           return true;
       }
       return false;
    }

    @Override
    public boolean register(UserBean userBean) {
        return userDao.register(userBean);
    }
}
