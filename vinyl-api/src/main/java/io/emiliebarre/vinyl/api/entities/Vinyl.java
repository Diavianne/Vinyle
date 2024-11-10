package io.emiliebarre.vinyl.api.entities;


import jakarta.persistence.*;

@Entity
@Table(name = "t_vinyls")
public class Vinyl {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vinyl_id")
    private Long id;

    @Column(name = "release_title")
    private String title;

    @Column(name = "artist_name")
    private String artist;

    @Column(name = "music_style")
    private String style;

    @Column(name = "release_year")
    private String year;

    @Column(name = "label_name")
    private String label;

    @Column(name = "vinyl_img")
    private String image;

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

    public String getStyle() {
        return style;
    }

    public void setStyle(String genre) {
        this.style = genre;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setImageId(String imageId) {
        this.image = imageId;
    }
}
