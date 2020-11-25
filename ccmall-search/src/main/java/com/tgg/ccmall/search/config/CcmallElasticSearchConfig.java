package com.tgg.ccmall.search.config;

import org.apache.http.HttpHost;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestClientBuilder;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author tanguogang
 * @create 2020-07-28-10:33
 */
@Configuration
public class CcmallElasticSearchConfig {

    public static final RequestOptions COMMON_OPTIONS;
    static {
        RequestOptions.Builder builder = RequestOptions.DEFAULT.toBuilder();
        COMMON_OPTIONS = builder.build();
    }

    @Bean
    public RestHighLevelClient esRestClient(){
        RestClientBuilder builder = null;
        builder = RestClient.builder(new HttpHost("192.168.150.132",9200,"http"));
        RestHighLevelClient client = new RestHighLevelClient(builder);
        /*RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(new HttpHost("192.168.150.132",9200,"http")));*/
        return client;
    }
}
