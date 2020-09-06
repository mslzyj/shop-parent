package shop.service.order.api.feign;


import com.shop.entity.Result;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import shop.service.order.api.pojo.Order;

/**
 * @autor zyj
 * @date 2020/9/6 11:17
 */
@FeignClient(name = "order")
public interface OrderFeign {

    @PostMapping("/order")
    public Result add(@RequestBody Order order);

    @GetMapping("/order/{id}")
    public Result<Order> findById(@PathVariable("id") String id);
}
