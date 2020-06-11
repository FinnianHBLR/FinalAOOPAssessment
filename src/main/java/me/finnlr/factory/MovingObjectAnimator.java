package me.finnlr.factory;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import me.finnlr.factory.gravityHandler.MovingObject;

/**
 *
 * @author jnesis
 */

public class MovingObjectAnimator implements Runnable{
    
    private MovingObject movingObject;
    private int movePerSec=100;
    
    public MovingObjectAnimator(MovingObject movingObject){
        this.movingObject=movingObject;
    }

    public int getMovePerSec() {
        return movePerSec;
    }

    public void setMovePerSec(int movePerSec) {
        this.movePerSec = movePerSec;
    }
    
    

    @Override
    public void run() {
        while (true){
            movingObject.move();
            try {
                //move every movePerSec.
                Thread.sleep(1000/movePerSec);
            } catch (InterruptedException ex) {
                System.out.println("Something interrupted me while sleeping...");
            }
        }
    }
    
}
