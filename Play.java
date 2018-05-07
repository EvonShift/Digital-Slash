package com.evon.slash;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;

import java.util.ArrayList;

public class Play implements Screen {
	private ShootingEnemy enemies[];
	private StealthEnemy Senemies[];
	private BitmapFont font48;
	private BitmapFont font96;

	@Override
	public void show() {
		Player.create();
		enemies = new ShootingEnemy[5];
		Senemies = new StealthEnemy[2];
		for (int i = 0; i < enemies.length; i++){
			float r = (float) (Math.random()*360);
			enemies[i] = new ShootingEnemy();
		}
		for (int i = 0; i < Senemies.length; i++){
			float r = (float) (Math.random()*360);
			Senemies[i] = new StealthEnemy();
		}
		FreeTypeFontGenerator generator = new FreeTypeFontGenerator(Gdx.files.internal("zorque.ttf"));
		FreeTypeFontGenerator.FreeTypeFontParameter parameter = new FreeTypeFontGenerator.FreeTypeFontParameter();
		parameter.size = 96;
		parameter.mono = true;
		parameter.borderWidth = 5;
		parameter.borderColor = Color.BLACK;
		parameter.color = Color.RED;
		font96 = generator.generateFont(parameter);
		parameter.size = 48;
		parameter.borderWidth = 3;
		parameter.color = Color.GREEN;
		font48 = generator.generateFont(parameter);
	}

	@Override
	public void render(float delta) {
		Main.getBatch().begin();
		for (int i = 0; i < enemies.length; i++) enemies[i].update();
		for (int i = 0; i < Senemies.length; i++) Senemies[i].update();
		Player.update();
		font96.draw(Main.getBatch(), Player.getHp() + "", 12,  Gdx.graphics.getHeight() - 12);
		font48.draw(Main.getBatch(), Player.getScore() + "", 12,  Gdx.graphics.getHeight() - 112);
		Main.getBatch().end();
	}

	@Override
	public void resize(int width, int height) {

	}

	@Override
	public void pause() {

	}

	@Override
	public void resume() {

	}

	@Override
	public void hide() {

	}

	@Override
	public void dispose() {

	}
}
