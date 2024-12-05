import static org.junit.Assert.*;
import java.io.File;
import java.io.FileNotFoundException;
import org.junit.Test;

public class MorseCodeConverterStudentTest {

    /**
     * test converting a simple morse code string to english
     */
    @Test
    public void testConvertToEnglishString() {
        String morseCode = ".... --- .-- / -.. --- / .. / .-.. --- ...- . / - .... . . / .-.. . - / -- . / -.-. --- ..- -. - / - .... . / .-- .- -.-- ...";
        String expected = "how do i love thee let me count the ways";
        assertEquals(expected, MorseCodeConverter.convertToEnglish(morseCode));
    }

    /**
     * test printing the morse code tree in LNR order
     */
    @Test
    public void testPrintTree() {
        String expected = "h s v i f u e l r a p w j  b d x n c k y t z g q m o";
        assertEquals(expected, MorseCodeConverter.printTree());
    }

    /**
     * test converting a file with morse code to english
     */
    @Test
    public void testConvertMorseFileToEnglishString() {
        File file = new File("src/howDoILoveThee.txt");
        String expected = "how do i love thee let me count the ways";
        try {
            assertEquals(expected, MorseCodeConverter.convertToEnglish(file));
        } catch (FileNotFoundException e) {
            assertTrue("File not found exception occurred", false);
        }
    }

    /**
     * test converting the Daisy file with morse code to english
     */
    @Test
    public void testConvertDaisyFileToEnglish() {
        File file = new File("src/Daisy.txt");
        String expected = "give me your answer do";
        try {
            assertEquals(expected, MorseCodeConverter.convertToEnglish(file));
        } catch (FileNotFoundException e) {
            assertTrue("File not found exception occurred", false);
        }
    }

    /**
     * test converting the DaisyDaisy file with morse code to english
     */
    @Test
    public void testConvertDaisyDaisyFileToEnglish() {
        File file = new File("src/DaisyDaisy.txt");
        String expected = "im half crazy all for the love of you";
        try {
            assertEquals(expected, MorseCodeConverter.convertToEnglish(file));
        } catch (FileNotFoundException e) {
            assertTrue("File not found exception occurred", false);
        }
    }
}
