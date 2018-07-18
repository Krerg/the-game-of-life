package grid

class Universe {

    companion object {

        public val EMPTY_CELL = Cell();

    }

    private val grid: Array<Array<Cell>>

    constructor(gridSize: GridSize) {
        grid = Array(gridSize.width, {i -> Array<Cell>(gridSize.height,{i -> Universe.EMPTY_CELL }) });


    }

}