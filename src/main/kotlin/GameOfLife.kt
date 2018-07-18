import compute.Computer
import grid.GridSize
import strategy.cell.InitialCellArrangementStrategy
import strategy.cell.impl.RandomInitialCellArrangementStrategy
import strategy.vitality.VitalityStrategy
import strategy.vitality.impl.B3S23

class GameOfLife  {

    private val computer: Computer;

    companion object {

        val DEFAULT_GRID_SIZE = GridSize(50,50)

        val DEFAULT_VITALITY_STRATEGY = B3S23()

        val DEFAULT_INITIAL_CELL_ARRANGEMENT_STRATEGY = RandomInitialCellArrangementStrategy();
    }

    constructor(gridSize: GridSize = DEFAULT_GRID_SIZE, vitalityStrategy: VitalityStrategy = DEFAULT_VITALITY_STRATEGY,
                initialCellArrangementStrategy: InitialCellArrangementStrategy = DEFAULT_INITIAL_CELL_ARRANGEMENT_STRATEGY) {
        computer = Computer()
    }

    fun start() {

    }

}