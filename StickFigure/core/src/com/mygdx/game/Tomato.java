package com.mygdx.game;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;

public class Tomato extends Actor {
    TextureRegion[] animationFrames;
    TextureRegion tmpFrames[][] = TextureRegion.split(new Texture(Gdx.files.internal("tomatosheet.png")),64,64);
    Animation animation;

    private int tomatoNumber;
    private boolean rightTomato, alreadyExploded;
    private ClickListener listener;



    public Tomato()
    {
        alreadyExploded = false;


        //this.setDrawable(textureToDrawable(new Texture(Gdx.files.internal("tomato1.png"))));
        init();
    }
    private void init()
    {
        animationFrames = new TextureRegion[9];
        int a = 0;
        for (int k = 0; k < 3; k++)
        {
            for (int j = 0; j < 3; j++)
            {
                animationFrames[a] = tmpFrames[k][j];
                a++;
            }
        }
        animation = new Animation(1f/4f, animationFrames);
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

    @Override
    public void act(float delta) {
        //someActor.setBounds( getParent().getX()+getX(), getParent.getY()+getY(), someActor.getPrefWidth(), someActor.getPrefHeight() );
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
    }
}
