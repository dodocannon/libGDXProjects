package com.mygdx.game.Screens;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.ImageButton;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.Align;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.StickFigure;

public class TomatoScreen implements Screen, InputProcessor {
    private Texture tomato1, tomato2, tomato3, tomato4, tomato5, appleword, tomatoword,door;
    private Stage stage;
    private Table table;
    private Image t1,t2,t3,t4,t5;

    final StickFigure game;
    OrthographicCamera camera;
    public TomatoScreen(StickFigure game)
    {
        Pixmap pm1 = new Pixmap(1, 1, Pixmap.Format.RGB565);
        pm1.setColor(Color.WHITE);
        pm1.fill();

        Pixmap pm2 = new Pixmap(1, 1, Pixmap.Format.RGB565);
        pm2.setColor(Color.GRAY);
        pm2.fill();

        stage = new Stage(new ScreenViewport());
        this.game = game;



        table = new Table();
        table.setWidth(225f);

        table.setPosition(400-225, 240);
        door = new Texture(Gdx.files.internal("door.png"));
        tomato1 = new Texture(Gdx.files.internal("tomato.png"));
        tomato2 = new Texture(Gdx.files.internal("tomato2.png"));
        tomato3 = new Texture(Gdx.files.internal("tomato3.png"));
        tomato4 = new Texture(Gdx.files.internal("tomato4.png"));
        tomato5 = new Texture(Gdx.files.internal("tomato5.png"));

        t1 = new Image(tomato1);
        t1.addListener(appleButtons);
        t2 = new Image(tomato2);
        t3 = new Image(tomato3);
        t4 = new Image(tomato4);
        t5 = new Image(tomato5);
        table.add(t1).width(50).height(50);
        table.add(t2).width(50).height(50);
        table.row();
        table.add(t3).width(50).height(50).pad(100);
        table.add(t4).width(50).height(50);
        table.add(t5).width(50).height(50).pad(100);
        stage.addActor(table);




        camera = new OrthographicCamera();
        camera.setToOrtho(false, 800,480);

        InputMultiplexer im = new InputMultiplexer(stage,this);
        Gdx.input.setInputProcessor(im);
    }
    ClickListener appleButtons = new ClickListener(){ //universal listener added to the images in the table
        @Override
        public void clicked(InputEvent event, float x, float y)
        {
            System.out.println("HHH"); // tester code
            t1.setDrawable(textureToDrawable(door));
        }
    };
    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();

    }

    private Drawable textureToDrawable(Texture t) // I made this method to convert textures to drawables for ease of modification in the table
    {
        return new TextureRegionDrawable(new TextureRegion(t));
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {

    }

    @Override
    public void dispose() {

    }
// inputprocessor methods that must be overriden
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
