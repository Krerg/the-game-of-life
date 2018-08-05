package connect.listener

import connect.event.GameStartEvent

interface EventListener {

    fun gameStart(gameStartEvent: GameStartEvent)

}