package com.sa.statemachine.states;

import java.awt.Graphics;

public class StartState extends BaseState {

	@Override
	public void on() {
		System.out.println("Start State is on");
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
		System.out.println("Start State is rendering");
	}

}
