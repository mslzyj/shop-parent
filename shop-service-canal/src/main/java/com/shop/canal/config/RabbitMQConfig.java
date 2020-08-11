package com.shop.canal.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * duilie
 */
@Configuration
public class RabbitMQConfig {

    //定义交换机名称
    public static final String SHOP_UP_EXCHANGE="shop_up_exchange";
    public static final String SHOP_DOWN_EXCHANGE="shop_down_exchange";

    //定义队列名称
    public static final String AD_UPDATE_QUEUE="ad_update_queue";
    public static final String SEARCH_ADD_QUEUE="search_add_queue";
    public static final String SEARCH_DEL_QUEUE="search_del_queue";
    public static final String PAGE_CREATE_QUEUE="page_create_queue";

    //声明队列
    @Bean
    public Queue queue(){
        return new Queue(AD_UPDATE_QUEUE);
    }
    @Bean(SEARCH_ADD_QUEUE)
    public Queue SEARCH_ADD_QUEUE(){
        return new Queue(SEARCH_ADD_QUEUE);
    }
    @Bean(SEARCH_DEL_QUEUE)
    public Queue SEARCH_DEL_QUEUE(){
        return new Queue(SEARCH_DEL_QUEUE);
    }
    @Bean(PAGE_CREATE_QUEUE)
    public Queue PAGE_CREATE_QUEUE(){
        return new Queue(PAGE_CREATE_QUEUE);
    }

    //声明交换机
    @Bean(SHOP_UP_EXCHANGE)
    public Exchange SHOP_UP_EXCHANGE(){
        return ExchangeBuilder.fanoutExchange(SHOP_UP_EXCHANGE).durable(true).build();
    }
    @Bean(SHOP_DOWN_EXCHANGE)
    public Exchange SHOP_DOWN_EXCHANGE(){
        return ExchangeBuilder.fanoutExchange(SHOP_DOWN_EXCHANGE).durable(true).build();
    }


    //队列与交换机的绑定
    @Bean
    public Binding SHOP_UP_EXCHANGE_BINDING(@Qualifier(SEARCH_ADD_QUEUE)Queue queue,@Qualifier(SHOP_UP_EXCHANGE)Exchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with("").noargs();
    }
    @Bean
    public Binding PAGE_CREATE_QUEUE_BINDING(@Qualifier(PAGE_CREATE_QUEUE)Queue queue,@Qualifier(SHOP_UP_EXCHANGE)Exchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with("").noargs();
    }
    @Bean
    public Binding SHOP_DOWN_EXCHANGE_BINDING(@Qualifier(SEARCH_DEL_QUEUE)Queue queue,@Qualifier(SHOP_DOWN_EXCHANGE)Exchange exchange){
        return BindingBuilder.bind(queue).to(exchange).with("").noargs();
    }

}