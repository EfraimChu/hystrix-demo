package com.example.hystrixdemo.consumer.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Author efraim.zhu
 * @Date 2019/12/31
 **/
@FeignClient(value = "${provider.url}", url= "${provider.url}", fallbackFactory = ProviderFeignFallback.class)
public interface ProviderFeign {

    @GetMapping("/demo/test1")
    String test1(@RequestParam String name);

}
