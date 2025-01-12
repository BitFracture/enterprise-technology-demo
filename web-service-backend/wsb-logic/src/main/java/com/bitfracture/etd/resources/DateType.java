package com.bitfracture.etd.resources;

import com.bitfracture.etd.exceptions.ModelException;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.time.temporal.ChronoUnit;
import java.util.regex.Pattern;

/**
 * Due to the highly variable nature of dates and date time formats, this class applies some additional restrictions
 * to the data shape ensuring a predictable and stable API contract. Something like JSR-310 could be used instead if
 * these restrictions were not desired.
 */
@AllArgsConstructor(staticName = "fromTime")
@Data
public class DateType {
    private static final Pattern VALID_PATTERN = Pattern.compile(
            "^[0-9]{4}-[0-9]{2}-[0-9]{2}T[0-9]{2}:[0-9]{2}:[0-9]{2}(\\.[0-9]{3})?"
            + "((Z)|([+\\-][0-9]{1,2}(:[0-9]{1,2})?))$");

    @NonNull //Todo: Test where this is asserted
    private OffsetDateTime time;

    @JsonValue
    public String serialize() {
        String serial = time
                .truncatedTo(ChronoUnit.MILLIS)
                .format(DateTimeFormatter.ISO_OFFSET_DATE_TIME);
        testRegexMatch(serial);
        return serial;
    }

    @JsonCreator
    public static DateType deserialize(String json) {
        testRegexMatch(json);
        try {
            return new DateType(OffsetDateTime.parse(json, DateTimeFormatter.ISO_OFFSET_DATE_TIME));
        } catch (DateTimeParseException ex) {
            throw new ModelException("Date type was not parsable, value: %s".formatted(json), ex);
        }
    }

    public static DateType now() {
        return new DateType(OffsetDateTime.now());
    }

    private static void testRegexMatch(String formatted) {
        if (!VALID_PATTERN.matcher(formatted).matches()) {
            throw new ModelException(
                    "Date types must match the regular expression '%s' but instead found '%s'"
                            .formatted(VALID_PATTERN.pattern(), formatted));
        }
    }
}
