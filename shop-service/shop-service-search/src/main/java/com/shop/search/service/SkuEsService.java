package com.shop.search.service;

import com.shop.search.pojo.SkuInfo;

import java.util.Map;

/**
 * @autor zyj
 * @date 2020/8/15 16:49
 */
public interface SkuEsService {
    /***
     * 导入SKU数据
     */
    void importSku();

    /***
     * 根据关键词搜索
     * @param id
     * @return
     */
    SkuInfo search(String id);
}
