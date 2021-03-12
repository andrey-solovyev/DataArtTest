package models;

import lombok.AllArgsConstructor;
import lombok.Data;
/**
 * Класс TestClass <b>id</b>, <b>name</b>, <b>lastName</b>.
 * Данный класс предназначен для тестов, ведь у нас универсальный компаратор
 * @autor Андрей Соловьем
 */
@Data
@AllArgsConstructor
public class TestClass {
    /** Поле id **/
    private int id;

    /** Поле имя **/
    private String name;

    /** Поле фамилия **/
    private String lastName;
}
