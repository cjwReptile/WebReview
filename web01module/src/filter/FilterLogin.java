package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by hasee on 2017/4/8.
 */
@WebServlet(name = "FilterServlet")
public class FilterLogin  implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request=(HttpServletRequest)servletRequest;
        HttpServletResponse response=(HttpServletResponse)servletResponse;
        HttpSession session=request.getSession();
        String path = request.getRequestURI();
       System.out.println(session.getAttribute("Login")+"lanjieqi");
        if(path.indexOf("/Login")>-1||path.indexOf("/hello.do")>-1){
            filterChain.doFilter(request,response);
        }
        if("OK".equals(session.getAttribute("Login"))){
            filterChain.doFilter(request,response);
        }else {
            RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/jsp/login.jsp");
            dispatcher.forward(request,response);
        }
    }

    @Override
    public void destroy() {

    }
}
