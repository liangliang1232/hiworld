package com.ceshi.servlet;

import com.ceshi.pojo.Product;
import com.ceshi.service.ProductService;
import com.ceshi.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/listServlet")
public class ListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //调用Service查询
        ProductService service = new ProductServiceImpl();
        List<Product> products = service.findAll();

        //将list存入request域
        request.setAttribute("products",products);

        //跳转到list.jsp
        request.getRequestDispatcher("/list.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
