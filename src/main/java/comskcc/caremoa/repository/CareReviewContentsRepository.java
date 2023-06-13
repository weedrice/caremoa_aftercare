package comskcc.caremoa.repository;

import comskcc.caremoa.model.entity.CareReviewContentsEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CareReviewContentsRepository extends JpaRepository<CareReviewContentsEntity, Long> {

    /**
    +-------------------+----------------------------------------------------+------------------------------------+
    | 메서드 이름 키워드|  샘플                                              |     설명                           |
    +-------------------+----------------------------------------------------+------------------------------------+
    | And               | findByEmailAndUserId(String email, String userId)  | 여러필드를 and 로 검색             |
    | Or                | findByEmailOrUserId(String email, String userId)   | 여러필드를 or 로 검색              |
    | Between           | findByCreatedAtBetween(Date fromDate, Date toDate) | 필드의 두 값 사이에 있는 항목 검색   |
    | LessThan          | findByAgeGraterThanEqual(int age)                  | 작은 항목 검색                    |
    | GreaterThanEqual  | findByAgeGraterThanEqual(int age)                  | 크거나 같은 항목 검색              |
    | Like              | findByNameLike(String name)                        | like 검색                          |
    | IsNull            | findByJobIsNull()                                  | null 인 항목 검색                  |
    | In                | findByJob(String … jobs)                           | 여러 값중에 하나인 항목 검색       |
    | OrderBy           | findByEmailOrderByNameAsc(String email)            | 검색 결과를 정렬하여 전달          |
    +-------------------+----------------------------------------------------+------------------------------------+
     **/
    Optional<CareReviewContentsEntity> findByReviewId(Long reviewId);
}
