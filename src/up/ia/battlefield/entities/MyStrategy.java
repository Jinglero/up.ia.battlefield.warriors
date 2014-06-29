package up.ia.battlefield.entities;



import java.util.Collections;
import java.util.List;

import ia.battle.camp.Action;
import ia.battle.camp.Attack;
import ia.battle.camp.BattleField;
import ia.battle.camp.FieldCell;
import ia.battle.camp.FieldCellType;
import ia.battle.camp.Skip;
import ia.battle.camp.Warrior;
import ia.exceptions.OutOfMapException;

public class MyStrategy {
	BattleField bf;
	Action a;
	Warrior w;
	boolean PowerUp = false;
	
	public MyStrategy(Warrior my){
		bf = BattleField.getInstance();
		w= my;
	}
	
	public Action getAction(long tick, int numberAction){
		List<FieldCell> nextPosition =null;
		/*
		 * Si el Enemigo esta cerca, Me acerco para atacarlo.
		 */
		if(bf.getEnemyData().getInRange()){
			System.out.println("Hasta la vista baby!");
			//Atacar sin importar el numero de acción.
			a = new Attack(bf.getEnemyData().getFieldCell());
			return a;
		}
		/*
		 * Si mi enemigo no esta cerca analizo los items especiales a mi al rededor.
		 */
		if(!PowerUp){
			switch(this.getPowerUpType()){
			case DEFENSE:
				PowerUp = false;
			break;
			case HEALTH:
				PowerUp = false;
			break;
			case SPEED:
				PowerUp = false;
			break;
			case RANGE:
				PowerUp = false;
			break;
			case STRENGTH:
				PowerUp = true;
			break;
			case NOTHING:
				if(bf.getSpecialItems().size()>0){
					//moveto:
					//nextPosition = bf.getSpecialItems();
				}
			break;
			}
			
		}
		/*
		 * Tengo que esquivar todos los items especiales de ahora en más,
		 * porque ya tengo el que quiero.
		 */
		
		MyMove m = new MyMove();
		if(nextPosition==null){
			nextPosition = bf.getAdjacentCells(w.getPosition());
		}
		Collections.shuffle(nextPosition);
		for(int i=0; i<nextPosition.size();i++){
			try {
				if(bf.getFieldCell(nextPosition.get(i).getX(), nextPosition.get(i).getY()).getFieldCellType() == FieldCellType.NORMAL){
					m.setDestino(nextPosition.get(i).getX(), nextPosition.get(i).getY());
					return m;
				}
			} catch (OutOfMapException e) {
				e.printStackTrace();
			}
			i++;
		}
		a = new Skip();
		return a;

	}
	
	private PowerUpType getPowerUpType(){
		if(w.getInitialDefense()<w.getDefense()){
			return PowerUpType.DEFENSE;
		}
		if(w.getInitialHealth()<w.getHealth()){
			return PowerUpType.HEALTH;
		}
		if(w.getInitialRange()<w.getRange()){
			return PowerUpType.RANGE;
		}
		if(w.getInitialSpeed()<w.getSpeed()){
			return PowerUpType.SPEED;
		}
		if(w.getInitialStrength()<w.getStrength()){
			return PowerUpType.STRENGTH;
		}
		return PowerUpType.NOTHING;
	
	
	}
	
}


/*
 * Arbol:
 if EnemicoCerca
 	if DecidoAtacar
 		Atacar
 	else
 		Skip
 ifelse 
 	case ItemSpecial
		 Vida: Agarrar o esquivar
		 Fuerza: Agarrar o esquivar
		 Velocidad: Agarrar o esquivar
	endcase
 else
	 Ir a algún lugar, que decidas, ej: la coordenada opuesta a la que llegaste.
 */