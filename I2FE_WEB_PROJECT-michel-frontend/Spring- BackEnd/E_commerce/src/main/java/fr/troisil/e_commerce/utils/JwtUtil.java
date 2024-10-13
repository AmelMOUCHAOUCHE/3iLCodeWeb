package fr.troisil.e_commerce.utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.stereotype.Component;
import io.jsonwebtoken.Claims;
import org.springframework.security.core.userdetails.UserDetails;


import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
import java.util.Date;
import java.util.Map;
import java.util.HashMap;
import java.util.function.Function;

@Component
public class JwtUtil {

    private static final String SECRET = "A2455DE56776DEA56784556778789"; // Votre clé secrète en texte

    // Génère un token JWT pour un utilisateur donné
    public String generateToken(String username) {
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims, username);
    }

    // Crée le token avec les claims et le nom d'utilisateur
    private String createToken(Map<String, Object> claims, String username) {
        return Jwts.builder()
                .setClaims(claims)
                .setSubject(username)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 30)) // Expire après 30 minutes
                .signWith(getSignKey(), SignatureAlgorithm.HS256) // Utilise la clé de signature et l'algorithme HS256
                .compact();
    }

    // Retourne la clé de signature en utilisant la clé secrète et #l'algorithme HMAC-SHA256
    private Key getSignKey() {
        byte[] keyBytes = SECRET.getBytes();
        return new SecretKeySpec(keyBytes, SignatureAlgorithm.HS256.getJcaName());
    }

    public String extractUsername(String token) {
        return extractClaim(token, Claims::getSubject);
    }


    public <T> T extractClaim(String token, Function<Claims,T> claimsResolver)
    {
        final Claims claims = extractAllClaim(token);
        return claimsResolver.apply(claims);
    }


    private Claims extractAllClaim(String token) {
        /*try*/ {
            return Jwts.parserBuilder().setSigningKey(getSignKey()).build().parseClaimsJws(token).getBody();
        }
        /*catch (Exception e) {
            throw new RuntimeException("Erreur lors de l'extraction des claims du token", e);
        }*/

//                return Jwts.parser().setSigningKey(getSignKey()).build().parseClaimsJws(token).getBody();
    }


    private Boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    public Date extractExpiration(String token) {
        return extractClaim(token,Claims::getExpiration);
    }



   public Boolean validateToken(String token, UserDetails userDetails)
    {
        final String email = extractUsername(token);
        return (email.equals(userDetails.getUsername()) && !isTokenExpired(token));
    }
}
