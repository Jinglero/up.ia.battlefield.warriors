package up.ia.battlefield.entities;



import ia.battle.camp.Action;
import ia.battle.camp.Attack;
import ia.battle.camp.BattleField;
import ia.battle.camp.Skip;
import ia.battle.camp.Warrior;

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
		/*
		 * Si el Enemigo esta cerca, Me acerco para atacarlo.
		 */
		if(bf.getEnemyData().getInRange()){
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
			default:
				if(bf.getSpecialItems().size()>0){
					//moveto:
					bf.getSpecialItems().get(0);
				}
			break;
			}
			
		}else{
			/*
			 * Tengo que esquivar todos los items especiales de ahora en más,
			 * porque ya tengo el que quiero.
			 */
			MyMove m = new MyMove();
			
			return m;
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
		return null;
	
	
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