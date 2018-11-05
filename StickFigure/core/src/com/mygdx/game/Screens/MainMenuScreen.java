package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.Timer;
import com.mygdx.game.StickFigure;


public class MainMenuScreen implements Screen {

    boolean touched = false;
    float alpha =1;
    final StickFigure game;
    private Texture StupidStickFigure;

    OrthographicCamera camera;

    public MainMenuScreen(final StickFigure game)
    {
        this.game = game;
        StupidStickFigure = new Texture(Gdx.files.internal("StickFigure1.png"));
        camera = new OrthographicCamera();
        camera.setToOrtho(false,800,480);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        if (touched)
        {
            alpha-=.2 * Gdx.graphics.getDeltaTime();
            Gdx.gl.glClearColor(alpha,alpha,alpha,1);
        }
        else {
            Gdx.gl.glClearColor(1, 1, 1, 1);
        }
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        camera.update();
        game.batch.setProjectionMatrix(camera.combined);
        game.batch.begin();
        game.font.getData().setScale(2f);
        game.font.setColor(Color.BLACK);
        game.font.draw(game.batch, "An experience that questions your mentality.\n Do you think you are who you are?",100,450);

        game.font.draw(game.batch, "Tap anywhere to begin",100,100);
        game.batch.draw(StupidStickFigure, 400 - 64, 240-64, StupidStickFigure.getHeight()*2, StupidStickFigure.getWidth()*2);
        game.batch.end();
        if (touched) camera.zoom -= .1 * Gdx.graphics.getDeltaTime();
        if (camera.zoom < .32f)
        {
            //camera.zoom = 0;
           game.setScreen(new QuoteScreen(game));
           dispose();


        }
        if (Gdx.input.isTouched())
        {
            touched = true;
        }



    }

    @Override
    public void resize(int width, int height) {

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
}
