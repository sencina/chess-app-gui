package edu.austral.dissis.chess

import adapter.GameAdapter
import edu.austral.dissis.chess.gui.*
import factory.GameFactory
import interfaces.Game

class MyGameEngine : GameEngine {

    private val game: Game = GameFactory.classicGame();
    private val adapter: GameAdapter = GameAdapter(game);

    override fun applyMove(move: Move): MoveResult {

        TODO("Not implemented yet")
    }

    override fun init(): InitialState {
        val pieces = adapter.getPieces()
        return InitialState(BoardSize(8, 8), pieces, PlayerColor.WHITE);
    }
}
