package net.ems.ems.security.Jwt;

import io.jsonwebtoken.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import java.security.SignatureException;
import java.util.Date;

@Slf4j
@Component
public class JwtUtils {

   @Value("${ems.app.jwtSecret}")
    private String jwtSecret;

    @Value("${ems.app.jwtExpirationMs}")
    private int jwtExpirationMs;

    public String generateJwtToken(UserDetails userDetails){
        return Jwts.builder()
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date((new Date()).getTime()+ jwtExpirationMs))
                .signWith(SignatureAlgorithm.HS512,jwtSecret)
                .compact();
    }

    public String getUserNameFromJwtToken(String token){
        return Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateJwtToken(String authToken){
        try{
            jwts.parser().setSigningKey(jwtSecret).parseClamsJws(authToken);
            return true;
        } catch (SignatureException | MalformedJwtException | ExpiredJwtException | IllegalArgumentException e){
            log.error("JWT validation error: {}", e.getMessage());
        }
        return false;
    }


}
