package com.evon.slash;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;

public class Joystick {
    Vector2 pos;
    Vector2 touchPos;
    int touchId;
    Circle touchBox;

    public Joystick(float x, float y) {
        touchId = 19;
        pos = new Vector2(x, y);
        touchPos = new Vector2(0, 0);
        touchBox = new Circle(pos, 200);
    }

    public void update() {
        for (int i = 0; i < 3; i++)
            if (Gdx.input.justTouched() && Gdx.input.isTouched(i) && touchBox.contains(Gdx.input.getX(i), Gdx.graphics.getHeight() - Gdx.input.getY(i))) {
                touchId = i;
                break;
            }
        if (Gdx.input.isTouched(touchId)) {
            touchPos.x = Gdx.input.getX(touchId) - pos.x;
            touchPos.y = (Gdx.graphics.getHeight() - Gdx.input.getY(touchId)) - pos.y;
        }
        if (!Gdx.input.isTouched(touchId)) {
            touchPos.x = 0;
            touchPos.y = 0;
            touchId = 19;
        }
        if (DtP.toPolaris((touchPos.x), (touchPos.y), true) > 150) {
            double r = DtP.toPolaris((touchPos.x), (touchPos.y), false);
            touchPos.x = (float) DtP.toCartesian(150, r, false);
            touchPos.y = (float) DtP.toCartesian(150, r, true);
        }
        render();
    }

    public void render() {
        action();
        Main.getBatch().draw(TextureManager.tJoyBack, pos.x - 100, pos.y - 100);
        Main.getBatch().draw(TextureManager.tJoy, -24 + pos.x + touchPos.x, -24 + pos.y + touchPos.y);
    }

    public void action() {
    }
}
