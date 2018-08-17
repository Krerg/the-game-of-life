package strategy.vitality.impl

import grid.Cell
import grid.GridSnapshot
import grid.Universe
import strategy.vitality.CellVitality
import strategy.vitality.CellVitalityState
import strategy.vitality.VitalityStrategy
import strategy.vitality.util.VitalityUtils

class B3S23: VitalityStrategy {

    override fun apply(cell: Cell, gridSnapshot: GridSnapshot): CellVitality {
        var list = VitalityUtils.getNeighbours(cell, gridSnapshot)
        if(cell == Universe.EMPTY_CELL) {
            if(list.size >= 3) {
                return CellVitality(CellVitalityState.BORN)
            } else {
                return CellVitality(CellVitalityState.SAME)
            }
        } else {
            if(list.size >= 2 && list.size < 4) {
                return CellVitality(CellVitalityState.SAME)
            } else {
                return CellVitality(CellVitalityState.DEAD)
            }
        }
    }

}