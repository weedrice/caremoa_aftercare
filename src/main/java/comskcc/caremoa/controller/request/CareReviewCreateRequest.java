package comskcc.caremoa.controller.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CareReviewCreateRequest {
    private Long contId;
    private Long memberId;
}
