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
import me.finnlr.factory.gravityHandler.GravityResult;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

/**
 *
 * @author jnesis
 */
public class CustomPanel extends JPanel
{
    //Array List of Balls
    private List<Ball> balls = new ArrayList<>();
    //Array List of Square
    private List<Square> squares = new ArrayList<>();
    //Array of belts.
    private List<ConveyorBelt> conveyorBelts = new ArrayList<>();
    //Array of Lasers
    private List<Laser> lasers = new ArrayList<>();
    //Array list of the Gravity Box
    private List<GravityBox> gravityBoxes = new ArrayList<>();
    //Array list of the semi image box.
    private List<Semi> semiList = new ArrayList<>();
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        //If the object is a ball, a ball will be found in the list.
        for (Ball ball: balls){
            ball.paintBall(g);
        }
        //If the object is a square, a square will be found in the list.
        for (Square square: squares){
            square.paintSquare(g);
        }

        for(ConveyorBelt conveyorBelt: conveyorBelts){
            conveyorBelt.paintConveyorBelt(g);
        }
        for(Laser laser: lasers){
            Graphics2D g2 = (Graphics2D) g;

            //Casts  g as Graphics 2D to create a shape that can be rotated.
            laser.paintLaser(g2);
            //System.out.println("Creating Lasers..");

            //Uses the pain laster base to paint the base.
            laser.paintLaserBase(g);
        }
        for(GravityBox gravityBox: gravityBoxes){
            gravityBox.paintGravityBox(g);
        }
        //To paint semi Image.
        for(Semi semi: semiList) {
            semi.paintSemi(g);
        }
    }


    @Override
    public void remove(Component comp) {
        super.remove(comp);
    }

    public void addBall(Ball ball) {
       balls.add(ball);
    }


    public void addSquare(Square square) {
        //Adds a new square to the list of squares.
        squares.add(square);
    }

    public void addConveyorBelt(ConveyorBelt conveyorBelt){
        conveyorBelts.add(conveyorBelt);
    }

    public void addLaser(Laser laser){
        lasers.add(laser);
    }

    public void addGravityBox(GravityBox gravityBox){
        gravityBoxes.add(gravityBox);
    }

    public void addSemiImage(Semi semi) {
        semiList.add(semi);
    }

}
