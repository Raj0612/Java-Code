package Educative.Cricinfo.patterns;

import Educative.Cricinfo.matches.*;

import java.time.LocalDateTime;

public class ConcreteMatchFactory  implements MatchFactory {
    @Override
    public Match createMatch(String type, LocalDateTime startTime) {
        switch (type.toUpperCase()) {
            case "T20": return new T20(startTime);
            case "ODI": return new ODI(startTime);
            case "TEST": return new Test(startTime);
            default: throw new IllegalArgumentException("Unknown Match Type");
        }
    }
}
