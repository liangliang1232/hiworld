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

@WebServlet("/updateProductServlet")
public class UpdateProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //设置编码
        request.setCharacterEncoding("utf-8");

        //获取map
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

        //调用Service修改
        ProductService service = new ProductServiceImpl();
        service.updateProduct(product);

        //跳转到查询所有的Servlet
        response.sendRedirect(request.getContextPath()+"/findProductByPageServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
