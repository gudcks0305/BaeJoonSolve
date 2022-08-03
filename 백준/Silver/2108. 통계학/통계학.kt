import kotlin.math.round

fun main(args: Array<String>) {

    // 소수 구하기
    val num1 : Int = readLine()!!.toInt()
    var array = mutableListOf<Int>();
    for(i in 1..num1){
        array.add(readLine()!!.toInt());
    }
    array.sort();
    println(average(array));
    println(center(array));
    println(mostFrequent(array));
    println(range(array));
}

// average array element
fun average(array: List<Int>): Int {
    var sum = 0.0
    for (i in array) {
        sum += i
    }
    // 반올림
    return round(sum / array.size).toInt()

}
// center of array
fun center(array: List<Int>): Int {
    val size = array.size;
    val center = size / 2;
    return array[center];
}
// 최빈값
fun mostFrequent(array: List<Int>):Int {
    val map = mutableMapOf<Int, Int>()
    for (i in array) {
        if (map.containsKey(i)) {
            map[i] = map[i]!! + 1
        } else {
            map[i] = 1
        }
    }
    val resultList = map.filter { it.value == map.values.maxOrNull() }.toMap()
    return if (resultList.size == 1) {
        resultList.keys.elementAt(0)
    } else {
        // second key is most frequent
        resultList.keys.elementAt(1)

    }
    // List 에서 2번째로 작은값

}
// range of array
fun range(array: List<Int>): Int {
    val min = array.minOrNull()!!
    val max = array.maxOrNull()!!
    return max - min
}