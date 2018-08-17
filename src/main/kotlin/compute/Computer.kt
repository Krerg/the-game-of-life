package compute

import connect.Observable
import connect.event.EndTurnEvent
import connect.event.GameEndEvent
import connect.event.GameStartEvent
import connect.listener.EventListener
import grid.GridSize
import grid.Universe
import strategy.cell.InitialCellArrangementStrategy

class Computer {

    var universe: Universe

    var observable: Observable

    constructor(observable: Observable) {
        universe = createUniverse(GameOfLife.GRID_SIZE, GameOfLife.INITIAL_CELL_ARRANGEMENT_STRATEGY)
        this.observable = observable
    }

    fun start() {
        observable.fireStartEvent(GameStartEvent(universe.getGridSnapshot()))
    }

    fun nextTurn() {
        val changes = universe.nextTurn(GameOfLife.VITALITY_STRATEGY)
        if(universe.isEmpty()) {
            endGame();
        } else {
            observable.fireEndTurnEvent(EndTurnEvent(changes))
        }
    }

    fun registerListener(eventListener: EventListener) {
        observable.registerListener(eventListener);
    }

    private fun endGame() {
        observable.fireGameEndEvent(GameEndEvent(universe.getGridSnapshot()))
    }

    private fun createUniverse(gridSize: GridSize, initialCellArrangementStrategy: InitialCellArrangementStrategy): Universe {
        val initialCells = initialCellArrangementStrategy.getInitialCells(gridSize.width, gridSize.height)
        return Universe(gridSize, initialCells)
    }

}