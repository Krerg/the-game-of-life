package strategy.cell

interface InitialCellArrangementStrategy {

    fun getInitialCells(width: Int, height: Int): List<InitialCell>

}