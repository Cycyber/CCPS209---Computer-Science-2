import java.util.LinkedList;
import java.util.List;

public class Tail extends FileProcessor<List<String>>{
    private int numberOfLines;
    private LinkedList<String> myList;

    public Tail(int n){
        this.numberOfLines=n;
    }
    @Override protected void processLine(String line) {
        if(this.myList.size()==this.numberOfLines){
            myList.removeFirst();
        }
        this.myList.addLast(line);
    }
    @Override protected void startFile(){
        myList=new LinkedList<String>();
    }
    @Override protected List<String> endFile(){
        return this.myList;
    }
}
