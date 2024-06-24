package ru.testtask.task3.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.testtask.task3.dto.results.ResultDto;
import ru.testtask.task3.dto.results.ResultValueDto;
import ru.testtask.task3.dto.structure.StructureDto;
import ru.testtask.task3.dto.structure.StructureValueDto;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.stream.Collectors;

public class FileWriterService {

    public void writeReport(String filePath, ResultDto resultDto, StructureDto structureDto) throws IOException {
        Map<Integer, String> ids = resultDto.getValues().stream().collect(Collectors.toMap(ResultValueDto::getId, ResultValueDto::getValue));
        for (StructureValueDto test : structureDto.getTests()) {
            structureTraversal(test, ids);
        }
        new ObjectMapper().writeValue(new File(filePath), structureDto);
    }

    private void structureTraversal(StructureValueDto value, Map<Integer, String> ids){
        if (value != null){
            value.setValue(ids.get(value.getId()));
        }
        if (value.getValues() != null && !value.getValues().isEmpty()) {
            for (StructureValueDto innerValue : value.getValues()) {
                structureTraversal(innerValue, ids);
            }
        }
    }
}
