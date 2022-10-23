package edu.austral.dissis.chess

import edu.austral.dissis.chess.gui.AbstractChessGameApplication
import edu.austral.dissis.chess.gui.CachedImageResolver
import edu.austral.dissis.chess.gui.DefaultImageResolver
import edu.austral.dissis.chess.gui.ImageResolver
import javafx.application.Application

fun main() {
    Application.launch(MyChessGameApplication::class.java)
}

class MyChessGameApplication : AbstractChessGameApplication() {

    override val gameEngine = MyGameEngine()
    override val imageResolver: ImageResolver = CachedImageResolver(DefaultImageResolver())
}