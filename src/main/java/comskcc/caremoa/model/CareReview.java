package comskcc.caremoa.model;

import comskcc.caremoa.model.entity.CareReviewEntity;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CareReview {
    private Long id;
    private Long contId;
    private Long memberId;

    public static CareReview fromEntity(CareReviewEntity entity) {
        return new CareReview(
                entity.getId(),
                entity.getContId(),
                entity.getMemberId()
        );
    }
}