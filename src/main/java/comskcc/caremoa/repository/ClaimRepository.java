package comskcc.caremoa.repository;

import comskcc.caremoa.model.entity.ClaimEntity;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClaimRepository extends JpaRepository<ClaimEntity, Long> {
    Optional<ClaimEntity> findByReviewId(Long reviewId);
}
