package buscaminas;

import java.util.Random;

/**
 * Class representing a Minesweeper game board. This class manages the game
 * logic,
 * including board setup, mine placement, cell value assignment, and gameplay
 * methods.
 */
public class BuscaMinas {
    private int tamañoTablero; // The number of rows and columns of the board
    private Celda[][] tablero; // 2D array representing the game board cells
    private int numeroMinas; // Total number of mines on the board
    private int estado; // Game state: 0 for ongoing, 1 for loss, 2 for win
    private int casillasDestapadas; // Count of revealed cells, used to determine victory conditions

    /**
     * Constructs a Minesweeper board, randomly places mines, and assigns numerical
     * values to cells.
     *
     * @param tamañoTablero The size of the board, defining both its rows and
     *                      columns.
     * @param numeroMinas   The number of mines to be randomly placed on the board.
     */
    public BuscaMinas(int tamañoTablero, int numeroMinas) {
        this.tamañoTablero = tamañoTablero;
        this.tablero = new Celda[tamañoTablero][tamañoTablero];
        this.numeroMinas = numeroMinas;
        this.estado = 0; // Game starts in "ongoing" state
        this.casillasDestapadas = 0;

        // Initialize all cells as non-mined with a value of 0
        for (int f = 0; f < this.tamañoTablero; f++) {
            for (int c = 0; c < this.tamañoTablero; c++) {
                this.tablero[f][c] = new Celda(0, false);
            }
        }

        // Place mines randomly on the board
        for (int i = 0; i < numeroMinas; i++) {
            int f, c;
            do {
                f = new Random().nextInt(tamañoTablero);
                c = new Random().nextInt(tamañoTablero);
            } while (this.tablero[f][c].getValor() == 9); // Avoid placing a mine on an already mined cell
            this.tablero[f][c].setValor(9);
        }

        // Assign numbers to cells adjacent to mines
        for (int f = 0; f < tamañoTablero; f++) {
            for (int c = 0; c < tamañoTablero; c++) {
                if (tablero[f][c].getValor() == 9) {
                    for (int f2 = Math.max(0, f - 1); f2 < Math.min(tamañoTablero, f + 2); f2++) {
                        for (int c2 = Math.max(0, c - 1); c2 < Math.min(tamañoTablero, c + 2); c2++) {
                            if (tablero[f2][c2].getValor() != 9) {
                                tablero[f2][c2].setValor(tablero[f2][c2].getValor() + 1);
                            }
                        }
                    }
                }
            }
        }
    }

    /**
     * Sets the game state to indicate that the player has hit a mine.
     */
    void gameOver() {
        this.estado = 1;
    }

    /**
     * Sets the game state to indicate that the player has won.
     */
    void victoria() {
        this.estado = 2;
    }

    /**
     * Reveals the specified cell. If the cell contains a 0, recursively reveals
     * adjacent cells.
     * If the cell contains a mine, ends the game. Checks for a win condition upon
     * each reveal.
     *
     * @param f The row of the cell to reveal.
     * @param c The column of the cell to reveal.
     */
    public void destaparCasilla(int f, int c) {
        if (!tablero[f][c].getVisible()) {
            tablero[f][c].setVisible(true);
            this.casillasDestapadas++;

            // Check for win condition
            if (casillasDestapadas == (this.tamañoTablero * this.tamañoTablero) - this.numeroMinas) {
                this.victoria();
            }

            // Check for mine hit
            if (tablero[f][c].getValor() == 9) {
                this.gameOver();
                return;
            }

            // If the revealed cell has a value of 0, reveal adjacent cells recursively
            if (tablero[f][c].getValor() == 0) {
                for (int f2 = Math.max(0, f - 1); f2 < Math.min(tamañoTablero, f + 2); f2++) {
                    for (int c2 = Math.max(0, c - 1); c2 < Math.min(tamañoTablero, c + 2); c2++) {
                        if (tablero[f2][c2].getValor() != 9) {
                            destaparCasilla(f2, c2);
                        }
                    }
                }
            }
        }
    }

    /**
     * Retrieves the current state of the game.
     *
     * @return 0 if the game is ongoing, 1 if the player has lost, and 2 if the
     *         player has won.
     */
    public int getEstado() {
        return estado;
    }

    /**
     * Returns the size of the board, representing both rows and columns.
     *
     * @return An integer representing the number of rows and columns.
     */
    public int getTamañoTablero() {
        return tamañoTablero;
    }

    /**
     * Returns the game board as a 2D array of Celda objects.
     *
     * @return A 2D array representing the board cells.
     */
    public Celda[][] getTablero() {
        return tablero;
    }
}
