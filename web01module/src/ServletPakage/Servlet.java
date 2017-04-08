package ServletPakage;

import dao.userDao;
import model.UserBean;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by cjw on 2017/4/7.
 */
public class Servlet extends javax.servlet.http.HttpServlet {
    userDao userDao=new userDao();
    UserBean userBean=new UserBean();
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
           doGet(request,response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.setContentType("text/html");
        UserBean userBean1=new UserBean();
        userBean.setUserId(request.getParameter("userBean.userId"));
        userBean.setPassWord(request.getParameter("userBean.passWord"));
        userBean1=userDao.getUserInfo(userBean);
        HttpSession session=request.getSession();
        if(userBean.getUserId()==null||userBean.getPassWord()==null){
            RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
            dispatcher.forward(request,response);

        }
        if(userBean.getPassWord().equals(userBean1.getPassWord())){
            session.setAttribute("Login","OK");
            System.out.println(session.getAttribute("Login")+"denglu");
            RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/jsp/success.jsp");
            dispatcher.forward(request,response);
        }else{
            RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
            dispatcher.forward(request,response);
        }


    }
}
