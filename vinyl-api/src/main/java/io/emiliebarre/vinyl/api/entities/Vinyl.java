package io.emiliebarre.vinyl.api.entities;


import jakarta.persistence.*;

@Entity
@Table(name = "t_vinyls")
public class Vinyl {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "vinyl_id")
    private Long id;
}
