package up.ia.battlefield.entities;

import ia.battle.camp.Action;
import ia.battle.camp.Warrior;
import ia.exceptions.RuleException;


public class MyWarrior extends Warrior{
	MyStrategy strategy;
	public MyWarrior(String name, int health, int defense, int strength, int speed, int range) throws RuleException {
		
		super(name, health, defense, strength, speed, range);
		System.out.print(this.toString());
		strategy = new MyStrategy(this);
	}

	@Override
	public Action playTurn(long tick, int actionNumber) {
		
		
		return strategy.getAction(tick, actionNumber);
		
		/*
		boolean direccionHorizontal = false;
		if (actionNumber == 1) {

			MyMove m = new MyMove();

			int x = getPosition().getX(), y = getPosition().getY();

			if (direccionHorizontal)
				x++;
			else
				x--;
			
			try {
				System.out.println("Width: "+ConfigurationManager.getInstance().getMapWidth()+" - x:" +x);
				
				if (x < ConfigurationManager.getInstance().getMapWidth() && x > 0 
						&& BattleField.getInstance().getFieldCell(x, y)
								.getFieldCellType() != FieldCellType.BLOCKED )
					
					m.setDestino(x, y);
				else {
					direccionHorizontal = !direccionHorizontal;
					m.setDestino(--x, y);
					System.out.println("X:" + x + " - Y" + y);
				}

			} catch (OutOfMapException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return m;
		}

		return null;
		*/
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