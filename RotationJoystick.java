package com.evon.slash;


public class RotationJoystick extends Joystick  {
	private Shot shots[];
	private Timer attackSpeed;

	public RotationJoystick(float x, float y) {
		super(x, y);
		attackSpeed = new Timer(7);
		attackSpeed.resume();
		attackSpeed.setLoop(false);
		shots = new Shot[80];
		for (int i = 0; i < shots.length; i++)
			shots[i] = new Shot();
	}

	public void action(){
		if (touchPos.x != 0 && touchPos.y != 0) {
			Player.setSpriteRotatiion((float) DtP.toPolaris(touchPos.x, touchPos.y, false));
			if (!attackSpeed.isPlaying()) {
				attackSpeed.restart();
				for (int j = 0; j < 2; j++)
				for (int i = 0; i < shots.length; i++)
					if (shots[i].getAl() == 0) {
						shots[i].shot(Player.getPos().x + 22, Player.getPos().y + 30, (float) DtP.toPolaris(touchPos.x, touchPos.y + Math.random()*16-8, false), true);
						Player.setPos(Player.getPos().x + (float) DtP.toCartesian(10 * Math.random(), (float) DtP.toPolaris(touchPos.x, touchPos.y, false) + 180, false),
								Player.getPos().y + (float) DtP.toCartesian(10 * Math.random(), (float) DtP.toPolaris(touchPos.x, touchPos.y, false) + 180, true));
						break;
					}
			}
		}
		attackSpeed.update();
	}

	public Shot[] getShots() {
		return shots;
	}
}
