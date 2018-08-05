package compute

import connect.Observable
import connect.event.GameStartEvent
import grid.GridSize
import grid.Universe
import strategy.cell.InitialCellArrangementStrategy

class Computer(val observable: Observable) {

    var universe: Universe? = null;

    fun start() {
        universe = createUniverse(GameOfLife.GRID_SIZE!!, GameOfLife.INITIAL_CELL_ARRANGEMENT_STRATEGY!!)
        observable.fireStartEvent(GameStartEvent());
    }

    fun nextTurn() {
        universe.
    }

    private fun createUniverse(gridSize: GridSize, initialCellArrangementStrategy: InitialCellArrangementStrategy): Universe {
        val initialCells = initialCellArrangementStrategy.getInitialCells(gridSize.width, gridSize.height);
        return Universe(gridSize, initialCells);
    }

}