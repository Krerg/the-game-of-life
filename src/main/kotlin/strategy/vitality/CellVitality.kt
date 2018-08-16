package strategy.vitality

import grid.Cell
import grid.Universe

class CellVitality {

    val cell: Cell;

    val cellVitalityState: CellVitalityState;

    constructor(cellVitalityState: CellVitalityState) : this(cellVitalityState, Universe.EMPTY_CELL)

    constructor(cellVitalityState: CellVitalityState, cell: Cell) {
        this.cell = cell;
        this.cellVitalityState = cellVitalityState;
    }

}