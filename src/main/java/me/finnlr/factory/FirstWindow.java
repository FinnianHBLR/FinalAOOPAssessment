package me.finnlr.factory;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import me.finnlr.factory.assests.dynamic.Ball;
import me.finnlr.factory.assests.dynamic.Square;
import me.finnlr.factory.assests.statics.ConveyorBelt;
import me.finnlr.factory.assests.statics.Laser;
import me.finnlr.factory.assests.statics.Semi;
import me.finnlr.factory.gravityHandler.GravityBox;

import java.awt.Color;
import java.awt.Dimension;
import javax.management.modelmbean.ModelMBeanInfo;
import javax.swing.JFrame;
/**
 *
 * @author jnesis
 */
public class FirstWindow {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		JFrame window = new JFrame();

		window.setTitle("First Window");
                //Don't give a size to the window but to the content pane (see further)
		//window.setSize(400, 400);
		// Locate window content in the center
		window.setLocationRelativeTo(null);
		// Kill the Java process on click on the close (X) icon
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		CustomPanel panel = new CustomPanel();
		//Sets the panel background color because it looks better!
		panel.setBackground(Color.DARK_GRAY);
		window.setContentPane(panel);

		//Squares and balls imported from dynamic shapes package.
                Ball blueBall=new Ball();
                blueBall.setColor(Color.WHITE);
                blueBall.setX(20);
                blueBall.setY(100);
                blueBall.setXDirection(0);
                blueBall.setYDirection(1);
                blueBall.setH(30);
                blueBall.setW(30);

                Square blueSquare = new Square();
                blueSquare.setColor(Color.WHITE);
                blueSquare.setX(750);
                blueSquare.setY(100);
                blueSquare.setXDirection(0);
                blueSquare.setYDirection(1);
                blueSquare.setH(30);
                blueSquare.setW(30);

                //Static objects!
                ConveyorBelt conveyorBeltL = new ConveyorBelt();
                conveyorBeltL.setColor(Color.WHITE);
                conveyorBeltL.setX(0);
                conveyorBeltL.setY(200);
                conveyorBeltL.setId(1);
                conveyorBeltL.setW(200);
                conveyorBeltL.setH(30);
                conveyorBeltL.setDirection("R");
                conveyorBeltL.setSpeed(1);

                ConveyorBelt conveyorBeltR = new ConveyorBelt();
                conveyorBeltR.setColor(Color.WHITE);
                conveyorBeltR.setX(600);
                conveyorBeltR.setY(200);
                conveyorBeltR.setId(2);
                conveyorBeltR.setW(200);
                conveyorBeltR.setH(30);
                conveyorBeltR.setDirection("L");
                conveyorBeltR.setSpeed(1);

                //Left Laser.
                Laser laserL = new Laser();
                //Laser Base.
                laserL.setbX(400);
                laserL.setbY(0);
                laserL.setbW(20);
                laserL.setbH(20);
                laserL.setbColor(Color.BLACK);
                //Laser.
                laserL.setLaserH(610);
                laserL.setLaserW(2);
                laserL.setLaserX(400);
                laserL.setLaserY(0);
                //Angle of laser
                laserL.setTheta(-48);
                laserL.setLaserColor(Color.BLUE);

                //Right Laser
                Laser laserR = new Laser();
                //Laser Base
                laserR.setbX(380);
                laserR.setbY(0);
                laserR.setbW(20);
                laserR.setbH(20);
                laserR.setbColor(Color.BLACK);

                laserR.setLaserH(610);
                laserR.setLaserW(2);
                laserR.setLaserX(400);
                laserR.setLaserY(0);
                //Angle of laser
                laserR.setTheta(48);
                laserR.setLaserColor(Color.RED);


                GravityBox gravityBox = new GravityBox();
                Semi semi = new Semi();


                //Adds objects to panel
                panel.addBall(blueBall);
                panel.addSquare(blueSquare);
                panel.addConveyorBelt(conveyorBeltL);
                panel.addConveyorBelt(conveyorBeltR);
                panel.addLaser(laserL);
                panel.addLaser(laserR);
                panel.addGravityBox(gravityBox);
                panel.addSemiImage(semi);

                CollisionManager.height=600;
                CollisionManager.width=800;

                CollisionManager.addCollidable(blueBall);
                CollisionManager.addCollidable(blueSquare);

                CollisionManager.addCollidable(conveyorBeltL);
                CollisionManager.addCollidable(conveyorBeltR);

                CollisionManager.addCollidable(laserL);
                CollisionManager.addCollidable(laserR);
                CollisionManager.addCollidable(gravityBox);
                CollisionManager.addCollidable(semi);

                //A window has insets (borders and title bar). To give a size to the panel
                //where we draw (so we can make sure we know the size) use setPreferedSize.
                window.getContentPane().setPreferredSize(new Dimension(800, 600));
                //calculate the window size base on its content
                window.pack();
                //Show the window
		window.setVisible(true);

		//Adds objects to thread.
                MovingObjectAnimator mBall1 = new MovingObjectAnimator(blueBall);
                mBall1.setMovePerSec(30);

                MovingObjectAnimator mSquare1 = new MovingObjectAnimator(blueSquare);
                mSquare1.setMovePerSec(30);

                //MovingObjectAnimator mGravityThread = new MovingObjectAnimator(gravityBox);
                
                Thread thread1=new Thread(mBall1);
                thread1.start();

                Thread thread2=new Thread(mSquare1);
                thread2.start();

                //Thread gravity = new Thread(gravityBox);

                
                while (true){
                    
                    panel.repaint();
                    try {
                        //frame rate, refresh screen every 35ms
                        Thread.sleep(20);
                    } catch (InterruptedException ex) {
                        System.out.println("Something interrupted me while sleeping...");
                    }
                }
                
	}

}

