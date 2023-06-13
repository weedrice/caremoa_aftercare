package comskcc.caremoa.service;

import comskcc.caremoa.controller.request.ClaimCreateRequest;
import comskcc.caremoa.exception.CareReviewException;
import comskcc.caremoa.exception.ErrorCode;
import comskcc.caremoa.model.Claim;
import comskcc.caremoa.model.ClaimStatus;
import comskcc.caremoa.model.ReviewType;
import comskcc.caremoa.model.entity.CareReviewContentsEntity;
import comskcc.caremoa.model.entity.CareReviewEntity;
import comskcc.caremoa.model.entity.ClaimEntity;
import comskcc.caremoa.repository.CareReviewEntityRepository;
import comskcc.caremoa.repository.ClaimRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClaimService {
    private final CareReviewEntityRepository careReviewEntityRepository;
    private final ClaimRepository claimRepository;

    public Claim getByReviewId(Long reviewId) {
        return Claim.fromEntity(getClaimByReviewId(reviewId));
    }

    private ClaimEntity getClaimByReviewId(Long reviewId) {
        return claimRepository.findByReviewId(reviewId).orElseThrow(() ->
                new CareReviewException(ErrorCode.REVIEW_NOT_FOUND, String.format("%s not founded", reviewId)));
    }

    public void create(Long reviewId, ClaimCreateRequest claimCreateRequest) {
        ClaimEntity claimEntity = getClaimByReviewId(reviewId);
        CareReviewEntity careReviewEntity = getCareReviewByReviewId(reviewId);

        claimRepository.save(ClaimEntity.of(reviewId, ClaimStatus.APPLY, claimCreateRequest.getClaimType()));
        careReviewEntity.setReviewType(ReviewType.CLAIM);
        careReviewEntityRepository.saveAndFlush(careReviewEntity);
    }

    private CareReviewEntity getCareReviewByReviewId(Long reviewId) {
        return careReviewEntityRepository.findByReviewId(reviewId).orElseThrow(() ->
                new CareReviewException(ErrorCode.REVIEW_NOT_FOUND, String.format("%s not founded", reviewId)));
    }

    public Claim update(Long reviewId, ClaimCreateRequest claimCreateRequest) {
        ClaimEntity claimEntity = getClaimByReviewId(reviewId);
        CareReviewEntity careReviewEntity = getCareReviewByReviewId(reviewId);

        claimEntity.setClaimType(claimCreateRequest.getClaimType());
        return Claim.fromEntity(claimRepository.saveAndFlush(claimEntity));
    }
}
