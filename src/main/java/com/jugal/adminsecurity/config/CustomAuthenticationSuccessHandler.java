package com.jugal.adminsecurity.config;

import com.jugal.adminsecurity.model.AppRole;
import com.jugal.adminsecurity.model.User;
import com.jugal.adminsecurity.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Collection;

@Component
@Configuration
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

    @Autowired
    private UserService userService;


    @Override
    public void onAuthenticationSuccess(HttpServletRequest httpServletRequest,
                                        HttpServletResponse httpServletResponse, Authentication authentication)
            throws IOException, ServletException, RuntimeException {
        HttpSession session = httpServletRequest.getSession();
        User user = userService.findByUsername(authentication.getName());
        session.setAttribute("userProfile", user);
        httpServletResponse.setStatus(HttpServletResponse.SC_OK);
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        if (authorities.contains(new SimpleGrantedAuthority("ROLE_SUPER_ADMIN"))) {
            session.setAttribute("role", AppRole.ROLE_SUPER_ADMIN);
                try {
                    httpServletResponse.sendRedirect("/super-admin");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
        } else if (authorities.contains(new SimpleGrantedAuthority("ROLE_ADMIN"))) {
            session.setAttribute("role", AppRole.ROLE_ADMIN);
                try {
                    httpServletResponse.sendRedirect("/admin");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
        } else if(authorities.contains(new SimpleGrantedAuthority("ROLE_USER"))){
            session.setAttribute("role", AppRole.ROLE_USER);
                try {
                    httpServletResponse.sendRedirect("/user");
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
        }
    }
}