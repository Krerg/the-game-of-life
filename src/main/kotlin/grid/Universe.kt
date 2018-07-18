package grid

import strategy.cell.InitialCell

class Universe {

    companion object {

        public val EMPTY_CELL = Cell();

    }

    private val grid: Array<Array<Cell>>

    constructor(gridSize: GridSize, initialCells: List<InitialCell>) {
        grid = Array(gridSize.width, {i -> Array<Cell>(gridSize.height,{i -> Universe.EMPTY_CELL }) });
        createInitialCells(initialCells);
    }

    private fun createInitialCells(initialCells: List<InitialCell>) {

    }

}