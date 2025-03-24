package my.gorae.appUniverseServer.transportation.timetable.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashSet;
import java.util.Set;

public class TimetableChecker {
    /**
     * 시간표가 JSON 형식인지 확인한다.
     *
     * @param jsonTimetable 검증할 시간표 JSON 문자열
     * @return 입력된 시간표가 JSON 형식이면 true, 그렇지 않으면 false 반환
     */
    public static boolean isTimetableValid(String jsonTimetable) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            // JSON 파싱 시도 → 문제 없으면 true 반환
            objectMapper.readTree(jsonTimetable);
            return true;
        } catch (JsonProcessingException e) {
            // JSON 파싱 실패 시 false 반환
            return false;
        }
    }
    /**
     * 요일 코드가 0부터 7까지의 숫자로 이루어져 있는지 확인한다.
     *
     * @param dayCode 검증할 요일 코드 문자열
     * @return 입력된 요일 코드가 유효하면 true, 그렇지 않으면 false 반환
     */
    public static boolean isDayCodeValid(String dayCode) {
        // 쉼표로 구분된 값이 0~7이고 중복이 없도록 체크
        String[] codes = dayCode.split(",");
        Set<String> uniqueCodes = new HashSet<>();

        for (String code : codes) {
            if (!code.matches("[0-7]") || !uniqueCodes.add(code)) {
                // 0~7 범위를 벗어나거나 중복된 값이 있으면 false 반환
                return false;
            }
        }
        return true;
    }
}
