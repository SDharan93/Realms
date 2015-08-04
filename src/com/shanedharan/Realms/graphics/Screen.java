package com.shanedharan.Realms.graphics;

import java.util.Random;

import com.shanedharan.Realms.entity.mob.Player;
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
				//to be safe, we will render one more tile to the right, left and bottom to eliminate black border.
				if(xa < -tile.sprite.SIZE || xa >= width ||  ya < 0 || ya >= height) break;
				//removes black border on the x.
				if(xa < 0) xa = 0;
				//sets the tile within the sprite size on the screen. Currently it goes for 16 pixels.
				pixels[xa + ya * width] = tile.sprite.pixels[x+y*tile.sprite.SIZE];
			}
		}
	}
	
	public void renderPlayer(int xp, int yp, Sprite sprite) {
		xp -= xOffset;
		yp -= yOffset;
		for(int y = 0; y < 32; y++) {
			//y absolute value
			int ya = y + yp;
			for(int x = 0; x < 32; x++) {
				//X absolute value
				int xa = x + xp;
				//to be safe, we will render one more tile to the right, left and bottom to eliminate black border.
				if(xa < -32 || xa >= width ||  ya < 0 || ya >= height) break;
				//removes black border on the x.
				if(xa < 0) xa = 0;
				int col = sprite.pixels[x + y * 32];
				//sets the tile within the sprite size on the screen. Currently it goes for 16 pixels.
				if(col != 0xFFFF00FF) pixels[xa + ya * width] = col;
			}
		}
		
	}
	
	public void setOffset(int xOffset, int yOffset) {
		this.xOffset = xOffset;
		this.yOffset = yOffset;
	}
}
