package com.evon.slash;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.math.Vector2;

public class Joystick {
	Vector2 pos;
	Vector2 touchPos;
	int touchId;

	public Joystick(float x, float y){
		pos = new Vector2(x, y);
		touchPos = new Vector2(0, 0);
	}

	public void update(){
		for (int i = 0; i < 3; i++)
			if (Gdx.input.isTouched(i)){
				touchPos.x = Gdx.input.getX(i) - pos.x;
				touchPos.y = (Gdx.graphics.getHeight() - Gdx.input.getY(i)) - pos.y;
				touchId = i; break;
			}
		if (!Gdx.input.isTouched(touchId)){
			touchPos.x = 0; touchPos.y = 0;
		}
		if (DtP.toPolaris((touchPos.x),(touchPos.y),true) > 150){
			double r = DtP.toPolaris((touchPos.x),(touchPos.y),false);
			touchPos.x = (float) DtP.toCartesian(150, r, false);
			touchPos.y = (float) DtP.toCartesian(150, r, true);
		}
		render();
	}

	public void render(){
		action();
		Main.getBatch().draw(TextureManager.tJoyBack, 140, 140);
		Main.getBatch().draw(TextureManager.tJoy, - 24 + pos.x + touchPos.x, - 24 + pos.y + touchPos.y);
	}

	public void action(){};
}
