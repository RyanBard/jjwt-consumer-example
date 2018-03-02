
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.Base64Codec;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;

public class Example {

    public static String exerciseBase64Codec(String input) {
        Base64Codec codec = new Base64Codec();
        return new String(codec.decode(codec.encode(input.getBytes())));
    }

    public static String exerciseBuilder(String key, String subject) {
        Base64Codec codec = new Base64Codec();
        return Jwts.builder()
                .setSubject(subject)
                .signWith(SignatureAlgorithm.HS256, codec.encode(key.getBytes()))
                .compact();
    }

    public static Claims exerciseParser(String keyStr, String compactStr) {
        Base64Codec codec = new Base64Codec();
        Key key = new SecretKeySpec(
                keyStr.getBytes(),
                SignatureAlgorithm.HS256.getJcaName()
        );
        return Jwts.parser()
                .setSigningKey(key)
                .parseClaimsJws(compactStr)
                .getBody();
    }

    public static void main(String[] args) {
        String input = "abc123";
        System.out.println("\n");
        System.out.println("Expected: " + input);
        System.out.println("  Actual: " + exerciseBase64Codec(input));
        System.out.println("\n");
    }

}
