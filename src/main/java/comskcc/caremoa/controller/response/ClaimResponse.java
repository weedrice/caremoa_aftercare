package comskcc.caremoa.controller.response;

import comskcc.caremoa.model.Claim;
import comskcc.caremoa.model.ClaimStatus;
import comskcc.caremoa.model.ClaimType;
import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ClaimResponse {
    private Long id;
    private Long reviewId;
    private ClaimStatus claimStatus;
    private ClaimType claimType;
    private Timestamp registeredAt;
    private Timestamp updatedAt;
    private Timestamp deletedAt;

    public static ClaimResponse fromClaim(Claim claim) {
        return new ClaimResponse(
                claim.getId(),
                claim.getReviewId(),
                claim.getClaimStatus(),
                claim.getClaimType(),
                claim.getRegisteredAt(),
                claim.getUpdatedAt(),
                claim.getDeletedAt()
        );
    }
}
