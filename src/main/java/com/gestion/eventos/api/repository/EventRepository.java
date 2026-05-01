package com.gestion.eventos.api.repository;

import com.gestion.eventos.api.domain.Event;
import lombok.NonNull;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;


public interface EventRepository extends JpaRepository<Event, Long> {

    Page<Event> findByNameContainingIgnoreCase(String name, Pageable pageable);

    @Query("Select e from Event e Join Fetch e.category Left Join Fetch e.speakers")
    List<Event> findAllWithCategoryAndSpeaker();

    @Query("Select e from Event e Join Fetch e.category Left Join Fetch e.speakers Where e.id = :id")
    Optional<Event> findByIdWithCategoryAndSpeaker(Long id);

    @Override
    @NonNull
    @EntityGraph(attributePaths = {"category", "speakers"})
    List<Event> findAll();

    @Override
    @NonNull
    @EntityGraph(attributePaths = {"category", "speakers"})
    Optional<Event> findById(Long id);

    @EntityGraph(attributePaths = {"category", "speakers", "attendedUsers"})
    @Query("Select e From Event e")
    List<Event> findAllWithAllDetails();


}
