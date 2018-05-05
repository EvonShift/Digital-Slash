package com.evon.slash;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

public class Player {
	private static Vector2 pos;
	private static MoveJoystick moveJoystick;
	private static Sprite sprite;

	public static void create(){
		pos = new Vector2(Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2);
		moveJoystick = new MoveJoystick(240, 240);
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
		System.out.println(pos);
		render();
	}

	public static void render(){
		sprite.draw(Main.getBatch());
	}

	public static MoveJoystick getMoveJoystick() {
		return moveJoystick;
	}

	public static void setSpriteRotatiion(float degress){
		sprite.setRotation(degress);
	}
}
