import java.lang.invoke.SerializedLambda

/////////// 1. 람다 //////////////
// 람다식은 우리가 마치 value 처럼 다룰 수 있는 익명함수이다.
// value 처럼 사용
//  1) 메서드의 파라미터로 넘겨줄수 있음
//  2) return 값으로 사용할 수 있음

// 람다 문법
// val lamdaName : Type = {argumentList -> codeBody}

val square: (Int) -> (Int) = {number -> number * number}

val nameAge = {name: String, age: Int -> "My name is ${name}, ${age} years old" }

fun main() {
    println(square(5)) // 25
    println(nameAge("nameA", 29))

    // a,b(String)를 확장해서 사용
    val a = "Some String...."
    val b = "mac said "
    println(a.pizzaIsGreat()) // Some String....Pizza is the best
    println(b.pizzaIsGreat()) // mac said Pizza is the best

    println(extendString("nameA", 29))
    println(calculaeGrade(97))

    val lambda = {number: Double ->
        number == 4.3333
    }
    println(invokeLambda(lambda))
    println(invokeLambda({it > 2}))
    // 메서드의 마지막 파라미터가 람다식일경우 소괄호를 생략해서 사용할 수 있다.
    println(invokeLambda { it > 3}) // it => 5.23333, it: 인풋파라미터가 하나일경우 예약어

}

// 1.1 확장함수
// String 클래스를 확장해서 사용
val pizzaIsGreat : String.() -> String = {
    // 여기서 this => String자체를 의미함
    this + "Pizza is the best"
}

// 확장함수 예시
fun extendString(name: String, age: Int): String {
    val introduceMyself : String.(Int) -> String = {
        // this가 가리키는 것은 확장함수가 가리키는 오브젝트
        // 파라미터가 하나일 경우 it 예약어 사용 가능 여기서는 Int 파라미터
        "I am ${this} and ${it} years old"
    }
    return name.introduceMyself(age)
}

// 1.2 람다의 Return
val calculaeGrade: (Int) -> String = {
    when(it) {
        in 0..40 -> "fail"
        in 41..70 -> "pass"
        in 71..100 -> "perfect"
        else -> "error"
    }
}

// 1.3 람다를 표현하는 여러가지 방법
fun invokeLambda(lambda: (Double) -> Boolean) : Boolean {
    return lambda(5.23333)
}
