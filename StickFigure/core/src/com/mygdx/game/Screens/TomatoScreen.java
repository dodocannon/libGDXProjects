package com.mygdx.game.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Group;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import com.badlogic.gdx.utils.viewport.FitViewport;
import com.badlogic.gdx.utils.viewport.ScreenViewport;
import com.mygdx.game.Background;
import com.mygdx.game.StickFigure;
import com.mygdx.game.Tomato;
import com.mygdx.game.TomatoTable;


public class TomatoScreen implements Screen{
    final StickFigure game;

    private Image appleword, tomatoword, door;
    private Stage stage;
    private Table table;

    int appleTarget;

    Image[] numberContainer = new Image[5];

    ScreenViewport viewport = new ScreenViewport();
    public TomatoScreen(StickFigure game) {
        this.game = game;

        appleTarget = MathUtils.random(4);


        stage = new Stage(viewport); // 800 x 480 world

        numberContainer[0] = new Image(new Texture(Gdx.files.internal("zeroText.png")));
        numberContainer[1] = new Image(new Texture(Gdx.files.internal("oneText.png")));
        numberContainer[2] = new Image(new Texture(Gdx.files.internal("twoText.png")));
        numberContainer[3] = new Image(new Texture(Gdx.files.internal("threeText.png")));
        numberContainer[4] = new Image(new Texture(Gdx.files.internal("fourText.png")));


        numberContainer[appleTarget].setPosition(144,480-64);

        tomatoword = new Image(new Texture(Gdx.files.internal("tomatoText.png")));

        //tomatoword.setPosition(16,100);

        TomatoTable tomatoFarm = new TomatoTable(5,4,appleTarget, viewport);
        tomatoFarm.setPosition(100,0);
        //Actor a = new Actor();

        //tomatoFarm.setFillParent(true);
        //tomatoFarm.setSize(1000,1000);
        tomatoFarm.setDebug(true);
        tomatoFarm.fill();

        //tomatoFarm.setPosition(-10,0);

        Background b = new Background(viewport);
        stage.addActor(b);
        stage.addActor(tomatoFarm);
        //stage.addActor(tomatoFarm);
        //stage.addActor(a);




/*
        table = new Table();
        table.setFillParent(true);
        //table.setDebug(true);
        //table.setY(table.getY()-32);




        for (int k = 0; k < 6; k++) {
            for (int i = 0; i < 12; i++) {
               *//* final int rand = MathUtils.random(4);
                final Image curr = new Image(new Texture(Gdx.files.internal("tomato" + (rand) + ".png")));
                table.add(curr);
                curr.addListener(new ClickListener()
                {

                    @Override
                    public void clicked(InputEvent event, float x, float y) {
                        System.out.println("clicked" + rand);
                        TomatoSplatAction a = new TomatoSplatAction(curr);
                        curr.addAction(a);

                    }
                });*//*
               int rand = MathUtils.random(4);
               Tomato curr = new Tomato(rand, rand==appleTarget);
               table.add(curr);


            }
            table.row();

        }
        stage.addActor(table);*/
        stage.addActor(numberContainer[appleTarget]);
      //  stage.addActor(tomatoword);
        //table.remove();

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


