package com.evon.slash;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

public class Player {
	private static Vector2 pos;
	private static MoveJoystick moveJoystick;
	private static RotationJoystick rotationJoystick;
	private static Sprite sprite;

	public static void create(){
		pos = new Vector2(Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2);
		moveJoystick = new MoveJoystick(240, 240);
		rotationJoystick = new RotationJoystick(Gdx.graphics.getWidth() - 240, 240);
		sprite = new Sprite(TextureManager.tPlayer);
		sprite.setOrigin(22, 30);
	}

	public static void setPos(float x, float y) {
		pos.x = x;
		pos.y = y;
	}

	public static Vector2 getPos() {
		return pos;
	}

	public static void update(){
		sprite.setPosition(pos.x, pos.y);
		moveJoystick.update();
		rotationJoystick.update();
		for (int i = 0; i < rotationJoystick.getShots().length; i++)
			rotationJoystick.getShots()[i].update();
		sprite.draw(Main.getBatch());
	}

	public static RotationJoystick getRotationJoystick() {
		return rotationJoystick;
	}

	public static void setSpriteRotatiion(float degress){
		sprite.setRotation(degress);
	}

	public static Sprite getSprite() {
		return sprite;
	}
}
