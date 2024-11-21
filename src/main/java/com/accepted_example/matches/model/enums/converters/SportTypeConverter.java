package com.accepted_example.matches.model.enums.converters;

import com.accepted_example.matches.model.enums.SportType;
import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;

import java.util.stream.Stream;

@Converter(autoApply = true)
public class SportTypeConverter implements AttributeConverter<SportType, Short> {

    @Override
    public Short convertToDatabaseColumn(SportType sportType) {
        if (sportType == null) {
            return null;
        }
        return sportType.getCode();
    }

    @Override
    public SportType convertToEntityAttribute(Short code) {
        if (code == null) {
            return null;
        }
        return Stream.of(SportType.values())
                .filter(c -> c.getCode().equals(code))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
