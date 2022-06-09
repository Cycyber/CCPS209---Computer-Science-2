import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ParticleMain {
    public static void main(String[] args){
        JFrame myFrame = new JFrame("Concurrency in Animation Lab");
        ParticleField myField = new ParticleField(2000,800,800);
        myFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we){
                myField.terminate();
                myFrame.dispose();
            }
        });
        myFrame.setLayout(new FlowLayout());
        myFrame.add(myField);
        myFrame.pack();
        myFrame.setVisible(true);
    }
}
