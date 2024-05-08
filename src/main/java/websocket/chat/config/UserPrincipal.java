package websocket.chat.config;

import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;

import java.util.List;

public class UserPrincipal extends User {

    // role : 역할 -> 관리자, 사용자, 매니저
    // authority : 권한 -> 글쓰기, 읽기, 사용자 정지 시키기

    public UserPrincipal(Object email, Object role){
        super((String) email, "", List.of(
                new SimpleGrantedAuthority((String) role)
        ));
    }
}
