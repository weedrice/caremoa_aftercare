package comskcc.caremoa.repository;

import comskcc.caremoa.model.entity.CareReviewEntity;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CareReviewEntityRepository extends JpaRepository<CareReviewEntity, Integer> {
    Page<CareReviewEntity> findAllByMemberId(Long memberId, Pageable pageable);
    Optional<CareReviewEntity> findByReviewId(Long reviewId);
}