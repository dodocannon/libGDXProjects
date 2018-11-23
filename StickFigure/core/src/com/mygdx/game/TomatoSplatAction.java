package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Action;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.actions.Actions;
import com.badlogic.gdx.scenes.scene2d.actions.TemporalAction;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Pool;

public class TomatoSplatAction extends TemporalAction {
    TextureRegion[] animationFrames;
    TextureRegion tmpFrames[][] = TextureRegion.split(new Texture(Gdx.files.internal("tomatosheet.png")),64,64);


    private float time,duration,buffer;
    boolean complete;

    Texture door = new Texture(Gdx.files.internal("door.png"));
    Image i;
    Texture  tomato1 = new Texture(Gdx.files.internal("tomato1.png"));
    boolean a = false;
    int k = 0;
    public TomatoSplatAction(Image i) {
        this.i = i;
        duration =1;
        buffer = duration/2000; //increasing the denominator increases the rate of the animation, while decreasing the denominator decreases the rate of hte animation.
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
        //animationFrames[0] = tmpFrames[0][0];

    }

    @Override
    public boolean act(float delta) {
        if (complete) return true;
        time+= delta;
        complete = time >=duration;
        System.out.println(time);
        if (time >= buffer) {
            i.setDrawable(new TextureRegionDrawable(animationFrames[k]));
            if (k < 8)k++;

            buffer += buffer;
        }
        return false;
    }

    @Override
    protected void begin() {
        super.begin();
    }

    @Override
    protected void end() {
        super.end();
    }

    @Override
    protected void update(float percent) {
        System.out.println("SSSS");
    }


    private Drawable textureToDrawable(Texture t) // I made this method to convert textures to drawables for ease of modification in the table
    {
        return new TextureRegionDrawable(new TextureRegion(t));
    }
}
