import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.lang.invoke.WrongMethodTypeException;
import java.util.Arrays;

public class TasksVectorTest {
    private Vector<Object> vector;
    private TasksVector tasksVector;

    @Before
    public void setUp() throws Exception {
        tasksVector = new TasksVector();
    }

    @Test
    public void firstTask() {
        Integer[] array = new Integer[]{4, 1, 5, 7, 6};
        vector = new Vector<>(array, array.length);
        Assert.assertEquals(10, tasksVector.firstTask(vector, 2));
    }

    @Test
    public void firstTaskResultZero() {
        Integer[] array = new Integer[]{4, 1, 5, 7, 8};
        vector = new Vector<>(array, array.length);
        Assert.assertEquals(0, tasksVector.firstTask(vector, 3));
    }

    @Test(expected = WrongMethodTypeException.class)
    public void firstTaskFail() {
        Double[] array = new Double[]{4.0, 1.0, 5.0, 7.0, 6.0};
        vector = new Vector<>(array, array.length);
        tasksVector.firstTask(vector, 2);
    }

    @Test
    public void secondTaskCheckCount() {
        Double[] array = new Double[]{4.0, 1.0, 5.0, 7.0, 6.0};
        vector = new Vector<>(array, array.length);
        Assert.assertEquals(4, tasksVector.secondTask(vector, 2));
    }

    @Test
    public void secondTaskCheckArray() {
        Double[] array = new Double[]{4.0, 1.0, 5.0, 7.0, 6.0};
        vector = new Vector<>(array, array.length);
        tasksVector.secondTask(vector, 2.0);
        Assert.assertArrayEquals(new Double[]{2.0, 1.0, 2.0, 2.0, 2.0}, vector.getArray());
    }

    @Test(expected = WrongMethodTypeException.class)
    public void secondTaskFail() {
        Integer[] array = new Integer[]{4, 1, 5, 7, 8};
        vector = new Vector<>(array, array.length);
        tasksVector.secondTask(vector, 2.0);
    }

    @Test
    public void getCountNegative() {
        Double[] array = new Double[]{-4.0, 0.0, 5.0, -7.0, 6.0, 0.0, -8.0};
        vector = new Vector<>(array, array.length);
        Assert.assertEquals(3, tasksVector.getCountNegative(vector));
    }

    @Test(expected = WrongMethodTypeException.class)
    public void getCountNegativeFail() {
        Integer[] array = new Integer[]{4, -1, 0, 7, 8};
        vector = new Vector<>(array, array.length);
        tasksVector.getCountNegative(vector);
    }

    @Test
    public void getCountPositive() {
        Double[] array = new Double[]{-4.0, 0.0, 5.0, -7.0, 6.0, 0.0, -8.0};
        vector = new Vector<>(array, array.length);
        Assert.assertEquals(2, tasksVector.getCountPositive(vector));
    }

    @Test(expected = WrongMethodTypeException.class)
    public void getCountPositiveFail() {
        Integer[] array = new Integer[]{4, -1, 0, 7, 8};
        vector = new Vector<>(array, array.length);
        tasksVector.getCountPositive(vector);
    }

    @Test
    public void getCountZero() {
        Double[] array = new Double[]{-4.0, 0.0, 5.0, -7.0, 6.0, 0.0, -8.0};
        vector = new Vector<>(array, array.length);
        Assert.assertEquals(2, tasksVector.getCountZero(vector));
    }

    @Test(expected = WrongMethodTypeException.class)
    public void getCountZeroFail() {
        Integer[] array = new Integer[]{4, -1, 0, 7, 8};
        vector = new Vector<>(array, array.length);
        tasksVector.getCountZero(vector);
    }

    @Test
    public void forthTask() {
        Double[] array = new Double[]{4.0, 1.0, 5.0, 7.0, 6.0};
        vector = new Vector<>(array, array.length);
        Assert.assertArrayEquals(new Double[]{4.0, 7.0, 5.0, 1.0, 6.0}, tasksVector.forthTask(vector));
    }

    @Test(expected = WrongMethodTypeException.class)
    public void forthTaskFail() {
        Integer[] array = new Integer[]{4, -1, 0, 7, 8};
        vector = new Vector<>(array, array.length);
        tasksVector.forthTask(vector);
    }

    @Test
    public void fifthTask() {
        Integer[] array = new Integer[]{4, -1, 0, 7, 8};
        vector = new Vector<>(array, array.length);
        Assert.assertEquals(Arrays.asList(4, 7, 8), tasksVector.fifthTask(vector));
    }

