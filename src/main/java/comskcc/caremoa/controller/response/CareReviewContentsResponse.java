package comskcc.caremoa.controller.response;

import comskcc.caremoa.model.CareReviewContents;
import comskcc.caremoa.model.LikeType;
import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CareReviewContentsResponse {
    private Long id;
    private Long reviewId;
    private String contents;
    private LikeType likeType;
    private Timestamp registeredAt;
    private Timestamp updatedAt;
    private Timestamp deletedAt;

    public static CareReviewContentsResponse fromCareReviewContents(CareReviewContents careReviewContents) {
        return new CareReviewContentsResponse(
                careReviewContents.getId(),
                careReviewContents.getReviewId(),
                careReviewContents.getContents(),
                careReviewContents.getLikeType(),
                careReviewContents.getRegisteredAt(),
                careReviewContents.getUpdatedAt(),
                careReviewContents.getDeletedAt()
        );
    }
}
