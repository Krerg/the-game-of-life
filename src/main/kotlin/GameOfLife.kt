import compute.Computer
import connect.Observable
import grid.GridSize
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

        var GRID_SIZE: GridSize? = null;

        var INITIAL_CELL_ARRANGEMENT_STRATEGY: InitialCellArrangementStrategy? = null;

    }

    constructor(gridSize: GridSize = DEFAULT_GRID_SIZE, vitalityStrategy: VitalityStrategy = DEFAULT_VITALITY_STRATEGY,
                initialCellArrangementStrategy: InitialCellArrangementStrategy = DEFAULT_INITIAL_CELL_ARRANGEMENT_STRATEGY) {
        computer = Computer(Observable());
        GRID_SIZE = gridSize;
        INITIAL_CELL_ARRANGEMENT_STRATEGY = initialCellArrangementStrategy;

    }
    fun start() {

    }

}