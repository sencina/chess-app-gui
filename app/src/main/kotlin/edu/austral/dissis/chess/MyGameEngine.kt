package edu.austral.dissis.chess

import adapter.Adapter
import adapter.GameAdapter
import edu.austral.dissis.chess.gui.*
import enums.Colour
import factory.GameFactory
import interfaces.Game
import java.lang.Exception

class MyGameEngine : GameEngine {

    private val game: Game = GameFactory.classicGame();
    private val adapter: GameAdapter = GameAdapter(game);

    override fun applyMove(move: Move): MoveResult {

        val movement = Adapter.toMovement(move,game.board);
        return try{
            game.makeMove(movement);
            NewGameState(Adapter.adaptPieces(game.board.pieces), if (game.turnManager().getTurn() == Colour.WHITE) PlayerColor.WHITE else PlayerColor.BLACK);
        }catch (e: Exception){
            InvalidMove(e.localizedMessage);
        }

    }

    override fun init(): InitialState {
        val pieces = adapter.getPieces()
        return InitialState(BoardSize(8, 8), pieces, PlayerColor.WHITE);
    }
}
