package com.kopylov.telegrambotlogger.util;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

@Converter(autoApply = true)
public class EnumConverter implements AttributeConverter<Enum, String> {

    @Override
    public Enum convertToEntityAttribute(String dbData) {
        return convertToEntityAttribute(dbData);
    }

    @Override
    public String convertToDatabaseColumn(Enum attribute) {
        return convertToDatabaseColumn(attribute);
    }

}
