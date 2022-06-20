class ClassPractice {
}
// 생성자
open class Human(val name: String = "디폴트값도 설정가능") {
    /**
     * java에서 생성자...
     *
     * class Person {
     *  public Person(String name) {}
     *  public Person(String name, int age) { this(name) }
     * }
     */

    // 클래스를 처음 생성할때 어떤 동작을 해줄지 정함, 주 생성자의 일부라서 constructor보다 먼저 실행됨
    init {
        println("New Human has been born")
    }

    // 부생성자(constructor)는 주 생성자에게 위임을 받음
    constructor(name: String, age: Int) : this(name) {
        println("my name is ${name}, ${age}years old")
    }


    fun eatingFood() {
        println("eating FOOD")
    }

   open fun singASong() {
        println("lalala")
    }
}

// 상속하려면 open 예약어 사용하기
class Korean: Human() {
    // 오버라이딩도 open 예약어 사용
    override fun singASong() {
        println("RARARA")
        println("name is ${name}.")// 부모생성자의 name, name is 디폴트값도 설정가능.
    }
}


fun main () {
    // 자바: Human human = new Human();
    val human = Human("minsu")
    val human2 = Human("AAA", 30);
    val human3 = Human()
    human.eatingFood()

    println("this human's name is ${human.name}.") // this human's name is minsu.
    println("this human2's name is ${human2.name}.") // my name is AAA, 30years old
    println("this human3's name is ${human3.name}.") // this human2's name is 디폴트값도 설정가능.


    val korean = Korean()
    korean.singASong()
}


