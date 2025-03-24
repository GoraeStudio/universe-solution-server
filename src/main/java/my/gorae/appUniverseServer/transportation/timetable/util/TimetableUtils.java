package my.gorae.appUniverseServer.transportation.timetable.util;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import my.gorae.appUniverseServer.transportation.timetable.dto.time.TimeUnit;

import java.util.List;

public class TimetableUtils {

    public static List<TimeUnit> parseTimetable(String jsonTimetableString) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            // JSON 문자열 → List<TimeUnit> 변환
            List<TimeUnit> timeUnits = objectMapper.readValue(
                    jsonTimetableString,
                    new TypeReference<List<TimeUnit>>() {}
            );

            return timeUnits;
        } catch (Exception e) {
            throw new IllegalArgumentException("JSON 파싱에 실패했습니다: " + e.getMessage());
        }
    }
}
