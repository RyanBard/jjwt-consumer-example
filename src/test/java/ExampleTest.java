
import org.junit.Test;

import static org.junit.Assert.*;

public class ExampleTest {

    @Test
    public void testExerciseBase64Codec() throws Exception {
        String input = "abc123";
        assertEquals(input, Example.exerciseBase64Codec(input));
    }

}
