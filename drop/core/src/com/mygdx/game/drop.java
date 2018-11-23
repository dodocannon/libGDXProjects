package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;

import java.util.Iterator;

public class drop extends ApplicationAdapter implements InputProcessor {
	private Texture dropImage;
	private Texture bucketImage;
	private Sound dropSound;
	private Music rainMusic;
	private OrthographicCamera camera;
	private SpriteBatch batch;
	private Rectangle bucket;
	private Vector3 touchPos = new Vector3();
	private Array<Rectangle> raindrops; //an array to hold the rectangle coordinates for the raindrops, I used GDX's array rather than Arraylists to minimize garbage collector
	private long lastDropTime;
	
	@Override
	public void create () {
		//loading the images from files
		raindrops = new Array<Rectangle>();
		spawnRainDrop();
		dropImage = new Texture(Gdx.files.internal("droplet.png"));
		bucketImage = new Texture(Gdx.files.internal("bucket.png"));
		//loading the sounds/music
		dropSound = Gdx.audio.newSound(Gdx.files.internal("waterDrop.wav"));
		rainMusic = Gdx.audio.newMusic(Gdx.files.internal("rain.mp3"));

		//starting the playback of the background music (rain)
		rainMusic.setLooping(true);
		rainMusic.play();
		//initialize camera
		camera = new OrthographicCamera();
		camera.setToOrtho(false,800,480);

		bucket = new Rectangle(); // the rectangle holds coordinates for the bucket
		bucket.x = 800/2-64/2;
		bucket.y = 20;
		bucket.width = 64;
		bucket.height = 64;
		batch = new SpriteBatch();


	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0.2f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.setProjectionMatrix(camera.combined); //this line basically tells the spritebatch to use coordinate system specified by the camera. passes in a matrix
		batch.begin();
		batch.draw(bucketImage,bucket.x,bucket.y);
		for (Rectangle r: raindrops)
		{
			batch.draw(dropImage, r.getX(),r.getY());
		}
		batch.end();
		if (Gdx.input.isTouched()) //handling mouse input
		{
			touchPos.set(Gdx.input.getX(), Gdx.input.getY(),0); // touchpos is a vector3, passing in touch coordinates to the vector
			camera.unproject(touchPos);//converting standard touch coordinates to camera coordinates
			bucket.x = touchPos.x -64/2;//the x coordinate of the bucket is now the effective x coordinate of where the touch was at.
		}
		if(Gdx.input.isKeyPressed(Input.Keys.LEFT)) bucket.x -= 200 * Gdx.graphics.getDeltaTime();
		if(Gdx.input.isKeyPressed(Input.Keys.RIGHT)) bucket.x += 200 * Gdx.graphics.getDeltaTime();
		if (bucket.x < 0) bucket.x = 0;
		if (bucket.x > 800-64) bucket.x = 800-64;
		if(TimeUtils.nanoTime() - lastDropTime > 1000000000) spawnRainDrop();
		for (Iterator<Rectangle> iter = raindrops.iterator(); iter.hasNext(); ) {
			Rectangle raindrop = iter.next();
			raindrop.y -= 200 * Gdx.graphics.getDeltaTime();
			if(raindrop.y + 64 < 0) iter.remove();
			if (raindrop.overlaps(bucket))
			{
				dropSound.play();
				iter.remove();
			}
		}


	}
	private void spawnRainDrop()
	{
		Rectangle raindrop = new Rectangle();
		raindrop.x = MathUtils.random(0, 800-64);
		raindrop.y = 480;
		raindrop.width = 64;
		raindrop.height = 64;
		raindrops.add(raindrop);
		lastDropTime = TimeUtils.nanoTime();
	}



}
	@Override
	public boolean keyDown(int keycode) {
		/*switch (keycode)
		{
			case Input.Keys.LEFT:
				bucket.x -= 12;
				break;

		}*/
		return true;

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
