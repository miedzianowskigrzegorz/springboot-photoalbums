package pl.gm.albums.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name="albums")
@ToString
public class Album {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String albumTitle;

    @OneToOne(cascade = CascadeType.REMOVE)
    private Photo albumMainPhoto;

    @OneToMany(mappedBy="album")
    private List<Photo> photos;

}
