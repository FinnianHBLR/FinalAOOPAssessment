package me.finnlr.factory.gravityHandler;

import me.finnlr.factory.Collidable;
import me.finnlr.factory.CollisionEvent;

import java.awt.*;

public class GravityBox implements Collidable {

    public void paintGravityBox(Graphics graphics){
        /* Color Gravity Box.
        graphics.setColor(new Color(1, 0, 0, 0.2f));
        graphics.fillRect(200, 190, 400, 400);
       */
    }


    @Override
    public Rectangle getBounds() {
        return new Rectangle(200, 190, 400, 400);
    }

    @Override
    public void handleCollision(CollisionEvent collisionEvent) {

    }


}
