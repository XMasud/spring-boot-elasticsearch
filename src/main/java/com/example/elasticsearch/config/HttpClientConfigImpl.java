package com.example.elasticsearch.config;

import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.CredentialsProvider;
import org.apache.http.impl.client.BasicCredentialsProvider;
import org.apache.http.impl.nio.client.HttpAsyncClientBuilder;
import org.apache.http.ssl.SSLContextBuilder;
import org.apache.http.ssl.SSLContexts;
import org.elasticsearch.client.RestClientBuilder;
import org.springframework.context.annotation.Configuration;

import javax.net.ssl.SSLContext;
import java.io.File;

@Configuration
public class HttpClientConfigImpl implements RestClientBuilder.HttpClientConfigCallback {

    @Override
    public HttpAsyncClientBuilder customizeHttpClient(HttpAsyncClientBuilder httpClientBuilder) {
        try {
            final CredentialsProvider credentialsProvider = new BasicCredentialsProvider();
            UsernamePasswordCredentials usernamePasswordCredentials = new UsernamePasswordCredentials("elastic",
                    "123456");
            credentialsProvider.setCredentials(AuthScope.ANY, usernamePasswordCredentials);
            httpClientBuilder.setDefaultCredentialsProvider(credentialsProvider);

            String trustLocationStore = "D:\\elasticsearch-8.17.1\\config\\certs\\truststore.p12";
            File trustLocationFile = new File(trustLocationStore);

            SSLContextBuilder sslContextBuilder = SSLContexts.custom().loadTrustMaterial(trustLocationFile,
                    "123456".toCharArray());
            SSLContext sslContext = sslContextBuilder.build();
            httpClientBuilder.setSSLContext(sslContext);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return httpClientBuilder;
    }
}
