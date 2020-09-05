package com.shop.goods.controller;

import com.shop.entity.Result;
import com.shop.entity.StatusCode;
import com.shop.goods.pojo.Sku;
import com.shop.goods.service.SkuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @autor zyj
 * @date 2020/8/22 10:34
 */
@RestController
@ResponseBody
@CrossOrigin
@RequestMapping("/sku")
public class SkuController {
    @Autowired
    private SkuService skuService;

    /***
     * 根据审核状态查询Sku
     * @param status
     * @return
     */
    @GetMapping("/status/{status}")
    public Result<List<Sku>> findByStatusAll(@PathVariable String status){
        List<Sku> list = skuService.findByStatusAll(status);
        return new Result<List<Sku>>(true, StatusCode.OK,"查询成功",list);
    }

}
