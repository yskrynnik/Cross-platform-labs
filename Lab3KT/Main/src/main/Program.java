package main;

import Lab3Lib.FileIO;
import Lab3Lib.SignalCharacteristicsCalculator;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;


public class Program {
    public static void main(String[] args) throws IOException
    {
        List<Integer> numbers = null;

        if (args.length == 0)
        {
            System.out.println("Укажите путь к файлу");
            return;
        }

        try
        {
            numbers = FileIO.readFile(args[0]);
        }
        catch (FileNotFoundException ex)
        {
            System.out.println("Файл не найден");
            return;
        }
        catch (IOException ex)
        {
            System.out.println("Ошибка файла");
            return;
        }

        System.out.println("Динамический диапазон сигнала = " + SignalCharacteristicsCalculator.calculateDynamicRange(numbers));
        System.out.println("Энергия сигнала = " + SignalCharacteristicsCalculator.calculateSignalEnergy(numbers));
        System.out.println("Средняя мощность сигнала = " + SignalCharacteristicsCalculator.calculateAverageSignalStrength(numbers));
        System.out.println("Среднее значение отсчетов сигнала = " + SignalCharacteristicsCalculator.calculateAverageSignalSamplesValue(numbers));
        System.out.println("Дисперсия значений отсчетов сигнала = " + SignalCharacteristicsCalculator.calculateSignalSampleValuesVariance(numbers));
        for (int i=-50;i<=50;i++)
        {
            System.out.println("tau = " + i + " result = " +SignalCharacteristicsCalculator.calculateAutoCorrelationFunc(numbers,i));
        }
        System.out.println("Интервал корелляции = " + SignalCharacteristicsCalculator.calculateCorrelationInterval(numbers));
    }
}
