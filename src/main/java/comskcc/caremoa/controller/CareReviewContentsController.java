package comskcc.caremoa.controller;

import comskcc.caremoa.controller.request.CareReviewContentsCreateRequest;
import comskcc.caremoa.controller.response.CareReviewContentsResponse;
import comskcc.caremoa.controller.response.Response;
import comskcc.caremoa.service.CareReviewContentsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/careReviewContents")
@RequiredArgsConstructor
public class CareReviewContentsController {

    private final CareReviewContentsService careReviewContentsService;

    @GetMapping("/{reviewId}")
    public Response<CareReviewContentsResponse> getByReviewId(@PathVariable("reviewId") Long reviewId) {
        return Response.success(CareReviewContentsResponse.fromCareReviewContents(careReviewContentsService.getByReviewId(reviewId)));
    }

    @PostMapping("/{reviewId}")
    public Response<Void> create(@PathVariable Long reviewId, @RequestBody CareReviewContentsCreateRequest careReviewContentsCreateRequest) {
        careReviewContentsService.create(reviewId, careReviewContentsCreateRequest);
        return Response.success();
    }
}
