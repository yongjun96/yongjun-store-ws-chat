package websocket.chat.response;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ChatResponse {

    private String msg;
    private String sender; // 보내는 사람
    private String roomNum;
    private LocalDateTime createAt; // 생성 시간

    @Builder
    public ChatResponse(String msg, String sender, String roomNum, LocalDateTime createAt) {
        this.msg = msg;
        this.sender = sender;
        this.roomNum = roomNum;
        this.createAt = createAt;
    }
}
