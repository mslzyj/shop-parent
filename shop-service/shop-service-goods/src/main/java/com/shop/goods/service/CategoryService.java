package com.shop.goods.service;

import com.shop.goods.pojo.Category;

import java.util.List;

/**
 * @autor zyj
 * @date 2020/8/10 17:02
 */
public interface CategoryService {
    /***
     * 根据分类的父ID查询子分类节点集合
     */
    List<Category> findByParentId(Integer pid);
}
