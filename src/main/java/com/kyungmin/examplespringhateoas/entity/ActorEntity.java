package com.kyungmin.examplespringhateoas.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@ToString(exclude = "albums")
@Builder //빌더패턴 사용
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="actor")
public class ActorEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String firstName;
    private String lastName;
    private String birthDate;

    @ManyToMany(cascade= CascadeType.ALL)
    @JoinTable(
            name = "actor_album",
            joinColumns = @JoinColumn(name = "actor_id"),
            inverseJoinColumns = @JoinColumn(name = "album_id"))
    private List<AlbumEntity> albums;

    public ActorEntity(String firstName, String lastName, String birthDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthDate = birthDate;
    }
}
