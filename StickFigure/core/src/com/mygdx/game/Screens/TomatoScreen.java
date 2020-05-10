package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.Background;
import com.mygdx.game.StickFigure;
import com.mygdx.game.TomatoTable;
import com.mygdx.game.TomatoUI;
import com.mygdx.game.TomatoWorld;


public class TomatoScreen implements Screen{
    final StickFigure game;

    private Image appleword, tomatoword, door;

    int appleTarget;

    Image[] numberContainer = new Image[5];

    ScreenViewport tViewport = new ScreenViewport();
    private SpriteBatch tBatch;
    private TomatoWorld tTomatoWorld;
    public TomatoScreen(StickFigure game) {
        this.game = game;
        tBatch = new SpriteBatch();
        appleTarget = MathUtils.random(4);


        tTomatoWorld = new TomatoWorld(tViewport, tBatch); // 800 x 480 world

        numberContainer[0] = new Image(new Texture(Gdx.files.internal("zeroText.png")));
        numberContainer[1] = new Image(new Texture(Gdx.files.internal("oneText.png")));
        numberContainer[2] = new Image(new Texture(Gdx.files.internal("twoText.png")));
        numberContainer[3] = new Image(new Texture(Gdx.files.internal("threeText.png")));
        numberContainer[4] = new Image(new Texture(Gdx.files.internal("fourText.png")));


        numberContainer[appleTarget].setPosition(144,480-64);

        tomatoword = new Image(new Texture(Gdx.files.internal("tomatoText.png")));


        TomatoTable tomatoFarm = new TomatoTable(5,4,appleTarget, tViewport,false);
        tomatoFarm.setSize(tViewport.getScreenWidth(),tViewport.getScreenHeight());
        tomatoFarm.setPosition(tViewport.getScreenWidth()-100,0);

        tomatoFarm.setDebug(true);
        tomatoFarm.fill();


        Background b = new Background(tViewport,128f);
        tTomatoWorld.addActor(b);
        tTomatoWorld.addActor(new TomatoUI(tViewport,tBatch,1));
        tTomatoWorld.addActor(tomatoFarm);
        tTomatoWorld.addActor(numberContainer[appleTarget]);
        Gdx.input.setInputProcessor(tTomatoWorld);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(1, 1, 1, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        tTomatoWorld.act(delta);

        tTomatoWorld.draw();
    }

    private Drawable textureToDrawable(Texture t) // I made this method to convert textures to drawables for ease of modification in the table
    {
        return new TextureRegionDrawable(new TextureRegion(t));
    }

    @Override
    public void resize(int width, int height) {
        tTomatoWorld.getViewport().update(width, height);
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
    private void drawScore()
    {

    }



}


