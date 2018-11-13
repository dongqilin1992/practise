package com.smart.test;

import org.openjdk.jmh.annotations.*;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: dongql
 * @date: 2018/3/20 12:04
 */
@State(Scope.Thread)
public class JMHRedis {
    private static RestTemplate restTemplate = new RestTemplate();

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(JMHRedis.class.getSimpleName()).warmupIterations(5)
                .measurementIterations(2)
                .forks(1)
                .build();

        new Runner(opt).run();
    }

    @Setup
    public void startbubbo(){
        System.out.println("init dubbo");
    }
    @Benchmark
    @BenchmarkMode(Mode.Throughput)//计算一个时间单位内操作数量
    @OutputTimeUnit(TimeUnit.SECONDS)
    public void restWithDubbo() {
        //restTemplate.getForObject("http://localhost:8082/dubbo-consumer/user/getRedisLockDubbo", String.class);
    }

    @Benchmark
    @BenchmarkMode(Mode.Throughput)//计算一个时间单位内操作数量
    @OutputTimeUnit(TimeUnit.SECONDS)
    public void restWithoutDubbo() {
        //restTemplate.getForObject("http://localhost:8082/dubbo-consumer/user/getRedisLock", String.class);
    }
}
