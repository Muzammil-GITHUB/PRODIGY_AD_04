import android.os.Bundle
import android.view.View
import android.widget.GridLayout
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

private val gridLayout by lazy { findViewById<GridLayout>(R.id.gridLayout) }
private val board = Array(3) { Array(3) { 0 } } // 0: Empty, 1: X, 2: O
private var currentPlayer = 1 // 1: X, 2: O

        override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Set initial properties for each cell
        for (row in 0 until gridLayout.rowCount) {
        for (col in 0 until gridLayout.columnCount) {
        val cellId = resources.getIdentifier("cell_${row}${col}", "id", packageName)
        val cell = findViewById<ImageView>(cellId)
        cell.setImageResource(R.drawable.ic_empty)
        }
        }
        }

        fun onCellClicked(view: View) {
        if (view is ImageView) {
        val row = GridLayout.spec(GridLayout.UNDEFINED, 1f)
        val col = GridLayout.spec(GridLayout.UNDEFINED, 1f)

        val layoutParams = GridLayout.LayoutParams(row, col)
        layoutParams.width = 0
        layoutParams.height = 0

        val rowIndex = GridLayout.getRowSpec(view.layoutParams)
        val colIndex = GridLayout.getColumnSpec(view.layoutParams)

        val cellRow = gridLayout.getRowIndex(rowIndex)
        val cellCol = gridLayout.getColumnIndex(colIndex)

        if (board[cellRow][cellCol] == 0) {
        val symbol = if (currentPlayer == 1) R.drawable.ic_x else R.drawable.ic_o
        view.setImageResource(symbol)
        board[cellRow][cellCol] = currentPlayer

        if (checkForWinner(cellRow, cellCol)) {
        // Handle game over
        } else {
        currentPlayer = if (currentPlayer == 1) 2 else 1
        }
        }
        }
        }

private fun checkForWinner(row: Int, col: Int): Boolean {
        // Implement the logic to check for a winner (row, column, diagonal)
        // Return true if a winner is found, false otherwise
        // Update UI or show a message if there is a winner
        return false
        }
        }
