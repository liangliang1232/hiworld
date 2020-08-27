package com.ceshi.service;

import com.ceshi.pojo.PageBean;
import com.ceshi.pojo.Product;

import java.util.List;
import java.util.Map;


/**
 * 商品管理的业务接口
 */
public interface ProductService {


    /**
     * 保存product
     * @param product
     */
    void addProduct(Product product);

    /**
     * 查询所有商品信息
     * @return
     */
    public List<Product> findAll();

    /**
     * 根据id删除Product
     * @param id
     */
    void deleteProduct(String id);

    /**
     * 根据id查询商品
     * @param id
     * @return
     */

    Product findProductById(String id);

    /**
     * 修改商品
     * @param product
     */
    void updateProduct(Product product);

    /**
     * 删除选中的商品
     * @param ids
     */
    void delSelectedProduct(String[] ids);

    /**
     * 分页条件查询
     * @param currentPage
     * @param rows
     * @param condition
     * @return
     */
    PageBean<Product> findProductByPage(String currentPage, String rows, Map<String, String[]> condition);
}
