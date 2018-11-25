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
    Animation<TextureRegion> animation;
    private float animationTime;


    private int tomatoNumber;
    private boolean rightTomato, alreadyExploded, clicked;



    private ClickListener listener;
    private TextureRegion explosionFrame, tomatoSprite;



    public Tomato(int tomatoNumber, boolean rightTomato)
    {
        this.rightTomato = rightTomato;
        this.tomatoNumber = tomatoNumber;
        animationTime = 0;
        tomatoSprite = new TextureRegion(new Texture(Gdx.files.internal("tomato"+tomatoNumber+".png")));
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
        animation = new Animation<TextureRegion>(1f/4f, animationFrames);
        listener = new ClickListener()
        {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if (!alreadyExploded) {
                    clicked = true;
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
        super.act(delta);
        setBounds( getParent().getX()+getX(), getParent().getY()+getY(), 64,64 );
        System.out.println(getParent().getY());
        if (clicked) animationTime += delta;

        //someActor.setBounds( getParent().getX()+getX(), getParent.getY()+getY(), someActor.getPrefWidth(), someActor.getPrefHeight() );
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        if (clicked ) {
            if (rightTomato) { //if this tomato is the "right" (exploding) tomato...
                explosionFrame = animation.getKeyFrame(animationTime);
                //batch.draw(new Texture(Gdx.files.internal("door.png")),getX(),getY(),64,64);
                batch.draw(explosionFrame,getX(),getY(),64,64);
            }
            else { //if this tomato isn't the right tomato (it's non-exploding tomato)

            }
        }
        else
        {
            batch.draw(tomatoSprite,getX(),getY(),64,64);
        }

    }
}
