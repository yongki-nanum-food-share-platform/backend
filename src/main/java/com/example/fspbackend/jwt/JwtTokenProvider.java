package com.example.fspbackend.jwt;

import com.example.fspbackend.DTO.LoginDTO;
import io.jsonwebtoken.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import java.time.Duration;
import java.util.Date;

@RequiredArgsConstructor
//빈 등록 자체를 빈 객체가 존재하는 클래스 자체에서 해주는 애노테이션
@Component
public class JwtTokenProvider {
    private final JwtProperties jwtProperties;

    public String makeJwtToken(LoginDTO loginDTO) {
        Date now = new Date();

        return Jwts.builder()
                .setHeaderParam(Header.TYPE, Header.JWT_TYPE)   //헤더 설정
                //jwt의 body 설정
                .setIssuer(jwtProperties.getIssuer())   //토큰 발급자 설정
                .setIssuedAt(now)   //토큰 발급 시간 설정
                .setExpiration(new Date(now.getTime() + Duration.ofMinutes(30).toMillis())) //토큰 만료 시간 설정
                .claim("userId", loginDTO.getUserId())  //비공개 클레임
                //
                .signWith(SignatureAlgorithm.HS256, jwtProperties.getSecretKey())   //서명
                .compact(); //토큰 생성
    }

    public String getUserIdFromJwt(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(jwtProperties.getSecretKey())
                .parseClaimsJws(token)
                .getBody();

        return claims.get("userId", String.class);
    }

    // Jwt 토큰 유효성 검사
    public boolean validateToken(String token) {
        try {
            Jwts.parser().setSigningKey(jwtProperties.getSecretKey()).parseClaimsJws(token);
            return true;
        } catch (MalformedJwtException ex) {
            System.out.println("error");
        } catch (ExpiredJwtException ex) {
            System.out.println("error");
        } catch (UnsupportedJwtException ex) {
            System.out.println("error");
        } catch (IllegalArgumentException ex) {
            System.out.println("error");
        }
        return false;
    }
}