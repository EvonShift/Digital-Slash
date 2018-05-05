package com.evon.slash;


public class MoveJoystick extends Joystick  {
	public MoveJoystick(float x, float y) {
		super(x, y);
	}

	public void action(){
		Player.setPosX(Player.getPos().x + touchPos.x * 0.06f);
		Player.setPosY(Player.getPos().y + touchPos.y * 0.06f);
	}
}
