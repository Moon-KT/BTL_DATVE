package com.example.SB_Week9.service.impl;

import com.example.SB_Week9.dto.GenreDto;
import com.example.SB_Week9.entity.Genre;
import com.example.SB_Week9.repository.GenreRepository;
import com.example.SB_Week9.service.GenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;
import java.util.Optional;

@Component
public class GenreServiceDto implements GenreService {
    private final GenreRepository genreRepository;

    @Autowired
    public GenreServiceDto(GenreRepository genreRepository) {
        this.genreRepository = genreRepository;
    }

    private GenreDto convertToDto(Genre genre) {
        return GenreDto.builder()
                .genreName(genre.getGenreName())
                .build();
    }

    @Override
    public GenreDto create(GenreDto genreDto) throws Exception {
        Genre genre = Genre.builder()
                .genreName(genreDto.getGenreName())
                .build();
        genreRepository.save(genre);
        return convertToDto(genre);
    }

    @Override
    public List<GenreDto> reads() {
        return genreRepository.findAll().stream().map(this::convertToDto).toList();
    }

    @Override
    public GenreDto read(Long genreID) throws Exception {
        return genreRepository.findById(genreID)
                .map(this::convertToDto)
                .orElseThrow(() -> { return new Exception("Không tìm thấy thể loại có ID: " + genreID);
                });
    }

    @Override
    public GenreDto update(Long genreID, GenreDto genreDto) throws Exception {
        Genre genre = genreRepository.findById(genreID)
                .orElseThrow(() -> { return new Exception("Không tìm thấy thể loại có ID: " + genreID);
                });
        genre.setGenreName(genreDto.getGenreName());
        genreRepository.save(genre);
        return convertToDto(genre);
    }

    @Override
    public void delete(Long genreID) throws Exception {
        if (!genreRepository.existsById(genreID)) {
            throw new Exception("Không tìm thấy thể loại có ID: " + genreID);
        }
        genreRepository.deleteById(genreID);
    }
}
