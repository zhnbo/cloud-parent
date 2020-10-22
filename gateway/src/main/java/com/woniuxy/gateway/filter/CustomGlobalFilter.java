package com.woniuxy.gateway.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * 自定义全局过滤器
 * @author zh_o
 * @date 2020-10-23
 */
@Configuration
public class CustomGlobalFilter implements GlobalFilter, Ordered {

    private final Logger log = LoggerFactory.getLogger(CustomGlobalFilter.class);

    /**
     * 过滤方法
      * @param exchange SpringWebFlux 封装了 Request,Response
     * @param chain 过滤器中的 chain
     */
    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        log.info("调用自定义 Filter");
        if (exchange.getRequest().getQueryParams().get("username") == null) {
            log.info("用户身份不合法,拒绝访问!");
        }
        log.info("用户身份信息合法，放行");
        chain.filter(exchange);
        return exchange.getResponse().setComplete();
    }

    /**
     * 执行优先级，返回值越小越优先执行
     */
    @Override
    public int getOrder() {
        return 0;
    }
}
