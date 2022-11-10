package edu.austral.dissis.chess

import edu.austral.dissis.chess.gui.*
import game.engine.ExtinctionGameEngine
import game.engine.MyGameEngine
import game.engine.TestEngine
import javafx.application.Application

fun main() {
    Application.launch(MyChessGameApplication::class.java)
}

class MyChessGameApplication : AbstractChessGameApplication() {

    override val gameEngine = MyGameEngine()
    override val imageResolver: ImageResolver = CachedImageResolver(DefaultImageResolver())
}