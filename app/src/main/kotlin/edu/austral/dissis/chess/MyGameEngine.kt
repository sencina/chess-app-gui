package edu.austral.dissis.chess

import adapter.Adapter
import adapter.GameAdapter
import edu.austral.dissis.chess.gui.*
import game.ClassicGame
import interfaces.Game

class MyGameEngine : GameEngine {

    private val game: Game = ClassicGame();
    private val adapter: GameAdapter = GameAdapter(game);

    override fun applyMove(move: Move): MoveResult {

        val movement = Adapter.toMovement(move, game.board);
        return try {
            game.makeMove(movement);
            NewGameState(Adapter.adaptPieces(game.board.pieces), if (game.whiteTurn()) PlayerColor.WHITE else PlayerColor.BLACK);
        }catch (e: Exception){
            InvalidMove(e.localizedMessage)
        }
    }

    override fun init(): InitialState {

        return InitialState(BoardSize(8,8),Adapter.adaptPieces(game.pieces),if (game.whiteTurn()) PlayerColor.WHITE else PlayerColor.BLACK)
    }
}
