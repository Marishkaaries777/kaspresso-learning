
interface Nuclear

/**Carbon — углерод — 6 протонов
Boron — бор — 5 протонов
Beryllium — бериллий — 4 протона
Lithium — литий — 3 протона
Magnesium — магний — 12 протонов*/

class Carbon : Nuclear
class Boron : Nuclear
class Lithium : Nuclear
class Magnesium : Nuclear
class Proton

fun Nuclear.knockOutProton(proton: Proton) : Nuclear {
    return when(this){
        is Carbon -> Boron()
        else -> throw IllegalStateException("Операция не осуществима")
    }
}

operator fun Nuclear.minus(proton: Proton) : Nuclear {
    return when(this){
        is Carbon -> Boron()
        else -> throw IllegalStateException("Операция не осуществима")
    }
}

operator fun Nuclear.times(multiplier: Int) : Nuclear {
    require(this is Carbon){"Операция доступна только для углерода"}
    require(multiplier == 2){"Доступно объединение двух ядер"}
    return Magnesium()
}

fun main(){
    val proton = Proton()
    val carbon = Carbon()
    val boron = carbon.knockOutProton(proton)
    println(boron.javaClass.simpleName)

    val boron2 = carbon - proton




    carbon * 2
    println(boron2.javaClass.simpleName)
}

