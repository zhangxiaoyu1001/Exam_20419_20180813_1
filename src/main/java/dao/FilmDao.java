package dao;

import entity.Film;

import java.util.List;

public interface FilmDao {
    public List showAllFilms();
    public boolean addFilm(Film film);

}
