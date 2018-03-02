
import org.junit.Test;

import static org.junit.Assert.*;

public class ExampleTest {

    @Test
    public void testExerciseBase64Codec() throws Exception {
        String input = "abc123";
        assertEquals(input, Example.exerciseBase64Codec(input));
    }

    @Test
    public void testDefaultJwtBuilder() throws Exception {
        String key = "abc123";
        String subject = "Joe";
        String expected = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJKb2UifQ.dpfYOKiEwcUXaok-UztzgvBh1HcKr3pqAFFTOJ3sbsU";
        assertEquals(expected, Example.exerciseBuilder(key, subject));
    }

    @Test
    public void testDefaultJwtParser() throws Exception {
        String key = "abc123";
        String compact = "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJKb2UifQ.dpfYOKiEwcUXaok-UztzgvBh1HcKr3pqAFFTOJ3sbsU";
        String expected = "Joe";
        assertEquals(expected, Example.exerciseParser(key, compact).getSubject());
    }

}
