package Educative.Cricinfo.matches;
import Educative.Cricinfo.accounts.Umpire;
import Educative.Cricinfo.enums.UmpireType;
import Educative.Cricinfo.tournaments.Stadium;

import java.time.LocalDateTime;

public class Test extends Match {
    public Test(LocalDateTime startTime) {
        super(startTime, 90); // 90 overs per day, can be extended
    }
    @Override
    public boolean assignStadium(Stadium stadium) {
        setStadium(stadium);
        return true;
    }
    @Override
    public boolean assignUmpire(Umpire umpire) {
        addUmpire(umpire, UmpireType.FIELD); // Example
        return true;
    }
}

