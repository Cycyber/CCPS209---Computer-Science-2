import javax.swing.*;

public class LissajousMain {
    public static void main(String[] args) {
        JFrame f=new JFrame();
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.add(new Lissajous(800));
        f.pack();
        f.setVisible(true);

    }

}