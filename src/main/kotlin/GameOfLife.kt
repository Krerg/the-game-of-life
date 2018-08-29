import compute.Computer
import connect.Observable
import connect.listener.EventListener
import grid.GridSize
import grid.GridSnapshot
import strategy.cell.InitialCellArrangementStrategy
import strategy.cell.impl.RandomInitialCellArrangementStrategy
import strategy.vitality.VitalityStrategy
import strategy.vitality.impl.B3S23

/**
 * @author Aleksandr Mylnikov
 */
class GameOfLife  {

    private val computer: Computer = Computer(Observable());

    private val controller: GameOfLifeController;

    companion object {

        val DEFAULT_GRID_SIZE = GridSize(20,20)

        val DEFAULT_VITALITY_STRATEGY = B3S23()

        val DEFAULT_INITIAL_CELL_ARRANGEMENT_STRATEGY = RandomInitialCellArrangementStrategy()

        var GRID_SIZE: GridSize = DEFAULT_GRID_SIZE;

        var VITALITY_STRATEGY: VitalityStrategy = DEFAULT_VITALITY_STRATEGY

        var INITIAL_CELL_ARRANGEMENT_STRATEGY: InitialCellArrangementStrategy = DEFAULT_INITIAL_CELL_ARRANGEMENT_STRATEGY

    }

    constructor(gridSize: GridSize = DEFAULT_GRID_SIZE, vitalityStrategy: VitalityStrategy = DEFAULT_VITALITY_STRATEGY,
                initialCellArrangementStrategy: InitialCellArrangementStrategy = DEFAULT_INITIAL_CELL_ARRANGEMENT_STRATEGY) {
        GRID_SIZE = gridSize
        INITIAL_CELL_ARRANGEMENT_STRATEGY = initialCellArrangementStrategy
        VITALITY_STRATEGY = vitalityStrategy
        controller = GameOfLifeController(computer);
    }

    fun getController(): GameOfLifeController {
        return controller;
    }

    class GameOfLifeController(private val computer: Computer) {

        fun start() {
            computer.start()
        }

        fun nextTurn() {
            computer.nextTurn()
        }

        fun registerListener(eventListener: EventListener) {
            computer.registerListener(eventListener)
        }

        fun getSnapshot(): GridSnapshot {
            return computer.getSnapshot();
        }

    }

}

