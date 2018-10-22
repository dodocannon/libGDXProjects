package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.badlogic.gdx.utils.Timer;

public class scene2dui extends ApplicationAdapter implements InputProcessor {
	private Stage stage;
	private Skin skin;

	private Table table;
	private TextButton startButton;
	private TextButton quitButton;

	private SpriteBatch batch;
	private Sprite sprite;

	@Override
	public void create () {
		skin = new Skin(Gdx.files.internal("uiskin.json"));
		stage = new Stage(new ScreenViewport());

		table = new Table();
		table.setWidth(stage.getWidth());
		table.align(Align.center|Align.top);

		table.setPosition(0,Gdx.graphics.getHeight());

		startButton = new TextButton("New Game", skin);
		quitButton = new TextButton("Quit Game", skin);

		startButton.addListener(new ClickListener(){
			@Override
			public void clicked(InputEvent event, float x, float y) {
				Gdx.app.log("Clicked","Yes you did");
			}
		});
		table.padTop(30);
		table.add(startButton).padBottom(30);
		table.row();
		table.add(quitButton);

		stage.addActor(table);

		batch = new SpriteBatch();
		sprite = new Sprite(new Texture(Gdx.files.internal("badlogic.jpg")));
		sprite.setSize(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());

		InputMultiplexer im = new InputMultiplexer(stage,this);
		Gdx.input.setInputProcessor(im);

		/*final TextButton button = new TextButton("Click Me", skin, "default");
		button.setWidth(200);
		button.setHeight(50);

		final Dialog dialog = new Dialog("Click Message",skin);
		button.addListener(new ClickListener(){

			@Override
			public void clicked(InputEvent event, float x, float y)
			{
				dialog.show(stage);
				Timer.schedule(new Timer.Task() {
					@Override
					public void run() {
						dialog.hide();
					}
				},5);
			}
		});
		stage.addActor(button);*/



	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		batch.begin();
		sprite.draw(batch);
		batch.end();
		stage.act(Gdx.graphics.getDeltaTime());
		stage.draw();

	}
	
	@Override
	public void dispose () {

	}

	@Override
	public boolean keyDown(int keycode) {
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
		sprite.setFlip(!sprite.isFlipX(),sprite.isFlipY());
		return true;
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
