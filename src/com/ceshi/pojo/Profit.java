package com.ceshi.pojo;

/**
 *利润实体类
 */
public class Profit {
    private String goodsName;
    private int goodsId;
    private int costPrice;
    private int sellPrice;
    private int tradingNumber;        //交易数量
    private int times;              //交易次数
    private int profit;             //商品利润

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public int getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(int costPrice) {
        this.costPrice = costPrice;
    }

    public int getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(int sellPrice) {
        this.sellPrice = sellPrice;
    }

    public int getTradingNumber() {
        return tradingNumber;
    }

    public void setTradingNumber(int tradingNumber) {
        this.tradingNumber = tradingNumber;
    }

    public int getTimes() {
        return times;
    }

    public void setTimes(int times) {
        this.times = times;
    }

    public int getProfit() {
        return profit;
    }

    public void setProfit(int profit) {
        this.profit = profit;
    }

    @Override
    public String toString() {
        return "Profit{" +
                "goodsName='" + goodsName + '\'' +
                ", goodsId=" + goodsId +
                ", costPrice=" + costPrice +
                ", sellPrice=" + sellPrice +
                ", tradingNumber=" + tradingNumber +
                ", times=" + times +
                ", profit=" + profit +
                '}';
    }
}
