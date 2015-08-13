package com.sa.statemachine.states;

import java.awt.Graphics;

import com.sa.statemachine.StateName;

public class BaseState {

	protected StateName stateName;

	public BaseState() {

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
	
	public void tick(){
		
	}
	public void render(Graphics g){
		
	}
}
