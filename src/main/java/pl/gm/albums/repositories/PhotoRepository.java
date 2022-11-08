package pl.gm.albums.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.gm.albums.model.Photo;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface PhotoRepository extends JpaRepository<Photo, Long> {

    @Query("SELECT p FROM Photo p WHERE p.fileName = :fileName")
    Photo getPhotoByFileName(@Param("fileName") String fileName);
}