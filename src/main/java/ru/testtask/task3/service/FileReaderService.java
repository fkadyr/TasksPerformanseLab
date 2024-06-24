package ru.testtask.task3.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.testtask.task3.dto.results.ResultDto;
import ru.testtask.task3.dto.structure.StructureDto;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileReaderService {

    public ResultDto readResultDto(String filePath) throws IOException {
        var json = new String(Files.readAllBytes(Paths.get(filePath)), StandardCharsets.UTF_8);
        return new ObjectMapper().readValue(json, ResultDto.class);
    }

    public StructureDto readStructureValueDto(String filePath) throws IOException {
        var json = new String(Files.readAllBytes(Paths.get(filePath)), StandardCharsets.UTF_8);
        return new ObjectMapper().readValue(json, StructureDto.class);
    }

}
