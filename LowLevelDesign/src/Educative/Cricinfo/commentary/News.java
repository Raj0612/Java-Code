package Educative.Cricinfo.commentary;

import Educative.Cricinfo.teams.Team;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

public class News {
    private final UUID id;
    private final LocalDate date;
    private final String text;
    private final List<Byte> image;
    private final Team team;

    public News(LocalDate date, String text, List<Byte> image, Team team) {
        this.id = UUID.randomUUID();
        this.date = date;
        this.text = text;
        this.image = image;
        this.team = team;
    }

    public UUID getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getText() {
        return text;
    }

    public List<Byte> getImage() {
        return image;
    }

    public Team getTeam() {
        return team;
    }
}
