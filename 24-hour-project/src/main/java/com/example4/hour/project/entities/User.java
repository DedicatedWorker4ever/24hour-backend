package com.example4.hour.project.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int userId;

   @Column(nullable = false,length = 30)
    String username;

    @Column(nullable = false,length = 100)
    String description;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    @JsonManagedReference
   // @JoinColumn(name ="pk_fk", nullable = false)
    List<Post> posts;

    public User(String username, String description) {
        this.username = username;
        this.description = description;
    }

}
