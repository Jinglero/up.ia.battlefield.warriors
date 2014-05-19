package up.ia.battlefield.entities;

import ia.battle.camp.Action;
import ia.battle.camp.BattleField;
import ia.battle.camp.ConfigurationManager;
import ia.battle.camp.FieldCellType;
import ia.battle.camp.Warrior;
import ia.exceptions.OutOfMapException;
import ia.exceptions.RuleException;


public class MyWarrior extends Warrior{
	private boolean direccionHorizontal = true;

	public MyWarrior(String name, int health, int defense, int strength,
			int speed, int range) throws RuleException {
		
		super(name, health, defense, strength, speed, range);
		System.out.print(this.toString());

	}

	@Override
	public Action playTurn(long tick, int actionNumber) {

		if (actionNumber == 1) {

			MyMove m = new MyMove();

			int x = getPosition().getX(), y = getPosition().getY();

			if (direccionHorizontal)
				x++;
			else
				x--;
			
			try {
				if (x < ConfigurationManager.getInstance().getMapWidth() && x > 0 
						&& BattleField.getInstance().getFieldCell(x, y)
								.getFieldCellType() != FieldCellType.BLOCKED )
					
					m.setDestino(x, y);
				else {
					direccionHorizontal = !direccionHorizontal;
					m.setDestino(--x, y);
					System.out.println(x + "  " + y);
				}

			} catch (OutOfMapException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return m;
		}

		return null;
	}
	
	public String toString(){
		String s;
		s = super.getName()+"\n";
		s+="- H:("+super.getHealth()+") ";
		s+="D:("+super.getDefense()+") ";
		s+="St:("+super.getStrength()+") ";
		s+="R:("+super.getRange()+") ";
		s+=" - Speed: "+super.getSpeed()+"\n";
		s+="- X:"+super.getPosition().toString()+"\n";
		
		return s;
				
	}
}