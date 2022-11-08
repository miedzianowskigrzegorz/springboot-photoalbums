package pl.gm.albums.service;

import org.springframework.stereotype.Service;
import pl.gm.albums.model.Album;

import java.util.List;


public interface IAlbumService {

    List<Album> listAll();

    void save(Album album);

    Album get(long id);

    void update(Album album);

    void delete(long id);
}

