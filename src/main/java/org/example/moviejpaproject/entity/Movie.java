package org.example.moviejpaproject.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity // Q1. @Entity, @Id, @GeneratedValue는 각각 어떤 역할을 하는가? 이 클래스를 jpa가 관리하는 entity로 지정한다는 뜻이다.
@Table(name = "movies") // 연결할 데이터베이스의 이름을 movies로 한다는 뜻이다.
@EntityListeners(AuditingEntityListener.class)
public class Movie {

    @Id // Q1. @Entity, @Id, @GeneratedValue는 각각 어떤 역할을 하는가? 영화를 만들때 각 영화를 구분해주는 기본 키를 생성해준다.
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Q1. @Entity, @Id, @GeneratedValue는 각각 어떤 역할을 하는가? db의 자동 증가 기능으로서 id를 생성해준다.
    private Long id;
    // Q2. Entity 클래스와 데이터베이스 테이블은 어떻게 연결되는가? 자바에서 만든 movie 객체를 db에서 movie테이블에 저장하고 꺼낼 수 있도록 연결한다.
    @Column(nullable = false, length = 100) // 각각 연결되는 컬럼의 이름 길이 null 여부 허용 같은 것들을 설정할 수 있다.
    private String title;

    @Column(length = 100)
    private String director;

    @Column(length = 50)
    private String genre;

    private Double rating;

    @Column(name = "release_year")
    private Integer releaseYear;

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDirector() {
        return director;
    }

    public String getGenre() {
        return genre;
    }

    public Double getRating() {
        return rating;
    }

    public Integer getReleaseYear() {
        return releaseYear;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public void setReleaseYear(Integer releaseYear) {
        this.releaseYear = releaseYear;
    }

    @CreatedDate
    @Column(name = "created_at", updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }
}