package com.ceshi.servlet;

import com.ceshi.pojo.Product;
import com.ceshi.service.ProductService;
import com.ceshi.service.impl.ProductServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/addServlet")
public class AddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       //1.设置编码
        request.setCharacterEncoding("utf-8");

        //2.获取参数
        Map<String, String[]> map = request.getParameterMap();

        //封装对象
        Product product = new Product();
        try {
            BeanUtils.populate(product,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }

        //调用Service保存
        ProductService service = new ProductServiceImpl();
        service.addProduct(product);

        //跳转到ListServlet
        response.sendRedirect(request.getContextPath()+"/findProductByPageServlet");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
