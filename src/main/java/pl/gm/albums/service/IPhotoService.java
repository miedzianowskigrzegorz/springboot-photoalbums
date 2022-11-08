package pl.gm.albums.service;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pl.gm.albums.model.Photo;

import java.util.List;


public interface IPhotoService {

    List<Photo> listAll();

    void save(Photo photo);

    Photo get(long id);

    void update(Photo photo);

    void delete(long id);

    void savePhotoImage(Photo photoDTO, MultipartFile imageFile);
}
