package connect.listener

import connect.event.EndTurnEvent
import connect.event.GameEndEvent
import connect.event.GameStartEvent

interface EventListener {

    fun gameStart(gameStartEvent: GameStartEvent)

    fun endTurn(endTurnEvent: EndTurnEvent)

    fun gameEnd(gameEndEvent: GameEndEvent)

}