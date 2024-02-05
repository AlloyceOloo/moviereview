package proj1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.core.query.Criteria;

@Service
public class ReviewService {

	@Autowired
	private ReviewRepository reviewRepository;

	@Autowired
	private MongoTemplate mongoTemplate;

	public Review createReviewBy(String reviewBody, String imdbId) {
		Review review = reviewRepository.insert(new Review(reviewBody));

		mongoTemplate.update(Movie.class)
			.matching(Criteria.where("imdbId").is(imdbId))
			.apply(new Update().push("reviewIds", review))
			.first();

		return review;
	}
}
