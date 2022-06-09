import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class Mondrian extends JPanel {
    private static final int CUTOFF = 40;
    private static final double WHITE = 0.75;
    private static final Color[] COLORS = { Color.YELLOW, Color.RED, Color.BLUE, Color.CYAN };

    private Random rng = new Random();
    private Image mondrian;

    public Mondrian(int w, int h) {
        setPreferredSize(new Dimension(w, h));
        mondrian = new BufferedImage(w, h, BufferedImage.TYPE_INT_ARGB);
        Graphics2D g = (Graphics2D) mondrian.getGraphics();
        g.setStroke(new BasicStroke(3));
        subdivide(0, 0, w, h, g);
    }

    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(mondrian, 0, 0, null);
    }


    private void subdivide(int tx, int ty, int w, int h, Graphics2D g2) {
        if (w < CUTOFF || h < CUTOFF) {
            if (rng.nextDouble() > WHITE) {
                g2.setColor(COLORS[rng.nextInt(COLORS.length)]);
                g2.fillRect(tx, ty, w, h);
            } else {
                g2.setColor(Color.WHITE);
                g2.fillRect(tx, ty, w, h);
            }
            g2.setColor(Color.BLACK);
            g2.drawRect(tx, ty, w, h);
        } else {
            if (w >= h) {
                int w2 = rng.nextInt((3 * w / 4) - (w / 3)) + (w / 3);
                subdivide(tx, ty, w2, h, g2);
                subdivide(tx + w2, ty, w - w2, h, g2);
            } else {
                int h2 = rng.nextInt((3 * h / 4) - (h / 3)) + (h / 3);
                subdivide(tx, ty, w, h2, g2);
                subdivide(tx, ty + h2, w, h - h2, g2);
            }
        }
    }

    public static void main(String[] args) {
        JFrame f = new JFrame();
        f.add(new Mondrian(1000, 800));
        f.pack();
        f.setLocationRelativeTo(null);
        f.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        f.setVisible(true);
    }

}