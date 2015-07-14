package com.shanedharan.Realms.graphics;

import java.util.Random;

public class Screen {

	private int width, height;
	public int[] pixels;
	
	public int[] tiles = new int[64 * 64];
	
	private Random random = new Random();
	
	public Screen(int width, int height){
		this.width = width;
		this.height = height;
		//remember 0 - 50,399
		pixels = new int[width * height];
		
		for(int i = 0; i < 64 * 64; i++) {
			tiles[i] = random.nextInt(0xffffff);
		}
	}
	
	public void clean() {
		for(int i = 0; i < pixels.length; i++){
			pixels[i] = 0;
		}
	}
	
	//Renders image pixel by pixel.
	public void render(){
		for(int y = 0; y < height; y++){	
			int yy = y;
			if(yy < 0 || yy >= height) break;
			for(int x = 0; x < width; x++){
				int xx = x;
				if(xx < 0 || xx >= width) break;
				int tileIndex = (xx >> 4) + (yy >> 4) * 64;
				pixels[x + y * width] = tiles[tileIndex];
			}
		}
	}
}
