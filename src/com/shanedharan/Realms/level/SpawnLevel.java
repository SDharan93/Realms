package com.shanedharan.Realms.level;

import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

import com.shanedharan.Realms.level.tile.Tile;

public class SpawnLevel extends Level{

	public SpawnLevel(String path) {
		super(path);
	}
	
	protected void loadLevel(String path) {
		try {
			BufferedImage image = ImageIO.read(SpawnLevel.class.getResource(path));
			int w = image.getWidth();
			width = w;
			int h = image.getHeight();
			height = h;
			tiles = new int[w * h];
			image.getRGB(0, 0, w, h, tiles, 0, w);
		}
		catch(IOException e) {
			e.printStackTrace();
			System.out.println("Exception! Could not load Level file!");
		}
	}
	
	// Grass = 0xFF00FF00
	// FLower = 0xFFFFFF00
	//Rock = 0xFF7F7F00
	protected void generateLevel() {
	}
}
