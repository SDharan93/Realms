package com.shanedharan.Realms.level.tile.spawn_level;

import com.shanedharan.Realms.graphics.Screen;
import com.shanedharan.Realms.graphics.Sprite;
import com.shanedharan.Realms.level.tile.Tile;

public class SpawnWallTile extends Tile {
	public SpawnWallTile(Sprite sprite) {
		super(sprite);
	}
	
	public void render(int x, int y, Screen screen) {
		screen.renderTile(x << 4, y << 4, this);
	}
	
	public boolean solid() {
		return true;
	}
}
