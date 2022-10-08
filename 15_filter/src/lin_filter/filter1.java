package lin_filter;

import javax.servlet.*;
import java.io.IOException;

public class filter1 implements Filter {//演示filter的执行顺序
    //filter1或者filter谁先执行要看在web.xml中配置顺序
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("filter1前置");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("filter1后置");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }
}
