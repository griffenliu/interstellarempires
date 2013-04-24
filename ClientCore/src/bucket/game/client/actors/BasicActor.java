package bucket.game.client.actors;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer.ShapeType;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.Touchable;

/* 
 * Copyright (c) 2012 ***REMOVED***
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
 * 
 * @author: ***REMOVED***
 */
public class BasicActor extends Actor {
	TextureRegion region;

	private ShapeRenderer renderer;

	public void draw(SpriteBatch batch, float parentAlpha) {
		batch.end();

		renderer.setProjectionMatrix(batch.getProjectionMatrix());
		renderer.setTransformMatrix(batch.getTransformMatrix());
		renderer.translate(getX(), getY(), 0);

		renderer.begin(ShapeType.Rectangle);
		renderer.rect(0, 0, getWidth(), getHeight());
		renderer.end();

		batch.begin();
	}

	public BasicActor() {
		region = new TextureRegion();
	}

	public Actor hit(float x, float y, boolean touchable) {
		if (touchable && getTouchable() != Touchable.enabled)
			return null;
		return x >= 0 && x < getWidth() && y >= 0 && y < getHeight() ? this : null;
	}

	// public void draw(SpriteBatch batch, float parentAlpha) {
	// Color color = getColor();
	// batch.setColor(color.r, color.g, color.b, color.a * parentAlpha);
	// batch.draw(region, getX(), getY(), getOriginX(), getOriginY(), getWidth(), getHeight(), getScaleX(), getScaleY(),
	// getRotation());
	// }

}
