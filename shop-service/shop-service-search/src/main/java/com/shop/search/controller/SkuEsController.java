package com.shop.search.controller;

import com.shop.entity.Result;
import com.shop.entity.StatusCode;
import com.shop.search.service.SkuEsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @autor zyj
 * @date 2020/8/15 17:09
 */
@RestController
@RequestMapping(value = "/search")
@CrossOrigin
public class SkuEsController {

    @Autowired
    private SkuEsService skuEsService;

    /**
     * 导入数据
     * @return
     */
    @GetMapping("/import")
    public Result search(){
        skuEsService.importSku();
        return new Result(true, StatusCode.OK,"导入数据到索引库中成功！");
    }
}
