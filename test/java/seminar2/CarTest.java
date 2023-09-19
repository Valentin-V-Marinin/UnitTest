package seminar2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


class CarTest {

    private Car car;

    /**
     * Инициализируем объект Car перед каждым тестом
     */
    @BeforeEach
    void BeforeEach(){
        car = new Car("Москвич", "412", 1970);
    }

    /**
     * Проверяем является ли экземпляр Car объектом Vehicle
     */
    @Test
    void checkInstance(){
        assertThat(car).isInstanceOf(Vehicle.class);
    }

    /**
     * Проверяем, что объект Car создается с 4-мя колесами.
     */
    @Test
    void checkWheelsNumber() {
        assertThat(car.getNumWheels()).isEqualTo(4);
    }

    /**
     * Проверяем, что объект Car развивает скорость 60 в режиме тестового вождения
     * по очереди подставляем значения скорости равные 70, 0, 60
     */
    @ParameterizedTest
    @ValueSource(ints = { 70, 0, 60 })
    void testDrive(int testSpeed) {
        car.testDrive();
        assertThat(car.getSpeed()).isEqualTo(testSpeed);
    }

    /**
     * Проверяем, что в режиме парковки (сначала testDrive, потом park,
     *   т.е. эмуляция движения транспорта) машина останавливается
     */
    @Test
    void park() {
        car.testDrive();
        assertThat(car.getSpeed()).isEqualTo(60);
        car.park();
        assertThat(car.getSpeed()).isEqualTo(0);
    }
}