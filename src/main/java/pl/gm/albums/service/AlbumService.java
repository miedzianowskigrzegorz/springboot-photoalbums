package pl.gm.albums.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pl.gm.albums.model.Photo;
import pl.gm.albums.repositories.AlbumRepository;
import pl.gm.albums.model.Album;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AlbumService implements IAlbumService{

    private final AlbumRepository albumRepository;
    private final PhotoService photoService;

    public List<Album> listAll() {
        return albumRepository.findAll();
    }

    public void save(Album album) {
        albumRepository.save(album);
    }

    public Album get(long id) {
        return albumRepository.findById(id).get();
    }

    public void update(Album album) {
        albumRepository.save(album);
    }

    public void delete(long id) {
        albumRepository.deleteById(id);
    }

    public void saveImage(MultipartFile imageFile, Photo photo) throws Exception {
        photoService.savePhotoImage(photo, imageFile);
        photoService.save(photo);
    }
    public void removeMainAlbumPhoto(Album album) throws Exception {
        photoService.removePhotoImage(album.getAlbumMainPhoto());
    }
}
