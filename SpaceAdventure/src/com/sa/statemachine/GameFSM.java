package com.sa.statemachine;

import java.awt.Graphics;
import java.util.HashMap;
import java.util.Map;

import com.sa.resources.ResourceManager;
import com.sa.statemachine.states.BaseState;
import com.sa.statemachine.states.StartState;
import com.sa.textures.Texture;

public class GameFSM {

	private Texture _tx;
	private ResourceManager _rm;
	private BaseState currentState;
	private Map<StateName, BaseState> stateMap = new HashMap<StateName, BaseState>();

	public void tick() {
		currentState.tick();
	}

	public void render(Graphics g) {
		currentState.render(g);
	}

	public void initialize() {
		_rm = new ResourceManager();
		_rm.initialize();
		_tx = new Texture(_rm);
		
		StartState st = new StartState(_tx);
		stateMap.put(StateName.START, st);
		currentState = st;
		currentState.on();
	}

}
