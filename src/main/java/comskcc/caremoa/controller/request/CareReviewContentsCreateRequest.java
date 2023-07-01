package comskcc.caremoa.controller.request;

import comskcc.caremoa.model.LikeType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CareReviewContentsCreateRequest {
    private Long reviewId;
    private Long contId;
    private String contents;
    private LikeType likeType;
}
