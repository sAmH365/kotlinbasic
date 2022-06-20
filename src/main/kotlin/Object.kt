// Object
// Singleton Pattern
// 처음 컴파일될때 만들어진 인스턴스 하나로 사용
object CarFactory {
    val cars = mutableListOf<Car>()

    fun makeCar(horsePower: Int): Car {
        val car = Car(horsePower)
        cars.add(car)
        return car
    }
}

data class Car(val horsePower: Int)

fun main() {
    val car = CarFactory.makeCar(10)
    val car2 = CarFactory.makeCar(20)

    println(CarFactory.cars.size) // 2
    println(car)
    println(car2)
}
