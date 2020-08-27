package com.ceshi.dao.impl;

import com.ceshi.dao.ProductDao;
import com.ceshi.pojo.Product;
import com.ceshi.pojo.Profit;
import com.ceshi.uitl.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ProductDaoImpl implements ProductDao {

    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<Product> findAll() {
        //1.定义sql
        String sql = "select * from product";
        List<Product> products = template.query(sql, new BeanPropertyRowMapper<Product>(Product.class));
        return products;
    }

    @Override
    public void add(Product product) {
        //定义sql
        String sql = "insert into product values(null,?,?,?,?)";
        //执行sql
        template.update(sql, product.getGoodsName(), product.getCostPrice(), product.getSellPrice(), product.getManufacturer());

    }

    @Override
    public void delete(int id) {
        String sql = "delete from product where goods_id = ?";
        template.update(sql, id);
    }

    @Override
    public Product findById(int id) {
        String sql = "select * from product where goods_id = ?";
        return template.queryForObject(sql, new BeanPropertyRowMapper<Product>(Product.class), id);
    }

    @Override
    public void update(Product product) {
        String sql = "update product set goodsName = ?,cost_price = ?,sellPrice = ?,manufacturer = ? where goods_id = ?";
        template.update(sql, product.getGoodsName(), product.getCostPrice(), product.getSellPrice(), product.getManufacturer(), product.getGoodsId());
    }

    @Override
    public int findTotalCount(Map<String, String[]> condition) {
        //定义初始化sql
        String sql = "select count(*) from product where 1 = 1 ";
        StringBuilder sb = new StringBuilder(sql);

        //遍历map
        Set<String> keySet = condition.keySet();

        //定义参数的集合
        List<Object> params = new ArrayList<Object>();
        for (String key : keySet) {
            //排除分页条件参数
            if ("currentPage".equals(key) || "rows".equals(key)) {
                continue;
            }

            //获取value
            String value = condition.get(key)[0];

            //判断value是否有值
            if (value != null && !"".equals(value)) {
                sb.append(" and "+key+" like ? ");
                params.add("%"+value+"%");
            }
        }
        System.out.println(sb.toString());
        System.out.println(params);

        return template.queryForObject(sb.toString(),Integer.class,params.toArray());
    }

    @Override
    public List<Product> findByPage(int start, int rows, Map<String, String[]> condition) {
        String sql = "select * from product where 1 = 1 ";
        StringBuilder sb = new StringBuilder(sql);
        Set<String> keySet = condition.keySet();
        List<Object> params = new ArrayList<Object>();
        for (String key : keySet) {

            //排除分页条件参数
            if ("currentPage".equals(key) || "rows".equals(key)) {
                continue;
            }
            //获取value
            String value = condition.get(key)[0];
            //判断value是否有值
            if (value != null && !"".equals(value)) {
                //有值
                sb.append(" and "+key+" like ? ");
                params.add("%"+value+"%");
            }
        }


        //分页查询
        sb.append(" limit ?,? ");
        params.add(start);
        params.add(rows);
        sql = sb.toString();
        System.out.println("-------productDaoImpl---------");
        System.out.println(sql);
        System.out.println(params);
        return template.query(sql, new BeanPropertyRowMapper<Product>(Product.class), params.toArray());
    }



}
