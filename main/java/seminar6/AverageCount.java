package seminar6;

import java.util.ArrayList;

public class AverageCount <T extends Number>{

    private ArrayList<T> list;

    public AverageCount(ArrayList<T> list) {
        this.list = list;
    }

    /**
     * Метод расчета среднего значения для списков типа Double, Integer
     * если в метод передали пустой список - кидаем исключение RunTimeException,
     * если список не пустой - возвращаем среднее значение списка
     * @return  - среднее заначение списка, имеет тип Double
     */
    public double countAverage(){
        double sum = 0;

        if (list.isEmpty()) throw new RuntimeException("Пустой список не допускается!");

        for (int i = 0; i < list.size(); i++) {
            sum += list.get(i).doubleValue();
        }
        return sum / list.size();
    }

}
