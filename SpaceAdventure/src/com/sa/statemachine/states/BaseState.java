package com.sa.statemachine.states;

import java.awt.Graphics;

import com.sa.statemachine.StateName;
import com.sa.textures.Texture;

public class BaseState {

	protected StateName stateName;
	protected Texture texture;

	public BaseState() {

	}

	public BaseState(StateName stName, Texture tx) {
		this.stateName = stName;
		this.texture = tx;
	}

	public StateName getStateName() {
		return stateName;
	}

	public void on() {
		System.out.println("error");
	}

	public void off() {
		System.out.println("error");
	}

	public void tick() {

	}

	public void render(Graphics g) {

	}
}
