package connect

import connect.event.EndTurnEvent
import connect.event.GameEndEvent
import connect.event.GameStartEvent
import connect.listener.EventListener
import java.util.*

class Observable {

    val listeners: MutableList<EventListener> = LinkedList();

    fun registerListener(eventListener: EventListener) {
        listeners.add(eventListener);
    }

    fun fireStartEvent(gameStartEvent: GameStartEvent) {
        listeners.forEach { it.gameStart(gameStartEvent) }
    }

    fun fireEndTurnEvent(endTurnEvent: EndTurnEvent) {
        listeners.forEach { it.endTurn(endTurnEvent) }
    }

    fun fireGameEndEvent(gameEndEvent: GameEndEvent) {
        listeners.forEach { it.gameEnd(gameEndEvent) }
    }

}