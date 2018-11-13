package com.smart.test;

import org.openjdk.jmh.annotations.Benchmark;
import org.openjdk.jmh.annotations.BenchmarkMode;
import org.openjdk.jmh.annotations.Mode;
import org.openjdk.jmh.annotations.OutputTimeUnit;
import org.openjdk.jmh.runner.Runner;
import org.openjdk.jmh.runner.RunnerException;
import org.openjdk.jmh.runner.options.Options;
import org.openjdk.jmh.runner.options.OptionsBuilder;
import org.springframework.web.client.RestTemplate;

import java.util.concurrent.TimeUnit;

/**
 * @description:
 * @author: dongql
 * @date: 2018/3/21 10:20
 */
public class JMHZk {
    private static RestTemplate restTemplate = new RestTemplate();

    public static void main(String[] args) throws RunnerException {
        Options opt = new OptionsBuilder()
                .include(JMHZk.class.getSimpleName()).warmupIterations(5)
                .measurementIterations(20)
                .forks(1)
                .build();

        new Runner(opt).run();
    }

    @Benchmark
    @BenchmarkMode(Mode.Throughput)//计算一个时间单位内操作数量
    @OutputTimeUnit(TimeUnit.SECONDS)
    public void restWithDubbo() {
        restTemplate.getForObject("http://localhost:8082/dubbo-consumer/user/getZkLockDubbo", String.class);
    }

    @Benchmark
    @BenchmarkMode(Mode.Throughput)//计算一个时间单位内操作数量
    @OutputTimeUnit(TimeUnit.SECONDS)
    public void restWithoutDubbo() {
        restTemplate.getForObject("http://localhost:8082/dubbo-consumer/user/getZkLock", String.class);
    }
}
