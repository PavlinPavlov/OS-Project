package com.tu.listener;

import java.util.HashMap;
import java.util.Map;

public class StudentData {

    private static Map<String, String> students;

    static {
        students = new HashMap<>();
        students.put("121217001", "Иван Тодоров");
        students.put("121217002", "Атанас Иванов");
        students.put("121217003", "Мария Стефанова");
        students.put("121217004", "Анастасия Димитрова");
        students.put("121217005", "Ива Тошева");
        students.put("121217006", "Иван Боров");
        students.put("121217007", "Страхил Димитров");
        students.put("121217008", "Владимира Иваова");
        students.put("121217009", "Димитър Борисов");
        students.put("121217010", "Георги Красимирова");
        students.put("121217011", "Анна Вирчева");
        students.put("121217012", "Йордан Тинчев");
        students.put("121217013", "Гергана Димитрова");
        students.put("121217014", "Мирослава Георгиева");
        students.put("121217015", "Даниел Петров");
        students.put("121217016", "Вяра Узунова");
        students.put("121217017", "Габриела Георгиева");
        students.put("121217018", "Павел Пенчев");
        students.put("121217019", "Минчо Димитров");
        students.put("121217020", "Яница Мирославова");
    }

    public static String getNameByFacNumber(String facNumber) {
        return students.getOrDefault(facNumber, "Студентът не е намерен");
    }
}
