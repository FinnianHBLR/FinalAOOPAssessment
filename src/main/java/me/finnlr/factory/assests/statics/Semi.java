package me.finnlr.factory.assests.statics;

import javax.imageio.ImageIO;
import javax.swing.*;

import me.finnlr.factory.Collidable;
import me.finnlr.factory.CollisionEvent;

import sun.awt.image.BufferedImageDevice;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;

public class Semi implements Collidable {
    //https://stackoverflow.com/questions/299495/how-to-add-an-image-to-a-jpanel

    private BufferedImage semiImage;
    //URL resource = Semi.class.getResource("/semi.png");
//C:\Users\finnn\OneDrive\Year 2\AOOP (Extra)\FinalAOOPAssessment\src\main\java\me\finnlr\factory\assests\statics
    public void paintSemi(Graphics graphics){
        try {
            semiImage = ImageIO.read(new File("semi.png"));
        } catch (IOException ex) {
            System.out.println("Image Error" + ex);

        }
            graphics.drawImage(semiImage, 0, 480, null);

        /*Color Bounding Box
        graphics.setColor(new Color(1, 0, 0, 0.2f));
        graphics.fillRect(0,480,550,120);
        */
    }



    @Override
    public Rectangle getBounds() {
        return new Rectangle(0,480,550,120);
    }

    @Override
    public void handleCollision(CollisionEvent collisionEvent) {

    }
}
