package org.example.moviejpaproject.repository;

import org.example.moviejpaproject.entity.Movie;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MovieRepository extends JpaRepository<Movie, Long>{// Q3. JpaRepository<Entity, Long>에서 두 타입은 각각 무엇을 의미하는가? movie -> 이 repository가 관리하는 entity의 타입이다. long -> movie의 기본 키인 id의 자료형 타입이다.
    List<Movie> findByGenre(String genre);
    List<Movie> findByDirectorAndGenre(String director, String genre);
    List<Movie> findByRatingGreaterThanEqualOrderByRatingDesc(Double rating);
    //Q4. JpaRepository에서 기본 제공하는 CRUD 메서드를 5개 이상 찾아 메서드명과 역할을 주석으로 작성하세요.
    /**
     * save(movie) -> movie의 새로운 데이터를 저장하거나 기존 데이터의 변경 내용 다시 반영시킴
     * findAll() -> 전체 영화 조회
     * findById(id)-> id를 통해서 영화 한개 조회하는 기능 Q5. findById()의 반환 타입이 Optional인 이유는 무엇인가? Optional<Movie> 를 반환 한다는 것은 그 id의 영화가 없을 수도 있기 때문이다.
     * existsById(id) -> 해당 영의 id가 존재하는지 확인하는 기능
     * count() -> 전체 영화 개수 조회
     * deleteById(id) -> id랑 같은 영화 삭제하는 기능
     */
}
// Q6. JpaRepository에서 기본 제공하는 메서드와 개발자가 직접 작성하는 Query Method의 차이는 무엇인가? 이미 제공되고 있는 기능을 쓰는지 아니면 필요한 조건을 메서드 이름으로 선언하는의 차이다.