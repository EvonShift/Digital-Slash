package com.evon.slash;


public class MoveJoystick extends Joystick  {
	public MoveJoystick(float x, float y) {
		super(x, y);
	}

	public void action(){
		Player.setPosX(Player.getPos().x + touchPos.x);
		Player.setPosX(Player.getPos().y + touchPos.y);
	}
}
