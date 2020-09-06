package com.shop.service.order.controller;

import com.shop.entity.Result;
import com.shop.entity.StatusCode;
import com.shop.service.order.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import shop.service.order.api.pojo.OrderItem;

import java.util.List;

/**
 * @autor zyj
 * @date 2020/9/6 11:26
 */
@RestController
@CrossOrigin
@RequestMapping(value = "/cart")
public class CartController {
    @Autowired
    private CartService cartService;

    /***
     * 加入购物车
     * @param num:购买的数量
     * @param id：购买的商品(SKU)ID
     * @return
     */
    @RequestMapping(value = "/add")
    public Result add(Integer num, Long id){
        //用户名
        String username="szitheima";
        //将商品加入购物车
        cartService.add(num,id,username);
        return new Result(true, StatusCode.OK,"加入购物车成功！");
    }

    /***
     * 查询用户购物车列表
     * @return
     */
    @GetMapping(value = "/list")
    public Result list(){
        //用户名
        String username="szitheima";
        List<OrderItem> orderItems = cartService.list(username);
        return new Result(true,StatusCode.OK,"购物车列表查询成功！",orderItems);
    }

}
