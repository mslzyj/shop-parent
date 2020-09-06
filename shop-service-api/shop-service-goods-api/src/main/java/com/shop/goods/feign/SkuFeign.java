package com.shop.goods.feign;

import com.shop.entity.Result;
import com.shop.goods.pojo.Sku;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @autor zyj
 * @date 2020/8/15 16:46
 */
@FeignClient(name="goods")
@RequestMapping(value = "/sku")
public interface  SkuFeign {
    /***
     * 根据审核状态查询Sku
     * @param status
     * @return
     */
    @GetMapping("/status/{status}")
    Result<List<Sku>> findByStatusAll(@PathVariable String status);


    @GetMapping("/sku/{id}")
    public Result<Sku> findById(@PathVariable("id") String id);
}
