package com.evon.slash;


import com.badlogic.gdx.Gdx;

public class MoveJoystick extends Joystick  {
	public MoveJoystick(float x, float y) {
		super(x, y);
	}

	public void action(){
		float spMod = 1f * Gdx.graphics.getDeltaTime();
		if (Player.getRotationJoystick().touchId != 19) spMod = 0.5f * Gdx.graphics.getDeltaTime();
		Player.setPosX(Player.getPos().x + touchPos.x * spMod);
		Player.setPosY(Player.getPos().y + touchPos.y * spMod);
	}
}
