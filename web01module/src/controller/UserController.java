package controller;

import model.UserBean;
import service.ServiceImpl.UserServiceImpl;
import service.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by cjw on 2017/4/7.
 */
public class UserController extends javax.servlet.http.HttpServlet {

    UserBean userBean=new UserBean();
    UserService service=new UserServiceImpl();
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
           doGet(request,response);
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.setContentType("text/html");
        userBean.setUserId(request.getParameter("userBean.userId"));
        userBean.setPassWord(request.getParameter("userBean.passWord"));
        HttpSession session=request.getSession();
        String type=(String )request.getAttribute("type");
        if ("login".equals(type)){  if(userBean.getUserId()==null||userBean.getPassWord()==null){
            RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
            dispatcher.forward(request,response);

        }
            if(service.login(userBean)){
                session.setAttribute("Login","OK");
                RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/jsp/success.jsp");
                dispatcher.forward(request,response);
            }else{
                RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
                dispatcher.forward(request,response);
            }
        }
        if("register".equals(type)){
            if(service.register(userBean)){
                RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
                dispatcher.forward(request,response);
            }else{
                RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/jsp/fail.jsp");
                dispatcher.forward(request,response);
            }

        }



    }
}
