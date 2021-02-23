package cn.kgc.order.client.config;

import cn.kgc.order.client.service.AuthorizeService;
import cn.kgc.shop.common.entity.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Created by Tiler on 2020/5/22
 */
//登录拦截器
public class LoginInterceptor implements HandlerInterceptor {
    @Value("${user.login.url}")
    private String loginPage;

    @Autowired
    private AuthorizeService authorizeService;

    //调用controller前执行
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession session = request.getSession();

        //session中存在user
        if (session.getAttribute("user") != null) {
            System.out.println("session中有用户信息");
            return true;
        }

        //查看cookie中是否有token
        String token = null;

        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("token")) {
                    token = cookie.getValue();
                }
            }
        }

        //cookie中有用户token
        if (token != null) {
            //从认证服务器读取用户信息
            Customer user = authorizeService.getUserByToken(token);
            if (user.getId() != null) { //认证服务器上有用户信息
                System.out.println("认证服务器中有用户信息");
                session.setAttribute("user", user);
                return true;
            }
        }

        System.out.println("用户未登录");

        //转向登录页面
        response.sendRedirect(loginPage);

        return false;
    }
}
