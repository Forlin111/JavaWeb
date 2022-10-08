package lin_filter;

import javax.servlet.*;
import java.io.IOException;

public class filter2 implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("filter2前置");
        filterChain.doFilter(servletRequest,servletResponse);
        System.out.println("filter2后置");
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }
}
