package com.sa.statemachine.states;

import java.awt.Graphics;

import com.sa.screens.FlashScreen;
import com.sa.statemachine.StateName;
import com.sa.textures.Texture;

public class StartState extends BaseState {
	
	FlashScreen flash;
	
	public StartState(Texture tx) {
		super(StateName.START, tx);
		this.texture = tx;
	}

	@Override
	public void on() {
		flash = new FlashScreen(this.texture);
	}

	@Override
	public void off() {
		System.out.println("Start State is off");
	}

	@Override
	public void tick() {
		System.out.println("Start State is ticking");
	}

	@Override
	public void render(Graphics g) {
		flash.render(g);
	}

}
