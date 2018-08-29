import connect.impl.ConsoleUI

fun main(args: Array<String>) {

    val controller = GameOfLife().getController();
    val consoleUI = ConsoleUI(controller);
    consoleUI.startUI()

}