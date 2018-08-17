package strategy.vitality.util

import grid.Cell
import grid.GridSnapshot
import grid.Universe

class VitalityUtils {
    companion object {

        fun getNeighbours(cell: Cell, gridSnapshot: GridSnapshot) : List<Cell> {
            var resultList: MutableList<Cell> = mutableListOf();
            addIfExists(cell.x-1, cell.y-1, gridSnapshot, resultList)
            addIfExists(cell.x, cell.y-1, gridSnapshot, resultList)
            addIfExists(cell.x+1, cell.y-1, gridSnapshot, resultList)
            addIfExists(cell.x+1, cell.y, gridSnapshot, resultList)
            addIfExists(cell.x+1, cell.y+1, gridSnapshot, resultList)
            addIfExists(cell.x, cell.y+1, gridSnapshot, resultList)
            addIfExists(cell.x-1, cell.y+1, gridSnapshot, resultList)
            addIfExists(cell.x-1, cell.y, gridSnapshot, resultList)
            return resultList
        }

        private fun addIfExists(x: Int, y: Int, gridSnapshot: GridSnapshot, list: MutableList<Cell>) {
            if (x<0 || y<0) {
                return
            }
            if (gridSnapshot.grid[x][y] != Universe.EMPTY_CELL) {
                list.add(gridSnapshot.grid[x][y])
            }
        }

    }
}