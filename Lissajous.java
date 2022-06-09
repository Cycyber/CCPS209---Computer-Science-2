import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Lissajous extends JPanel {

    JTextField aText, bText, deltaText;
    double a = 0, b = 0, delta = 0;
    int size;

    public Lissajous(int size) {
        setPreferredSize(new Dimension(size, size));
        this.size = size;

        aText = new JTextField(5);
        aText.setText("6");
        bText = new JTextField(5);
        bText.setText("5");
        deltaText = new JTextField(5);
        deltaText.setText("0.5");

        setLayout(new FlowLayout());
        setBackground(Color.WHITE);
        add(new JLabel("a   "));
        add(aText);
        add(new JLabel("b   "));
        add(bText);
        add(new JLabel("delta   "));
        add(deltaText);


        aText.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                repaint();
            }
        });

        bText.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                repaint();

            }
        });

        deltaText.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                repaint();
            }
        });

    }
    public int gcd(int a, int b) { return b==0 ? a : gcd(b, a%b); }
    @Override
    protected void paintComponent(Graphics g) {

        super.paintComponent(g);

        try {
            a = Double.parseDouble(aText.getText());
            b = Double.parseDouble(bText.getText());
            delta = Double.parseDouble(deltaText.getText());

        } catch (Exception ignored) {}

        double x1 = size/2 + 2*size/5 * Math.sin(delta);
        double y1 = size/2 + 2*size/5 * Math.sin(0);

        for (double t = 0; t <= ((a/gcd((int) a, (int) b))*b); t += 0.01) {

            double x2 = size/2 + 2*size/5 * Math.sin(a*t*Math.PI + delta);
            double y2 = size/2 + 2*size/5 * Math.sin(b*t*Math.PI);

            Graphics2D g2 = (Graphics2D) g;
            g2.setStroke(new BasicStroke(3));
            g.drawLine((int) x1, (int) y1, (int) x2, (int)y2);

            x1=x2;
            y1=y2;
        }
    }
}