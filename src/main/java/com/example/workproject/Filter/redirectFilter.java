package com.example.workproject.Filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(urlPatterns = "/page/*",filterName = "channelFilter")
//@Component
public class redirectFilter implements Filter {
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httprequest = (HttpServletRequest) request;
        HttpServletResponse httpresponse= (HttpServletResponse) response;
//        System.out.println(((HttpServletRequest) request).getRequestURL());
//        request.getRequestDispatcher("/admin").forward(request, response);
//        httpresponse.sendRedirect("/demo/admin");
        chain.doFilter(request,response);
    }
}

