package com.evon.slash;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

public class Player {
	private static Vector2 pos;
	private static MoveJoystick moveJoystick;
	private static RotationJoystick rotationJoystick;
	private static Sprite sprite;
	private static Shot shots[];
	private static Timer attackSpeed;

	public static void create(){
		attackSpeed = new Timer(70);
		shots = new Shot[5];
		for (int i = 0; i < shots.length; i++)
			shots[i] = new Shot();
		pos = new Vector2(Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2);
		moveJoystick = new MoveJoystick(240, 240);
		rotationJoystick = new RotationJoystick(Gdx.graphics.getWidth() - 240, 240);
		sprite = new Sprite(TextureManager.tPlayer);
		sprite.setCenter(20, 33);
	}

	public static void setPosX(float x) {
		pos.x = x;
	}

	public static void setPosY(float y) {
		pos.y = y;
	}

	public static Vector2 getPos() {
		return pos;
	}

	public static void update(){
		sprite.setPosition(pos.x, pos.y);
		moveJoystick.update();
		rotationJoystick.update();
		render();
		if (moveJoystick.touchPos.x != 0 && moveJoystick.touchPos.y != 0 && !attackSpeed.isPlaying()){
			attackSpeed.restart();
			for (int i = 0; i < shots.length; i++)
				if (shots[i].getAl() == 0) {
					shots[i].shot(pos, sprite.getRotation());
					break;
				}
		}
	}

	public static void render(){
		sprite.draw(Main.getBatch());
	}

	public static RotationJoystick getRotationJoystick() {
		return rotationJoystick;
	}

	public static void setSpriteRotatiion(float degress){
		sprite.setRotation(degress);
	}
}
