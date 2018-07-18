package strategy.cell.impl

import strategy.cell.InitialCell
import strategy.cell.InitialCellArrangementStrategy
import java.util.*
import java.util.concurrent.ThreadLocalRandom
import kotlin.collections.ArrayList

class RandomInitialCellArrangementStrategy: InitialCellArrangementStrategy {

    override fun getInitialCells(width: Int, height: Int): List<InitialCell> {

        val initialNumberOfCells: Int = (width*height * 0.3).toInt();

        val generatedCells = TreeSet<Int>();
        var cellCount = 0;
        val initialCells = ArrayList<InitialCell>(initialNumberOfCells);

        while(true) {
            val x = ThreadLocalRandom.current().nextInt(width);
            val y = ThreadLocalRandom.current().nextInt(height);
            val cellNumber = x*10+y;
            if (!generatedCells.contains(cellNumber)) {
                generatedCells.add(cellNumber);
                initialCells.add(InitialCell(x, y));
                cellCount++;
                if (cellCount == initialNumberOfCells) {
                    return initialCells;
                }
            }
        }

    }

}