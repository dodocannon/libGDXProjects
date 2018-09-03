package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class SceneDemo extends ApplicationAdapter {


	Stage stage;
	@Override
	public void create () {
		ScreenViewport viewport = new ScreenViewport();
		MyActor actor = new MyActor();
		stage = new Stage(viewport);
		stage.addActor(actor);
		Gdx.input.setInputProcessor(stage);
		stage.setKeyboardFocus(actor);



	}

	@Override
	public void render () {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.act(Gdx.graphics.getDeltaTime());
		stage.draw();



	}
	
	@Override
	public void dispose () {

	}
}
