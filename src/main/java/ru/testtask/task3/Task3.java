package ru.testtask.task3;

import com.beust.jcommander.JCommander;
import ru.testtask.task3.arguments.InputArgumentHolder;
import ru.testtask.task3.service.FileReaderService;
import ru.testtask.task3.service.FileWriterService;

import java.io.IOException;

public class Task3 {
    public static void main(String[] args) throws IOException {
        InputArgumentHolder inputArgumentHolder = new InputArgumentHolder();
        JCommander.newBuilder()
                .addObject(inputArgumentHolder)
                .build()
                .parse(args);

        var resultDto = new FileReaderService().readResultDto(inputArgumentHolder.getTestResults());
        var structureDto = new FileReaderService().readStructureValueDto(inputArgumentHolder.getTestStructure());

        new FileWriterService().writeReport(inputArgumentHolder.getReport(), resultDto, structureDto);
    }
}
