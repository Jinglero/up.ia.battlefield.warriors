package up.ia.battlefield.utils;

import ia.battle.camp.WarriorData;

public class Logger {
	public void addToLog(String s) {
		System.out.println(s);
	}
	public void printWarrior(WarriorData w){
		this.addToLog("Name: "+w.getName());
		this.addToLog("InRange? "+w.getInRange());
		this.addToLog("FieldCell: "+w.getFieldCell().toString());
		this.addToLog("Health: "+w.getHealth());
	}
}
