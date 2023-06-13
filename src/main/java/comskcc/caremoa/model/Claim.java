package comskcc.caremoa.model;

import comskcc.caremoa.model.entity.CareReviewContentsEntity;
import comskcc.caremoa.model.entity.ClaimEntity;
import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Claim {
    private Long id;
    private Long reviewId;
    private ClaimStatus claimStatus;
    private ClaimType claimType;
    private Timestamp registeredAt;
    private Timestamp updatedAt;
    private Timestamp deletedAt;

    public static Claim fromEntity(ClaimEntity claimEntity) {
        return new Claim(
                claimEntity.getId(),
                claimEntity.getReivewId(),
                claimEntity.getClaimStatus(),
                claimEntity.getClaimType(),
                claimEntity.getRegisteredAt(),
                claimEntity.getUpdatedAt(),
                claimEntity.getDeletedAt()
        );
    }
}
