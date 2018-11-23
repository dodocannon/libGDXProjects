package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Tomato extends Actor {
    private Texture t;
    private int numLeaves;
    private boolean selected;
    public Tomato(Texture t, int numLeaves, boolean selected)
    {
        this.t = t;
        this.numLeaves = numLeaves;
    }



    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
    }
}
