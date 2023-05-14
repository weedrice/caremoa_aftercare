package comskcc.caremoa.controller.response;

import comskcc.caremoa.model.CareReview;
import java.sql.Timestamp;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class CareReviewResponse {
    private Long id;
    private Long contId;
    private Long memberId;

    public static CareReviewResponse fromCareReview(CareReview careReview) {
        return new CareReviewResponse(
                careReview.getId(),
                careReview.getContId(),
                careReview.getMemberId()
        );
    }
}