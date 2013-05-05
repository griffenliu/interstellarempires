package de.r2soft.space.client.settings;

/* 
 * Copyright (c) 2013 ***REMOVED***
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
 */

/**
 * Initializes the settings for the game. Also responsible for setting new
 * Settings.
 * 
 * @author: ***REMOVED***
 */
public class Settings {

	// Trying to be 16:9 here
	public static int OLD_WIDTH = 1080;
	public static int OLD_HEIGHT = 600;
	public static String SUPERTITLE = "Game Client";
	public static String VERSION_NUMBER = "Prototype 1.0.6";
	public static final String SCREENTITLE_SETTINGS = "SETTINGS";
	public static final String SCREENTITLE_HOME = "HOME";
	public static final String SCREENTITLE_SOLAR = "SOLARSYSTEM";

	/** Log sings */
	public final static String LOG_GLOBAL = "From Client";
	public final static String LOG_HEXMAP = "From HexMap";
	public final static String LOG_HEX_TILE = "From HexMap";
	public final static String LOG_SOLAR_MAP = "From System";
	public final static String LOG_MAP_OBJECT = "From Object";

	public static boolean skipIntro = true;

}
