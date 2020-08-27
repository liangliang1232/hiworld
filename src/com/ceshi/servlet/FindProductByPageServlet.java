package com.ceshi.servlet;

import com.ceshi.pojo.PageBean;
import com.ceshi.pojo.Product;
import com.ceshi.service.ProductService;
import com.ceshi.service.impl.ProductServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/findProductByPageServlet")
public class FindProductByPageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        //获取参数
        String currentPage = request.getParameter("currentPage");  //当前页码
        String rows = request.getParameter("rows");     //每页记录数

        if (currentPage == null || "".equals(currentPage)){
            currentPage = "1";
        }
        if (rows == null || "".equals(rows)){
            rows = "5";
        }

            //获取条件查询参数
        Map<String, String[]> condition = request.getParameterMap();
        
        //调用Service查询
        ProductService service = new ProductServiceImpl();
        PageBean<Product> pb = service.findProductByPage(currentPage,rows,condition);
        System.out.println("---------findProductByPageServlet-----------");
        System.out.println(pb);

            //将PageBean存入request
        request.setAttribute("pb",pb);
        request.setAttribute("condition",condition);

            //转发到list.jsp
        request.getRequestDispatcher("/list.jsp").forward(request,response);

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
