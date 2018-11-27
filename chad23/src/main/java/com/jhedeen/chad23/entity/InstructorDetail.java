package com.jhedeen.chad23.entity;

import javax.persistence.*;

@Entity
@Table(name = "instructor_detail")
public class InstructorDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "youtube_channel")
    private String youtubeCahnnel;

    @Column(name = "hobby")
    private String hobby;

    public InstructorDetail(int id, String hobby) {
        this.id = id;
        this.hobby = hobby;
    }
}
