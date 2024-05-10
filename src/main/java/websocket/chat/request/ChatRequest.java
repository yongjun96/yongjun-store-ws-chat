package websocket.chat.request;

import lombok.Data;

@Data
public class ChatRequest {

    private String msg;
    private String sender; // 보내는 사람
    private String roomNum;
    private Long chatRoomId; // 채팅방 ID
    private String chatRoomName; // 채팅방 이름

}
