package me.finnlr.factory.assests.dynamic;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import me.finnlr.factory.Collidable;
import me.finnlr.factory.CollisionEvent;
import me.finnlr.factory.CollisionManager;
import me.finnlr.factory.assests.statics.Semi;
import me.finnlr.factory.gravityHandler.GravityBox;
import me.finnlr.factory.gravityHandler.MovingObject;
import me.finnlr.factory.assests.statics.ConveyorBelt;
import me.finnlr.factory.assests.statics.Laser;
import me.finnlr.factory.CustomPanel;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

/**
 * @author finn
 * @author jnesis
 */
public class Ball extends MovingObject implements Collidable {

    private int w = 10;
    private int h = 10;

    public Color color;

    public void paintBall(Graphics g) {
        g.setColor(color);
        g.fillOval(getX(), getY(), w, h);
    }

    @Override
    public Rectangle getBounds() {
        return new Rectangle(getX(), getY(), w, h);
    }

    @Override
    public void move() {
        super.move();
        CollisionManager.handleCollisions(this);
    }

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
            //THIS NEEDS COMMENTS!

              //setX(super.calculateFall().getX());


            this.setXDirection(((ConveyorBelt) eventSource).getSpeed());
                //System.out.println(((ConveyorBelt) eventSource).getSpeed());
            this.setYDirection(0);

            }
            //Inerracting with laser!
            if(eventSource instanceof Laser){
                this.setColor(Color.RED);

                ((Laser) eventSource).blinkLaser();

            }

            if(eventSource instanceof GravityBox) {
                //setY(super.calculateFall().getCalY() + super.getY());
                //System.out.println("Setting X to:" + super.calculateFall().getX());
                //(super.calculateFall().getCalX());
                //System.out.println("Setting Y to:" + super.calculateFall().getCalY());

                //Sends the moving object class Ball to control the ball gravity trajectory.
                //calculateFall("Ball");

                this.setX(super.calculateFall("Ball").getCalX());
                this.setY(super.calculateFall("Ball").getCalY());

            }
            if(eventSource instanceof Semi) {
                //Reset Everything to 0 then stops the thread.

                this.setW(0);
                this.setH(0);
                //Stops the thread if it hits the truck.
                Thread.currentThread().interrupt();
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
                    this.color = Color.MAGENTA;
                    ((Square) eventSource).setColor(Color.MAGENTA);

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
