package ru.testtask.task3.arguments;

import com.beust.jcommander.Parameter;

public class InputArgumentHolder {

    @Parameter(names = "-testResults", description = "Путь к файлу результата тестов", required = true)
    private String testResults;

    @Parameter(names = "-testStructure", description = "Путь к файлу структуры тестов", required = true)
    private String testStructure;

    @Parameter(names = "-report", description = "Путь к файлу-результату", required = true)
    private String report;

    public String getTestResults() {
        return testResults;
    }

    public String getTestStructure() {
        return testStructure;
    }

    public String getReport() {
        return report;
    }
}