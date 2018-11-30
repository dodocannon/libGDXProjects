package com.mygdx.game;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.utils.viewport.Viewport;


public class TomatoTable extends Table {
    private int height;
    private int width;
    private int appleTarget;
    private Viewport globalViewport;

    public TomatoTable(int width, int height, int appleTarget, Viewport globalViewport)
    {
        //super();
        this.globalViewport = globalViewport;
        this.appleTarget = appleTarget;
        this.height = height;
        this.width = width;

    }
    public void fill()
    {
        for (int k = 0; k < height; k++) {
            for (int i = 0; i < width; i++) {


                int rand = MathUtils.random(4);
                Tomato curr = new Tomato(rand, rand==appleTarget, globalViewport);
                add(curr);


            }
            row();

        }

    }

}
