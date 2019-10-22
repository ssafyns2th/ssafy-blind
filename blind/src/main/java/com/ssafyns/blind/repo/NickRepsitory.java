package com.ssafyns.blind.repo;

import com.ssafyns.blind.model.Nick;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NickRepsitory extends JpaRepository<Nick, Long> {
}
