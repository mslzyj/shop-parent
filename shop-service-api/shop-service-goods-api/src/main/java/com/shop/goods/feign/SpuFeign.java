package com.shop.goods.feign;


import com.shop.entity.Result;
import com.shop.goods.pojo.Spu;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "goods")
public interface SpuFeign {

    @GetMapping("/spu/findSpuById/{id}")
    Result<Spu> findSpuById(@PathVariable("id") String id);


    @GetMapping("/spu/findSpuById/{id}")
    Result<Spu> findById(@PathVariable("id") String id);
}
