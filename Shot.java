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

	public void shot (Vector2 pos, float degress){
		this.pos = pos;
		al = 1;
		this.pos.x = pos.x;
		this.pos.y = pos.y;
		sprite.setRotation(degress);
	}

	public void update(){
		sprite.setAlpha(al);
		if (al < 0) al = 0;
		if (al > 0) al -= Gdx.graphics.getDeltaTime();
		if (al == 0){ pos.x = -1; pos.y = -1; }
		sprite.draw(Main.getBatch());
	}

	public float getAl(){
		return al;
	}
}
