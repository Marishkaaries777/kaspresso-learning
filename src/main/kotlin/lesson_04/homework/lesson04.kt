package org.example.lesson_04.homework

import kotlin.random.Random

//1
class Inventory{
    private val items = mutableListOf<String>()

    operator fun plus(item: String) {
        items.add(item)
    }

    operator fun get(index: Int) : String {
        return items[index]
    }

    operator fun contains(item: String) : Boolean {
        return item in items
    }
}

//2
class Toggle(private val enabled : Boolean){
    operator fun not() : Toggle{
        return Toggle(!enabled)
    }
    override fun toString(): String {
        return enabled.toString()
    }}

//3
class Price(var number: Int){
    operator fun times(num: Int): Int{
        return number * num
    }
}

//4
class Step(val number: Int) {

    operator fun rangeTo(other: Step): IntRange {
        return number..other.number
    }
}

operator fun IntRange.contains(step: Step): Boolean {
    return step.number in this
}

//5
class Log{
    val entries = mutableListOf<String>()
    operator fun plus(log: String) : Log{
        entries.add(log)
        return this
    }

    fun printInfoLog() {
        println(entries.joinToString())
    }

}

//6
class Person(private val name: String) {

    private val phrases = mutableListOf<String>()

    infix fun says(string: String) : Person{
        phrases.add(string)
        return this
    }

    infix fun and(string: String) : Person{
        check(phrases.isNotEmpty()) {"Says используется в начале"}
        phrases.add(string)
        return this
    }

    infix fun or(phrase: String) : Person{
        check(phrases.isNotEmpty()) {"Says используется в начале"}
        phrases[phrases.lastIndex] = selectPhrase(phrases[phrases.lastIndex], phrase)
        return this
    }

    fun print() {
        println(phrases.joinToString(" "))
    }

    private fun selectPhrase(first: String, second: String): String {
        val random = Random.nextInt(0, 2)
        return if (random == 0) first else second
    }


}

fun main(){
    //1
    val inventory = Inventory()
    inventory + "25"
    inventory + "33"
    println(inventory[0])

    println("33" in inventory)

    //2
    val toggle = Toggle(false)
    println(!toggle)

    //3
    var price = Price(3)
    println(price.times(2))

    //4
    val stepFrom = Step(22)
    val stepTo = Step(37)
    val stepBetween = Step(29)
    val range = stepFrom..stepTo
    println(range.joinToString())
    println(stepBetween in range)

    //5
    val log = Log()
    log + "ava" + "viva" + "victory" + "star"
    log.printInfoLog()

    //6
    val andrew = Person("Andrew")
    andrew says "Hello" and "brothers." or "sisters." and "I believe" and "you" and "can do it" or "can't"
    andrew.print()
}