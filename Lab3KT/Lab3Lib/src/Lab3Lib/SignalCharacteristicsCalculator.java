package Lab3Lib;

import java.util.Collections;
import java.util.List;

public class SignalCharacteristicsCalculator {
    public static Integer calculateDynamicRange(List<Integer> numbers)
    {
        Integer min = Collections.min(numbers);
        Integer max = Collections.max(numbers);
        return max - min;
    }
    public static Integer calculateSignalEnergy(List<Integer> numbers)
    {
        int result = 0;
        for (Integer i : numbers)
        {
            result += (i * i);
        }
        return result;
    }
    public static Float calculateAverageSignalStrength(List<Integer> numbers)
    {
        float result = 0f;
        for (Integer i : numbers)
        {
            result += (i * i);
        }
        return result / numbers.size();
    }
    public static Float calculateSignalSampleValuesVariance(List<Integer> numbers)
    {
        Float m = calculateAverageSignalSamplesValue(numbers);
        float result = 0f;
        for (Integer i : numbers)
        {
            result += ((i - m) * (i - m));
        }
        return result / numbers.size();
    }
    public static Float calculateAverageSignalSamplesValue(List<Integer> numbers)
    {
        Float result = 0f;
        for (Integer i : numbers)
        {
            result += i;
        }
        return result / numbers.size();
    }
    public static Float calculateAutoCorrelationFunc(List <Integer> numbers, int tau)
    {
        Float m = calculateAverageSignalSamplesValue(numbers);
        float result = 0f;
        if (tau<0)
        {
            tau = -tau;
        }
        for(int i = 0; i<numbers.size()-tau; i++)
        {
            result = result + (numbers.get(i+tau) - m)*(numbers.get(i)-m);
        }
        result = result/(numbers.size()-tau);
        return result;
    }
    public static Float calculateCorrelationInterval(List <Integer> numbers)
    {
        float result = 0f;
        for(int j = 0; j<numbers.size();j++)
        {
            result = result+calculateAutoCorrelationFunc(numbers,j);
        }
        return result/calculateAutoCorrelationFunc(numbers,0);
    }
}
