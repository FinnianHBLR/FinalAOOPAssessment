package me.finnlr.factory.assests.dynamic;

import me.finnlr.factory.Collidable;
import me.finnlr.factory.CollisionEvent;
import me.finnlr.factory.CollisionManager;
import me.finnlr.factory.assests.statics.Semi;
import me.finnlr.factory.gravityHandler.GravityBox;
import me.finnlr.factory.gravityHandler.MovingObject;
import me.finnlr.factory.assests.statics.ConveyorBelt;
import me.finnlr.factory.assests.statics.Laser;

import java.awt.*;

/**
 * This class is the base of the square object, this class uses the paintSquare method called by the customPanel class
 * Using this a original colour and position can be set in FirstWindow and the object will be created here
 * @author finn
 */
public class Square extends MovingObject implements Collidable {
    //Properties
    //Defaults
    private int w;
    private int h;

    //Paint object
    public Color color;

    public void paintSquare(Graphics graphics) {
        graphics.setColor(color);
        graphics.fillRect(getX(), getY(), w, h);
    }

    /**
     * @return This returns a new bounding box using the x,y,w and h of of the current ball object.
     */
    @Override
    public Rectangle getBounds() {
        //Creates bounding box around the rectangle.
        return new Rectangle(getX(), getY(), w, h);
    }

    @Override
    public void move() {
        super.move();
        //Asks the collision manager to handle this instance of a Collidable.
        CollisionManager.handleCollisions(this);
    }

    /**
     * @param collisionEvent This takes in a collision event which allows this method to get the source of where that impact has occured
     * Using collision.getSource from the CollisionEvent class it is now possible to compare this event with a specific class
     * In this method if any specific collision occurs the reaction to that is programmed in this method.
     */
    @Override
    public void handleCollision(CollisionEvent collisionEvent) {
        if (collisionEvent.getSource().equals(CollisionEvent.WALLSEVENTSOURCE)) {
            //it the the wall
            //wall specifics
        } else {
            //the collisionEvent source is the other object
            Collidable eventSource = (Collidable) collisionEvent.getSource();
            //AS THIS IS NOT hitting a moving object, it must be outside the instance of movingObject!
            if(eventSource instanceof ConveyorBelt) {
                //This code will get the speed of the ConveyorBelt and move that fast.

                this.setXDirection(((ConveyorBelt) eventSource).getSpeed());
                //System.out.println(((ConveyorBelt) eventSource).getSpeed());
                this.setYDirection(0);

            }

            //Ineracting with laser!
            if(eventSource instanceof Laser){
                this.setColor(Color.BLUE);
                ((Laser) eventSource).blinkLaser();

            }

            if(eventSource instanceof GravityBox) {
                //Sends the moving object class Ball to control the square gravity trajectory.
                //calculateFall("Square");

                this.setX(super.calculateFall("Square").getCalX());
                this.setY(super.calculateFall("Square").getCalY());
            }

            if(eventSource instanceof Semi) {
                //Reset Everything to 0, then stops the thread.

                this.setW(0);
                this.setH(0);
                //Stops the thread if it hits the truck.
                try {
                    Thread.currentThread().interrupt();
                } catch (Exception e) {
                    System.out.println("Thread Error:" + e);
                }
            }

            if (eventSource instanceof MovingObject) {
                //it is a moving object
                //me.finnlr.factory.gravityHandler.MovingObject movingObject=(me.finnlr.factory.gravityHandler.MovingObject)eventSource;
                //movingObject specifics
                if (eventSource instanceof Ball) {

                    //Sets this balls colors
                    this.color = Color.MAGENTA;;
                    //Sets the other balls colour.
                    ((Ball) eventSource).color = Color.MAGENTA;;

                    //it is a Ball
                    //Ball ball=(me.finnlr.factory.assests.dynamic.Ball)eventSource;
                    //Ball specifics

                } if (eventSource instanceof Square) {
                  //  this.color = Color.MAGENTA;
                    //((Square) eventSource).setColor(Color.MAGENTA);
                }
            }
        }
        switch (collisionEvent.getImpact()) {
            case "left":
            case "right":
                setXDirection(-getXDirection());
                break;
            case "top":
            case "bottom":
                setYDirection(-getYDirection());
        }
    }

    //Getters/Setters
    public int getW() {
        return w;
    }

    public void setW(int w) {
        this.w = w;
    }

    public int getH() {
        return h;
    }

    public void setH(int h) {
        this.h = h;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
