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

    private boolean stopped = false;

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

        while (stopped == false){
            movingObject.move();
            try {
                //move every movePerSec.
                Thread.sleep(1000/movePerSec);

                //i'm very much assuming this is how a thread is stopped.
                //When a object is interrupted using Thread.currentThread().interrupt(); Stop will be set and the loop will no longer run.
                //Other than the loop stopping, the thread is interrupted now.

                if(Thread.currentThread().isInterrupted()){
                    stopped = true;
                }
            } catch (InterruptedException ex) {
                System.out.println("Something interrupted me while sleeping...");
            }
        }
    }

    public boolean isStopped() {
        return stopped;
    }

    public void setStopped(boolean stopped) {
        this.stopped = stopped;
    }
}
