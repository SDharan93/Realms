package com.shanedharan.Realms.level.tile;

import com.shanedharan.Realms.graphics.Screen;
import com.shanedharan.Realms.graphics.Sprite;
import com.shanedharan.Realms.level.tile.spawn_level.SpawnFloorTile;
import com.shanedharan.Realms.level.tile.spawn_level.SpawnGrassTile;
import com.shanedharan.Realms.level.tile.spawn_level.SpawnHedgeTile;
import com.shanedharan.Realms.level.tile.spawn_level.SpawnWallTile;
import com.shanedharan.Realms.level.tile.spawn_level.SpawnWaterTile;

//super class for all tiles.
public class Tile {
	
	public int x,y;
	public Sprite sprite;
	
	public static Tile grass = new GrassTile(Sprite.grass);
	public static Tile flower = new FlowerTile(Sprite.flower);
	public static Tile rock = new RockTile(Sprite.rock);
	public static Tile voidTile = new VoidTile(Sprite.voidSprite);
	
	//spawn tiles
	public static Tile spawn_grass = new SpawnGrassTile(Sprite.spawn_grass);
	public static Tile spawn_hedge = new SpawnHedgeTile(Sprite.spawn_hedge);
	public static Tile spawn_water = new SpawnWaterTile(Sprite.spawn_water);
	public static Tile spawn_wall = new SpawnWallTile(Sprite.spawn_wall);
	public static Tile spawn_wall2 = new SpawnWallTile(Sprite.spawn_wall2);
	public static Tile spawn_floor = new SpawnFloorTile(Sprite.spawn_floor);
	
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
