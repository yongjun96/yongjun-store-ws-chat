package websocket.chat.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import websocket.chat.collection.Chat;
import websocket.chat.request.ChatRequest;
import websocket.chat.service.ChatService;

@RequiredArgsConstructor
@Controller
public class ChatController {

    private final ChatService chatService;

    // 일반 메시지 매핑
    @MessageMapping("/chat")
    @SendTo("/sub/chat")
    public Mono<Chat> sendMessage(ChatRequest chatRequest) {

        return chatService.sendMessage(chatRequest);
    }

    @MessageMapping("/chat/{roomNum}")
    @SendTo("/sub/chat/{roomNum}")
    public Flux<Chat> getChatRoom(@PathVariable String roomNum){

        return chatService.getChatRoom(roomNum);
    }
}
