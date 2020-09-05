package com.shop.goods.service.impl;

import com.shop.goods.dao.SkuMapper;
import com.shop.goods.pojo.Sku;
import com.shop.goods.service.SkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @autor zyj
 * @date 2020/8/22 10:36
 */
@Service
public class SkuServiceImpl implements SkuService {
    @Autowired
    private SkuMapper skuMapper;

    /***
     * 根据状态查询SKU列表
     * @return
     */
    @Override
    public List<Sku> findByStatusAll(String status) {
        Sku sku = new Sku();
        sku.setStatus(status);
        sku.setCategoryName("手机");
        List<Sku> list = skuMapper.select(sku);
        return list;
    }
}
