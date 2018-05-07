package com.evon.slash;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

import java.awt.geom.Line2D;

import javafx.scene.shape.Line;

public class Shot{
	private Sprite sprite;
	private Sprite ggg;
	private Vector2 pos;
	private float al;
	private double distance;
	private boolean player;
	private boolean active;
	private Vector2 collisionPos;
	public Shot(){
		pos = new Vector2(-1, -1);
		collisionPos = new Vector2(0, 0);
		sprite = new Sprite(TextureManager.tShot);
	}

	public void shot (float x, float y, float degress, boolean player){
		this.player = player;
		if (!player) sprite.setColor(1, 0, 0, 1);
		else sprite.setColor(1, 1, 1, 1);
		active = true;
		al = 1;
		pos.x = x;
		pos.y = y;
		sprite.setRotation(degress);
		sprite.setOrigin(0, 0);
	}

	public void update(){
		collisionPos.x = (float) DtP.toCartesian(distance + 48,(double) sprite.getRotation(), false) + Player.getPos().x;
		collisionPos.y = (float) DtP.toCartesian(distance + 48,(double) sprite.getRotation(), true) + Player.getPos().y;
		if (active) distance += 2000 * Gdx.graphics.getDeltaTime();
		sprite.setSize((float) distance, 1);
		sprite.setX(pos.x);
		sprite.setY(pos.y);
		sprite.setAlpha(al);
		sprite.draw(Main.getBatch());
		if (al < 0) al = 0;
		if (al > 0) al -= Gdx.graphics.getDeltaTime();
		if (al == 0){ pos.x = -1; pos.y = -1; distance = 0;}
	}

	public float getAl(){
		return al;
	}

	public Vector2 getCollisionPos() {
		return collisionPos;
	}

	public void setPlayer(boolean player) {
		this.player = player;
	}

	public boolean isPlayer() {
		return player;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}
}
