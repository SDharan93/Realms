package com.shanedharan.Realms.level.tile;

import com.shanedharan.Realms.graphics.Screen;
import com.shanedharan.Realms.graphics.Sprite;

public class VoidTile extends Tile {

	public VoidTile(Sprite sprite) {
		//super calls constructor of class it inherits. 
		super(sprite);
	}
	
	//renders to screen.
	public void render(int x, int y, Screen screen) {
		screen.renderTile(x << 4, y << 4, this);
	}

}
