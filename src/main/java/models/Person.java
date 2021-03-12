package models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

import java.util.Date;

/**
 * Класс Человек со свойствами <b>chief</b>, <b>firstName</b>, <b>lastName</b>, <b>born</b>.
 * Данный класс предназначен для тестов
 * @autor Андрей Соловьем
 */
@Data
@AllArgsConstructor
public class Person {
    /** Поле chief **/
    public Person chief;

    /** Поле имя **/
    @NonNull
    public String firstName;

    /** Поле фамилия **/
    @NonNull
    public String lastName;

    /** Поле год рождения **/
    @NonNull
    public Date born;

}
