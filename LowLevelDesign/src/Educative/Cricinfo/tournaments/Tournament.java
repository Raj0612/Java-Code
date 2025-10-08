package Educative.Cricinfo.tournaments;

import Educative.Cricinfo.matches.Match;
import Educative.Cricinfo.teams.TournamentSquad;

import java.time.LocalDate;
import java.util.*;

public class Tournament {
    private final UUID id;
    private LocalDate startDate;
    private List<TournamentSquad> teams;
    private List<Match> matches;
    private PointsTable points;

    public Tournament(LocalDate startDate) {
        this.id = UUID.randomUUID();
        this.startDate = startDate;
        this.teams = new ArrayList<>();
        this.matches = new ArrayList<>();
        this.points = new PointsTable(this);
    }

    public boolean addTeam(TournamentSquad team) {
        if (!teams.contains(team)) {
            teams.add(team);
            return true;
        }
        return false;
    }

    public boolean addMatch(Match match) {
        matches.add(match);
        return true;
    }

    public UUID getId() {
        return id;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public List<TournamentSquad> getTeams() {
        return Collections.unmodifiableList(teams);
    }

    public List<Match> getMatches() {
        return Collections.unmodifiableList(matches);
    }

    public PointsTable getPoints() {
        return points;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setPoints(PointsTable points) {
        this.points = points;
    }
}
