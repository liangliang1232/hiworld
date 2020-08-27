package com.ceshi.servlet;

import com.alibaba.fastjson.JSON;
import com.ceshi.pojo.Profit;
import com.ceshi.service.ProfitService;
import com.ceshi.service.impl.ProfitServiceImpl;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet("/reportServlet")
public class ReportServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        request.setCharacterEncoding("utf-8");

        ProfitService service = new ProfitServiceImpl();
        List<Profit> profits = service.findProfit();
        List<String> pNames = new ArrayList<>();
        List<Integer> pValues = new ArrayList<>();
        for (Profit p : profits) {
            pNames.add(p.getGoodsName());
            pValues.add(p.getProfit());
        }
        Map<String,Object> map = new HashMap<>();
        map.put("pName",pNames);
        map.put("pProfit",pValues);
        response.setCharacterEncoding("utf-8");

        PrintWriter pw = response.getWriter();
        pw.write(JSON.toJSONString(map));

        System.out.println("-------reportServlet---------");
        System.out.println(map);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
