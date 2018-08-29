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
        initialCells.forEach{ cell -> grid[cell.x][cell.y]=Cell(cell.x, cell.y);}
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
        val gridSnapshot = getGridSnapshot();
        var resultList = mutableListOf<CellVitality>()
        grid.forEachIndexed { index, arrayOfCells ->
            arrayOfCells.forEachIndexed { index2, cell ->
                val resultCell = vitalityStrategy.apply(cell, gridSnapshot)
                if(resultCell.cellVitalityState == CellVitalityState.BORN) {
                    grid[index][index2] = Cell(index, index2)
                    resultList.add(resultCell)
                } else if(resultCell.cellVitalityState == CellVitalityState.DEAD) {
                    grid[index][index2] = Universe.EMPTY_CELL
                    resultList.add(resultCell)
                }
            }
        }
        return List(0, {CellVitality(CellVitalityState.BORN)})
    }

}