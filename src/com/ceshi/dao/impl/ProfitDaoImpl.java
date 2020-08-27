package com.ceshi.dao.impl;

import com.ceshi.dao.ProfitDao;
import com.ceshi.pojo.Profit;
import com.ceshi.uitl.JDBCUtils;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProfitDaoImpl implements ProfitDao {
    private static Connection con = null;
    private static PreparedStatement ps,ps2 = null;
    private  static ResultSet rs,rs2 = null;
    @Override
    public List<Profit> findProfit(){
        List<Profit> profits = new ArrayList<Profit>();
        String sql = "select p.goods_id id ,p.goodsName name,p.cost_price cprice,p.sellPrice sprice,sum(t.trading_number ) num,count(t.trading_id) as times from product p left join tradeinfo t on p.goods_id = t.trading_goods_id group by p.goods_id" ;

        try {
            con =  JDBCUtils.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            Profit profit = null;
            while (rs.next()){
                profit = new Profit();
                profit.setGoodsId(rs.getInt("id"));
                profit.setGoodsName(rs.getString("name"));
                profit.setCostPrice(rs.getInt("cprice"));
                profit.setSellPrice(rs.getInt("sprice"));
                profit.setTradingNumber(rs.getInt("num"));
                profit.setTimes(rs.getInt("times"));

                //计算总利润
                int money = profit.getSellPrice() - profit.getCostPrice();
                profit.setProfit(money * profit.getTradingNumber());
                profits.add(profit);

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("--------------------dada-------------");

        System.out.println(profits);
        System.out.println("--------------------dada-------------");
        return profits;

    }

}
