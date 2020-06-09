package me.finnlr.factory.assests.statics;

import me.finnlr.factory.Collidable;
import me.finnlr.factory.CollisionEvent;
import me.finnlr.factory.CollisionManager;
import me.finnlr.factory.assests.dynamic.Ball;
import me.finnlr.factory.assests.dynamic.Square;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class Laser implements Collidable {

    //Laser Base Properties
    private int bW;
    private int bH;

    private int bX;
    private int bY;

    private Color bColor;
    //Laser Properties
    private int id;

    private int laserW;
    private int laserH;

    private int laserX;
    private int laserY;

    //Tried to set rectangle angle. This did not work.
    private double theta;

    private Color laserColor;

    public void paintLaserBase(Graphics base) {
        base.setColor(getbColor());
        base.fillRect(getbX(), getbY(), getbW(), getbH());
    }


    public void paintLaser(Graphics2D laserG){
        /*
        laserG.setColor(getLaserColor());
        laserG.fillRect(getLaserX(), getLaserY(), getLaserW(), getLaserH());
        laserG.setColor(getLaserColor());
        laserG.fillRect(getLaserX(), getLaserY(), getLaserW(), getLaserH());

        This requires a rectangle2D. A rectangle2D was casted in Custom panel (I was pretty proud of this :D).
        Got the information here https://stackoverflow.com/questions/13992150/drawing-rectangles-at-an-angle
        */
        Rectangle2D rectangle2D = new Rectangle.Double(-getLaserW()/2., -getLaserH()/2., getLaserW(), getLaserH());
        //Creates a 2D rectangle, this is so the shape can be rotated.
        AffineTransform transform = new AffineTransform();

        transform.translate(getLaserX(), getLaserY());
        //Rotates the shape by the theta
        transform.rotate(theta);

        Shape rotatedRect = transform.createTransformedShape(rectangle2D);
        //Rotated shape is now drawn!
        laserG.setColor(getLaserColor());
        laserG.draw(rotatedRect);

        //COLOR BOUNDING LASERS BOX DEBUG:laserG.setColor(new Color(1, 0, 0, 0.2f));
        //COLOR BOUNDING LASERS BOX DEBUG:laserG.fillRect(getBounds().x,getBounds().y,getBounds().width,getBounds().height);
    }


    @Override
    public Rectangle getBounds() {
        //Returns only the laser boundaries.
        //If less than 0 it is a anticlockwise right facing laser. This will change the bounding box.
        if(theta < 0 ) {
        return new Rectangle(625, 200, 10, 10);
        } else {
            //Else it is a clockwise facing laser!
            return new Rectangle(165, 200, 10, 10);
        }
    }

    @Override
    public void handleCollision(CollisionEvent collisionEvent) {
        Collidable eventSource = (Collidable) collisionEvent.getSource();

        System.out.println("Htting something");
        if (eventSource instanceof Ball) {
            ((Ball) eventSource).setColor(Color.RED);

        } else if (eventSource instanceof Square) {
            ((Square) eventSource).setColor(Color.BLUE);
        }
    }

    public void blinkLaser() {
        Color tempColor = getLaserColor();
        this.setLaserColor(Color.MAGENTA);

        Timer tickTimer = new Timer( 500, e -> {
          Laser.this.setLaserColor(tempColor);
        });
        tickTimer.setInitialDelay(0);
        tickTimer.start();

    }
 /*
    Timer tickTimer = new Timer( 25, e -> {
        this.world.tick();
        this.revalidate();
        this.repaint();
    });

    tickTimer.setInitialDelay(0);
    tickTimer.start();
*/
    public int getbW() {
        return bW;
    }

    public void setbW(int bW) {
        this.bW = bW;
    }

    public int getbH() {
        return bH;
    }

    public void setbH(int bH) {
        this.bH = bH;
    }

    public int getbX() {
        return bX;
    }

    public void setbX(int bX) {
        this.bX = bX;
    }

    public int getbY() {
        return bY;
    }

    public void setbY(int bY) {
        this.bY = bY;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLaserW() {
        return laserW;
    }

    public void setLaserW(int laserW) {
        this.laserW = laserW;
    }

    public int getLaserH() {
        return laserH;
    }

    public void setLaserH(int laserH) {
        this.laserH = laserH;
    }

    public int getLaserX() {
        return laserX;
    }

    public void setLaserX(int laserX) {
        this.laserX = laserX;
    }

    public int getLaserY() {
        return laserY;
    }

    public void setLaserY(int laserY) {
        this.laserY = laserY;
    }

    public Color getLaserColor() {
        return laserColor;
    }

    public void setLaserColor(Color laserColor) {
        this.laserColor = laserColor;
    }

    public Color getbColor() {
        return bColor;
    }

    public void setbColor(Color bColor) {
        this.bColor = bColor;
    }

    public double getTheta() {
        return theta;
    }

    public void setTheta(double theta) {
        this.theta = theta;
    }
}
