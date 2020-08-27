package com.ceshi.servlet;

import com.ceshi.service.ProductService;
import com.ceshi.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteServlet")
public class DeleteServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取id
        String id = request.getParameter("goodsId");

        //调用Service删除
        ProductService service = new ProductServiceImpl();
        service.deleteProduct(id);

        //跳转到查询所有Servlet
        response.sendRedirect(request.getContextPath()+"/findProductByPageServlet");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
