package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Files;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Timer;

public class music extends ApplicationAdapter {
	Music song1, song2;

	@Override
	public void create() {
		song1 = Gdx.audio.newMusic(Gdx.files.internal("m1.mp3"));
		song2 = Gdx.audio.newMusic(Gdx.files.internal("m2.mp3"));


		song1.play();
		

		song1.setOnCompletionListener(new Music.OnCompletionListener() {
			@Override
			public void onCompletion(Music music) {
				song2.play();
			}
		});




		Timer.schedule(new Timer.Task() {
			@Override
			public void run() {
				if (song1.isPlaying())
				{

						song1.setVolume(song1.getVolume()-.2f);

				}
			}
		},5f,.2f,4);


	}

	@Override
	public void render() {

	}

	@Override
	public void dispose() {

	}
}
