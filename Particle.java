import java.util.Random;

public class Particle {
    double x,y,angle;
    private static final Random rng = new Random();
    private static final double BUZZY = 9.9;

    public Particle(int width, int height){
        this.x = rng.nextDouble()*width;
        this.y = rng.nextDouble()*height;
        this.angle = Math.PI*2*rng.nextDouble();
    }
    public double getX(){return this.x;}
    public double getY(){return this.y;}

    public void move(){
        this.x+=Math.cos(this.angle);
        this.y+=Math.sin(this.angle);
        this.angle+=rng.nextGaussian()*BUZZY;
    }

}
