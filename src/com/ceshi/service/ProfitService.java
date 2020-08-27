package com.ceshi.service;

import com.ceshi.pojo.Profit;

import java.util.List;

public interface ProfitService {
    /**
     * 查询报表
     * @return
     */
    List<Profit> findProfit();
}
