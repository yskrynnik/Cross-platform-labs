package Library;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LibClassTest {

    @Test
    void acrostic() {
        System.err.println("Running testAcrostic...");
        String result = LibClass.acrostic(new String[] {"fnord", "polly", "tropism"});
        assertEquals("foo",  result);
    }
}