package com.messaging_app.authserver.core.services;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Date;
import java.util.Map;

@Service
public class JwtService {
    private static final long EXPIRATION=600000;
    private static String  SECRET_KEY="cKtM1Y3FQdCJpev5bXscNaOj/cL4uyQ+Xs+csNpeGdgyub0HNjKQY1MbYvccmP3abbnGvitf6aMGek11CgjhcnPHveWepRkLhcc9yGRdYH12y10nf6SKN8KI9pePwofNmhHOWOx4+SS/vjQU4+pJ//8RwhltopDM6giA7ARqgm2Z8V8DX5pAVWIcIqeLy0kRSbjqTHE3kHpcXI0EiKn30W/f+14CaJnQHOZgXng/T9ezgLwYd+nqHVGc/Ql4BG9Ii2RXcu2TiQiKhfjI3A3JCsLe9ZkClPUzgqYviSCzBMeWYesveG7Q+crhwmeQYf+VzhZGHyOugj5IsWzAsE++mYVY56I50dIeRz/Ay/Iz9lc=";
    public String generateToken(String userName, Map<String,Object> extraClaims) {
        String token= Jwts.builder()
                .subject(userName)//tokenin üretilme sebebi
                .issuedAt(new Date(System.currentTimeMillis()))//token üretildiği zama<n
                .expiration(new Date(System.currentTimeMillis()+EXPIRATION))
                .claims(extraClaims)
                .signWith(getSigningKey())//decode edebilmek için key lazım
                .compact();
        return token;
    }
    private Key getSigningKey(){
        byte[] keyBytes= Decoders.BASE64.decode(SECRET_KEY);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
