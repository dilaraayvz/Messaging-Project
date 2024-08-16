package com.messaging_project.messageservice.websocket.config;

import lombok.NonNull;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketHandler;
import org.springframework.web.socket.server.HandshakeInterceptor;

import java.util.Map;
@Component
public class AuthHandshakeInterceptor implements HandshakeInterceptor {
    @Override
    public boolean beforeHandshake(ServerHttpRequest request, @NonNull ServerHttpResponse response,@NonNull WebSocketHandler wsHandler,@NonNull Map<String, Object> attributes) throws Exception {
        String authToken = request.getHeaders().getFirst("Authorization");
        if (authToken != null && authToken.startsWith("Bearer ")) {
            authToken = authToken.substring(7);
            return true;
        }
        return false; // Doğrulama başarısızsa bağlantıyı reddeder
    }

    @Override
    public void afterHandshake(@NonNull ServerHttpRequest request,@NonNull ServerHttpResponse response,@NonNull WebSocketHandler wsHandler, Exception ex) {
    }
}
