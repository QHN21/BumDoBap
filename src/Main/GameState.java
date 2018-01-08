package Main;

/**
 * Typ wyliczeniowy okreslajacy nazwy stanow
 * w jakihc znajduje sie program
 */
public enum GameState
{
    Menu(),
    ChoosingNumberOfPlayers(),
    Settings(),
    Game(),
    PauseMenu(),
    EndGame(),
    Leaderboard();
}
