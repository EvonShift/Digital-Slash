package com.evon.slash;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;

public class Enemy {
	public Vector2 pos;
	private int Hp, maxHp, dmg, gotDmg, speed;
	public double distance;
	public Timer attackSpeed;
	public Sprite sprite;
	private boolean AroundtheClock;
	private Circle hitBox;

	public Enemy(int maxHp, int speed, double distance, int time){
		this.maxHp = maxHp; this.Hp = this.maxHp;
		this.speed = speed;
		this.distance = distance*0.8 + Math.random()*(distance*0.4);
		float r = (float) (Math.random()*360);
		attackSpeed = new Timer(time);
		pos = new Vector2((float) DtP.toCartesian(1000, r, false) + Gdx.graphics.getHeight()/2, (float) DtP.toCartesian(1000, r, true) + Gdx.graphics.getHeight()/2);
		hitBox = new Circle(pos, 32);
		sprite = new Sprite(TextureManager.ttt);
		double ran = Math.random();
		if (ran < 0.5) AroundtheClock = true; else AroundtheClock = false;
	}

	public void update(){
		if (Hp <= 0){
			revive();
		}
		sprite.setRotation((float) DtP.toPolaris(Player.getPos().x - pos.x, Player.getPos().y - pos.y, false));
		if (DtP.toPolaris(Player.getPos().x - pos.x, Player.getPos().y - pos.y, true) > distance){
			pos.x += DtP.toCartesian(speed, sprite.getRotation(), false) * Gdx.graphics.getDeltaTime();
			pos.y += DtP.toCartesian(speed, sprite.getRotation(), true) * Gdx.graphics.getDeltaTime();
		}
		if (DtP.toPolaris(Player.getPos().x - pos.x, Player.getPos().y - pos.y, true) < distance - 50){
			pos.x += DtP.toCartesian(speed, sprite.getRotation() + 180, false) * Gdx.graphics.getDeltaTime();
			pos.y += DtP.toCartesian(speed, sprite.getRotation() + 180, true) * Gdx.graphics.getDeltaTime();
		}
		if (DtP.toPolaris(Player.getPos().x - pos.x, Player.getPos().y - pos.y, true) < distance + 20){
			double x = 90; if (AroundtheClock) x = -90;
			pos.x += DtP.toCartesian(speed, sprite.getRotation() + x, false) * Gdx.graphics.getDeltaTime();
			pos.y += DtP.toCartesian(speed, sprite.getRotation() + x, true) * Gdx.graphics.getDeltaTime();
		}
		hitBox.setPosition(pos.x, pos.y	);
		sprite.setPosition(pos.x, pos.y);
		sprite.draw(Main.getBatch());
		for (int i = 0; i < Player.getRotationJoystick().getShots().length; i++) {
			if (hitBox.contains(Player.getRotationJoystick().getShots()[i].getCollisionPos().x, Player.getRotationJoystick().getShots()[i].getCollisionPos().y) && Player.getRotationJoystick().getShots()[i].isPlayer() && Player.getRotationJoystick().getShots()[i].isActive()){
				 Player.getRotationJoystick().getShots()[i].setActive(false);
				 Hp -= 1;
			}
		}
	}

	public void revive(){
		Player.addScore();
		float r = (float) (Math.random()*360);
		pos.x = (float) DtP.toCartesian(1000, r, false) + Gdx.graphics.getHeight()/2;
		pos.y = (float) DtP.toCartesian(1000, r, true) + Gdx.graphics.getHeight()/2;
		Hp = maxHp;
		double ran = Math.random();
		if (ran < 0.5) AroundtheClock = true; else AroundtheClock = false;
	}
}
