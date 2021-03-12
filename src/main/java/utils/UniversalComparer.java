package utils;

import lombok.Data;
import models.FieldSort;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * Класс UniversalComparer <b>expression</b>, <b>checkNull</b>, <b>fieldSorts</b>.
 * Данный класс предназначен для компаратора
 * @autor Андрей Соловьем
 */

@Data
public class UniversalComparer<T> implements Comparator<T> {
    /**Поле строка**/
    private String expression;
    /**Поле проверка на null**/
    private Boolean checkNull;
    /**Поля для сравнения последовательно**/
    private ArrayList<FieldSort> fieldSorts;

    public UniversalComparer(String expression) {
        this.expression = expression;
        this.checkNull = null;
        parseFields();
    }

    public UniversalComparer(String expression, Boolean checkNull) {
        this.expression = expression;
        this.checkNull = checkNull;
        parseFields();
    }
    /**Основной метод для работы**/
    public int compare(T o1, T o2) {
        Class classOne = o1.getClass();
        Class classTwo = o2.getClass();
        try {
            for (FieldSort fieldSort : getFieldSorts()) {
                if (fieldSort.getNameField().isEmpty()) return 0;
                if (fieldSort.getNameField().contains(".")) {
                    String className = fieldSort.getNameField().split("\\.")[0].trim();
                    if (classOne.getDeclaredField(className).get(o1) != null && classTwo.getDeclaredField(className).get(o2) != null) {
                        int res = new UniversalComparer<Object>(fieldSort.getNameField().split("\\.")[1]).compare(classOne.getDeclaredField(className).get(o1), classTwo.getDeclaredField(className).get(o2));
                        if (res != 0) return !fieldSort.isReserve()
                                ? res
                                : -res;
                        continue;
                    } else {
                        return classOne.getDeclaredField(className).get(o1) != null && getCheckNull() != null && getCheckNull()
                                ? 1
                                : classTwo.getDeclaredField(className).get(o2) != null && getCheckNull() != null && getCheckNull()
                                ? -1
                                : 0;
                    }
                }
                Field fieldClassOne = classOne.getDeclaredField(fieldSort.getNameField());
                Field fieldClassTwo = classTwo.getDeclaredField(fieldSort.getNameField());
                fieldClassOne.setAccessible(true);
                fieldClassTwo.setAccessible(true);
                Comparable c1 = (Comparable) fieldClassOne.get(o1);
                Comparable c2 = (Comparable) fieldClassTwo.get(o2);
                int result = c1.compareTo(c2);
                if (result != 0) {
                    return !fieldSort.isReserve()
                            ? result
                            : -result;
                } else {
                    continue;
                }
            }
        } catch (NoSuchFieldException | IllegalArgumentException | IllegalAccessException ex) {
            System.err.println(ex);
        }
        return 0;
    }
    /**Парсер строки**/
    private void parseFields() {
        ArrayList<FieldSort> fieldSorts = new ArrayList<FieldSort>();
        String[] fields = getExpression().split("[,]+");
        for (String field : fields) {
            String[] splitFiels = field.trim().split("[\\s,]+");

            if (splitFiels.length == 1 || splitFiels[1].toLowerCase().equals("asc")) {
                fieldSorts.add(new FieldSort(splitFiels[0], false));
            } else if (splitFiels[1].toLowerCase().equals("desc")) {
                fieldSorts.add(new FieldSort(splitFiels[0], true));
            }
        }
        setFieldSorts(fieldSorts);
    }
}
