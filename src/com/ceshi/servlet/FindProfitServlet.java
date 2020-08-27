package com.ceshi.servlet;

import com.ceshi.pojo.Profit;
import com.ceshi.service.ProfitService;
import com.ceshi.service.impl.ProfitServiceImpl;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/findProfitServlet")
public class FindProfitServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        ProfitService  service = new ProfitServiceImpl();
        List<Profit> profits = service.findProfit();

        request.setAttribute("profits",profits);
        request.getRequestDispatcher("/main.jsp").forward(request,response);

        System.out.println("----findProfitServlet--------");
        System.out.println(profits);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
