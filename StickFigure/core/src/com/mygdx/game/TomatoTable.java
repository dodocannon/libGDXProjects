package com.mygdx.game;

import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.ui.Table;

public class TomatoTable extends Table {
    private int height;
    private int width;
    private int appleTarget;

    public TomatoTable(int width, int height, int appleTarget)
    {
        //super();
        this.appleTarget = appleTarget;
        this.height = height;
        this.width = width;

    }
    public void fill()
    {
        for (int k = 0; k < height; k++) {
            for (int i = 0; i < width; i++) {


                int rand = MathUtils.random(4);
                Tomato curr = new Tomato(rand, rand==appleTarget);
                add(curr);


            }
            row();

        }

    }

}
