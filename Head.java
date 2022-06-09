import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Rectangle2D;

public class Head extends JPanel {
    private boolean mouseInside=false;

    public Head(){
        this.setPreferredSize(new Dimension(500, 500));
        this.setBorder(BorderFactory.createBevelBorder(BevelBorder.RAISED));
        MyMouseListener myMouse = new MyMouseListener();
        this.addMouseListener(myMouse);
    }
    @Override public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2=(Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setStroke(new BasicStroke(3.0f));
        Ellipse2D.Double faceBorder = new Ellipse2D.Double(100,100,300,300);
        //Ellipse2D.Double mouth = new Ellipse2D.Double(200,300,100,50);
        Rectangle2D.Double mouth = new Rectangle2D.Double(200,300,100,50);
        g2.draw(faceBorder);
        g2.draw(mouth);

        Ellipse2D.Double leftEye;
        Ellipse2D.Double rightEye;

        if(mouseInside){
            leftEye = new Ellipse2D.Double(150, 200, 30, 30);
            rightEye = new Ellipse2D.Double(320, 200, 30, 30);
        }else {
            leftEye = new Ellipse2D.Double(150, 200, 30, 1);
            rightEye = new Ellipse2D.Double(320, 200, 30, 1);
        }
        g2.draw(leftEye);
        g2.draw(rightEye);
    }
    private class MyMouseListener extends MouseAdapter {
        @Override
        public void mouseEntered(MouseEvent e) {
            super.mouseEntered(e);
            mouseInside=true;
            repaint();
        }
        @Override
        public void mouseExited(MouseEvent e) {
            super.mouseExited(e);
            mouseInside=false;
            repaint();
        }

    }


}
