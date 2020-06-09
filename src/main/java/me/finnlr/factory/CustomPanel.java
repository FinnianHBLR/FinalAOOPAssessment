package me.finnlr.factory;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import me.finnlr.factory.assests.dynamic.Ball;
import me.finnlr.factory.assests.dynamic.Square;
import me.finnlr.factory.assests.statics.ConveyorBelt;

import java.awt.Graphics;
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


}
