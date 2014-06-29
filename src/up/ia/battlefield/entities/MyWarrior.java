package up.ia.battlefield.entities;


import java.util.ArrayList;
import java.util.List;

import up.ia.battlefield.utils.Logger;
import ia.battle.camp.Action;
<<<<<<< HEAD
import ia.battle.camp.BattleField;
import ia.battle.camp.ConfigurationManager;
import ia.battle.camp.FieldCell;
import ia.battle.camp.FieldCellType;
import ia.battle.camp.Skip;
=======
>>>>>>> FETCH_HEAD
import ia.battle.camp.Warrior;
import ia.exceptions.RuleException;


public class MyWarrior extends Warrior{
<<<<<<< HEAD
	private FieldCell actual;
	private Logger log;
	private List<FieldCell> listAdj;
	/*
	 * MyWarrior
	 * Inicializa mi Warrior.
	 */
	public MyWarrior(String name, int health, int defense, int strength,
		int speed, int range) throws RuleException {
		
		super(name, health, defense, strength, speed, range);
		
		log = new Logger();
		System.out.print(this.toString());
		
=======
	MyStrategy strategy;
	public MyWarrior(String name, int health, int defense, int strength, int speed, int range) throws RuleException {
		
		super(name, health, defense, strength, speed, range);
		strategy = new MyStrategy(this);
>>>>>>> FETCH_HEAD
	}

	@Override
	public Action playTurn(long tick, int actionNumber) {
<<<<<<< HEAD
		boolean direccionHorizontal = true;
		Action r;
		log.printWarrior(BattleField.getInstance().getEnemyData());
		actual = getPosition();
=======
		
		
		return strategy.getAction(tick, actionNumber);
		
		/*
		boolean direccionHorizontal = false;
>>>>>>> FETCH_HEAD
		if (actionNumber == 1) {
			listAdj = new ArrayList<FieldCell>();
			listAdj = BattleField.getInstance().getAdjacentCells(actual);
			log.addToLog("1) Acci—n-"+BattleField.getInstance().getEnemyData().getWarriorNumber());
			log.addToLog(listAdj.toString());
			r= new Skip();
		}else if(actionNumber == 2){
			log.addToLog("2) Acci—n");
			MyMove m = new MyMove();

			int x = getPosition().getX(), y = getPosition().getY();

			if (direccionHorizontal)
				x++;
			else
				x--;
			
			try {
				if (x < ConfigurationManager.getInstance().getMapWidth() && x > 0 
						&& BattleField.getInstance().getFieldCell(x, y)
								.getFieldCellType() != FieldCellType.BLOCKED ){
					m.setDestino(x, y);
				}else {
					direccionHorizontal = !direccionHorizontal;
					y++;
					m.setDestino(--x, y);
				}

			} catch (OutOfMapException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return m;
		}else{
			log.addToLog("3) Acci—n");
			r= new Skip();
		}
<<<<<<< HEAD
		
		return r;
=======

		return null;
		*/
>>>>>>> FETCH_HEAD
	}
	
	public String toString(){
		String s;
		s = super.getName()+"\n";
		s+="- H:("+super.getHealth()+") ";
		s+="D:("+super.getDefense()+") ";
		s+="St:("+super.getStrength()+") ";
		s+="R:("+super.getRange()+") ";
		s+=" - Speed: "+super.getSpeed()+"\n";
		//pincha
		//s+="- X:"+super.getPosition().toString()+"\n";
		
		return s;
				
	}
}