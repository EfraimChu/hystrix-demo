package com.example.hystrixdemo.consumer.feign;

import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

/**
 * @Author efraim.zhu
 * @Date 2019/12/31
 **/
@Component
public class ProviderFeignFallback implements FallbackFactory<ProviderFeign> {

    @Override
    public ProviderFeign create(Throwable throwable) {
        return new ProviderFeign() {
            @Override
            public String test1(String name) {
                return "fallback";
            };
        };
    }
}
