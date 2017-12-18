package com.kinopoisk.security.repository;

import com.kinopoisk.security.model.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Maksim Shkurko on 12/18/2017
 *
 * @author m.shkurko
 */
public interface AutoritiesRepository extends JpaRepository<Authority, Long> {
}
