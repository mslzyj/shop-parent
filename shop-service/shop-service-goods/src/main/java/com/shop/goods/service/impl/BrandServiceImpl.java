package com.shop.goods.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.shop.goods.dao.BrandMapper;
import com.shop.goods.pojo.Brand;
import com.shop.goods.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandMapper brandMapper;

    @Override
    public List<Brand> findAll() {
        return brandMapper.selectAll();
    }

    @Override
    public PageInfo<Brand> findPage(int page, int size) {
        PageHelper.startPage(page,size);
        return new PageInfo<>(brandMapper.selectAll());
    }
}
