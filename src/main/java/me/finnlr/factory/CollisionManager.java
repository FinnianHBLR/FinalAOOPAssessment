package me.finnlr.factory;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author jnesis
 */
public class CollisionManager {

    public static int width;
    public static int height;
    private final static List<Collidable> COLLIDABLES = new ArrayList<>();

    public static void addCollidable(Collidable collidable) {
        COLLIDABLES.add(collidable);
    }

    public static void handleCollisions(Collidable collidable) {

        handleBoundaryCollision(collidable);
        List<Collidable> others = new ArrayList<>(COLLIDABLES);
        others.remove(collidable);
        handleOtherShapesCollisions(collidable, others);

    }

    protected static void handleBoundaryCollision(Collidable collidable) {
        //Detect the horizontal borders
        CollisionEvent event = null;
        if (collidable.getBounds().getY() < 0) {
            //Top border
            event = new CollisionEvent(CollisionEvent.WALLSEVENTSOURCE);
            event.setImpact("top");
        } else if (collidable.getBounds().getY() + collidable.getBounds().getHeight() > height) {
            //Bottom border
            event = new CollisionEvent(CollisionEvent.WALLSEVENTSOURCE);
            event.setImpact("bottom");
        }

        if (collidable.getBounds().getX() < 0) {
            //Left border
            event = new CollisionEvent(CollisionEvent.WALLSEVENTSOURCE);
            event.setImpact("left");
        } else if (collidable.getBounds().getX() + collidable.getBounds().getWidth() > width) {
            //Right border
            event = new CollisionEvent(CollisionEvent.WALLSEVENTSOURCE);
            event.setImpact("right");

        }
        if (event != null) {
            collidable.handleCollision(event);
        }
    }

    protected static void handleOtherShapesCollisions(Collidable collidable, List<Collidable> others) {

        for (Collidable otherCollidable : others) {
            if (otherCollidable.getBounds().intersects(collidable.getBounds())) {
                CollisionEvent event = new CollisionEvent(otherCollidable);
                double depth = 0;
                if (collidable.getBounds().getY() < otherCollidable.getBounds().getY() + otherCollidable.getBounds().height) {
                    //Top border
                    event.setImpact("top");
                    depth = otherCollidable.getBounds().getY() + otherCollidable.getBounds().height - collidable.getBounds().getY();
                }
                if (collidable.getBounds().getY() + collidable.getBounds().getHeight() > otherCollidable.getBounds().getY()) {
                    //Bottom border
                    double newDepth = collidable.getBounds().getY() + collidable.getBounds().getHeight() - otherCollidable.getBounds().getY();
                    if (event.getImpact() == null || newDepth < depth) {
                        event.setImpact("bottom");
                        depth=newDepth;
                    }
                }
                //Detect the vertical borders
                if (collidable.getBounds().getX() < otherCollidable.getBounds().getX() + otherCollidable.getBounds().width) {
                    //Left border
                    double newDepth = otherCollidable.getBounds().getX() + otherCollidable.getBounds().width - collidable.getBounds().getX();
                    if (event.getImpact() == null || newDepth < depth) {
                        event.setImpact("left");
                        depth=newDepth;
                    }
                }
                if (collidable.getBounds().getX() + collidable.getBounds().getWidth() > otherCollidable.getBounds().getX()) {
                    //Right border
                    double newDepth = collidable.getBounds().getX() + collidable.getBounds().getWidth() - otherCollidable.getBounds().getX();
                    if (event.getImpact() == null || newDepth < depth) {
                        event.setImpact("right");
                    }

                }

                collidable.handleCollision(event);
            }
        }
    }

}
