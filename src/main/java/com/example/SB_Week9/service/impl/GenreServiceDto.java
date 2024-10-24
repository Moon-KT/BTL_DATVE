package com.example.SB_Week9.service.impl;

import com.example.SB_Week9.dto.GenreDto;
import com.example.SB_Week9.entity.Genre;
import com.example.SB_Week9.repository.GenreRepository;
import com.example.SB_Week9.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GenreServiceDto implements GenreService {
    @Autowired
    GenreRepository genreRepository;

    @Override
    public Genre create(GenreDto genreDto) throws Exception {
        Genre genre = new Genre();
        genre.setGenreName(genreDto.getGenreName());
        return genreRepository.save(genre);
    }

    @Override
    public List<Genre> reads() {
        return genreRepository.findAll();
    }

    @Override
    public Genre read(Long genreID) throws Exception {
        Optional<Genre> genre = Optional.ofNullable(genreRepository.findById(genreID))
                .orElseThrow(() -> { return new Exception("Không tìm thấy thể loại có ID: " + genreID);
                });
        return genre.get();
    }

    @Override
    public Genre update(Long genreID, GenreDto genreDto) throws Exception {
        Optional<Genre> genre = Optional.ofNullable(genreRepository.findById(genreID))
                .orElseThrow(() -> { return new Exception("Không tìm thấy thể loại có ID: " + genreID);
                });
        genre.get().setGenreName(genreDto.getGenreName());
        return genre.get();
    }

    @Override
    public void delete(Long genreID) throws Exception {
        Optional<Genre> genre = Optional.ofNullable(genreRepository.findById(genreID))
                .orElseThrow(() -> { return new Exception("Không tìm thấy thể loại có ID: " + genreID);
                });
        genreRepository.delete(genre.get());
    }
}
