package com.example.whattowatchbeta.IMDB;


import com.example.whattowatchbeta.IMDB.Model.IMDBMovieEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface IMDBMovieEntityRepository extends JpaRepository<IMDBMovieEntity,Long> {

    @Query(value = "select id from public.imdbmovieentity where id =:id" ,nativeQuery = true)
    Optional<String> findBycheckId(String id);

    @Query(value = "select * from imdbmovieentity where ott_available ='false'",nativeQuery = true )
    List<IMDBMovieEntity> getMovieEntityByOTTAvailableFalse();

    @Query(value = "select * from imdbmovieentity where id=:id",nativeQuery = true )
    List<IMDBMovieEntity> getIMDBMovieEntitiesById(String id);

    @Query(value = "select * from imdbmovieentity where id=:imdbId",nativeQuery = true )
    IMDBMovieEntity getIMageAndRating(String imdbId);

}
