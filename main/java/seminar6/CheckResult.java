package seminar6;

public class CheckResult {

    /**
     * Метод для вывода результата сравнения двух чисел
     * @param var1 - первое сравниваемое число
     * @param var2 - второе сравниваемое число
     * @return - результат сравнения var1 и var2 в текстовом формате, тип String
     */
    public String compareResult(double var1, double var2){
        if (var1 > var2) {
            return "Первый список имеет большее среднее значение.";
        } else if (var1 < var2) {
            return "Второй список имеет большее среднее значение.";
        } else {
            return "Средние значения равны.";
        }
    }
}
