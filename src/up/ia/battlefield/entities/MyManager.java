package up.ia.battlefield.entities;

import ia.battle.camp.Warrior;
import ia.battle.camp.WarriorManager;
import ia.exceptions.RuleException;

public class MyManager extends WarriorManager {
	Warrior warrior=null;
	@Override
	public Warrior getNextWarrior() throws RuleException {
<<<<<<< HEAD
			return new MyWarrior("Pedro", 60, 10, 10, 10, 10);
=======
			return new MyWarrior("Pedro", 20, 15, 30, 5, 30);
			// health, defense, streght, speed, range
			

	}
	@Override
	public String getName() {
		
		return "Pedro";
>>>>>>> FETCH_HEAD
	}

}
