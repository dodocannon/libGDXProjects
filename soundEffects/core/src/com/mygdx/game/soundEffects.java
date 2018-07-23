package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Timer;

public class soundEffects extends ApplicationAdapter {

	Sound sound;
	@Override
	public void create () {
		sound = Gdx.audio.newSound(Gdx.files.internal("good.wav"));
		//long id = sound.play();
		final long id = sound.loop(1f, 1f, 0f);

		Timer.schedule(new Timer.Task() {
			@Override
			public void run() {
				sound.pause(id);
			}
		},5);


		//sound.setPitch(id,1.5f);
		//sound.setPan(id,-1f, 1f);
		//sound.setVolume(id, .2f);
		//sound.setPitch(id, 2f);
		//sound.play();



	}

	@Override
	public void render () {

	}
	
	@Override
	public void dispose () {
		sound.dispose();
	}
}
