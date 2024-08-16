package com.messaging_project.messageservice.websocket.config;

import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import java.util.Map;

@Component
public class WebSocketAuthInterceptor implements HandshakeInterceptor {

    @Override
    public boolean beforeHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Map<String, Object> attributes) throws Exception {
        String authToken = request.getHeaders().getFirst("Authorization");

        if (authToken != null && authToken.startsWith("Bearer ")) {
            // Token doğrulama işlemi
            authToken = authToken.substring(7);
            // Token doğrulama işlemini burada yapabilirsiniz
        }

        return true;  // Bağlantıya izin ver
    }

    @Override
    public void afterHandshake(ServerHttpRequest request, ServerHttpResponse response, WebSocketHandler wsHandler, Exception exception) {

    }
}