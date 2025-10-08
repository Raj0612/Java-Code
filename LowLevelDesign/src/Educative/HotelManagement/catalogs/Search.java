package Educative.HotelManagement.catalogs;

import Educative.HotelManagement.structures.Room;
import Educative.HotelManagement.enums.RoomStyle;

import java.time.LocalDate;
import java.util.List;

public interface Search {
    List<Room> search(RoomStyle style, LocalDate date, int duration);
}
