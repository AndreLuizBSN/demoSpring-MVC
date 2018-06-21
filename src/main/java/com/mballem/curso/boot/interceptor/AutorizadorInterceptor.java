package com.mballem.curso.boot.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class AutorizadorInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request,
        HttpServletResponse response,
        Object controller) throws Exception {
    	
    	String uri = request.getRequestURI();
        if(uri.endsWith("loginForm") || 
                uri.endsWith("efetuaLogin") || 
                        uri.contains("resources")){
            return true;
        }
    	
    	if(request.getSession().getAttribute("usuarioLogado") != null) {
    		System.out.println("usuario logado");
            return true;
        }

        response.sendRedirect("usuarios/login");
        return false;    
    }
}