package com.smart.web;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;

import java.util.HashSet;
import java.util.Set;

/**
 * @description:
 * @author: dongql
 * @date: 2017/10/17 9:18
 */
public class RedisTest {
    public static void main(String[] args) {
        Set<HostAndPort> jedisClusterNodes = new HashSet<HostAndPort>();
        jedisClusterNodes.add(new HostAndPort("192.168.175.128", 8001));
        jedisClusterNodes.add(new HostAndPort("192.168.175.128", 8002));
        jedisClusterNodes.add(new HostAndPort("192.168.175.128", 8003));
        jedisClusterNodes.add(new HostAndPort("192.168.175.128", 8004));
        jedisClusterNodes.add(new HostAndPort("192.168.175.128", 8005));
        jedisClusterNodes.add(new HostAndPort("192.168.175.128", 8006));
        JedisCluster cluster = new JedisCluster(jedisClusterNodes);
        //cluster.set("username", "dd");
        cluster.hset("user","username","zhangshan");
        System.out.println("set username "+cluster.hget("user","username"));
    }

}
