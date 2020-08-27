package com.ceshi.service.impl;


import com.ceshi.dao.ProfitDao;
import com.ceshi.dao.impl.ProfitDaoImpl;
import com.ceshi.pojo.Profit;
import com.ceshi.service.ProfitService;

import java.util.List;

public class ProfitServiceImpl implements ProfitService {
    private ProfitDao dao = new ProfitDaoImpl();

    @Override
    public List<Profit> findProfit() {

        return dao.findProfit();
    }
}
