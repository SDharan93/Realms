package com.shanedharan.Realms.level;

import java.util.Random;

public class RandomLevel extends Level{

	private static final Random random = new Random();
	
	public RandomLevel(int width, int height) {
		//super calls constructor of class it inherits. 
		super(width, height);
	}
	
	protected void generateLevel() {
		for (int y = 0; y < height; y++) {
			for (int x = 0; x < width; x++) {
				//fills pixel array with 0-3, representing the tiles.
				tiles[x+y*width] = random.nextInt(4);
			}
		}
	}

}
