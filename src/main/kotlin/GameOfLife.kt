import compute.Computer
import grid.GridSize
import grid.Universe
import strategy.cell.InitialCellArrangementStrategy
import strategy.cell.impl.RandomInitialCellArrangementStrategy
import strategy.vitality.VitalityStrategy
import strategy.vitality.impl.B3S23

/**
 * @author Aleksandr Mylnikov
 */
class GameOfLife  {

    private val computer: Computer;

    companion object {

        val DEFAULT_GRID_SIZE = GridSize(20,20)

        val DEFAULT_VITALITY_STRATEGY = B3S23()

        val DEFAULT_INITIAL_CELL_ARRANGEMENT_STRATEGY = RandomInitialCellArrangementStrategy();
    }

    constructor(gridSize: GridSize = DEFAULT_GRID_SIZE, vitalityStrategy: VitalityStrategy = DEFAULT_VITALITY_STRATEGY,
                initialCellArrangementStrategy: InitialCellArrangementStrategy = DEFAULT_INITIAL_CELL_ARRANGEMENT_STRATEGY) {
        computer = Computer(createUniverse(gridSize, initialCellArrangementStrategy), vitalityStrategy);
    }

    private fun createUniverse(gridSize: GridSize, initialCellArrangementStrategy: InitialCellArrangementStrategy): Universe {
        val initialCells = initialCellArrangementStrategy.getInitialCells(gridSize.width, gridSize.height);
        return Universe(gridSize, initialCells);
    }

    fun start() {

    }

}