val second = 18000

fun main(){
agoToText()
}

fun agoToText() {
    when (second) {
        in 0 .. 60 -> println("Был(а) только что")
        in 61 .. 60 * 60 -> println("Был(а) " + minToText() + " назад")
        in 60 * 60 + 1 .. 24 * 60 * 60 -> println("Был(а) " + hourToText() + " назад")
        in 24 * 60 * 60 + 1 .. 2 * 24 * 60 * 60 -> println("Сегодня")
        in 2 * 24 * 60 * 60 + 1 .. 3 * 24 * 60 * 60 -> println("Вчера")
        else -> println("Давно")
    }
}

fun minToText(): String {
    val minute = (second / 60)
    var total = ""
    when (minute) {
        1, 21, 31, 41, 51, 61, 71, 81, 91 -> total = "$minute минуту"
        in 2 .. 4, in 22 .. 24, in 32 .. 34,
        in 42 .. 44, in 52 .. 54, in 62 .. 64,
        in 72 .. 74, in 82 .. 84, in 92 .. 94 -> total = "$minute минуты"
        in 5 .. 20, in 25 .. 30, in 35 .. 40, in 45 .. 50, in 55 .. 60, in 65 .. 70, in 75 .. 80, in 85 .. 90 -> total = "$minute минут"
    }
    return total
}

fun hourToText(): String {
    val hour = (second / 60 / 60)
    var total = ""
    when (hour) {
        1, 21, 31, 41, 51, 61, 71, 81, 91 -> total = "$hour час"
        in 2 .. 4, in 22 .. 24, in 32 .. 34,
        in 42 .. 44, in 52 .. 54, in 62 .. 64,
        in 72 .. 74, in 82 .. 84, in 92 .. 94 -> total = "$hour часа"
        in 5 .. 20, in 25 .. 30, in 35 .. 40, in 45 .. 50, in 55 .. 60, in 65 .. 70, in 75 .. 80, in 85 .. 90 -> total = "$hour часов"
    }
    return total
}