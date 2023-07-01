package comskcc.caremoa.controller;

import comskcc.caremoa.controller.request.CareReviewCreateRequest;
import comskcc.caremoa.controller.response.CareReviewResponse;
import comskcc.caremoa.controller.response.Response;
import comskcc.caremoa.service.CareReviewService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/careReviews")
@RequiredArgsConstructor
public class CareReviewController {
    private final CareReviewService careReviewService;

    @GetMapping("/{contId}")
    public Response<CareReviewResponse> getByContId(@PathVariable Long contId) throws Exception {
        return Response.success(CareReviewResponse.fromCareReview(careReviewService.getByContId(contId)));
    }

    @PostMapping
    public Response<Void> post(@RequestBody CareReviewCreateRequest request) {
        careReviewService.create(request.getContId(), request.getMemberId(), null);
        return Response.success();
    }

}