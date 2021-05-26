package subtask3

class StringParser {

    // TODO: Complete the following function

    fun getResult(inputString: String): Array<String> {
        val listStrings = mutableListOf<String>()
        val indexes = mutableMapOf<Int, Int>()
        val roundBrackets = mutableListOf<Int>() // ()
        val boxBrackets = mutableListOf<Int>() // []
        val angleBrackets = mutableListOf<Int>() // <>

        for (index in inputString.indices) {
            when (inputString[index]) {
                '(' -> roundBrackets.add(index)
                ')' -> if (roundBrackets.isNotEmpty()) {
                    indexes[roundBrackets.last() + 1] = index
                    roundBrackets.removeAt(roundBrackets.lastIndex)
                }
                '[' -> boxBrackets.add(index)
                ']' -> if (boxBrackets.isNotEmpty()) {
                    indexes[boxBrackets.last() + 1] = index
                    boxBrackets.removeAt(boxBrackets.lastIndex)
                }
                '<' -> angleBrackets.add(index)
                '>' -> if (angleBrackets.isNotEmpty()) {
                    indexes[angleBrackets.last() + 1] = index
                    angleBrackets.removeAt(angleBrackets.lastIndex)
                }
            }

        }
        for ((firstIndex, lastIndex) in indexes.toSortedMap()) {
            listStrings.add(inputString.substring(firstIndex, lastIndex))
        }
        return listStrings.toTypedArray()
    }
}
