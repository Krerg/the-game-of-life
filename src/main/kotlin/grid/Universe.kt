package grid

import strategy.cell.InitialCell
import strategy.vitality.VitalityStrategy

class Universe {

    companion object {

        public val EMPTY_CELL = Cell();

    }

    private val grid: Array<Array<Cell>>

    private val gridSnapshot: Array<Array<Cell>>

    constructor(gridSize: GridSize, initialCells: List<InitialCell>) {
        grid = Array(gridSize.width) { Array<Cell>(gridSize.height) { Universe.EMPTY_CELL } };
        gridSnapshot = Array(gridSize.width) { Array<Cell>(gridSize.height) { Universe.EMPTY_CELL } };
        createInitialCells(initialCells);
    }

    private fun createInitialCells(initialCells: List<InitialCell>) {
        val initialCells = GameOfLife.INITIAL_CELL_ARRANGEMENT_STRATEGY?.getInitialCells(
                GameOfLife.GRID_SIZE!!.width, GameOfLife.GRID_SIZE!!.height);
    }

    fun getGridSnapshot(): GridSnapshot {
        return GridSnapshot(gridSnapshot);
    }

    fun isEmpty(): Boolean {
        return false
    }

    fun nextTurn(vitalityStrategy: VitalityStrategy) {

    }

}