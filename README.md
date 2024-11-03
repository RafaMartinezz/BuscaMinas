# Minesweeper Game

A command-line version of the classic **Minesweeper** game, built in Java. This project allows users to play Minesweeper by specifying the board size and number of mines, then interactively revealing cells until they either clear the board or hit a mine.

## Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Game Rules](#game-rules)
- [Installation](#installation)
- [Usage](#usage)
- [Example Output](#example-output)
- [Project Structure](#project-structure)
- [Customization](#customization)
- [License](#license)

---

## Overview

This Minesweeper game provides a text-based interface where players specify the size of the game board and the number of mines to be placed. Mines are placed randomly, and each cell displays the count of adjacent mines, helping players avoid mine locations through deduction. The game continues until all non-mine cells are uncovered or the player hits a mine.

## Features

- **Customizable Board Size**: Set the board size and number of mines before starting.
- **Recursive Cell Reveal**: Cells with no adjacent mines automatically reveal neighboring cells.
- **Game Status Feedback**: Displays a message upon winning or losing.
- **Simple Text-Based Interface**: A lightweight and straightforward interface for quick interaction.

## Game Rules

1. **Objective**: Reveal all cells without mines to win.
2. **Gameplay**:
   - Enter the row and column of the cell you want to reveal.
   - If the cell contains a mine, the game ends with a loss.
   - If the cell is empty (contains a zero), adjacent cells will be automatically revealed.
3. **Endgame Conditions**:
   - **Win**: All cells without mines are revealed.
   - **Loss**: A mine is revealed.

### Playing the Game

1. **Start**: Enter board dimensions and mine count.
2. **Reveal Cells**: Enter the row and column number for the cell you wish to reveal.
3. **Win/Loss**: The game announces the result and displays the final board state.

## Example Output

```plaintext
Please enter the board size and number of mines, separated by a space.
5 3
|_|_|_|_|_|
|_|_|_|_|_|
|_|_|_|_|_|
|_|_|_|_|_|
|_|_|_|_|_|

Please enter the row and column to reveal, separated by a space.
2 2
|_|_|_|_|_|
|_|1|_|_|_|
|_|1|0|0|_|
|_|_|0|1|_|
|_|_|_|_|_|

...
Congratulations!! You have won!!
```

## Project Structure

- `buscaminas` package:
  - **`BuscaMinas`**: Handles the board setup, mine placement, cell value assignments, and gameplay logic.
  - **`Celda`**: Represents an individual cell on the board, holding its value (mine or number of adjacent mines) and visibility status.
- `principal` package:
  - **`Interface`**: Provides a command-line interface for setting up and playing the game, handling user input and displaying the board state.

## Customization

- **Board Size and Mine Count**: Modify the parameters passed to `BuscaMinas` in `Interface` to set a different default size or number of mines.
- **Visual Representation**: Customize the `imprimirTablero` method in `Interface` to change how the board is displayed in the console.
- **Additional Features**: Enhance the game by adding features like flagging cells or adding difficulty levels.
