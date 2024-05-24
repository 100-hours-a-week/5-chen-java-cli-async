package org.school.kakao.movie;

import org.school.kakao.SummarizingService;
import org.school.kakao.audience.Audience;
import org.school.kakao.audience.AudienceService;
import org.school.kakao.pay.DiscountResult;
import org.school.kakao.pay.DiscountService;

public class MovieController {

    private AudienceService audienceService;
    private MovieService movieService;
    private DiscountService discountService;
    private SummarizingService summarizingService;

    public MovieController(AudienceService audienceService, MovieService movieService, DiscountService discountService, SummarizingService summarizingService) {
        this.audienceService = audienceService;
        this.movieService = movieService;
        this.discountService = discountService;
        this.summarizingService = summarizingService;
    }

    public void start() {
        // 사람 조사
        Audience audience = audienceService.ask();
        // 영화 선택
        MovieDTO movieDTO = movieService.ask(audience);

        DiscountResult discountResult = discountService.discountForMovie(audience, movieDTO);

        summarizingService.summarizeForMovie(movieDTO, discountResult);
    }
}
