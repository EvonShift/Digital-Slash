package com.evon.slash;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;

public class Player {
	private static Vector2 pos;
	private static MoveJoystick moveJoystick;
	private static RotationJoystick rotationJoystick;
	private static Sprite sprite;
	private static Circle hitBox;
	private static int hp;
	private static int score;

	public static void create(){
		hp = 100;
		pos = new Vector2(Gdx.graphics.getWidth()/2, Gdx.graphics.getHeight()/2);
		moveJoystick = new MoveJoystick(240, 240);
		rotationJoystick = new RotationJoystick(Gdx.graphics.getWidth() - 240, 240);
		sprite = new Sprite(TextureManager.tPlayer);
		sprite.setOrigin(22, 30);
		hitBox = new Circle(pos, 32);
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
		sprite.draw(Main.getBatch());
		moveJoystick.update();
		rotationJoystick.update();
		for (int i = 0; i < rotationJoystick.getShots().length; i++)
			rotationJoystick.getShots()[i].update();
		hitBox.setPosition(pos.x + 22, pos.y + 30);
		for (int i = 0; i < rotationJoystick.getShots().length; i++) {
			if (hitBox.contains(rotationJoystick.getShots()[i].getCollisionPos().x, rotationJoystick.getShots()[i].getCollisionPos().y) && !rotationJoystick.getShots()[i].isPlayer() && rotationJoystick.getShots()[i].isActive()){
				System.out.println("df");
				rotationJoystick.getShots()[i].setActive(false);
				if (hp > 0) hp -= 1;
			}
		}
		if (hp <= 0){
			sprite.setAlpha(0.2f);
		}
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

	public static void addScore() {if (hp > 0) score++;}

	public static int getScore() {
		return score;
	}

	public static int getHp() {
		return hp;
	}
}
