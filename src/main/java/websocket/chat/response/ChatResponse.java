package websocket.chat.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ChatResponse {

    private String msg;
    private String sender; // 보내는 사람
    private Long chatRoomId; // 채팅방 ID
    private String chatRoomName; // 채팅방 이름
    private LocalDateTime createAt; // 생성 시간

    @Builder
    public ChatResponse(String msg, String sender, Long chatRoomId, String chatRoomName, LocalDateTime createAt) {
        this.msg = msg;
        this.sender = sender;
        this.chatRoomId = chatRoomId;
        this.chatRoomName = chatRoomName;
        this.createAt = createAt;
    }
}
