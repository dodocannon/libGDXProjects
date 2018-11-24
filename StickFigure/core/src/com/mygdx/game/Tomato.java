package com.mygdx.game;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class Tomato extends Image {


    private int tomatoNumber;
    private boolean rightTomato, alreadyExploded;
    private ClickListener listener;


    public Tomato()
    {
        alreadyExploded = false;
        listener = new ClickListener()
        {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if (!alreadyExploded) {
                    System.out.println("clicked");
                    alreadyExploded = !alreadyExploded;
                }

            }
        };

        this.setDrawable(textureToDrawable(new Texture(Gdx.files.internal("tomato1.png"))));
        setExplosion();
    }
    private void setExplosion()
    {
        this.addListener(listener);
    }
    public void reset()
    {
        rightTomato = false;
        alreadyExploded = false;

    }

    private Drawable textureToDrawable(Texture t) // I made this method to convert textures to drawables for ease of modification in the table
    {
        return new TextureRegionDrawable(new TextureRegion(t));
    }


}
