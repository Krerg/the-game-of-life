package connect

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



}