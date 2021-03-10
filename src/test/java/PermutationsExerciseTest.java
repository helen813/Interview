import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class PermutationsExerciseTest {

    @DisplayName("Ensure correctness in handling null string")
    @Test
    void assertNullString() {
        assertTrue(PermutationsExercise.getPermutations(null).isEmpty());
    }

    @DisplayName("Ensure correctness in handling empty string")
    @Test
    void assertEmptyString() {
        List<String> test = PermutationsExercise.getPermutations("");
        test.forEach(x -> assertTrue(x.isEmpty()));
    }

    @DisplayName("Ensure correct single character returned when single character string provided")
    @Test
    void assertOneCharString() {
        PermutationsExercise.getPermutations("a").forEach(x -> assertEquals("a", x));
    }

    @DisplayName("Ensure all correct permutations returned when string with 2 chars provided")
    @Test
    void assertTwoCharsString() {
        List<String> l = PermutationsExercise.getPermutations("BC");
        assertAll(
                () -> assertTrue(l.contains("BC")),
                () -> assertTrue(l.contains("CB")),
                () -> assertEquals(2, l.size()));
    }

    @DisplayName("Ensure all correct permutations returned when string with more than 2 chars provided")
    @Test
    void assertMoreThanTwoCharsString() {
        List<String> l = PermutationsExercise.getPermutations("GOD");
        assertAll(
                () -> assertTrue(l.contains("GOD")),
                () -> assertTrue(l.contains("GDO")),
                () -> assertTrue(l.contains("ODG")),
                () -> assertTrue(l.contains("OGD")),
                () -> assertTrue(l.contains("DOG")),
                () -> assertTrue(l.contains("DGO")),
                () -> assertEquals(6, l.size()));
    }
}
