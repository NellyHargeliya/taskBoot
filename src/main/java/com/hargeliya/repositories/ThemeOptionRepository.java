package com.hargeliya.repositories;


import com.hargeliya.entities.Theme;
import com.hargeliya.entities.ThemeOption;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ThemeOptionRepository extends CrudRepository<ThemeOption, Long> {

    List<ThemeOption> findByTheme(Theme theme);

    @Query(name = "select tc from ThemeOption tc join theme t where t.id = :id")
    List<ThemeOption> findByThemeId(@Param("id") long id);
}
