package com.shop.goods.service.impl;

import com.shop.goods.dao.CategoryMapper;
import com.shop.goods.pojo.Category;
import com.shop.goods.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @autor zyj
 * @date 2020/8/10 17:03
 */
@Service
public class CategoryServiceImpl  implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    /***
     * 根据分类的父节点ID查询所有子节点
     * @param pid
     * @return
     */
    @Override
    public List<Category> findByParentId(Integer pid) {
        //SELECT * FROM tb_category WHERE parent_id=?
        Category category = new Category();
        category.setParentId(pid);
        return categoryMapper.select(category);
    }
}
