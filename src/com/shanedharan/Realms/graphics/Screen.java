package com.shanedharan.Realms.graphics;

import java.util.Random;

import com.shanedharan.Realms.level.tile.Tile;

public class Screen {
	
	public int width, height;
	public int[] pixels;
	public final int MAP_SIZE = 64;
	public final int MAP_SIZE_MASK = MAP_SIZE - 1;
	
	public int xOffset, yOffset;
	
	public int[] tiles = new int[MAP_SIZE * MAP_SIZE];
	
	private Random random = new Random();
	
	public Screen(int width, int height){
		this.width = width;
		this.height = height;
		//remember 0 - 50,399
		pixels = new int[width * height];
		
		for(int i = 0; i < MAP_SIZE * MAP_SIZE; i++) {
			tiles[i] = random.nextInt(0xffffff);
		}
	}
	
	public void clean() {
		for(int i = 0; i < pixels.length; i++){
			pixels[i] = 0;
		}
	}
	
	//renders game to screen.
	public void renderTile(int xp, int yp, Tile tile) {
		xp -= xOffset;
		yp -= yOffset;
		for(int y = 0; y < tile.sprite.SIZE; y++) {
			//y absolute value
			int ya = y + yp;
			for(int x = 0; x < tile.sprite.SIZE; x++) {
				//X absolute value
				int xa = x + xp;
				if(xa < 0 || xa >= width ||  ya < 0 || ya >= width) break;
				//sets the tile within the sprite size on the screen. Currently it goes for 16 pixels.
				pixels[xa + ya * width] = tile.sprite.pixels[x+y*tile.sprite.SIZE];
			}
		}
	}
	
	public void setOffset(int xOffset, int yOffset) {
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}
}