    @Test
    public void fifthTaskNullArray() {
        Integer[] array = new Integer[]{-4, -1, 0, -7, -8};
        vector = new Vector<>(array, array.length);
        Assert.assertEquals(Arrays.asList(), tasksVector.fifthTask(vector));
    }

    @Test(expected = WrongMethodTypeException.class)
    public void fifthTaskFail() {
        Double[] array = new Double[]{4.0, 1.0, 5.0, 7.0, 6.0};
        vector = new Vector<>(array, array.length);
        tasksVector.fifthTask(vector);
    }

    @Test
    public void sixthTask() {
        Double[] array = new Double[]{4.0, 1.0, 5.0, 7.0, 6.0};
        vector = new Vector<>(array, array.length);
        Assert.assertEquals(12.0, tasksVector.sixthTask(vector), 0.0000001);
    }

    @Test(expected = WrongMethodTypeException.class)
    public void sixthTaskFail() {
        Integer[] array = new Integer[]{4, -1, 0, 7, 8};
        vector = new Vector<>(array, array.length);
        tasksVector.sixthTask(vector);
    }

    @Test
    public void seventhTask() {
        Double[] array = new Double[]{4.0, 1.0, 5.0, 7.0, 6.0, -1.0};
        vector = new Vector<>(array, array.length);
        Assert.assertEquals(12.0, tasksVector.seventhTask(vector), 0.0000001);
    }

    @Test(expected = WrongMethodTypeException.class)
    public void seventhTaskFail() {
        Integer[] array = new Integer[]{4, -1, 0, 7, 8};
        vector = new Vector<>(array, array.length);
        tasksVector.seventhTask(vector);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void seventhTaskFailTwo() {
        Double[] array = new Double[]{4.0, 1.0, 5.0, 7.0, 6.0};
        vector = new Vector<>(array, array.length);
        tasksVector.seventhTask(vector);
    }

    @Test
    public void eigthTask() {
        Integer[] array = new Integer[]{4, -1, 0, 7, -1, 8, -1};
        vector = new Vector<>(array, array.length);
        Assert.assertEquals(Arrays.asList(4, 0, 7, 8), tasksVector.eigthTask(vector));
    }

    @Test(expected = WrongMethodTypeException.class)
    public void eigthTaskFail() {
        Double[] array = new Double[]{4.0, 1.0, 5.0, 7.0, 6.0};
        vector = new Vector<>(array, array.length);
        tasksVector.eigthTask(vector);
    }

    @Test
    public void ninethTask() {
        Integer[] array = new Integer[]{4, -1, 0, 7, 8, 8, -1};
        vector = new Vector<>(array, array.length);
        Assert.assertEquals(-1, tasksVector.ninethTask(vector));
    }

    @Test
    public void ninethTaskTwo() {
        Integer[] array = new Integer[]{4, -1, 0, 7, 8, 8, -1, 8};
        vector = new Vector<>(array, array.length);
        Assert.assertEquals(8, tasksVector.ninethTask(vector));
    }

    @Test
    public void ninethTaskThree() {
        Integer[] array = new Integer[]{4, -1, 0, 7, 8, 2, -2, 3};
        vector = new Vector<>(array, array.length);
        Assert.assertEquals(-2, tasksVector.ninethTask(vector));
    }

    @Test(expected = WrongMethodTypeException.class)
    public void ninethTaskFail() {
        Double[] array = new Double[]{4.0, 1.0, 5.0, 7.0, 6.0};
        vector = new Vector<>(array, array.length);
        tasksVector.ninethTask(vector);
    }

    @Test
    public void tenthTask() {
        Integer[] array = new Integer[]{4, -1, 0, 7, 8, 2, -2, 3};
        vector = new Vector<>(array, array.length);
        Assert.assertArrayEquals(new Integer[]{4, 0, 8, -2, 0, 0, 0, 0}, tasksVector.tenthTask(vector));
    }

    @Test
    public void tenthTaskTwo() {
        Integer[] array = new Integer[]{4, -1, 0, 7, 8, 2, -2};
        vector = new Vector<>(array, array.length);
        Assert.assertArrayEquals(new Integer[]{4, 0, 8, -2, 0, 0, 0}, tasksVector.tenthTask(vector));
    }

    @Test(expected = WrongMethodTypeException.class)
    public void tenthTaskFail() {
        Double[] array = new Double[]{4.0, 1.0, 5.0, 7.0, 6.0};
        vector = new Vector<>(array, array.length);
        tasksVector.tenthTask(vector);
    }
}