package buscaminas;

/**
 * Represents a cell in a Minesweeper board or any similar game board where
 * cells can be uncovered.
 * Each cell has a value indicating its content (e.g., mine or number of nearby
 * mines) and visibility status.
 */
public class Celda {
    private int valor; // 9 indicates a mine; other values indicate proximity to mines
    private boolean visible; // true if the cell is revealed, false if hidden

    /**
     * Constructs a Celda with specified value and visibility.
     *
     * @param valor   Indicates if the cell contains a mine (9) or the number of
     *                adjacent mines (0-8).
     * @param visible Indicates whether the cell is revealed (true) or hidden
     *                (false).
     */
    public Celda(int valor, boolean visible) {
        this.valor = valor;
        this.visible = visible;
    }

    /**
     * Retrieves the cell's value, which indicates its content.
     *
     * @return The value of the cell: 9 if it contains a mine, or a count of nearby
     *         mines if it doesn't.
     */
    public int getValor() {
        return this.valor;
    }

    /**
     * Sets the cell's value, representing its content.
     *
     * @param valor An integer to set as the cell's value (9 for mine, or proximity
     *              count).
     */
    public void setValor(int valor) {
        this.valor = valor;
    }

    /**
     * Retrieves the visibility status of the cell.
     *
     * @return true if the cell is revealed, false if it is hidden.
     */
    public boolean getVisible() {
        return this.visible;
    }

    /**
     * Sets the visibility status of the cell.
     *
     * @param visible A boolean indicating if the cell should be revealed (true) or
     *                hidden (false).
     */
    public void setVisible(boolean visible) {
        this.visible = visible;
    }
}
