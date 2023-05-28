package com.bob_r.client;

import com.bob_r.dto.GenreDTO;
import com.bob_r.dto.MovieCinemaDTO;
import com.bob_r.entity.MovieCinema;
import com.bob_r.service.GenreService;
import com.bob_r.service.MovieCinemaService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
public class DemoController {
//
//    private WebClient webClient = WebClient.builder().baseUrl("http://localhost:8080").build();
//
//    private final MovieCinemaService movieCinemaService;
//    private final GenreService genreService;
//
//    public DemoController(MovieCinemaService movieCinemaService, GenreService genreService) {
//        this.movieCinemaService = movieCinemaService;
//        this.genreService = genreService;
//    }
//
//    @GetMapping("/flux-movie-cinemas")
//    public Flux<MovieCinemaDTO> readAllCinemaFlux() {
//
//        return Flux.fromIterable(movieCinemaService.findAll());
//
//    }
//
////    @GetMapping("/mono-movie-cinema/{id}")
////    public Mono<MovieCinema> readById(@PathVariable("id") Long id){
////
////        return Mono.just(movieCinemaRepository.findById(id).get());
////
////    }
//
//    @GetMapping("/mono-movie-cinema/{id}")
//    public ResponseEntity<Mono<MovieCinemaDTO>> readById(@PathVariable("id") Long id) {
//
//        return ResponseEntity.ok(Mono.just(movieCinemaService.findById(id)));
//
//    }
//
//    @PostMapping("/create-genre")
//    public Mono<GenreDTO> createGenre(@RequestBody GenreDTO genre) {
//
//        GenreDTO createdGenre = genreService.save(genre);
//
//        return Mono.just(createdGenre);
////        return Mono.just(genreRepository.save(genre));
//
//    }
//
//    @DeleteMapping("/delete/genre/{id}")
//    public Mono<Void> deleteGenre(@PathVariable("id") Long id) {
//
//        genreService.deleteById(id);
//
//        return Mono.empty();
//    }
//
//
////    ---------------------------WEBCLIENT---------------------------
//
//
//    @GetMapping("/flux")
//    public Flux<MovieCinema> readWithWebClient() {
//
//        return webClient
//                .get()
//                .uri("/flux-movie-cinemas")
//                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE)
//                .retrieve()
//                .bodyToFlux(MovieCinema.class);
//
//    }
//
//
//    @GetMapping("/mono/{id}")
//    public Mono<MovieCinema> readMonoWithWebClient(@PathVariable("id") Long id) {
//
//        return webClient
//                .get()
//                .uri("/mono-movie-cinema/{id}", id)
//                .retrieve()
//                .bodyToMono(MovieCinema.class);
//
//    }
}