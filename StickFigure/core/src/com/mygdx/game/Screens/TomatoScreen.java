package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputMultiplexer;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.SnapshotArray;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.mygdx.game.StickFigure;
import com.mygdx.game.TomatoSplatAction;


public class TomatoScreen implements Screen {
    final StickFigure game;
    OrthographicCamera camera;
    ClickListener appleChange;
    private Texture tomato1, tomato2, tomato3, tomato4, tomato5, appleword, tomatoword, door;
    private Stage stage;
    private Table table;
    private Image t1, t2, t3, t4, t5;
   // MoveToAction action;


    public TomatoScreen(StickFigure game) {

        //imageContainer = new ArrayList<Image>();
        stage = new Stage(new FitViewport(800, 480)); // 800 x 480 world

        this.game = game;


        table = new Table();
        table.setFillParent(true);
        table.setDebug(true);


        door = new Texture(Gdx.files.internal("door.png"));
        tomato1 = new Texture(Gdx.files.internal("tomato1.png"));
        tomato2 = new Texture(Gdx.files.internal("tomato2.png"));
        tomato3 = new Texture(Gdx.files.internal("tomato3.png"));
        tomato4 = new Texture(Gdx.files.internal("tomato4.png"));
        tomato5 = new Texture(Gdx.files.internal("tomato5.png"));

        t1 = new Image(tomato1);
        t2 = new Image(tomato2);
        t3 = new Image(tomato3);
        t4 = new Image(tomato4);
        t5 = new Image(tomato5);

        for (int k = 0; k < 6; k++) {

            for (int i = 0; i < 12; i++) {
                final int rand = MathUtils.random(4) + 1;
                final Image curr = new Image(new Texture(Gdx.files.internal("tomato" + (rand) + ".png")));


                table.add(curr);
                curr.addListener(new ClickListener()
                {
                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        System.out.println("clicked" + rand);
                        TomatoSplatAction a = new TomatoSplatAction(curr);
                        curr.addAction(a);
                       /* MoveToAction action = new MoveToAction();
                        action.setPosition(100,200);
                        action.setDuration(10);
                        curr.setDrawable(textureToDrawable(door));
                        curr.addAction(action);*/

                    }
                });

                //imageContainer.add(curr);


            }
            table.row();

        }



        stage.addActor(table);


       // InputMultiplexer im = new InputMultiplexer(stage, this);
        Gdx.input.setInputProcessor(stage);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {

        Gdx.gl.glClearColor(1, 1, 1, 1);
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
        stage.getViewport().update(width, height);
        //table.invalidateHierarchy();
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
}

    // inputprocessor methods that must be overriden
