package me.finnlr.factory.assests.statics;
//Imports classes through
import me.finnlr.factory.Collidable;
import me.finnlr.factory.CollisionEvent;

import java.awt.*;


/**
 * This class is the conveyor belt class This class creates a conveyor belt that moves any object that hits it.
 *
 */
public class ConveyorBelt implements Collidable {
    //Position
    private int x;
    private int y;
    //Size
    private int w;
    private int h;
    //Object id, not sure if I will end up using this.
    private int id;

    /*Speed and direction. This will be used by object to detect a collision and
    move depending on what is set here. Speed will likely not be used
    but can be used in future.
    */
    private int speed;
    private String direction;


    //Paint object
    public Color color;

    /**
     * This method paints the conveyor belt. As the object hits the ConveyorBelt, this will be detected on the object side and it will move
     * @param graphics this is a graphics parameter, this is from the customPanel
     */
    public void paintConveyorBelt(Graphics graphics) {
        graphics.setColor(color);
        graphics.fillRect(getX(), getY(), w, h);

        /* Display bounding Box.
        graphics.setColor(new Color(1, 0, 0, 0.2f));
        graphics.fillRect(getBounds().x,getBounds().y,getBounds().width,getBounds().height);
        */
    }


    @Override
    public Rectangle getBounds() {
        //Creates bounding box around the rectangle.
        return new Rectangle(getX(), getY(), w, h);
    }



    @Override
    public void handleCollision(CollisionEvent collisionEvent) {
        /*
        Tried to do collisions with the converyorbelt, then change the properties of the object hitting it.
         Many hours later it still did't work, I've been all over the code. The conclusion that I have come to to is that
         this method is not getting triggered properly, I don't know why and it is very annoying.
         */
    }





    public void setDirection(String validate) {
        //Note: this doesn't protect against ints yet!

        if(validate.equals("L") || validate.equals("R")) {
            //If L or R has been inputted correctly this will work.
            this.direction = validate;
            return;
        } if (validate.equals("LEFT") || validate.equals("RIGHT")) {
        //if the user has accidently used "Left" or "Right" this will get the L or R from the start
        Character fixLRError = validate.charAt(0);

            this.direction = fixLRError.toString();
            return;
        }
        else {
            //This will default to R.
            System.out.println("DIRECTION ERROR! DEFAULTING TO RIGHT. USER HAS INPUTTED:" + validate + ". Not \"L\" or \"R\"");
            this.direction = "R";
        }

    }

    public void setSpeed(int speed) {
        if (direction.equals("L")) {
                /*If the direction the the ConveyorBelt is "L" the speed will be reversed using Absolute value.
                This was included for future iterations where the speed could be set at any time.
                */

            //NOT perfect. I have tried Math.abs, but it didn't work ;-;
            this.speed = -speed;
        } else {
            this.speed = speed;
        }

    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSpeed() {
        return speed;
    }


    public String getDirection() {
        return direction;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
