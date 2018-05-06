package com.evon.slash;

import com.badlogic.gdx.Screen;

public class Play implements Screen {


	@Override
	public void show() {
		Player.create();
	}

	@Override
	public void render(float delta) {
		Main.getBatch().begin();
		Player.update();
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
