package websocket.chat.collection;

import lombok.Getter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Document(collection = "seq") // 컬렉션의 이름 설정
public class Seq {
    @Id
    private String id;
    private Long seq;
}
