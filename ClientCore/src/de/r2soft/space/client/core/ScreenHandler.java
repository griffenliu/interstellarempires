/* #########################################################################
 * Copyright (c) 2013 Random Robot Softworks
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 * 
 ######################################################################### */
package de.r2soft.space.client.core;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;

import de.r2soft.space.client.screens.LoginScreen;
import de.r2soft.space.client.screens.TweenScreen;
import de.r2soft.space.client.settings.Resources;

/**
 * 
 * Called when the game is created. Handles all Screen activity for the game.
 * Further functionality might be added in the future
 * 
 * @author: ***REMOVED***
 */
public class ScreenHandler extends Game {

	private static ScreenHandler handler;
	private Music music;

	/**
	 * 
	 * Returns The Games screenhandler to start new screens from actors, groups and
	 * sub-classes. Accessed in a static way.
	 * 
	 * @return The main Screenhandler.
	 */
	public static ScreenHandler getInstance() {
		return handler;
	}

	@Override
	public void create() {
		handler = this;
		music = Gdx.audio.newMusic(Gdx.files.internal("assets/sounds/music/intro_music.mp3"));
		music.play();
		music.setLooping(true);
		music.setVolume(0.95f);

		if (!Resources.skipIntro)
			setScreen(new TweenScreen(this));
		else
			setScreen(new LoginScreen(this));
	}

	@Override
	public void dispose() {
		super.dispose();
		music.stop();
	}

	@Override
	public void render() {
		super.render();
	}

	@Override
	public void resize(int width, int height) {
		super.resize(width, height);
	}

	@Override
	public void pause() {
		super.pause();
		music.pause();
	}

	@Override
	public void resume() {
		super.resume();
		music.play();
	}

}
