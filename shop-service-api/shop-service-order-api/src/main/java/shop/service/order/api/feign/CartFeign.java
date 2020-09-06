package shop.service.order.api.feign;


import com.shop.entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;
/**
 * @autor zyj
 * @date 2020/9/6 11:17
 */
@FeignClient(name = "order")
public interface CartFeign {

    @GetMapping("/cart/addCart")
    public Result addCart(@RequestParam("skuId") String skuId, @RequestParam("num") Integer num);

    @GetMapping("/cart/list")
    public Map list();
}
