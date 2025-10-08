package Educative.Cricinfo.accounts;

import Educative.Cricinfo.commentary.*;
import Educative.Cricinfo.matches.*;
import Educative.Cricinfo.patterns.*;
import Educative.Cricinfo.stats.*;
import Educative.Cricinfo.teams.*;
import Educative.Cricinfo.tournaments.*;

import java.util.UUID;

public class Admin {
    private final UUID id;
    private final String name;

    public Admin(String name) {
        this.id = UUID.randomUUID();
        this.name = name;
    }

    public boolean addPlayer(Player player) {
        CricinfoSystem system = CricinfoSystem.getInstance();
        for (Player p : system.getPlayers()) {
            if (p.getId().equals(player.getId())) {
                return false;
            }
        }
        return system.addPlayer(player);
    }

    public boolean addTeam(Team team) {
        CricinfoSystem system = CricinfoSystem.getInstance();
        for (Team t : system.getTeams()) {
            if (t.getId().equals(team.getId())) {
                return false;
            }
        }
        return system.addTeam(team);
    }

    public boolean addMatch(Match match) {
        CricinfoSystem system = CricinfoSystem.getInstance();
        for (Match m : system.getMatches()) {
            if (m.getId().equals(match.getId())) {
                return false;
            }
        }
        return system.addMatch(match);
    }

    public boolean addTournament(Tournament tournament) {
        CricinfoSystem system = CricinfoSystem.getInstance();
        for (Tournament t : system.getTournaments()) {
            if (t.getId().equals(tournament.getId())) {
                return false;
            }
        }
        return system.addTournament(tournament);
    }

    public boolean addStats(Stat stats) {
        CricinfoSystem system = CricinfoSystem.getInstance();

        if (stats instanceof PlayerStat) {
            PlayerStat ps = (PlayerStat) stats;
            // Find the player by unique stat key (e.g., ranking, or you may add a playerId in PlayerStat)
            for (Player player : system.getPlayers()) {
                // Here, you should ideally have a player ID or reference in PlayerStat
                // For demo, let's update the first player with matching ranking (not ideal, but for illustration)
                if (player.getStat().getRanking() == ps.getRanking()) {
                    player.setStat(ps);
                    return true;
                }
            }
        } else if (stats instanceof TeamStat) {
            TeamStat ts = (TeamStat) stats;
            // Similar logic: you may want to add a teamId in TeamStat for proper association
            for (Team team : system.getTeams()) {
                if (team.getStats().getTotalSixes() == ts.getTotalSixes()) {
                    team.setStats(ts);
                    return true;
                }
            }
        } else if (stats instanceof MatchStat) {
            MatchStat ms = (MatchStat) stats;
            // Again, you may want to add a matchId in MatchStat for proper association
            for (Match match : system.getMatches()) {
                // For demo, let's update the first match with matching winPercentage
                if (!match.getStats().isEmpty() && match.getStats().get(0).getWinPercentage() == ms.getWinPercentage()) {
                    match.getStats().set(0, ms);
                    return true;
                }
            }
        } else if (stats instanceof TournamentStat) {
            TournamentStat ts = (TournamentStat) stats;
            // Add logic to find and update tournament stats if you associate TournamentStat with Tournament
            for (Tournament tournament : system.getTournaments()) {
                // For demo, you can add a get/set for TournamentStat in Tournament
                // Not implemented in the base code, but you can extend Tournament to hold TournamentStat
                // tournament.setStat(ts);
                // return true;
            }
        }
        return false;
    }

    public boolean addNews(News news) {
        CricinfoSystem system = CricinfoSystem.getInstance();
        for (News n : system.getNews()) {
            if (n.getId().equals(news.getId())) {
                return false;
            }
        }
        return system.addNews(news);
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }
}
