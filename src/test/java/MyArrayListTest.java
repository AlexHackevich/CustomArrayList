import org.assertj.core.util.Strings;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import javax.xml.crypto.Data;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MyArrayListTest {

    private static MyArrayList myArrayList;

    @BeforeEach
    void setUP() {
        myArrayList = new MyArrayList();
    }

    @AfterAll
    static void destroy() {
        myArrayList.clear();
    }

    @ParameterizedTest
    @MethodSource("getDataForAdd")
    void add(int expected, Object data) {
        myArrayList.add(data);
        myArrayList.add(data);
        int actual = myArrayList.size();

        assertEquals(expected, actual);
    }

    private static Stream<Arguments> getDataForAdd() {
        Object[] objects = new Object[]{"Petr", "Denis"};
        return Stream.of(

                Arguments.of(2, "Client"),
                Arguments.of(2, null),
                Arguments.of(2, 1111)
        );
    }

    @ParameterizedTest
    @MethodSource("getDataForAddElements")
    void addElements(int expected, Object[] data) {
        myArrayList.addElements(data);
        int actual = myArrayList.size();
        assertEquals(expected, actual);
    }

    private static Stream<Arguments> getDataForAddElements() {
        return Stream.of(
                Arguments.of(4, new Object[]{"Sergey", "Ser", null, 1234}),
                Arguments.of(2, new Object[]{null, 1234}),
                Arguments.of(1, new Object[]{null})
        );
    }

    @ParameterizedTest
    @MethodSource("getDataForAddOfIndex")
    void addOfIndex(int index, Object data) {
        myArrayList.addOfIndex(index, data);
        Object values = myArrayList.get(index);
        assertEquals(values, myArrayList.get(index));
    }

    private static Stream<Arguments> getDataForAddOfIndex() {
        return Stream.of(
                Arguments.of(1, "Client"),
                Arguments.of(4, null),
                Arguments.of(0, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("getDataForRemove")
    void remove(int index, Object data) {
        myArrayList.add(data);
        myArrayList.add(data);

        myArrayList.remove(index);
        myArrayList.remove(index);


        assertTrue(myArrayList.size() == 0);
    }

    private static Stream<Arguments> getDataForRemove() {
        return Stream.of(
                Arguments.of(0, "Value1"),
                Arguments.of(1, "Value2")
        );
    }


    @ParameterizedTest
    @MethodSource("getDataForClear")
    void clear(Object data) {
        myArrayList.add(data);
        myArrayList.add(data);
        myArrayList.add(data);
        myArrayList.add(data);
        myArrayList.clear();
        assertTrue(myArrayList.size() == 0);
        assertEquals(myArrayList.get(0), null);
    }

    private static Stream<Arguments> getDataForClear() {
        return Stream.of(
                Arguments.of(0, "Value1"),
                Arguments.of(1, null)
        );
    }
}