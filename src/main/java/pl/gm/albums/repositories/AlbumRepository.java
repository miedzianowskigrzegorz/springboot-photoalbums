package pl.gm.albums.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.gm.albums.model.Album;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface AlbumRepository extends JpaRepository<Album,Long> {
}
