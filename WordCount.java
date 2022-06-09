import java.util.List;
import java.util.*;

public class WordCount extends FileProcessor<List<Integer>>{
    private int wordCount;
    private int lineCount;
    private int characterCount;

    @Override
    protected void startFile() {
        this.wordCount=0;
        this.lineCount=0;
        this.characterCount=0;
    }

    @Override
    protected void processLine(String line) {
        StringTokenizer st = new StringTokenizer(line);
        this.wordCount+=st.countTokens();

        long totalCharacters = line.chars().count();
        this.characterCount+=totalCharacters;

        this.lineCount++;
    }

    @Override
    protected List<Integer> endFile() {
        List<Integer> myList = new ArrayList<>();
        myList.add(this.characterCount);
        myList.add(this.wordCount);
        myList.add(this.lineCount);

        return myList;
    }
}
