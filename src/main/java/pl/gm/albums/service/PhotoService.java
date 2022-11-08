package pl.gm.albums.service;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import pl.gm.albums.model.Photo;
import pl.gm.albums.repositories.PhotoRepository;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PhotoService implements IPhotoService {

    private final PhotoRepository photoRepository;

    @Override
    public void savePhotoImage(Photo photo, MultipartFile imageFile) {
        Path currentPath = Paths.get(".");
        Path absolutePath = currentPath.toAbsolutePath();
        photo.setPath(absolutePath + "/src/main/resources/static/photos/");
        byte[] bytes = imageFile.getBytes();
        Path path = Paths.get(photo.getPath() + photo.getFileName());
        Files.write(path, bytes);
    }

    public void removePhotoImage(Photo photo) throws Exception {
        Path path = Paths.get(photo.getPath() + photo.getFileName());
        Files.delete(path);
    }

    @Override
    public List<Photo> listAll() {
        return photoRepository.findAll();
    }

    @Override
    public void save(Photo photo) {
        photoRepository.save(photo);
    }

    @Override
    public Photo get(long id) {
        return photoRepository.getById(id);
    }

    @Override
    public void update(Photo photo) {
        photoRepository.save(photo);
    }

    @Override
    public void delete(long id) {
        photoRepository.deleteById(id);
    }

    public Photo getPhotoByFileName(String fileName) {
        return photoRepository.getPhotoByFileName(fileName);
    }
}
