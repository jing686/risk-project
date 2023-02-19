package com.zj;

import org.apache.ignite.Ignition;
import org.apache.ignite.client.ClientCache;
import org.apache.ignite.client.IgniteClient;
import org.apache.ignite.configuration.ClientConfiguration;

/**
 * @Author: zj
 * @Date: 2023/2/18 14:26
 * @Version: 1.0
 */
public class HelloWorld {

    public static void main(String[] args) {
        ClientConfiguration cfg = new ClientConfiguration().setAddresses("192.168.91.128:10800");
        IgniteClient client = Ignition.startClient(cfg);

        ClientCache<Integer, String> cache = client.getOrCreateCache("test_cache");

        cache.put(1, "first test value");

        System.out.println(cache.get(1));

        client.close();

    }
}
