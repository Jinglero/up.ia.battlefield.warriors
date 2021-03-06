package up.ia.battlefield.entities;


import java.util.ArrayList;
import ia.battle.camp.BattleField;
import ia.battle.camp.FieldCell;
import ia.battle.camp.Move;
import ia.exceptions.OutOfMapException;


public class MyMove extends Move {
	
	private FieldCell destino;
	
	public FieldCell getDestino() {
		return destino;
	}

	public void setDestino(int x, int y) {
		try {
			destino = BattleField.getInstance().getFieldCell(x, y);
			destino.getFieldCellType();
			if(BattleField.getInstance().getEnemyData().getInRange()){
				System.out.print("Esta en rango!");
			}
		} catch (OutOfMapException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}

	@Override
	public ArrayList<FieldCell> move() {

		ArrayList<FieldCell> path = new ArrayList<FieldCell>();
		
		path.add(destino);
		
		return path;
	}


}
