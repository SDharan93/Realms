package com.shanedharan.Realms.level;

import com.shanedharan.Realms.graphics.Screen;
import com.shanedharan.Realms.level.tile.Tile;

//super class for all tile classes.
public class Level {

	protected int width, height;
	protected int[] tiles;
	
	public Level(int width, int height) {
		this.width = width;
		this.height = height;
		tiles = new int[width * height];
		generateLevel();
	}
	
	public Level(String path) {
		loadLevel(path);
	}
	
	protected void generateLevel() {
		
	}
	
	private void loadLevel(String path) {
		
	}
	
	public void update() {
		
	}
	
	private void time() {
		
	}
	//render is same for random and loaded map.
	public void render(int xScroll, int yScroll, Screen screen) {
		screen.setOffset(xScroll, yScroll);
		//since tiles have 16 pixels and diving doesn't carry remainders, will move tile to tile.
		int x0 = xScroll >> 4; //divide by 16 for accounting for tiles not pixels.
		int x1 = (xScroll + screen.width) >> 4; 
		int y0 = yScroll >> 4;
		int y1 = (yScroll + screen.height) >> 4;
		
		for(int y = y0; y< y1; y++) {
			for(int x = x0; x < x1; x++) {
				//depending on the tile returned, it will render the tile to screen.
				getTile(x,y).render(x, y, screen);
			}
		}
	}
	
	public Tile getTile(int x, int y) {
		if (tiles[x+y * width] == 0) {
			return Tile.grass; 
		}
		//black tile for filler.
		return Tile.voidTile;
	}
}
