package Educative.Cricinfo.patterns;

import Educative.Cricinfo.accounts.*;
import Educative.Cricinfo.commentary.News;
import Educative.Cricinfo.matches.*;
import Educative.Cricinfo.teams.*;
import Educative.Cricinfo.tournaments.*;

import java.util.*;

public class CricinfoSystem {
    private static CricinfoSystem instance;
    private final List<Player> players;
    private final List<Team> teams;
    private final List<Match> matches;
    private final List<Tournament> tournaments;
    private final List<News> news;

    private CricinfoSystem() {
        players = new ArrayList<>();
        teams = new ArrayList<>();
        matches = new ArrayList<>();
        tournaments = new ArrayList<>();
        news = new ArrayList<>();
    }

    public static synchronized CricinfoSystem getInstance() {
        if (instance == null) {
            instance = new CricinfoSystem();
        }
        return instance;
    }

    public boolean addPlayer(Player player) { return players.add(player); }
    public boolean addTeam(Team team) { return teams.add(team); }
    public boolean addMatch(Match match) { return matches.add(match); }
    public boolean addTournament(Tournament tournament) { return tournaments.add(tournament); }
    public boolean addNews(News newsItem) { return news.add(newsItem); }

    public List<Player> getPlayers() { return Collections.unmodifiableList(players); }
    public List<Team> getTeams() { return Collections.unmodifiableList(teams); }
    public List<Match> getMatches() { return Collections.unmodifiableList(matches); }
    public List<Tournament> getTournaments() { return Collections.unmodifiableList(tournaments); }
    public List<News> getNews() { return Collections.unmodifiableList(news); }
}
