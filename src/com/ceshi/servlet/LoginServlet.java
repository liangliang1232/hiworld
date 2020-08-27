package com.ceshi.servlet;

import com.ceshi.pojo.User;
import com.ceshi.service.UserService;
import com.ceshi.service.impl.UserServiceImpl;
import org.apache.commons.beanutils.BeanUtils;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
         //设置编码
        request.setCharacterEncoding("utf-8");

        HttpSession session = request.getSession();
        //获取数据
        Map<String, String[]> map = request.getParameterMap();

        //封装User对象
        User user = new User();
        try {
            BeanUtils.populate(user,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        //调用Service查询
        UserService service = new UserServiceImpl();
        User loginUser = service.login(user);

        if (loginUser != null){
            //登录成功，用户存入session中
            session.setAttribute("user",loginUser);

            response.sendRedirect(request.getContextPath()+"/findProfitServlet");
            System.out.println("成功了");


        }else{
            request.setAttribute("login_msg","用户名或密码错误！");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
            System.out.println("失败了");
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
