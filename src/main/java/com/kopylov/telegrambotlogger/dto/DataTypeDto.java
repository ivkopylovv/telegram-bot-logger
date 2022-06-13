package com.kopylov.telegrambotlogger.dto;

import com.kopylov.telegrambotlogger.constants.DataType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
public class DataTypeDto {
    private DataType dataType;
    private String data;
}
