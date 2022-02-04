package com.example4.hour.project.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;


@Data
@Entity
@Table
@NoArgsConstructor
@AllArgsConstructor
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int postId;

    @Column(nullable = false,length = 50)
    String hashTag;

    @Column(nullable = false,length = 240)
    String text;


    @Temporal(TemporalType.DATE)
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    @Column(nullable = false,length = 50)
    Date timestamp;



    @ManyToOne
    @JoinColumn(name="user_id")
    @JsonBackReference
    User user;

    public Post(String hashTag, String text, User user){
        this.hashTag = hashTag;
        this.text = text;
        this.user = user;
    }

    @PrePersist
    private void onCreate() {
        timestamp = new Date();
    }

}
