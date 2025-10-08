package Educative.Cricinfo.teams;

import Educative.Cricinfo.accounts.*;
import Educative.Cricinfo.commentary.News;
import Educative.Cricinfo.stats.TeamStat;

import java.util.*;

public class Team {
    private final UUID id;
    private String name;
    private List<Player> players;
    private Coach coach;
    private List<News> news;
    private TeamStat stats;
    private List<TournamentSquad> squads;

    public Team(String name, Coach coach) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.coach = coach;
        this.players = new ArrayList<>();
        this.news = new ArrayList<>();
        this.stats = new TeamStat();
        this.squads = new ArrayList<>();
    }

    public boolean addSquad(TournamentSquad squad) {
        squads.add(squad);
        return true;
    }
    public boolean addPlayer(Player player) {
        if (!players.contains(player)) {
            players.add(player);
            player.addTeam(this);
            return true;
        }
        return false;
    }
    public boolean addNews(News newsItem) {
        news.add(newsItem);
        return true;
    }
    public UUID getId() { return id; }
    public String getName() { return name; }
    public List<Player> getPlayers() { return Collections.unmodifiableList(players); }
    public Coach getCoach() { return coach; }
    public List<News> getNews() { return Collections.unmodifiableList(news); }
    public TeamStat getStats() { return stats; }
    public List<TournamentSquad> getSquads() { return Collections.unmodifiableList(squads); }
    public void setName(String name) { this.name = name; }
    public void setCoach(Coach coach) { this.coach = coach; }
    public void setStats(TeamStat stats) { this.stats = stats; }
}
