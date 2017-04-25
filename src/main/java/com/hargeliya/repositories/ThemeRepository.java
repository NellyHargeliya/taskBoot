package com.hargeliya.repositories;


import com.hargeliya.entities.Theme;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface ThemeRepository extends CrudRepository<Theme, Long> {

    List<Theme> findAll(Sort sort);

    List<Theme> findByResolveDateIsNull(Sort sort);

    @Transactional
    @Modifying
    @Query("update Theme set resolveDate = now() where id = :id")
    int resolveTicket(@Param("id") long id);

    @Transactional
    @Modifying
    @Query("update Theme set resolveDate = null where id = :id")
    int reopenTicket(@Param("id") long id);
}
