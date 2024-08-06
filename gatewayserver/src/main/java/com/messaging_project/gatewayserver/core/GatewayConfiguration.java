package com.messaging_project.gatewayserver.core;

import org.springframework.context.annotation.Bean;
import reactor.netty.http.client.HttpClient;
import io.netty.resolver.DefaultAddressResolverGroup;

public class GatewayConfiguration {
    @Bean
    public HttpClient httpClient() {
        return HttpClient.create().resolver(DefaultAddressResolverGroup.INSTANCE);
    }
}
