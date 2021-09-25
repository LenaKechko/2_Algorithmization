import java.lang.invoke.WrongMethodTypeException;
import java.util.*;

public class TasksVector {

    public boolean checkSimpleNumber(int number) {
        boolean flag = true;
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    /*1. В массив A[N] занесены натуральные числа.
     * Найти сумму тех эл-тов, которые кратны данному K.*/

    public int firstTask(Vector vector, int k) {
        if (vector.checkType() != 1)
            throw new WrongMethodTypeException();
        int sum = 0;
        for (int i = 0; i < vector.getSize(); i++) {
            int element = (int) vector.getElement(i);
            if (element % k == 0) {
                sum += element;
            }
        }
        return sum;
    }

    /*2. Дана последовательность действительных чисел a1, a2, ..., an.
     * Заменить все ее члены, большие данного Z, этим числом. Подсчитать количество замен.*/

    public int secondTask(Vector vector, double z) {
        if (vector.checkType() != -1)
            throw new WrongMethodTypeException();
        int count = 0;
        for (int i = 0; i < vector.getSize(); i++) {
            if ((double) vector.getElement(i) > z) {
                vector.setElement(z, i);
                count++;
            }
        }
        return count;
    }

    /*3. Дан массив действительных чисел, размерность которого N.
     * Подсчитать, сколько в нем отрицательных, положительных и нулевых элементов.*/

    public int getCountNegative(Vector vector) {
        if (vector.checkType() != -1)
            throw new WrongMethodTypeException();
        int count = 0;
        for (int i = 0; i < vector.getSize(); i++) {
            if ((double) vector.getElement(i) < 0) {
                count++;
            }
        }
        return count;
    }

    public int getCountPositive(Vector vector) {
        if (vector.checkType() != -1)
            throw new WrongMethodTypeException();
        int count = 0;
        for (int i = 0; i < vector.getSize(); i++) {
            if ((double) vector.getElement(i) > 0) {
                count++;
            }
        }
        return count;
    }

    public int getCountZero(Vector vector) {
        if (vector.checkType() != -1)
            throw new WrongMethodTypeException();
        int count = 0;
        for (int i = 0; i < vector.getSize(); i++) {
            if ((double) vector.getElement(i) == 0) {
                count++;
            }
        }
        return count;
    }

    /*4. Даны действительные числа a1, a2, ...,an.
     * Поменять местами наибольший и наименьший элементы.*/

    public Object[] forthTask(Vector vector) {
        if (vector.checkType() != -1)
            throw new WrongMethodTypeException();
        int indexMin = vector.getMinIndex();
        int indexMax = vector.getMaxIndex();
        double temp = (double) vector.getElement(indexMin);
        vector.setElement(vector.getElement(indexMax), indexMin);
        vector.setElement(temp, indexMax);
        return vector.getArray();
    }

    /*5. Даны целые числа a1,a2,...,an.
     * Вывести на печать только те числа, для которых ai>i*/
    public List<Integer> fifthTask(Vector vector) {
        if (vector.checkType() != 1)
            throw new WrongMethodTypeException();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < vector.getSize(); i++) {
            int element = (int) vector.getElement(i);
            if (element > i) {
                result.add(element);
            }
        }
        return result;
    }

    /*6. Задана последовательность N вещественных чисел.
     * Вычислить сумму чисел, порядковые номера которых являются простыми числами.*/

    public double sixthTask(Vector vector) {
        if (vector.checkType() != -1)
            throw new WrongMethodTypeException();
        double sum = 0.0;
        for (int i = 1; i < vector.getSize(); i++) {
            if (checkSimpleNumber(i + 1)) {
                sum += (double) vector.getElement(i);
            }
        }
        return sum;
    }

    /*7. Даны действительные числа a1,a2,...,an.
     * Найти  max(a1+a{2n}, a2+a{2n-1},..., an+a{n+1})*/

    public double seventhTask(Vector vector) {
        if (vector.checkType() != -1)
            throw new WrongMethodTypeException();
        if (vector.getSize() % 2 != 0) {
            throw new IndexOutOfBoundsException();
        }
        int size = vector.getSize() / 2;
        Vector temp_vector = new Vector<>(new Double[size], size);
        for (int i = 0; i < size; i++) {
            temp_vector.setElement((double) vector.getElement(i) + (double) vector.getElement(vector.getSize() - 1 - i), i);
        }
        return (double) temp_vector.getMaxElement();
    }

    /*8. Дана последовательность целых чисел a1,a2,...,an.
     * Образовать новую последовательность, выбросив из исходной те члены, которые равны min(a1,a2,...,an).*/
    public List<Integer> eigthTask(Vector vector) {
        if (vector.checkType() != 1)
            throw new WrongMethodTypeException();
        List<Integer> result = new ArrayList<>();
        int min = (int) vector.getMinElement();
        for (int i = 0; i < vector.getSize(); i++) {
            int element = (int) vector.getElement(i);
            if (element != min) {
                result.add(element);
            }
        }
        return result;
    }

    /*9. В массиве целых чисел с кол-вом эл-тов n найти наиболее часто встречающееся число.
     * Если таких чисел несколько, то определить наименьшее из них.*/
    public int ninethTask(Vector vector) {
        if (vector.checkType() != 1)
            throw new WrongMethodTypeException();
        HashMap<Integer, Integer> result = new HashMap<>();
        for (int i = 0; i < vector.getSize(); i++) {
            int element = (int) vector.getElement(i);
            if (!result.containsKey(element)) {
                result.put(element, 0);
            }
            result.put(element, result.get(element) + 1);
        }
        int i = 0;
        while (i <= result.size()) {

            i++;
        }
        Iterator<Map.Entry<Integer, Integer>> iter = result.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<Integer, Integer> el = iter.next();
            if (el.getValue() != Collections.max(result.values())) {
                iter.remove();
            }
        }
        return Collections.min(result.keySet());
    }

    /*10. Дан целочисленный массив с кол-вом эл-тов n.
     * Сжать массив, выбросив из него каждый второй эл-т (освободившиеся эл-ты заполнить нулями).
     * Примечание. Дополнительный массив не использовать.*/
    public Object[] tenthTask(Vector vector) {
        if (vector.checkType() != 1)
            throw new WrongMethodTypeException();
        for (int i = 1; i < vector.getSize(); i++) {
            for (int j = i; j < vector.getSize() - 1; j++) {
                vector.setElement(vector.getElement(j + 1), j);

            }
            vector.setElement(0, vector.getSize() - 1);
        }
        return vector.getArray();
    }
}
