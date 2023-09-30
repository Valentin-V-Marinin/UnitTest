package seminar6;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;

public class ListGenerator{
    Random rnd;

    public ListGenerator() {
        this.rnd = new Random();
    }

    /**
     * Метод для создания списка с целочисленными значениями (тип Integer)
     * при попытке передать отрицательное число генерируем исключение IllegalArgumentException
     * @param listLength - входной параметр, определяющий длину создаваемого списка
     * @return - метод возвращает список ArrayList с типом Integer
     */
    public ArrayList<Integer> createIntegerList(int listLength) {
        if (listLength < 0) throw new IllegalArgumentException("Список не может иметь отрицательную длину!");
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < listLength; i++) {
            list.add(rnd.nextInt(-100, 101));
        }
        return list;
    }

    /**
     * Метод для создания списка со значениями с дробной частью (тип Double)
     * при попытке передать отрицательное число генерируем исключение IllegalArgumentException
     * метод усекает дробную часть числа до трёх знаков после запятой
     * @param listLength - входной параметр, определяющий длину создаваемого списка
     * @return - метод возвращает список ArrayList с типом Double
     */
    public ArrayList<Double> createDoubleList(int listLength) {
        if (listLength < 0) throw new IllegalArgumentException("Список не может иметь отрицательную длину!");
        DecimalFormat decimalFormat = new DecimalFormat("#,###");
        ArrayList<Double> list = new ArrayList<>();
        for (int i = 0; i < listLength; i++) {
            list.add(Double.parseDouble( decimalFormat.format( rnd.nextDouble()*1000 ) )/1000 + rnd.nextInt(-100, 101));
        }
        return list;
    }


}
