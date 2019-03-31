import org.junit.Test;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import static org.junit.Assert.fail;

public class Week2Test {

    @Test
    public void sampleTest() throws IOException, URISyntaxException {
        List<String> contents = FileReader.getFileContents("week2/distinct.txt");
        String[] characters = contents.get(0).split(" ");
        for (String character : characters) {
            System.out.println(character);
        }
        fail();
    }
}
