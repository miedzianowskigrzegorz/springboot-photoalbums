package pl.gm.albums.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="photos")
@Getter
@Setter
@NoArgsConstructor
public class Photo {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long photoId;
    private String path;
    private String fileName;

    @ManyToOne
    private Album album;

    public Photo(String path, String fileName) {
        this.path = path;
        this.fileName = fileName;
    }
}
