package com.shop.search.dao;

import com.shop.search.pojo.SkuInfo;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * @autor zyj
 * @date 2020/8/15 16:48
 * 用于索引数据操作，主要使用它来实现将数据导入到ES索引库中
 */
@Repository
public interface SkuEsMapper extends ElasticsearchRepository<SkuInfo,Long> {
}
