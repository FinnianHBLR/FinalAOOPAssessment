package me.finnlr.factory.gravityHandler;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.awt.*;
import java.util.Random;

/**
 *
 * @author jnesis
 */
public class MovingObject {
    
    private int x = 20;
    private int y = 20;
    
    private int xDirection = 1;
    private int yDirection = 1;
    
    public void move(){
        x+=xDirection;
        y+=yDirection;
    }

    public GravityResult calculateFall(String objectType){
        //YES, this is a Parabola!!! (This took so many hours...)

        if(objectType.equals("Ball")){
            //If it is a ball, (On the left side) a ball trajectory will be calculated.
            int currentX = getX();
            //Y will be calculated below.

            int nextX = (getX() + 1);
            //Calculate the next Y value in-front of the object!

            //In a parabola a = the slope.
            int aValue = 350;
            //System.out.println("CURRENT CORDS:X" + getX() + " Y:"+ getY() );


            //Swing sucks and can only use ints as coordinates. Non floating points system so I have to cast ints below.
            //Y = X²/A. This gets the Y value from the X value.
            int moveToY = (int) ((Math.pow(nextX, 2)/aValue) + 98);
            //System.out.println("CALCULATING:" + currentX + "*" + currentX + "/" + aValue + "=" + (currentX * currentX)/aValue);

            //Moves the ball to the next Y value corresponding to the X value.

            //System.out.println("Moving too: Y" + moveToY);
            //System.out.println("Moving too: X" + (getX() + 1));

            //setY(moveToY);
            //setX((getX() + 2));
            return new GravityResult((getX() + 2), moveToY);

        } else if(objectType.equals("Square")) {
            //Backwards parabola. This is essentially a mirror method!
            //My calculated technical x and y.
            int antiX = ((400 - getX()) + 400);
            //Example, antiX = (400 - 500) + 400 = 300. 400 = the mid points in the program.

            int nextX = (antiX + 1);
            //Calculate the next Y value in-front of the object!

            //In a parabola a = the slope.
            int aValue = 300;
            //System.out.println("CURRENT CORDS:X" + getX() + " Y:"+ getY() );

            //Y = X²/A. This gets the Y value.
            int moveToY = (int) ((Math.pow(nextX, -2)/aValue) + nextX);
            //System.out.println("CALCULATING:" + nextX + "*" + nextX + "/" + aValue + "=" + moveToY);

            setY(moveToY);
            //Moves the square to the next Y value corresponding to the X value.

            int unAntiX = (400 - antiX) + 400;

            int fianalY = (moveToY);
            int fianlX = (unAntiX + -2);
            //System.out.println("Moving too: Y" + moveToY);
            //System.out.println("Moving too: X" + (getX() + 1));
            return new GravityResult(fianlX, fianalY);
        }

        return null;
}


    public int getXDirection() {
        return xDirection;
    }

    public void setXDirection(int xDirection) {
        this.xDirection = xDirection;
    }

    public int getYDirection() {
        return yDirection;
    }

    public void setYDirection(int yDirection) {
        this.yDirection = yDirection;
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



}
