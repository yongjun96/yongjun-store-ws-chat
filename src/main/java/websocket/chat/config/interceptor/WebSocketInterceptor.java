package websocket.chat.config.interceptor;

import lombok.RequiredArgsConstructor;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.ChannelInterceptor;
import org.springframework.messaging.support.MessageHeaderAccessor;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import websocket.chat.config.common.exception.GlobalException;
import websocket.chat.config.common.exceptioncode.ErrorCode;
import websocket.chat.config.jwt.JwtProvider;

@RequiredArgsConstructor
@Component
public class WebSocketInterceptor implements ChannelInterceptor {

    private final JwtProvider jwtProvider;

    // 토큰 체크
    //@SneakyThrows
    @Override
    public Message<?> preSend(Message<?> message, MessageChannel channel) {
        StompHeaderAccessor accessor = MessageHeaderAccessor.getAccessor(message, StompHeaderAccessor.class);

        if (accessor.getCommand() == StompCommand.CONNECT) {
            String authToken = accessor.getFirstNativeHeader("Authorization");

            String token = jwtProvider.resolveToken(authToken);

            if (token == null || !jwtProvider.validateToken(token)) {
                throw new GlobalException(ErrorCode.MEMBER_NOT_FOUND);
            }

            // UsernamePasswordAuthenticationToken 발급
            Authentication authentication = jwtProvider.getAuthentication(token);
            // accessor에 등록
            accessor.setUser(authentication);
        }

        return message;
    }
}