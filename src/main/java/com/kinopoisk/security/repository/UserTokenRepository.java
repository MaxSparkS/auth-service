package com.kinopoisk.security.repository;

import com.kinopoisk.security.model.UserToken;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by Maksim Shkurko on 12/13/2017
 *
 * @author m.shkurko
 */
public interface UserTokenRepository extends JpaRepository<UserToken, Long>{
}
