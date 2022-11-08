package pl.gm.albums.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import pl.gm.albums.model.Photo;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AlbumDto {

    private Long id;
    private String albumTitle;
    private Photo albumMainPhoto;
    private List<Photo> photos;
}

