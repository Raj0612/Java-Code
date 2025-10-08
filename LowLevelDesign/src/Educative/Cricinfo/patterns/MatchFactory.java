package Educative.Cricinfo.patterns;

import Educative.Cricinfo.matches.Match;

import java.time.LocalDateTime;

public interface MatchFactory {
    Match createMatch(String type, LocalDateTime startTime);
}
