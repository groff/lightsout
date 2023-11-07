package moura.groff.ernani.lightsout

import android.os.Bundle
import android.os.SystemClock
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import moura.groff.ernani.lightsout.databinding.MainActivityBinding
import kotlin.random.Random

class LightsOut : AppCompatActivity() {

    private lateinit var binding: MainActivityBinding
    private var mapOfViews: List<Node> = listOf()
    private var listener: LightsOutListener? = null
    private var movesCounter = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        initialize()
        startGame()
    }

    private fun initialize() {
        listener = object : LightsOutListener {
            override fun addMove() {
                movesCounter++
                binding.tvMovesCounter.text = movesCounter.toString()
                didWin()
            }
        }
        mapOfViews = listOf(
            Node(
                view = binding.checkNumber1,
                adjacentNodes = listOf(
                    Node(binding.checkNumber2),
                    Node(binding.checkNumber6)
                ),
                isAdjacent = false,
                listener = listener
            ),
            Node(
                view = binding.checkNumber2,
                adjacentNodes = listOf(
                    Node(binding.checkNumber1),
                    Node(binding.checkNumber3),
                    Node(binding.checkNumber7)
                ),
                isAdjacent = false,
                listener = listener
            ),
            Node(
                view = binding.checkNumber3,
                adjacentNodes = listOf(
                    Node(binding.checkNumber2),
                    Node(binding.checkNumber4),
                    Node(binding.checkNumber8)
                ),
                isAdjacent = false,
                listener = listener
            ),
            Node(
                view = binding.checkNumber4,
                adjacentNodes = listOf(
                    Node(binding.checkNumber3),
                    Node(binding.checkNumber5),
                    Node(binding.checkNumber9)
                ),
                isAdjacent = false,
                listener = listener
            ),
            Node(
                view = binding.checkNumber5,
                adjacentNodes = listOf(
                    Node(binding.checkNumber4),
                    Node(binding.checkNumber10)
                ),
                isAdjacent = false,
                listener = listener
            ),
            Node(
                view = binding.checkNumber6,
                adjacentNodes = listOf(
                    Node(binding.checkNumber1),
                    Node(binding.checkNumber7),
                    Node(binding.checkNumber11)
                ),
                isAdjacent = false,
                listener = listener
            ),
            Node(
                view = binding.checkNumber7,
                adjacentNodes = listOf(
                    Node(binding.checkNumber6),
                    Node(binding.checkNumber8),
                    Node(binding.checkNumber2),
                    Node(binding.checkNumber12)
                ),
                isAdjacent = false,
                listener = listener
            ),
            Node(
                view = binding.checkNumber8,
                adjacentNodes = listOf(
                    Node(binding.checkNumber7),
                    Node(binding.checkNumber9),
                    Node(binding.checkNumber3),
                    Node(binding.checkNumber13)
                ),
                isAdjacent = false,
                listener = listener
            ),
            Node(
                view = binding.checkNumber9,
                adjacentNodes = listOf(
                    Node(binding.checkNumber8),
                    Node(binding.checkNumber10),
                    Node(binding.checkNumber4),
                    Node(binding.checkNumber14)
                ),
                isAdjacent = false,
                listener = listener
            ),
            Node(
                view = binding.checkNumber10,
                adjacentNodes = listOf(
                    Node(binding.checkNumber9),
                    Node(binding.checkNumber5),
                    Node(binding.checkNumber15)
                ),
                isAdjacent = false,
                listener = listener
            ),
            Node(
                view = binding.checkNumber11,
                adjacentNodes = listOf(
                    Node(binding.checkNumber12),
                    Node(binding.checkNumber6),
                    Node(binding.checkNumber16)
                ),
                isAdjacent = false,
                listener = listener
            ),
            Node(
                view = binding.checkNumber12,
                adjacentNodes = listOf(
                    Node(binding.checkNumber11),
                    Node(binding.checkNumber13),
                    Node(binding.checkNumber7),
                    Node(binding.checkNumber17)
                ),
                isAdjacent = false,
                listener = listener
            ),
            Node(
                view = binding.checkNumber13,
                adjacentNodes = listOf(
                    Node(binding.checkNumber12),
                    Node(binding.checkNumber14),
                    Node(binding.checkNumber8),
                    Node(binding.checkNumber18)
                ),
                isAdjacent = false,
                listener = listener
            ),
            Node(
                view = binding.checkNumber14,
                adjacentNodes = listOf(
                    Node(binding.checkNumber13),
                    Node(binding.checkNumber15),
                    Node(binding.checkNumber9),
                    Node(binding.checkNumber19)
                ),
                isAdjacent = false,
                listener = listener
            ),
            Node(
                view = binding.checkNumber15,
                adjacentNodes = listOf(
                    Node(binding.checkNumber14),
                    Node(binding.checkNumber10),
                    Node(binding.checkNumber20)
                ),
                isAdjacent = false,
                listener = listener
            ),
            Node(
                view = binding.checkNumber16,
                adjacentNodes = listOf(
                    Node(binding.checkNumber17),
                    Node(binding.checkNumber11),
                    Node(binding.checkNumber21)
                ),
                isAdjacent = false,
                listener = listener
            ),
            Node(
                view = binding.checkNumber17,
                adjacentNodes = listOf(
                    Node(binding.checkNumber16),
                    Node(binding.checkNumber18),
                    Node(binding.checkNumber12),
                    Node(binding.checkNumber22)
                ),
                isAdjacent = false,
                listener = listener
            ),
            Node(
                view = binding.checkNumber18,
                adjacentNodes = listOf(
                    Node(binding.checkNumber17),
                    Node(binding.checkNumber19),
                    Node(binding.checkNumber13),
                    Node(binding.checkNumber23)
                ),
                isAdjacent = false,
                listener = listener
            ),
            Node(
                view = binding.checkNumber19,
                adjacentNodes = listOf(
                    Node(binding.checkNumber18),
                    Node(binding.checkNumber20),
                    Node(binding.checkNumber14),
                    Node(binding.checkNumber24)
                ),
                isAdjacent = false,
                listener = listener
            ),
            Node(
                view = binding.checkNumber20,
                adjacentNodes = listOf(
                    Node(binding.checkNumber19),
                    Node(binding.checkNumber15),
                    Node(binding.checkNumber25)
                ),
                isAdjacent = false,
                listener = listener
            ),
            Node(
                view = binding.checkNumber21,
                adjacentNodes = listOf(
                    Node(binding.checkNumber22),
                    Node(binding.checkNumber16)
                ),
                isAdjacent = false,
                listener = listener
            ),
            Node(
                view = binding.checkNumber22,
                adjacentNodes = listOf(
                    Node(binding.checkNumber21),
                    Node(binding.checkNumber23),
                    Node(binding.checkNumber17)
                ),
                isAdjacent = false,
                listener = listener
            ),
            Node(
                view = binding.checkNumber23,
                adjacentNodes = listOf(
                    Node(binding.checkNumber22),
                    Node(binding.checkNumber24),
                    Node(binding.checkNumber18)
                ),
                isAdjacent = false,
                listener = listener
            ),
            Node(
                view = binding.checkNumber24,
                adjacentNodes = listOf(
                    Node(binding.checkNumber23),
                    Node(binding.checkNumber25),
                    Node(binding.checkNumber19)
                ),
                isAdjacent = false,
                listener = listener
            ),
            Node(
                view = binding.checkNumber25,
                adjacentNodes = listOf(
                    Node(binding.checkNumber24),
                    Node(binding.checkNumber20)
                ),
                isAdjacent = false,
                listener = listener
            )
        )

        binding.btPlayAgain.setOnClickListener {
            startGame()
        }
        binding.tvMovesText.setOnLongClickListener {
            instantWin()
            true
        }
    }

    private fun startGame() {
        cleanFields()
        // generate random start game
        var randomNumberStart = Random.nextInt(5, 12)
        do {
            mapOfViews[Random.nextInt(1, 25)].view.isChecked = true
            randomNumberStart--
        } while (randomNumberStart != 0)
    }

    private fun cleanFields() {
        for (node in mapOfViews) {
            node.view.isEnabled = true // enable view
            node.view.isChecked = false // uncheck view
        }
        binding.apply {
            tvMovesCounter.text = "0" // set move counter textfield to 0
            tvTimeCounter.base = SystemClock.elapsedRealtime() // restart clock numbers
            tvTimeCounter.start() // start timer
            victoryMessage.isVisible = false // hide victory message
            btPlayAgain.isVisible = false // hide play again message
            movesCounter = 0 // set move counter variable to 0
        }
    }

    private fun didWin() {
        Log.i("Talitha", "Checked boxes ${mapOfViews.filter { item -> item.view.isChecked }.size}")
        if (mapOfViews.filter { item -> item.view.isChecked }.size == 25) {
            binding.apply {
                for (node in mapOfViews) {
                    node.view.isEnabled = false // disable views
                }
                victoryMessage.isVisible = true // show victory message
                btPlayAgain.isVisible = true // show button play again
                tvTimeCounter.stop() // stop timer
            }
        }
    }

    /**
     * Instant win to check
     */
    private fun instantWin() {
        for (node in mapOfViews) {
            node.view.isChecked = true
            didWin()
        }
    }

    interface LightsOutListener {
        fun addMove()
    }
}