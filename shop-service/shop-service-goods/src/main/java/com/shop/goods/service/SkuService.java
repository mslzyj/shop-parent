package com.shop.goods.service;

import com.shop.goods.pojo.Sku;

import java.util.List;

/**
 * @autor zyj
 * @date 2020/8/22 10:35
 */
public interface SkuService {
    /**
     * 根据状态查询SKU列表
     */
    List<Sku> findByStatusAll(String status);
}
