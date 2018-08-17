package grid

import strategy.cell.InitialCell
import strategy.vitality.CellVitality
import strategy.vitality.CellVitalityState
import java.util.function.Consumer
import strategy.vitality.VitalityStrategy

class Universe {

    companion object {

        val EMPTY_CELL = Cell(-1,-1);

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

    fun forEachCell(func: Consumer<Cell>) {
        grid.forEach { it.forEach { func.accept(it) } }
    }

    fun getGridSnapshot(): GridSnapshot {
        prepareSnapshot()
        return GridSnapshot(gridSnapshot)
    }

    private fun prepareSnapshot() {
        grid.forEachIndexed { index1 ,array -> array.forEachIndexed { index2, cell -> gridSnapshot[index1][index2] = cell } }
    }

    fun isEmpty(): Boolean {
        return false
    }

    fun nextTurn(vitalityStrategy: VitalityStrategy): List<CellVitality> {
        return List(0, {CellVitality(CellVitalityState.BORN)})
    }

}