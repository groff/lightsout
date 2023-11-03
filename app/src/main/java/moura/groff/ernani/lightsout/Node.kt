package moura.groff.ernani.lightsout

import android.widget.CheckBox

data class Node(
    val view: CheckBox,
    val adjacentNodes: List<Node>? = null,
    val isAdjacent: Boolean = true,
    val listener: LightsOut.LightsOutListener? = null
) {
    init {
        if (isAdjacent.not()) {
            view.setOnClickListener {
                checkNodesList(adjacentNodes)
                listener?.addMove()
            }
        }
    }

    private fun checkNodesList(adjacentNodes: List<Node>?) {
        adjacentNodes?.let { list ->
            for (node in list) {
                node.view.isChecked = node.view.isChecked.not()
            }
        }
    }
}