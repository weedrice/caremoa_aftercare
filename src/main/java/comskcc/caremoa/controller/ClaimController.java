package comskcc.caremoa.controller;

import comskcc.caremoa.controller.request.ClaimCreateRequest;
import comskcc.caremoa.controller.response.ClaimResponse;
import comskcc.caremoa.controller.response.Response;
import comskcc.caremoa.service.ClaimService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/careReviewContents")
@RequiredArgsConstructor
public class ClaimController {

    private final ClaimService claimService;

    @GetMapping("/{reviewId}")
    public Response<ClaimResponse> getByReviewId(@PathVariable("reviewId") Long reviewId) {
        return Response.success(ClaimResponse.fromClaim(claimService.getByReviewId(reviewId)));
    }

    @PostMapping("/{reviewId}")
    public Response<Void> create(@PathVariable Long reviewId, @RequestBody ClaimCreateRequest claimCreateRequest) {
        claimService.create(reviewId, claimCreateRequest);
        return Response.success();
    }

    @PutMapping("/{reviewId}")
    public Response<ClaimResponse> update(@PathVariable Long reviewId, @RequestBody ClaimCreateRequest claimCreateRequest) {
        return Response.success(ClaimResponse.fromClaim(claimService.update(reviewId, claimCreateRequest)));
    }
}
