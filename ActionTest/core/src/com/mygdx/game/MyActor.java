package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;
import com.badlogic.gdx.scenes.scene2d.actions.ColorAction;
import com.badlogic.gdx.scenes.scene2d.actions.MoveByAction;
import com.badlogic.gdx.scenes.scene2d.actions.MoveToAction;
import com.badlogic.gdx.scenes.scene2d.actions.ParallelAction;
import com.badlogic.gdx.scenes.scene2d.actions.RotateToAction;
import com.badlogic.gdx.scenes.scene2d.actions.RunnableAction;
import com.badlogic.gdx.scenes.scene2d.actions.ScaleByAction;
import com.badlogic.gdx.scenes.scene2d.actions.SequenceAction;
import com.badlogic.gdx.scenes.scene2d.ui.Image;
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable;
import static com.badlogic.gdx.scenes.scene2d.actions.Actions.*;

public class MyActor extends Image {

    @Override
    public void draw(Batch batch, float parentAlpha) {
        batch.setColor(this.getColor());

        ((TextureRegionDrawable)getDrawable()).draw(batch,getX(),getY(),getOriginX(),getOriginY(),getWidth(), getHeight(),getScaleX(),getScaleY(),getRotation());
    }

    public MyActor(Texture texture)
    {
        super(texture);

        setBounds(getX(),getY(),getWidth(),getHeight());

        addListener(new InputListener() {
            @Override
            public boolean keyDown(InputEvent event, int keycode) {
                switch(keycode)
                {
                    case Input.Keys.NUM_1:
                        MoveToAction moveToAction = new MoveToAction();
                        moveToAction.setPosition(200f, 200f);
                        moveToAction.setDuration(5f);
                        MyActor.this.addAction(moveToAction);
                        break;
                    case Input.Keys.NUM_2:
                        MoveByAction mba = new MoveByAction();
                        mba.setAmount(-200f,0f);
                        mba.setDuration(5f);
                        MyActor.this.addAction(mba);
                        break;
                    case Input.Keys.NUM_3:
                        ColorAction colorAction = new ColorAction();
                        colorAction.setEndColor(Color.PURPLE);
                        colorAction.setDuration(5f);
                        MyActor.this.addAction(colorAction);
                    case Input.Keys.NUM_4:
                        MoveToAction mta = new MoveToAction();
                        mta.setPosition(Gdx.graphics.getWidth() -200f, Gdx.graphics.getHeight()-200f);
                        mta.setDuration(3f);

                        ScaleByAction sba = new ScaleByAction();
                        sba.setAmount(2f);
                        sba.setDuration(4f);

                        RotateToAction rta = new RotateToAction();
                        rta.setRotation(30f);
                        rta.setDuration(3f);

                        ParallelAction pa = new ParallelAction(mta,sba,rta);
                        MyActor.this.addAction(pa);
                    case Input.Keys.NUM_5:
                        MoveToAction mta2 = new MoveToAction();
                        mta2.setPosition(Gdx.graphics.getWidth() -200f, Gdx.graphics.getHeight()-200f);
                        mta2.setDuration(3f);

                        ScaleByAction sba2 = new ScaleByAction();
                        sba2.setAmount(2f);
                        sba2.setDuration(4f);

                        RotateToAction rta2 = new RotateToAction();
                        rta2.setRotation(30f);
                        rta2.setDuration(3f);

                        SequenceAction pa2 = new SequenceAction(mta2,sba2,rta2);
                        addAction(pa2);
                    case Input.Keys.NUM_6:
                        RunnableAction ra = new RunnableAction();
                        ra.setRunnable(new Runnable() {
                            @Override
                            public void run() {
                                MyActor.this.setPosition(0f,0f);
                                MyActor.this.setRotation(0f);
                                MyActor.this.setScale(1f);
                            }
                        });
                        MyActor.this.addAction(ra);
                        break;
                    case Input.Keys.SPACE:
                        addAction(parallel(
                                moveTo(200f,200f,3f),
                                scaleTo(2f,3f),
                                rotateTo(90f,3f)

                        ));

                }
                return true;
            }

        });
    }
}
