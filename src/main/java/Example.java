
import io.jsonwebtoken.impl.Base64Codec;

public class Example {

    public static String exerciseBase64Codec(String input) {
        Base64Codec codec = new Base64Codec();
        return new String(codec.decode(codec.encode(input.getBytes())));
    }

    public static void main(String[] args) {
        String input = "abc123";
        System.out.println("\n");
        System.out.println("Expected: " + input);
        System.out.println("  Actual: " + exerciseBase64Codec(input));
        System.out.println("\n");
    }

}
