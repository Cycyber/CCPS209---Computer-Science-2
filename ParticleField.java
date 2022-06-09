import java.awt.*;
import java.awt.geom.Rectangle2D;

public class ParticleField extends javax.swing.JPanel{
    private boolean running = true;
    private java.util.List<Particle> particles = new java.util.ArrayList<Particle>();

    public ParticleField(int n, int width, int height){
        this.setPreferredSize(new Dimension(width,height));
        for(int i=0;i<n;i++){
            particles.add(new Particle(width, height));
        }
        new Thread(new ParticleRunner()).start();

    }
    private class ParticleRunner implements Runnable{
        @Override
        public void run() {
            while(true){
                try {
                    Thread.sleep(20);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                for(Particle obj:particles){
                    obj.move();
                }
                repaint();
            }
        }
    }
    @Override public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D objG2=(Graphics2D) g;
        objG2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        for(Particle obj:particles){
            objG2.fill(new Rectangle2D.Double(obj.getX()-1,obj.getY()-1,3,3));
        }

    }
    public void terminate(){
        this.running=false;
    }


}
