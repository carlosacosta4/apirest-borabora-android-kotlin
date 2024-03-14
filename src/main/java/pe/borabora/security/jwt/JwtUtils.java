package pe.borabora.security.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.function.Function;

@Component
@Slf4j
public class JwtUtils {
	
	//Token debe ser firmado

	// Firma encriptada del token (Encryption key -> 256-bit , Hex -> Yes)
    @Value("${jwt.secret.key}")
    private String secretKey;

    // Tiempo de validez del token (1 dia a Milisegundos)
    @Value("${jwt.time.expiration}")
    private String timeExpiration;


    // Generar token de acceso
    public String generateAccesToken(String username){
        return Jwts.builder()
                .setSubject(username)  //Sujeto
                .setIssuedAt(new Date(System.currentTimeMillis()))  //Fecha de emision
                .setExpiration(new Date(System.currentTimeMillis()  //Fecha de expiracion
                		+ Long.parseLong(timeExpiration))) 
                .signWith(getSignatureKey(), SignatureAlgorithm.HS256)//Firmado con una clave secreta.
                .compact();
    }

    // Validar el token de acceso
    public boolean isTokenValid(String token){
        try{
        	//Parsea el JWT
            Jwts.parserBuilder()
                    .setSigningKey(getSignatureKey())
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
            return true;
        }catch (Exception e){
            log.error("Token invalido, error: ".concat(e.getMessage()));
            return false;
        }
    }

    // Obtener el username del token
    public String getUsernameFromToken(String token){
        return getClaim(token, Claims::getSubject);
    }

    // Obtener un solo claim
    public <T> T getClaim(String token, Function<Claims, T> claimsTFunction){
        Claims claims = extractAllClaims(token);
        return claimsTFunction.apply(claims);
    }

    // Obtener todos los claims del token
    public Claims extractAllClaims(String token){
    			//Parsea el JWT
        return Jwts.parserBuilder()
                .setSigningKey(getSignatureKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    // Obtener firma del token
    public Key getSignatureKey(){
        byte[] keyBytes = Decoders.BASE64.decode(secretKey); //Decodifica la clave secreta de 
        													 //Base64 a un array de bytes.
        return Keys.hmacShaKeyFor(keyBytes); //Genera una clave HMAC SHA
    }
}
