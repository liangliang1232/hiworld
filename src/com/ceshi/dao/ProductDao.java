package com.ceshi.dao;

import com.ceshi.pojo.Product;
import com.ceshi.pojo.Profit;

import java.util.List;
import java.util.Map;

/**
 * 商品信息操作的DAO
 */
public interface ProductDao {
    /**
     * 查询所有商品信息
     *
     * @return
     */
    public List<Product> findAll();

    /**
     * 添加商品
     *
     * @param product
     */
    void add(Product product);

    /**
     * 根据id删除商品
     *
     * @param id
     */
    void delete(int id);

    /**
     * 根据id查询
     *
     * @param parseInt
     * @return
     */
    Product findById(int parseInt);

    /**
     * 查询商品信息
     *
     * @param product
     */
    void update(Product product);

    /**
     * 查询总记录数
     *
     * @param condition
     * @return
     */
    int findTotalCount(Map<String, String[]> condition);

    /**
     * 分页查询每页记录
     *
     * @param start
     * @param rows
     * @param condition
     * @return
     */
    List<Product> findByPage(int start, int rows, Map<String, String[]> condition);
}