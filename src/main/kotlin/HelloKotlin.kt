import java.util.*

class HelloKotlin {
}

fun main() {
    helloWorld()
    println(add(1,3))
    println(stringTemplate("aaa"))
    println(checkNum(89))

    println("==============")
    forAndWhile()
    println("==============")
    nullCheck()
    ignoreNulls()
}


/////////// 1. 함수 //////////////
// 리턴형이 없을때는 암묵적으로 Unit을 반환
fun helloWorld(): Unit {
    println("hello kotlin!!")
}
// 무언가를 리턴하면 반드시 타입을 명시해야함
fun add(a: Int, b: Int): Int {
    return a + b
}

/////////// 2. val vs var //////////////
// val: 변할수 없는 값
// var: 변할수 있는 값
fun hi() {
    val a = 10
    var b = 5
    var name: String
//    a = 2 에러
    b = 4
}

/////////// 3. String Template //////////////
fun stringTemplate(name: String): String {
    return "my name is ${name}.";
}

/////////// 4. 조건식 //////////////
// if else
fun maxBy(a: Int, b: Int): Int {
    if (a > b) {
        return a
    } else {
        return b
    }
}
// 위와 같은 표현(삼항 연산자 대신 사용)
fun maxBy2(a: Int, b: Int) = if(a > b) a else b

// when
fun checkNum(score:Int) {
    when(score) {
        0 -> println("this is 0")
        1-> println("this is 1")
        2,3 -> println("this is 2 or 3")
        else -> println("N/A")
    }

    when(score) {
        in 90..100 -> println("A")
        in 80..90 -> println("B")
        else -> println("C")
    }
}

/////////// 5. Array and List //////////////
// Array: 처음 할당해준 크기만 사용가능
// List
//  1. 변경불가한 List
//  2. 변경가능한 MutableList(ex:arrayList)
fun array() {
    // 초기화
    val array = arrayOf(1,2,3)
    val list = listOf(1,2,3)
    val array2 = arrayOf(1,"d",3.4f)

    array[0] = 3
//    list[0] = 3 에러발생
    var a = list.get(0) // get으로 값에 넣을수는 있음

    val arrayList = arrayListOf<Int>()
    val mutableList = mutableListOf(1,3,4,"2","AAAA", 3.2f)

    arrayList.add(10)
    arrayList.add(20)
    arrayList[2] = 1
}

/////////// 6. 반복문 (for / while) //////////////
fun forAndWhile() {
    val students = arrayListOf("studentA", "studentB", "studentC", "studentD")

    for(name in students){
        println(name)
    }
    for((index, name) in students.withIndex()) {
        println("${index + 1} 번째 학생 : ${name}.")
    }

    var sum: Int = 0
    var sumStep2 = 0
    var sumDownTo = 0
    var sumUntil = 0

    for(i in 1..10) {
        sum += i // 55
    }
    for(i in 1..10 step 2) {
        sumStep2 += i // 25
    }
    for(i in 10 downTo 1) {
        sumDownTo += i // 55 , 10부터 거꾸로 더해감
    }
    for(i in 1 until 100) {
        sumUntil += i // 4950 , 1이상 100 미만
    }
    println("합1 = ${sum}")
    println("합2 = ${sumStep2}")
    println("합3 = ${sumDownTo}")
    println("합4 = ${sumUntil}")

    var index = 0
    while(index<10) {
        index++
        println("Current Index : ${index}")
    }
}

/////////// 7. NonNull 과 Nullable //////////////
fun nullCheck() {
    var name = "name1"
    // ? 연산자 -> null 가능
    var nullName: String? = null
    // nullName이 null이면 nullName.toUpperCase()가 null 반환
    var nullNameInUpperCase = nullName?.toUpperCase()

    // ?: 연산자 -> null일때 디폴트값을 정해주고 싶을 경우 사용
    val lastName: String? = null
    val fullName = name + (lastName?: " NO lastName")
    println("fullName = ${fullName}.") // name1 NO lastName.
}

/////////// 8. let함수 //////////////
// let함수 : 자신의 리시버객체를 람다식 내부로 옮겨서 실행시켜 줌(notNull일 경우에 let 함수를 실행함)
fun ignoreNulls() {
    val email: String? = "abcd@naver.com"
    email?.let {
        println(it)
    }
}
