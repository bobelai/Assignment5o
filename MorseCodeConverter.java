/**
 * a utility class for converting morse code to english
 * uses a morse code tree for conversions
 *
 * @author Leul Belay
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class MorseCodeConverter {

    /**
     * the morse code tree used for conversions
     */
    private static MorseCodeTree morseCodeTree = new MorseCodeTree();

    /**
     * converts a string of morse code to english
     *
     * @param code the morse code string
     * @return the english translation
     */
    public static String convertToEnglish(String code) {
        StringBuilder result = new StringBuilder();
        String[] words = code.split(" / ");
        for (String word : words) {
            String[] letters = word.split(" ");
            for (String letter : letters) {
                result.append(morseCodeTree.fetch(letter));
            }
            result.append(" ");
        }
        return result.toString().trim();
    }

    /**
     * converts a file of morse code to english
     *
     * @param codeFile the file containing morse code
     * @return the english translation
     * @throws FileNotFoundException if the file is not found
     */
    public static String convertToEnglish(File codeFile) throws FileNotFoundException {
        StringBuilder fileContent = new StringBuilder();
        try (Scanner scanner = new Scanner(codeFile)) {
            while (scanner.hasNextLine()) {
                fileContent.append(scanner.nextLine()).append(" ");
            }
        }
        return convertToEnglish(fileContent.toString().trim());
    }

    /**
     * prints the morse code tree in LNR order
     *
     * @return a string representation of the tree
     */
    public static String printTree() {
        return String.join(" ", morseCodeTree.toArrayList());
    }
}
