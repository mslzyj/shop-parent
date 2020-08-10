package com.shop.goods.service;

import com.github.pagehelper.PageInfo;
import com.shop.goods.pojo.Brand;

import java.util.List;

public interface BrandService {

    /***
     * 查询所有品牌
     * @return
     */
    List<Brand> findAll();

    /**
     * 品牌列表分页查询
     * @return
     */
    PageInfo<Brand> findPage(int page, int size);
}
