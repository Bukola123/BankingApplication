package com.bankApp.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.ssl.SSLContexts;
import org.apache.http.ssl.TrustStrategy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.neo4j.Neo4jProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;

import javax.net.ssl.SSLContext;
import java.security.KeyManagementException;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;


@Configuration
public class RestTemplateConfig {

    @Value("${apiConnectionTimeOut}")
    Integer apiConnectionTimeout;
    @Value("${apiConnectionTimeOut}")
    Integer apiConnectionRequestTimeout;
    @Value("${apiSocketTimeout}")
    Integer apiSocketTimeout;

    @Bean
    public org.springframework.web.client.RestTemplate restTemplate() throws KeyStoreException, NoSuchAlgorithmException, KeyManagementException {
        return new org.springframework.web.client.RestTemplate(getClientHttpRequestFactory());
    }

    private ClientHttpRequestFactory getClientHttpRequestFactory()
            throws KeyManagementException, NoSuchAlgorithmException, KeyStoreException {
        TrustStrategy acceptingTrustStrategy = (x509Certificates, s) -> true;
        SSLContext sslContext = SSLContexts.custom().loadTrustMaterial(null, acceptingTrustStrategy).build();
        SSLConnectionSocketFactory csf = new SSLConnectionSocketFactory(sslContext, new NoopHostnameVerifier());
        RequestConfig config = RequestConfig.custom().setConnectTimeout(apiConnectionTimeout)
                .setConnectionRequestTimeout(apiConnectionRequestTimeout).setSocketTimeout(apiSocketTimeout).build();

        CloseableHttpClient httpClient = HttpClientBuilder.create().setSSLSocketFactory(csf)
                .setDefaultRequestConfig(config).build();
        return new HttpComponentsClientHttpRequestFactory(httpClient);
    }


//New code
    @Bean
    public HttpComponentsClientHttpRequestFactory factory() {
        return new HttpComponentsClientHttpRequestFactory();

    }

    @Bean
    public ObjectMapper mapper() {
        return new ObjectMapper();

    }
}
