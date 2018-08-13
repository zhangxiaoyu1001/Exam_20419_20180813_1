package filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        System.out.println("我是过滤器" );
        HttpServletRequest servletRequest = (HttpServletRequest) request;
        HttpServletResponse servletResponse = (HttpServletResponse) response;
        HttpSession session = servletRequest.getSession();
        String path = servletRequest.getServletPath();
        System.out.println(path);

        if (path.equals("/login.jsp")||path.equals("/index.jsp")||path.equals("/login")) {
            chain.doFilter(request, response);
        } else {
            if (session.getAttribute("flag") != null && session.getAttribute("flag").equals("success")) {

                chain.doFilter(request, response);
                System.out.println("我是过滤器：通过了" );
            } else {
                System.out.println("我是过滤器：没通过" );
                request.getRequestDispatcher("fail.jsp").forward(request, response);
            }
        }

    }

    @Override
    public void destroy() {

    }
}
