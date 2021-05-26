package subtask1

class HappyArray {

    // TODO: Complete the following function
    fun convertToHappy(sadArray: IntArray) : IntArray {
        var happyArray = sadArray.toMutableList()

        do {
            var isHappy = false
            for(i in 1..happyArray.size-2) {
                if (happyArray[i-1] + happyArray[i + 1] < happyArray[i]) {
                    happyArray.removeAt(i)
                    isHappy = true
                    break
                }
            }
        } while (isHappy)

        return happyArray.toIntArray()
    }


}
