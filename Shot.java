package com.evon.slash;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

public class Shot{
	private Sprite sprite;
	private Vector2 pos;
	private float al;
	public Shot(){
		pos = new Vector2(-1, -1);
		sprite = new Sprite(TextureManager.tShot);
	}

	public void shot (float x, float y, float degress){
		al = 1;
		pos.x = x;
		pos.y = y;
		sprite.setRotation(degress);
		sprite.setOrigin(0, 0);
	}

	public void update(){
		sprite.setX(pos.x);
		sprite.setY(pos.y);
		sprite.setAlpha(al);
		sprite.draw(Main.getBatch());
		if (al < 0) al = 0;
		if (al > 0) al -= Gdx.graphics.getDeltaTime();
		if (al == 0){ pos.x = -1; pos.y = -1; }
	}

	public float getAl(){
		return al;
	}
}
