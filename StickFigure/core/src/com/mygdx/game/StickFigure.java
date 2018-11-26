package com.mygdx.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.Screens.MainMenuScreen;
import com.mygdx.game.Screens.TomatoScreen;

public class StickFigure extends Game {
	public SpriteBatch batch;
	public BitmapFont font;
	public static int takes;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		font = new BitmapFont();
		this.setScreen(new TomatoScreen(this));
	}

	@Override
	public void render () {
		super.render();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		font.dispose();
		//img.dispose();
	}
}
