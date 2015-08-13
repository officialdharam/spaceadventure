package com.sa.statemachine;

import java.awt.Graphics;
import java.util.HashMap;
import java.util.Map;

import com.sa.statemachine.states.BaseState;
import com.sa.statemachine.states.StartState;

public class GameFSM {

	private BaseState currentState;
	private Map<StateName, BaseState> stateMap = new HashMap<StateName, BaseState>();

	public void tick() {
		currentState.tick();
	}

	public void render(Graphics g) {
		currentState.render(g);
	}

	public void initialize() {
		StartState st = new StartState();
		stateMap.put(StateName.START, new StartState());
		currentState = st;
		currentState.on();
	}

}
