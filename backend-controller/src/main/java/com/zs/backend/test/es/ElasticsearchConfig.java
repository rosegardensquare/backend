package com.zs.backend.test.es;

import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;

@Configuration
public class ElasticsearchConfig {

    private String hostAndPort; // 127.0.0.1:9200

    @Bean
    public RestHighLevelClient elasticsearchClient() {


        // 需要引入 spring-boot-starter-web
        final ClientConfiguration clientConfiguration = ClientConfiguration.builder()
            .connectedTo("127.0.0.1:9200")
//                .connectedTo("127.0.0.1:9200", "192.168.38.128:9200")
            .withSocketTimeout(2000l)
            .build();
        return RestClients.create(clientConfiguration).rest();
    }
}