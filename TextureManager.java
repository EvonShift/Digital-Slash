package com.evon.slash;


import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;

public class TextureManager {
	static Texture tJoy;
	static Texture tJoyBack;
	static Texture tPlayer;

	public static void upload(){
		tJoyBack = new Texture(Gdx.files.internal("JoyBack.png"));
		tJoy = new Texture(Gdx.files.internal("JoyStick.png"));
		tPlayer = new Texture(Gdx.files.internal("Player.png"));
	}

	public static void dispose(){
		tJoy.dispose();
		tJoyBack.dispose();
	}
}
