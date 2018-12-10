package com.mygdx.game;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.Viewport;

import java.util.ArrayList;


public class TomatoTable extends Group {
    private InputProcessor processor;
    private int height;
    private int width;
    private int appleTarget;
    private Viewport globalViewport;
    private ArrayList<Actor> acts;
    //private Actor[][] tomatos;

    public TomatoTable(int width, int height, int appleTarget, Viewport globalViewport)
    {
        //super();
        acts = new ArrayList<Actor>();
        //tomatos = new Actor[height][width];
        this.globalViewport = globalViewport;
        this.appleTarget = appleTarget;
        this.height = height;
        this.width = width;
        //this.set


    }
    public void fill()
    {
        for (int k = 0; k < height; k++) {
            for (int i = 0; i < width; i++) {


                int rand = MathUtils.random(4);
                Tomato curr = new Tomato(rand, rand==appleTarget, globalViewport, this.getX()+i*64, this.getY() + k*64);
                this.addActor(curr);
                //curr.setPosition();




            }


        }

    }


}
