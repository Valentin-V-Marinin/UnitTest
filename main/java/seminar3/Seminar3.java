package seminar3;

public class Seminar3 {

   static int lowBorder;
   static int highBorder;



    // HW 3.1. Нужно покрыть тестами метод на 100%
    /**
     * Метод проверяет, является ли целое число записанное в переменную n, чётным (true) либо нечётным (false).
     * @param n - целое число проверяемое на четность
     * @return - результат проверки (тип boolean)
     */
    public static boolean evenOddNumber(int n){
        if (n % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }

    // HW 3.2. Нужно написать метод который проверяет, попадает ли переданное число в интервал (25;100) и возвращает true, если попадает и false - если нет,
    // покрыть тестами метод на 100%

    /**
     * функция проверяет вхождение передаваемого параметра n в заданный в функции интервал
     * @param n - число проверяемое на вхождение в интервал
     * @return - результат проверки булевого типа
     * перед запуском функции нужно присвоить значения нижней и верхней
     * границе интервала - статические переменные класса lowBorder и highBorder
     */


    public static boolean numberInInterval(int n){

        if (n>= lowBorder && n <= highBorder){
            return true;
        } else {
            return false;
        }
    }

}
