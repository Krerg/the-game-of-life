package strategy.vitality.impl

import grid.Cell
import grid.GridSnapshot
import strategy.vitality.CellVitality
import strategy.vitality.CellVitalityState
import strategy.vitality.VitalityStrategy

class B3S23: VitalityStrategy {

    override fun apply(cell: Cell, gridSnapshot: GridSnapshot): CellVitality {
        //TODO implement
        return CellVitality(CellVitalityState.BORN);
    }

}