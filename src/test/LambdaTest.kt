package test

fun main(args: Array<String>) {
    // Array<Integer> ints

    val x: IntArray = intArrayOf(1, 2, 3)
    // x[0] = x[1] + x[2]

    println(x);

    val y = x.map{ v -> v * v * v}

    y.forEach { v -> println(v) }

}

fun <T, R> List<T>.map(transform: (T) -> R): List<R> {
    val result = arrayListOf<R>()
    for (item in this)
        result.add(transform(item))
    return result
}

