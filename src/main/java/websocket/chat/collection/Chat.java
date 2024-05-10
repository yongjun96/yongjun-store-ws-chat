package websocket.chat.collection;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Getter
@Document(collection = "chat") // 컬렉션의 이름 설정
public class Chat {

    @Id
    private String id;
    private String msg;
    private String sender; // 보내는 사람
    private String receiver; // 받는 사람(귓속말 기능)
    private String roomNum; // 방 번호
    private Long chatRoomId; // 채팅방 ID
    private String chatRoomName; // 채팅방 이름

    private LocalDateTime createAt; // 생성 시간

    @Builder
    public Chat(String id, String msg, String sender, String receiver, String roomNum, Long chatRoomId, String chatRoomName, LocalDateTime createAt) {
        this.id = id;
        this.msg = msg;
        this.sender = sender;
        this.receiver = receiver;
        this.roomNum = roomNum;
        this.chatRoomId = chatRoomId;
        this.chatRoomName = chatRoomName;
        this.createAt = createAt;
    }
}
