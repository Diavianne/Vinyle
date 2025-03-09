package io.emiliebarre.vinyl.api.entities;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "t_vinyls")
public class Vinyl {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vinyl_id")
    @Schema(description = "Identifiant unique du vinyle", example = "1")
    private Long id;

    @Column(name = "release_title")
    @Schema(description = "Titre de l'album", example = "La salsa du démon")
    private String title;

    @Column(name = "artist_name")
    @Schema(description = "Nom de l'artiste ou du groupe", example = "Le Grand Orchestre Du Splendid")
    private String artist;

    @Column(name = "release_year")
    @Schema(description = "Année de sortie du vinyle", example = "1980")
    private String year;

    @Column(name = "vinyl_img")
    @Schema(description = "URL de l'image de la pochette du vinyle", example = "https://example.com/image.jpg")
    private String image;

    public Vinyl() {
    }

    public Vinyl(Long id, String title, String artist, String year, String imageId) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.year = year;
        this.image = imageId;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }


    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }


    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Vinyl{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", artist='" + artist + '\'' +
                ", year='" + year + '\'' +
                '}';
    }


    public void setImageId(String imageId) {
        this.image = imageId;
    }
}
