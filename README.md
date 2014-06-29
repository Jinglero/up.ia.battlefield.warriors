up.ia.battlefield.warriors
==========================

Warriors para Battlefield - Inteligencia Artificial -  Universidad de Palermo
Implementado para: https://code.google.com/p/battlefield-ia/

# Explicación de implementación
Para el desarrollo decidi una estrategia simple, que de prioridad al ataque al enemigo.
Con la elección de las siguientes características del warrior:
- Health: 20
- Defense: 15
- strength: 30
- Speed: 5
- Range: 30

Generare Warrior de características ofensivas, con un amplio rango de ataque y mucha fuerza para poder golpear en rafaga en cuanto el enemigo entre en el rango.

Además como estrategia de movimiento, me moveré hacia el centro de la pantalla para poder utilizar al 100% mi rango y encontrar rápidamente a mi enemigo. Para esto genero un cálculo muy simple de mi camino, siempre priorizando el movimiento en diagonal, si me encuentro con algún obstáculo me moveré aleatoriamente a algún casillero aleatorio. 
Como mi estrategia esta enfocada en priorizar las características de ataque (rango y fuerza), el movimiento siempre será de a 1 casillero.
# JavaDoc
## up.ia.battlefield.entities
- MyManager
- MyWarrior
- MyMove
- MyStrategy
### MyManager
Administra mi Warrior

**Constructor Detail**
_public MyManager()_

**Métodos**
_getNextWarrior_
Inicializa el Warrior
- Public
- Return: _ia.battle.camp.Warrior_
- Throws: ia.exceptions.RuleException

_getName_
Define el nombre solicitado por el BattleField
- Public
- Return: _java.lang.String_
- Throws: _ia.exceptions.RuleException_

**Field Detail**
- warrior: ia.battle.camp.Warrior warrior
- log: Logger log

### MyWarrior
Es el Warrior en si, quien tiene las características y los turnos a jugar.

**Constructor Details**
_public MyWarrior(java.lang.String name,_
         _int health,_
         _int defense,_
         _int strength,_
         _int speed,_
         _int range)_
          _throws ia.exceptions.RuleException_

- Throws: _ia.exceptions.RuleException_

**Métodos**
_playTurn_
Ejecuta el turno del Warrior
- Public
- Return: _ia.battle.camp.Action_

_toString_
- Public
- Return: _java.lang.String_

### MyMove
Resuelve el movimiento en la plataforma BattelField.

**Constructor Detail**
_public MyMove()_

**Metodos**
_getDestino_
Getter de la variable _destino_
- Public 
- Return: ia.battle.camp.FieldCell

_setDestino_
Pasa al Battelfield el destino que se desea
- Public 
- Return: void 
- Parameters:
-- x - Coordenada X del destino
-- y - Coordenada Y del destino
_move_
- Public
- Return: _java.util.ArrayList<ia.battle.camp.FieldCell>_

### MyStrategy
Decide la acción que tomará el Warrior según la situación del entorno
**Constructor Detail**
_public MyStrategy(ia.battle.camp.Warrior my)_

- Inicializa el entorno en el que se tomará la decisión de acción
- Parameters:
-- _my_ - Warrior que necesita de la decisión
**Métodos**
_getAction_
Trabaja el ambiente para tomar una decisión, en que acción va a realizar el warrior.
- Parameters:
-- _tick_ - reloj del battlefield
-- _numberAction_ - Número de acción.
- Returns: Retorna la acción a realizar por el Warrior: Move, Attack o Skip.
- Throws: _ia.exceptions.OutOfMapException_

_getDestino_
Defino el destino que quiero, si mi destino esta bloqueado busco una alternativa.
-  Return _FieldCell_, destino al que quiero llegar caminando.
-  Throws _OutOfMapException_

	_getNextStep_
Determina el próximo paso dependiendo del destino que se elija.
- Public
- Parameters
-- _x_ - Coordenada X en donde esta el Warrior
-- _y_ - Coordenada Y en donde esta el Warrior
- Return: _FieldCell_, al que debe moverse el _Warrior_
- Throws: _OutOfMapException_


_Getters & Setters_
- _getdX_
- _setdX_
- _getdY_
- _setdY_

**Field Detail**
- ia.battle.camp.Action	_a_: Acción a devolver
- ia.battle.camp.BattleField _bf_: Contexto en el que se mueve el _warrior_
- ia.battle.camp.FieldCell _destino_: Destino definido luego de la evaluación
- int _dX_: Coordenada en X definida para el destino
- int _dY_: Coordenada en Y definida para el destino
- Logger	_log_: Variable para aplicar los logs
- ia.battle.camp.Warrior _w_: Mi warrior

## up.ia.battlefield.util
- Logger

### Logger
Logger, sirve para realizar la presentación de información necesaria para el desarrollo

**Metodos**
_addToLog_
Agrega al log una linea de texto
- Parameters:
-- _s_ - String para imprimir, si se setea la variable como verdadera
_isDebuger_
public boolean isDebuger()
_setDebuger_
public void setDebuger(boolean debuger)




# Diagrama de Clases