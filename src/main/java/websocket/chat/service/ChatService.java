package websocket.chat.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Schedulers;
import websocket.chat.collection.Chat;
import websocket.chat.repository.ChatRepository;
import websocket.chat.request.ChatRequest;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class ChatService {

    private final ChatRepository chatRepository;

    public Mono<Chat> sendMessage(ChatRequest chatRequest) {

        Chat chat = Chat.builder()
                .msg(chatRequest.getMsg())
                .sender(chatRequest.getSender())
                .createAt(LocalDateTime.now()) // 현재 시간 입력
                .chatRoomId(chatRequest.getChatRoomId())
                .chatRoomName(chatRequest.getChatRoomName())
                .build();

        return chatRepository.save(chat);

    }

    public Flux<Chat> getChatRoom(Long chatRoomId){

        return chatRepository.mFindByRoomNum(chatRoomId)
                .subscribeOn(Schedulers.boundedElastic());
    }
}
