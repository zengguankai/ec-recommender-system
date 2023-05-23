package com.experiment.ecrecommendersystem.config;

import org.apache.http.HttpHost;
import org.apache.http.client.HttpClient;
import org.elasticsearch.client.RestClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ElasticsearchRestClient {
    @Value("${elasticsearch.ip}")
    String ipAddress;

    @Bean(name = "restClient")
    public RestClient restClient(){
        String[] address = ipAddress.split(":");
        String ip = address[0];
        Integer port = Integer.valueOf(address[1]);
        HttpHost httpHost = new HttpHost(ip, port, "http");
        return RestClient.builder(httpHost).build();
    }
}
