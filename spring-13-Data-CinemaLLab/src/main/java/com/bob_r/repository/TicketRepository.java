package com.bob_r.repository;

import com.bob_r.entity.MovieCinema;
import com.bob_r.entity.Ticket;
import com.bob_r.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TicketRepository extends JpaRepository<Ticket, Long> {

    // ------------------- DERIVED QUERIES ------------------- //

    //Write a derived query to count how many tickets a user bought
    List<Ticket> findAllBySeatNumber(Integer seatNumber);

    //Write a derived query to list all tickets by specific email
    List<Ticket> findAllByUserAccountEndsWithIgnoreCase(User userAccount);

    //Write a derived query to count how many tickets are sold for a specific movie
    List<Ticket> findByMovieNameCinemaMovieContainsIgnoreCase(String name);

    //Write a derived query to list all tickets between a range of dates
    List<Ticket> findAllByDateTimeBetween(LocalDateTime localDateTimeFrom,LocalDateTime localDateTimeEnd);

    // ------------------- JPQL QUERIES ------------------- //

    //Write a JPQL query that returns all tickets are bought from a specific user
    @Query("select t from Ticket t where t.userAccount.account=?1")
    List<Ticket> boughtTickets (@Param("account")String account);
    //Write a JPQL query that returns all tickets between a range of dates
    @Query("select t from Ticket t where t.dateTime between ?1 and ?2")
    List<Ticket> allTicketsRange (@Param("startDate")LocalDateTime startDate,@Param("endDate")LocalDateTime endDate);

    // ------------------- Native QUERIES ------------------- //

    //Write a native query to count the number of tickets a user bought
    @Query(value = "select * from Ticket t where t.User ",nativeQuery = true)
    List<Ticket> userBought();
    //Write a native query to count the number of tickets a user bought in a specific range of dates
    @Query(value = "select * from Ticket t where t.user BETWEEN t.ateTime and t.ateTime",nativeQuery = true)
    List<Ticket> userBoughtRange(@Param("Range")List<Integer> Range);

    //Write a native query to distinct all tickets by movie name
    @Query(value = "select * from Ticket t where t.movieCinema.movie.name",nativeQuery = true)
    List<Ticket> MovieName();

    //Write a native query to find all tickets by user email
    @Query(value = "select * from Ticket t where t.userAccount.email",nativeQuery = true)
    List<Ticket> userEmail();

    //Write a native query that returns all tickets
    @Query(value = "select * from Ticket t ",nativeQuery = true)
    List<Ticket> allTicked();

    //Write a native query to list all tickets where a specific value should be containable in the username or account name or movie name
    @Query(value = "SELECT * FROM Ticket t JOIN MovieCinema mc ON " +
            "mc.cinema_id = t.id JOIN User u ON t.user = u.id " +
            "WHERE l.name = ?1",nativeQuery = true)
    List<Ticket> retrieveAllNameUserNameMOvieNAME(@Param("name") String name);

}
