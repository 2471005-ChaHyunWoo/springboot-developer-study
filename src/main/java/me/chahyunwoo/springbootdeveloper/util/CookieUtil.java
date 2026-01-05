package me.chahyunwoo.springbootdeveloper.util;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.security.core.parameters.P;
import org.springframework.util.SerializationUtils;

import java.util.Base64;

public class CookieUtil {
    // 요청값(이름, 값, 만료 기간)을 바탕으로 쿠키 추가
    public static void addCookie(HttpServletResponse response, String name, String value, int maxAge){
        Cookie cookie=new Cookie(name,value);
        cookie.setPath("/"); // 우리 사이트의 모든 주소에서 이 쿠키를 읽을 수 있음
        cookie.setMaxAge(maxAge);
        response.addCookie(cookie);
    }

    // 쿠키의 이름을 입력받아 쿠키 삭제
    public static void deleteCookie(HttpServletRequest request, HttpServletResponse response, String name){
        Cookie[] cookies=request.getCookies();
        if(cookies==null){
            return;
        }

        for(Cookie cookie: cookies){
            if(name.equals(cookie.getName())){
                cookie.setValue("");
                cookie.setPath("/");
                cookie.setMaxAge(0); // 유효기간을 0 초로 설정해서 브라우저가 스스로 버리게 만드는 원리
                response.addCookie(cookie);
            }
        }
    }

    // 객체를 직렬화해 쿠키의 값으로 변환 ( 자바의 객체를 쿠키에 담기 위해 한 줄의 문자열로 변환하는 과정)
    public static String serialize(Object obj){
        return Base64.getUrlEncoder()
                .encodeToString(SerializationUtils.serialize(obj));
    }

    // 쿠키를 역직렬화해 객체로 변환 ( 쿠키에 담긴 문자열을 다시 자바 객체로 복원하는 과정)
    public static <T> T deserialize(Cookie cookie, Class<T> cls){
        return cls.cast(
                SerializationUtils.deserialize(
                        // 직렬화된 데이터에는 특수문자가 섞일 수 있어 쿠키가 깨질 위험이 있으므로 Base64 인코딩
                        Base64.getUrlDecoder().decode(cookie.getValue())
                )
        );
    }
}
