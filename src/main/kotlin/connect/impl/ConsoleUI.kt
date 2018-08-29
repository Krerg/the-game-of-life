package connect.impl

import connect.event.EndTurnEvent
import connect.event.GameEndEvent
import connect.event.GameStartEvent
import connect.listener.EventListener
import grid.Cell
import grid.Universe

class ConsoleUI : EventListener {

    private val gameOfLifeController: GameOfLife.GameOfLifeController

    constructor(gameOfLifeController: GameOfLife.GameOfLifeController) {
        this.gameOfLifeController = gameOfLifeController
        this.gameOfLifeController.registerListener(this);
    }

    fun startUI() {
        println("Game of Life v1.0")
        println("Console UI v1.0")
        println("Type 'start' to start game")
        println("After each turn type 'next' to get to the next turn")
        var inputLine:String?
        while (true) {
            print("Enter command: ")
            inputLine = readLine();
            if("exit" == inputLine) {
                println("Bye bye")
                return;
            }
            if("start" == inputLine) {
                gameOfLifeController.start();
            }
            if("next" == inputLine) {
                gameOfLifeController.nextTurn();
            }
        }
    }

    override fun gameStart(gameStartEvent: GameStartEvent) {
        println("Game started with next universe:")
        gameStartEvent.gridSnapshot.grid.forEach { arrayOfCells ->
            printGrid(arrayOfCells)
        }
    }

    private fun printGrid(array:Array<Cell>) {
        array.forEach {
            if (it == Universe.EMPTY_CELL) {
                print("#")
            } else {
                print("*")
            }
        }
        println()
    }

    override fun endTurn(endTurnEvent: EndTurnEvent) {
        println("Turn end")
        gameOfLifeController.getSnapshot()
        gameOfLifeController.getSnapshot().grid.forEach { arrayOfCells ->
            printGrid(arrayOfCells)
        }
    }

    override fun gameEnd(gameEndEvent: GameEndEvent) {
        println("Game over")
        println("There was not a single cell left")
    }

}