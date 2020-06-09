package me.finnlr.factory;/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.EventObject;


/**
 *
 * @author jnesis
 */
public class CollisionEvent extends EventObject{
    
    public static final String WALLSEVENTSOURCE="WALLS";
    
    private String impact;
    
    public CollisionEvent(Object source) {
        super(source);
    }

    public String getImpact() {
        return impact;
    }

    public void setImpact(String impact) {
        this.impact = impact;
    }
    
    
    
}
