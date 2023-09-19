package seminar2;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class MotorcycleTest {

    private Motorcycle moto;

    @BeforeEach
    void beforeAll() {
        moto = new Motorcycle("Ирбитский Мотоциклетный Завод", "Урал", 2010);
    }

    /**
     * Проверяем, что объект Motorcycle создается с 2-мя колесами.
     */
    @Test
    void checkWheelsNumber() {
        assertThat(moto.getNumWheels()).isEqualTo(2);
    }


    /**
     * Проверяем показтель скорости мотоцикла
     * по условию задачи он должен быть равен 75
     */
    @Test
    void testDrive() {
        moto.testDrive();
        assertThat(moto.getSpeed()).isEqualTo(75);
    }

    /**
     * Проверяем,что мотоцикл остановливется после движения
     */
    @Test
    void park() {
        moto.testDrive();
        assertThat(moto.getSpeed()).isEqualTo(75);
        moto.park();
        assertThat(moto.getSpeed()).isEqualTo(0);
    }
}