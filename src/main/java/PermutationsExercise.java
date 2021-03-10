import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class PermutationsExercise {
    public static void main(String[] args) {
        printPermutations(null);
        printPermutations("");
        printPermutations("a");
        printPermutations("GOD");
        printPermutations("abcd");
    }

    /**
     * The following printed out all permutations generated
     * @param words input string
     */
    private static void printPermutations(String words) {
        System.out.printf("Permutations for [%s] are = %n", words);
        getPermutations(words).forEach(x -> System.out.println(x));
    }

    /**
     * The following is a public method used to call the permutations logic
     * @param words input string
     * @return List<String> list of permutations
     */
    public static List<String> getPermutations(String words) {
        if (Objects.isNull(words))
            return Collections.emptyList();

        List<String> result = new ArrayList<>();
        permutations(words, 0, result);

        return result;
    }

    /**
     * The following is the logic for doing the permutations using recursion
     * @param words input string
     * @param start start index
     * @param output List<String> list of permutations
     */
    private static void permutations(String words, int start, List<String> output) {
        if (Objects.isNull(words)) {
            throw new NullPointerException();
        }

        char[] charArray = words.toCharArray();

        //Step 1 : When the length of the string is the same as the start index, stop recursion
        if (words.length() == start) {
            output.add(words);
        }

        //Step 2 : Use start index as the starting point to loop through the characters in the string.
        // Anything in charArray with index smaller than "start" is left unchanged until i incremented.
        // Anything in charArray with index bigger that "start" is passed into the recursive method to be re-arranged
        for (int i = start; i < charArray.length; i++) {
            char t = charArray[i];
            charArray[i] = charArray[start];
            charArray[start] = t;
            permutations(new String(charArray), start + 1, output);
        }
    }
}

