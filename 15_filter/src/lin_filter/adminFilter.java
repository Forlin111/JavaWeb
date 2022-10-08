package lin_filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class adminFilter implements Filter {//演示filter过滤器
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        /*
        专门用来拦截请求,可以做权限检查;
         */
        HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
        HttpSession session = httpServletRequest.getSession();
        Object user = session.getAttribute("user");
        if (user == null) {
            servletRequest.getRequestDispatcher("/login.jsp").forward(servletRequest,servletResponse);
            //servletRequest.getRequestDispatcher("/admin/a.html").forward(servletRequest,servletResponse);
            return;
        }else {
            //程序放行,访问用户的目标资源
            filterChain.doFilter(servletRequest,servletResponse);
        }
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println(filterConfig.getFilterName());
        System.out.println(filterConfig.getInitParameter("user"));
        ServletContext servletContext = filterConfig.getServletContext();
    }

    @Override
    public void destroy() {

    }
}
