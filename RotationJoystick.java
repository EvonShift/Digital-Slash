package com.evon.slash;


public class RotationJoystick extends Joystick  {
	public RotationJoystick(float x, float y) {
		super(x, y);
	}

	public void action(){
		if ((touchPos.x != 0 && touchPos.y != 0))
			Player.setSpriteRotatiion((float) DtP.toPolaris(touchPos.x, touchPos.y, false));
	}
}
