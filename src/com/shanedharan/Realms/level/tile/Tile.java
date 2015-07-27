package com.shanedharan.Realms.level.tile;

import com.shanedharan.Realms.graphics.Screen;
import com.shanedharan.Realms.graphics.Sprite;

//super class for all tiles.
public class Tile {
	
	public int x,y;
	public Sprite sprite;
	
	public static Tile grass = new GrassTile(Sprite.grass);
	public static Tile voidTile = new VoidTile(Sprite.voidSprite);
	
	public Tile(Sprite sprite) {
		this.sprite = sprite;
	}
	
	public void render(int x, int y, Screen screen) {
		
	}
	//if the object is passable.
	public boolean solid() {
		return false;
	}

}
