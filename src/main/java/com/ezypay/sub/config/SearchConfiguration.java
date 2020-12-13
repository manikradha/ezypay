package com.ezypay.sub.config;

import com.ezypay.sub.utils.Constant;
import org.elasticsearch.client.IndicesAdminClient;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;



import java.net.InetSocketAddress;


@Configuration
public class SearchConfiguration {

    @Value("${elasticsearch.recreate.index}")
    private boolean isRecreate;

    @Value("${elasticsearch.host}")
    public String esHost;

    @Value("${elasticsearch.port}")
    public int esPort;

    @Bean
    public TransportClient securedClient() throws Exception {
        Settings settings = Settings.builder().build();
        TransportClient transportClient = new PreBuiltTransportClient(settings)
                .addTransportAddress(new InetSocketTransportAddress(new InetSocketAddress(esHost, esPort)));
        IndicesAdminClient indices = transportClient.admin().indices();
        boolean exists = indices.prepareExists(Constant.SUBSCRIPTION).execute().actionGet().isExists();
        if (exists) {
            indices.prepareDelete(Constant.SUBSCRIPTION).execute().actionGet();
            indices.prepareCreate(Constant.SUBSCRIPTION).execute().actionGet();
        }
        return transportClient;
    }
}
