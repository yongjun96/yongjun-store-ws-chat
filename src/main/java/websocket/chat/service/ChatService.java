package websocket.chat.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;
import websocket.chat.collection.Chat;
import websocket.chat.repository.ChatRepository;
import websocket.chat.request.ChatRequest;
import websocket.chat.response.ChatResponse;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ChatService {

    private final ChatRepository chatRepository;

    public Mono<Chat> sendMessage(ChatRequest chatRequest) {

        Chat chat = Chat.builder()
                .msg(chatRequest.getMsg())
                .sender(chatRequest.getSender())
                .createAt(LocalDateTime.now())
                .roomNum(chatRequest.getRoomNum())
                .build();

        return chatRepository.save(chat);

    }

    public Flux<Chat> getChatRoom(String roomNum){

        return chatRepository.mFindByRoomNum(roomNum)
                .subscribeOn(Schedulers.boundedElastic());
    }
}
