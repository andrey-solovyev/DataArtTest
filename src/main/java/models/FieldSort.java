package models;

import lombok.Data;
import lombok.NonNull;
/**
 * Класс Поля со свойствами <b>nameField</b>, <b>isReserve</b>.
 * Данный класс хранит в себе поле и свойство сортировки
 * @autor Андрей Соловьем
 */
@Data
public class FieldSort {
    /** Поле свойство */
    @NonNull
    private String nameField;
    /** Поле обратный порядок */
    @NonNull
    private boolean isReserve;
}
