package com.ceshi.service.impl;


import com.ceshi.dao.ProductDao;
import com.ceshi.dao.impl.ProductDaoImpl;
import com.ceshi.pojo.PageBean;
import com.ceshi.pojo.Product;
import com.ceshi.service.ProductService;

import java.util.List;
import java.util.Map;


public class ProductServiceImpl implements ProductService {
    private ProductDao dao = new ProductDaoImpl();


    @Override
    public void addProduct(Product product) {
        dao.add(product);
    }

    @Override
    public List<Product> findAll() {
        //调用Dao完成查询
        return dao.findAll();
    }

    @Override
    public void deleteProduct(String id) {
        dao.delete(Integer.parseInt(id));
    }

    @Override
    public Product findProductById(String id) {
        return dao.findById(Integer.parseInt(id));
    }

    @Override
    public void updateProduct(Product product) {
        dao.update(product);
    }

    @Override
    public void delSelectedProduct(String[] ids) {
        if (ids != null && ids.length > 0) {
            //遍历数组
            for (String id : ids) {
                //调用dao删除
                dao.delete(Integer.parseInt(id));
            }
        }
    }

    @Override
    public PageBean<Product> findProductByPage(String _currentPage, String _rows, Map<String, String[]> condition) {

        int currentPage = Integer.parseInt(_currentPage);
        int rows = Integer.parseInt(_rows);

        if (currentPage <= 0){
            currentPage = 1;
        }


        //创建空的Pagebean对象
        PageBean<Product> pb = new PageBean<Product>();

        //设置参数
        pb.setCurrentPage(currentPage);
        pb.setRows(rows);


        //调用dao查询总记录数
        int totalCount = dao.findTotalCount(condition);
        pb.setTotalCount(totalCount);

        //调用dao查询list集合
        //计算开始的记录索引
        int start = (currentPage - 1) * rows;
        List<Product> list = dao.findByPage(start, rows,condition);
        pb.setList(list);

        //计算总页码
        int totalPage = (totalCount % rows) == 0 ? totalCount / rows : (totalCount / rows) + 1;
        pb.setTotalPage(totalPage);

        return pb;
    }
}
