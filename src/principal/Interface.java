package principal;

import java.util.Scanner;
import buscaminas.BuscaMinas;

/**
 * Command-line interface for the Minesweeper game, allowing players to input
 * board size,
 * place mines, and reveal cells. The game continues until the player wins or
 * hits a mine.
 */
public class Interface {
    private BuscaMinas bm; // Game board and logic handler
    private Scanner sc; // Scanner for user input

    /**
     * Initializes the game interface, prompts the user for game setup parameters,
     * and runs the game loop until the player wins or loses.
     */
    public Interface() {
        this.sc = new Scanner(System.in);
        System.out.println(
                "Por favor, indica el tamaño de tablero con el que quieres jugar y el numero de minas separados con un espacio.");

        // Initialize the game board with user-provided size and mine count
        this.bm = new BuscaMinas(sc.nextInt(), sc.nextInt());
        this.imprimirTablero();

        // Main game loop
        while (bm.getEstado() == 0) {
            System.out.println("Por favor, indica fila y columna que quieres destapar separadas con un espacio");

            // Reveal the chosen cell
            bm.destaparCasilla(sc.nextInt(), sc.nextInt());

            // Check game state and provide feedback
            if (bm.getEstado() == 1) {
                imprimirTablero();
                this.gameOver();
                break;
            } else if (bm.getEstado() == 2) {
                imprimirTablero();
                this.victoria();
                break;
            }

            // Print the board after each move
            this.imprimirTablero();
        }
    }

    /**
     * Prints the current state of the game board.
     * Revealed cells show their value, while hidden cells are represented by
     * underscores.
     */
    public void imprimirTablero() {
        for (int f = 0; f < bm.getTamañoTablero(); f++) {
            for (int c = 0; c < bm.getTamañoTablero(); c++) {
                if (bm.getTablero()[f][c].getVisible()) {
                    System.out.print("|" + bm.getTablero()[f][c].getValor() + "|");
                } else {
                    System.out.print("|_|");
                }
            }
            System.out.println(""); // Newline for each row
        }
    }

    /**
     * Displays a message indicating that the player has hit a mine and lost the
     * game.
     */
    public void gameOver() {
        System.out.println("Oh vaya! Ha explotado una mina y te has quedado sin un brazo.");
    }

    /**
     * Displays a congratulatory message indicating that the player has won the
     * game.
     */
    public void victoria() {
        System.out.println("Enhorabuena!! Has ganado!!");
    }

    /**
     * Main method to start the game. Instantiates the Interface class, which
     * prompts for input and runs the game loop.
     *
     * @param args Command-line arguments (not used in this application).
     */
    public static void main(String[] args) {
        new Interface();
    }
}
