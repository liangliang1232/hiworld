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

@WebServlet("/findProductServlet")
public class FindProductServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取id
        String id = request.getParameter("goodsId");

        //调用Service查询
        ProductService service = new ProductServiceImpl();
        Product product = service.findProductById(id);

        //讲product存入request
        request.setAttribute("product",product);

        //转发到update.jsp
        request.getRequestDispatcher("/update.jsp").forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
