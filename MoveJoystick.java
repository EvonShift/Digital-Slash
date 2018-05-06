package com.evon.slash;


import com.badlogic.gdx.Gdx;

public class MoveJoystick extends Joystick  {
	public MoveJoystick(float x, float y) {
		super(x, y);
	}

	public void action(){
		float spMod = 2 * Gdx.graphics.getDeltaTime();
		if (Player.getRotationJoystick().touchId != 19) spMod = 1 * Gdx.graphics.getDeltaTime();
		Player.setPos(Player.getPos().x + touchPos.x * spMod, Player.getPos().y + touchPos.y * spMod);
		if (Player.getRotationJoystick().touchPos.x == 0 && Player.getRotationJoystick().touchPos.y == 0 && (touchPos.x != 0 && touchPos.y != 0))
			Player.setSpriteRotatiion((float) DtP.toPolaris(touchPos.x, touchPos.y, false));
	}
}
