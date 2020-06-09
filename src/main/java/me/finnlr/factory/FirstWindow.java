package me.finnlr.factory;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import me.finnlr.factory.assests.dynamic.Ball;
import me.finnlr.factory.assests.dynamic.Square;
import me.finnlr.factory.assests.statics.ConveyorBelt;

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
                blueBall.setColor(Color.RED);
                blueBall.setX(20);
                blueBall.setY(100);
                blueBall.setXDirection(0);
                blueBall.setYDirection(1);
                blueBall.setH(30);
                blueBall.setW(30);

                Square blueSquare = new Square();
                blueSquare.setColor(Color.BLUE);
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


                //Adds objects to panel
                panel.addBall(blueBall);
                panel.addSquare(blueSquare);
                panel.addConveyorBelt(conveyorBeltL);
                panel.addConveyorBelt(conveyorBeltR);


                CollisionManager.height=600;
                CollisionManager.width=800;

                CollisionManager.addCollidable(blueBall);
                CollisionManager.addCollidable(blueSquare);

                CollisionManager.addCollidable(conveyorBeltL);
                CollisionManager.addCollidable(conveyorBeltR);

                //A window has insets (borders and title bar). To give a size to the panel
                //where we draw (so we can make sure we know the size) use setPreferedSize.
                window.getContentPane().setPreferredSize(new Dimension(800, 600));
                //calculate the window size base on its content
                window.pack();
                //Show the window
		window.setVisible(true);

		//Adds objects to thread.
                MovingObjectAnimator mBall1=new MovingObjectAnimator(blueBall);
                mBall1.setMovePerSec(25);

                MovingObjectAnimator mSquare1 = new MovingObjectAnimator(blueSquare);
                mSquare1.setMovePerSec(25);
                
                Thread thread1=new Thread(mBall1);
                thread1.start();

                Thread thread2=new Thread(mSquare1);
                thread2.start();
               
                
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

