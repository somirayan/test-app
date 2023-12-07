package com.app.springreact.repository;

import com.app.springreact.model.entity.Meetup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeetupRepository extends JpaRepository<Meetup, Long> {
}
