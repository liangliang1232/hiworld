package com.ceshi.pojo;

/**
 * 商品实体类
 */
public class Product {
    private int goodsId ;               //商品id
    private String goodsName;           //商品名称
    private int costPrice;              //生产价
    private int sellPrice;              //销售价
    private String manufacturer;        //生产商

    public int getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(int goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
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

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public String toString() {
        return "Product{" +
                "goodsId=" + goodsId +
                ", goodsName='" + goodsName + '\'' +
                ", costPrice=" + costPrice +
                ", sellPrice=" + sellPrice +
                ", manufacturer='" + manufacturer + '\'' +
                '}';
    }
}
