package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

public class groups extends ApplicationAdapter {
	Stage stage;
	@Override
	public void create() {
		stage = new Stage(new ScreenViewport());
		Group group = new Group();

		Image tableImg = new Image(new Texture(Gdx.files.internal("board.jpeg")));
		Image aceImg = new Image(new Texture(Gdx.files.internal("spades.jpg")));
		Image kingImg = new Image(new Texture(Gdx.files.internal("king.png")));

		group.addActor(tableImg);
		group.addActor(kingImg);
		group.addActor(aceImg);

		stage.addActor(group);

		kingImg.setPosition(300,150);
		aceImg.setPosition(400,150);
	}

	@Override
	public void render() {
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.act(Gdx.graphics.getDeltaTime());
		stage.draw();

	}

}
