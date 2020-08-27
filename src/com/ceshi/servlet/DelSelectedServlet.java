package com.ceshi.servlet;

import com.ceshi.service.ProductService;
import com.ceshi.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delSelectedServlet")
public class DelSelectedServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取所有的id
        String[] ids = request.getParameterValues("sid");

        //调用Service删除
        ProductService service = new ProductServiceImpl();
        service.delSelectedProduct(ids);

        //跳转到查询所有Servlet
        response.sendRedirect(request.getContextPath()+"/findProductByPageServlet");


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
