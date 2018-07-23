package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class test3 extends ApplicationAdapter implements InputProcessor{
	SpriteBatch batch;
	Texture img;
	Sprite sprite;
	boolean movingRight;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		sprite = new Sprite(img);
		sprite.setPosition(Gdx.graphics.getWidth()/2 - sprite.getWidth()/2, Gdx.graphics.getHeight()/2 - sprite.getHeight()/2);
		Gdx.input.setInputProcessor(this);
	}

	@Override
	public void render () {
		if (movingRight)
		{
			sprite.translateX(1f);
		}
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(sprite, sprite.getX(),sprite.getY());
		batch.end();
	}
	@Override
	public boolean keyDown(int keycode)
	{
		switch(keycode) {
			case Input.Keys.LEFT:
				sprite.translateX(-1f);
				break;
			case Input.Keys.RIGHT:
				movingRight = true;
				break;
			case Input.Keys.UP:
				sprite.translateY(1f);
				break;
			case Input.Keys.DOWN:
				sprite.translateY(-1f);
				break;
			default:
				break;
		}
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		switch(keycode) {
			case Input.Keys.LEFT:
				sprite.translateX(-1f);
				break;
			case Input.Keys.RIGHT:
				movingRight = false;
				break;
			case Input.Keys.UP:
				sprite.translateY(1f);
				break;
			case Input.Keys.DOWN:
				sprite.translateY(-1f);
				break;
			default:
				break;
		}
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
		//sprite.setPosition(screenX - sprite.getWidth()/2, Gdx.graphics.getHeight() - screenY-sprite.getHeight()/2);
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		sprite.translateY((amount < 0) ? 1f : -1f);
		return false;
	}

	@Override
	public void dispose () {
		batch.dispose();
		img.dispose();
	}
}
