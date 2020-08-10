package com.shop.goods.controller;

import com.shop.entity.Result;
import com.shop.entity.StatusCode;
import com.shop.goods.pojo.Category;
import com.shop.goods.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @autor zyj
 * @date 2020/8/10 17:05
 */
@RestController
@CrossOrigin
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    /****
     * 根据节点ID查询所有子节点分类集合
     */
    @GetMapping(value = "/list/{pid}")
    public Result<List<Category>> findByParentId(@PathVariable(value = "pid")Integer pid){
        //调用Service实现查询
        List<Category> categories = categoryService.findByParentId(pid);
        return new Result<List<Category>>(true, StatusCode.OK,"查询成功！",categories);
    }
}
