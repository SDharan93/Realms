package com.shanedharan.Realms.entity.mob;

import com.shanedharan.Realms.graphics.Screen;
import com.shanedharan.Realms.graphics.Sprite;
import com.shanedharan.Realms.input.Keyboard;

public class Player extends Mob{
	
	private Keyboard input;
	
	
	public Player(Keyboard input) {
		this.input = input;
	}
	
	public Player(int x, int y, Keyboard input) {
		this.x = x;
		this.y = y;
		this.input = input;
	}
	
	public void update() {
		int xa = 0, ya = 0;
		if(input.up) ya--;
		if(input.down) ya++;
		if(input.left) xa--;
		if(input.right) xa++;
		
		if(xa != 0 || ya != 0) move(xa,ya);
	}
	
	public void render(Screen screen) {
		//effects where the player is.
		screen.renderPlayer(x - 16, y - 16, Sprite.player);
	}
}
