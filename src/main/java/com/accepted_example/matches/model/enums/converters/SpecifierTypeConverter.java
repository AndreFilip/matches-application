package com.accepted_example.matches.model.enums.converters;

import com.accepted_example.matches.model.enums.SpecifierType;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.stream.Stream;

@Converter(autoApply = true)
public class SpecifierTypeConverter implements AttributeConverter<SpecifierType, String> {

    @Override
    public String convertToDatabaseColumn(SpecifierType specifier) {
        if (specifier == null) {
            return null;
        }
        return specifier.getCode();
    }

    @Override
    public SpecifierType convertToEntityAttribute(String code) {
        if (code == null) {
            return null;
        }
        return Stream.of(SpecifierType.values())
                .filter(c -> c.getCode().equals(code))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
