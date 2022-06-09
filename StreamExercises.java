import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExercises {
    public static int countLines(Path path, int thres) throws IOException {
        return (int) Files.lines(path).filter(line -> line.length() >= thres).count();
    }
    public static List<String> collectWords(Path path) throws IOException{
        Stream<String> lines = Files.lines(path).map(line -> line.toLowerCase()).map(line-> line.split("[^a-z]+")).flatMap(Arrays::stream).filter(word -> word.length() > 0).sorted();
        List<String> result = lines.distinct().collect(Collectors.toList());
        return result;
    }
}