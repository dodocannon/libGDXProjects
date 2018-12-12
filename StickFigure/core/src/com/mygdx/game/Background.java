package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.Viewport;

public class Background extends Actor {
    /*
    for ease of setting the background image
     */
    private Texture grassBackground = new Texture(Gdx.files.internal("grass1.jpg"));
    private Drawable background;
    private Viewport globalViewport;
    private float tileSize;

    public Background(Viewport globalViewport, float tileSize)
    {
        this.tileSize = tileSize;
        this.globalViewport = globalViewport;
        this.setHeight(globalViewport.getWorldHeight());
        this.setWidth(globalViewport.getWorldWidth());
    }
    public void setGrassBackground()
    {
        background = textureToDrawable(grassBackground);
    }

    @Override
    public void draw(Batch batch, float parentAlpha) {
        super.draw(batch, parentAlpha);
        for (int i = 0; i <= this.getWidth(); i+=tileSize)
        {
            for (int k = 0; k < this.getHeight(); k+=tileSize) {
                batch.draw(grassBackground, i, k, tileSize, tileSize);
            }
        }
    }
    private Drawable textureToDrawable(Texture t) // I made this method to convert textures to drawables for ease of modification in the table
    {
        return new TextureRegionDrawable(new TextureRegion(t));
    }
}
