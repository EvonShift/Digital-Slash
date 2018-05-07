package com.evon.slash;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;

public class ShootingEnemy extends Enemy{
	public ShootingEnemy(){
		super(30, 60, 300, 200);
	}

	public void update(){
		super.update();
		if (DtP.toPolaris(Player.getPos().x - pos.x, Player.getPos().y - pos.y, true) >= distance - 50 &&
			DtP.toPolaris(Player.getPos().x - pos.x, Player.getPos().y - pos.y, true) <= distance + 50){
			if (!attackSpeed.isPlaying()) {
				attackSpeed.restart();
				//for (int j = 0; j < 2; j++)
					for (int i = 0; i < Player.getRotationJoystick().getShots().length; i++)
						if (Player.getRotationJoystick().getShots()[i].getAl() == 0) {
							Player.getRotationJoystick().getShots()[i].shot(pos.x + 32, pos.y + 32, sprite.getRotation(), false);
							pos.x = pos.x + (float) DtP.toCartesian(10 * Math.random(), sprite.getRotation() + 180, false);
							pos.y = pos.y + (float) DtP.toCartesian(10 * Math.random(), sprite.getRotation() + 180, true);
							break;
						}
			}
		}
		attackSpeed.update();
	}
}
