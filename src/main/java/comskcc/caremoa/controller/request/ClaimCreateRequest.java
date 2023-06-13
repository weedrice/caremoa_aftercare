package comskcc.caremoa.controller.request;

import comskcc.caremoa.model.ClaimStatus;
import comskcc.caremoa.model.ClaimType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ClaimCreateRequest {
    private Long id;
    private Long reviewId;
    private ClaimStatus claimStatus;
    private ClaimType claimType;
}
