package com.bob_r.service.impl;

import com.bob_r.dto.GenreDTO;
import com.bob_r.entity.Genre;
import com.bob_r.repository.GenreRepository;
import com.bob_r.service.GenreService;
import com.bob_r.util.MapperUtil;
import org.springframework.stereotype.Service;

@Service
public class GenreServiceImpl implements GenreService {

    private final GenreRepository genreRepository;
    private final MapperUtil mapperUtil;

    public GenreServiceImpl(GenreRepository genreRepository, MapperUtil mapperUtil) {
        this.genreRepository = genreRepository;
        this.mapperUtil = mapperUtil;
    }

    @Override
    public GenreDTO save(GenreDTO genreDTO) {
        return mapperUtil.convert(genreRepository.save(mapperUtil.convert(genreDTO, new Genre())), new GenreDTO());
    }

    @Override
    public void deleteById(Long id) {
        Genre genre = genreRepository.findById(id).get();
        genre.setDeleted(true);
        genreRepository.save(genre);
    }

}
