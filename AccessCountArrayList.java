import java.util.ArrayList;

public class AccessCountArrayList<E> extends ArrayList<E> {
    private int myCount = 0;

    @Override
    public E get(int index) {
        this.myCount += 1;
        return super.get(index);
    }

    @Override
    public E set(int index, E element) {
        this.myCount += 1;
        return super.set(index, element);
    }

    public int getAccessCount() {
        return this.myCount;
    }

    public void resetCount() {
        this.myCount = 0;
    }

}