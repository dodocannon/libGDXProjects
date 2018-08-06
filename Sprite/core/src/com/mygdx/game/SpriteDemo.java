package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g2d.Sprite;


public class SpriteDemo extends ApplicationAdapter implements InputProcessor{
	Sound sound;
	SpriteBatch batch;
	TextureAtlas textureAtlas;
	Sprite sprite;
	TextureRegion textureRegion;
	int currFrame = 1;
	int MAX_FRAMES = 19;
	boolean upHeld;
	boolean downHeld;
	boolean movingRight;
	boolean movingLeft;
	boolean movingUp;
	boolean movingDown;
	@Override
	public void create () {
		sound = Gdx.audio.newSound(Gdx.files.internal("skrt.wav"));
		batch = new SpriteBatch();
		textureAtlas = new TextureAtlas(Gdx.files.internal("Spritesheets/JetSprite.atlas"));
		textureRegion = textureAtlas.findRegion("jet0001");
		sprite = new Sprite(textureRegion);
		sprite.setPosition(Gdx.graphics.getHeight()/2 - sprite.getHeight()/2, Gdx.graphics.getWidth()/2 - sprite.getWidth()/2);
		Gdx.input.setInputProcessor(this);

	}

	@Override
	public void render () {
		if (movingUp)
			sprite.translateY(clamp(sprite.getY(),  0 - sprite.getHeight()/2+15, Gdx.graphics.getHeight()-sprite.getHeight()/2-15,10f));
		if (movingLeft)
			sprite.translateX(clamp(sprite.getX(), 0 - sprite.getWidth()/2 +35, Gdx.graphics.getWidth()- sprite.getWidth()/2 -35,-10f));
		if (movingRight)
			sprite.translateX(clamp(sprite.getX(), 0 - sprite.getWidth()/2 +35, Gdx.graphics.getWidth()- sprite.getWidth()/2 -35,10f));
		if (movingDown)
			sprite.translateY(clamp(sprite.getY(), 0 - sprite.getHeight()/2+15, Gdx.graphics.getHeight()-sprite.getHeight()/2-15,-10f));

		if (upHeld)
		{
			if (currFrame > MAX_FRAMES)
			{
				currFrame = 1;
			}
			currFrame++;
			sprite.setRegion(textureAtlas.findRegion("jet" + ((currFrame >= 10) ? "00" : "000")+currFrame));

		}
		if (downHeld)
		{
			currFrame--;
			if (currFrame == 0)
			{
				currFrame = MAX_FRAMES;
			}
			sprite.setRegion(textureAtlas.findRegion("jet" + ((currFrame >= 10) ? "00" : "000")+currFrame));
		}
		Gdx.gl.glClearColor(0, 0, 0, 0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		sprite.draw(batch);

		batch.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();

	}

	@Override
	public boolean keyDown(int keycode) {

		switch(keycode) {
			case Input.Keys.A:
				movingLeft=true;
				break;
			case Input.Keys.S:
				movingDown= true;
				break;
			case Input.Keys.D:
				movingRight = true;
				break;
			case Input.Keys.W:
				movingUp = true;
				break;
			case Input.Keys.UP:
				upHeld=true;
				sound.loop();
				break;
			case Input.Keys.DOWN:
				downHeld = true;
				sound.loop();

			default:
				break;
		}
		return true;



	}

	@Override
	public boolean keyUp(int keycode) {
		switch(keycode) {
			case Input.Keys.A:
				movingLeft=false;
				break;
			case Input.Keys.S:
				movingDown= false;
				break;
			case Input.Keys.D:
				movingRight = false;
				break;
			case Input.Keys.W:
				movingUp = false;
				break;
			case Input.Keys.UP:
				upHeld=false;
				sound.stop();
				break;
			case Input.Keys.DOWN:
				downHeld = false;
				sound.stop();

			default:
				break;
		}
		return true;




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
	public static float clamp(float p, float min, float max,float c)
	{
		if ((p +c >=max) || (p + c <= min))
		{
			return 0;
		}

		return c;
	}

}
