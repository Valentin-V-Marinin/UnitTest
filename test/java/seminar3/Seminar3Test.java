package seminar3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class Seminar3Test {

    /**
     * проверяем переданный в функцию параметр на четность
     * @param number - передаваемое в фнкцию число для теста на четность
     * Передаем для теста одно четное и одно нечетное число
     * для значения "21" тест должен отработать корректно,
     * для значения "22" тест должен завершиться с ошибкой
     */
    @DisplayName("Тест функции определяющей четность входного параметра")
    @ParameterizedTest
    @ValueSource(ints = { 21, 22 })
    void  evenOddNumberTest(int number) {
        assertThat(Seminar3.evenOddNumber(number)).isEqualTo(false);
        assertThat(Seminar3.evenOddNumber(number-1)).isEqualTo(true);
    }


    /**
     * Проверяем ряд чисел на вхождение в интервал обозначенный
     * статическими переменныйми lowBorder и highBorder, которые введены
     * для большей гибкости тестируемой функции
     * @param checkNumber - входной параметр, тестируемый на вхождение в заданный интервал
     * соответственно checkNumber - тестируемое значение на вхождение в интервал
     */
    @DisplayName("Тест функции на вхождение параметра в заданные границы")
    @ParameterizedTest
    @ValueSource(ints = { 25, 50, 101, -2 })
    void  numberInIntervalTest(int checkNumber) {
        Seminar3.lowBorder = 25;
        Seminar3.highBorder = 100;
        if (checkNumber >= Seminar3.lowBorder && checkNumber <= Seminar3.highBorder) {
            assertThat(Seminar3.numberInInterval(checkNumber)).isEqualTo(true);
        } else {
            assertThat(Seminar3.numberInInterval(checkNumber)).isEqualTo(false);
        }
    }

}