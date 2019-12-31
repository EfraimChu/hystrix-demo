package com.example.hystrixdemo.consumer;

import com.example.hystrixdemo.consumer.feign.ProviderFeign;
import lombok.ToString;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Random;

/**
 * @Author efraim.zhu
 * @Date 2019/12/31
 **/
@SpringBootTest
public class HystrixDemoTest {
    @Autowired
    private ProviderFeign routerFeign;

    @Test
    public void HystrixDemo1(){
        System.out.println(routerFeign.test1("adsf"));
    }

    /**
     * // 配置：TEST-1
     * //       结果：
     * //        10个成功 ，10个失败； 5个异常fallback execution rejected.
     * @throws InterruptedException
     */
    @Test
    public void hystrixTest1() throws InterruptedException {

        for (int i = 0; i < 25; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    job();
                }
            }).start();
        }

        Thread.currentThread().join();

    }


    /**
     * // 配置：TEST-1
     * //       结果：
     * //        10个成功 ，10个失败； 5个异常fallback execution rejected.
     * @throws InterruptedException
     */
    @Test
    public void hystrixTest2() throws InterruptedException {

        for (int i = 0; i < 135; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    job();
                }
            }).start();
        }

        Thread.currentThread().join();

    }

    public void job() {

        String ret = routerFeign.test1(String.valueOf(System.currentTimeMillis()));

        System.out.println(String.format("获取结果为：【%s】",ret));
    }
}
