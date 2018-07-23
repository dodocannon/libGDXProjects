package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.FillViewport;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class CameraDemo extends ApplicationAdapter implements InputProcessor{
	SpriteBatch batch;
	Sprite sprite;
	OrthographicCamera camera;
	final float GAME_WORLD_WIDTH = 4912;
	final float GAME_WORLD_HEIGHT = 2760;

	Viewport viewport;

	
	@Override
	public void create () {
		batch = new SpriteBatch();
		sprite = new Sprite(new Texture(Gdx.files.internal("picture.jpg")));
		sprite.setSize(GAME_WORLD_WIDTH,  GAME_WORLD_HEIGHT);

		float aspectRatio = (float) Gdx.graphics.getHeight()/ Gdx.graphics.getWidth();
		camera = new OrthographicCamera();
		viewport = new ExtendViewport(GAME_WORLD_WIDTH * aspectRatio, GAME_WORLD_HEIGHT, camera);
		viewport.apply();
		camera.position.set(GAME_WORLD_WIDTH/2, GAME_WORLD_HEIGHT/2,0);
		Gdx.input.setInputProcessor(this);
	}
	@Override
	public void resize(int width, int height)
	{
		viewport.update(width,height);
		camera.position.set(GAME_WORLD_WIDTH/2, GAME_WORLD_HEIGHT/2, 0);
	}
	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		camera.update();
		batch.begin();
		batch.setProjectionMatrix(camera.combined);
		sprite.draw(batch);
		batch.end();
	}

	@Override
	public void dispose () {
		batch.dispose();
		sprite.getTexture().dispose();
	}

	@Override
	public boolean keyDown(int keycode) {
		switch (keycode)
		{
			case Input.Keys.LEFT:
				camera.translate(-10f,0f);
				break;
			case Input.Keys.UP:
				camera.translate(0,010f);
				break;
			case Input.Keys.DOWN:
				camera.translate(0,-10f);
				break;
			case Input.Keys.RIGHT:
				camera.translate(010f,0f);
				break;
			default:
				break;

		}
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		return false;
	}
}
