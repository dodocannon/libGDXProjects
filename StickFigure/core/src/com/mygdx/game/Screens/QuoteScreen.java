package com.mygdx.game.Screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.mygdx.game.StickFigure;

public class QuoteScreen implements Screen {
    private String message;
    boolean fadein =  true;
    float alpha = 0;
    final StickFigure game;
    OrthographicCamera camera;
    public QuoteScreen(StickFigure game, String message)
    {
        this.message = message;
        this.game = game;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800,480);
    }
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        if (fadein)
        {
            alpha += .4 * Gdx.graphics.getDeltaTime();
        }
        else
        {
            alpha -= .4 * Gdx.graphics.getDeltaTime();
        }
        game.batch.setProjectionMatrix(camera.combined);
        camera.update();
        game.batch.begin();
        game.font.setColor(new Color(alpha,alpha,alpha,1));
        game.font.draw(game.batch,message,400,240);
        game.batch.end();
        if (alpha >= 1)
        {
            fadein = false;
        }
        if (alpha <= 0)
        {
            game.setScreen(new TomatoScreen(game));
            dispose();
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
