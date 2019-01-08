package test1

/**
 * We declare a package-level function main which returns Unit and takes
 * an Array of strings as a parameter. Note that semicolons are optional.
 */

fun main(args: Array<String>) {
    println("Hello, world!")

    for (i in 1 .. 10) {
        println("i: ${i}, \ti^2: ${i*i}")
    }

}

