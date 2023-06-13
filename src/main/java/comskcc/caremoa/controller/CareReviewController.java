package comskcc.caremoa.controller;

import comskcc.caremoa.controller.request.CareReviewCreateRequest;
import comskcc.caremoa.controller.response.CareReviewResponse;
import comskcc.caremoa.controller.response.Response;
import comskcc.caremoa.service.CareReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/careReviews")
@RequiredArgsConstructor
public class CareReviewController {
    private final CareReviewService careReviewService;

    @GetMapping("/my")
    public Response<Page<CareReviewResponse>> my(Long memberId, Pageable pageable) {
        return Response.success(careReviewService.my(memberId, pageable).map(CareReviewResponse::fromCareReview));
    }

    @PostMapping
    public Response<Void> post(@RequestBody CareReviewCreateRequest request) {
        careReviewService.create(request.getContId(), request.getMemberId(), null);
        return Response.success();
    }

}