package strategy.vitality

import grid.Cell
import grid.GridSnapshot

interface VitalityStrategy {

    fun apply(cell: Cell, gridSnapshot: GridSnapshot): CellVitality

}