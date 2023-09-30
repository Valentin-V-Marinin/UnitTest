package seminar6;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        // Создаём списки с длиной LIST_LENGTH
        int LIST_LENGTH = 3;
        ArrayList<Double> list1  = new ArrayList<>();
        ArrayList<Integer> list2 = new ArrayList<>();
        ListGenerator listGenerator = new ListGenerator();
        try {
            list1 = listGenerator.createDoubleList(LIST_LENGTH);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
        try {
            list2 = listGenerator.createIntegerList(LIST_LENGTH + 4);
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }


        // Вычисляем среднее для первого списка состоящего из значений типа Double
        AverageCount<Double> avrList1 = new AverageCount<>(list1);
        double avr1 = 0;
        try {
            avr1 = avrList1.countAverage();
        } catch (RuntimeException e){
            System.out.println(e.getMessage());
        }

        // Вычисляем среднее для второго списка состоящего из значений типа Integer
        AverageCount<Integer> avrList2 = new AverageCount<>(list2);
        double avr2 = 0;
        try{
            avr2 = avrList2.countAverage();
        } catch (RuntimeException e){
            System.out.println(e.getMessage());
        }


        // сравниваем средние значения
        CheckResult cr = new CheckResult();
        if (list1.isEmpty() || list2.isEmpty()) {
            System.out.println("Для пустого списка среднее значение отсутствует!");
            System.out.println("Сравнение средних невозможно!");
        } else {
            System.out.println(cr.compareResult(avr1, avr2));
        }

        // выводим контрольную информацию
        System.out.print(list1 + "    среднее: ");
        System.out.println(avr1);
        System.out.print(list2 + "    среднее: ");
        System.out.println(avr2);

    }
}
