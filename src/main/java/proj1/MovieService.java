package proj1;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.bson.types.ObjectId;

@Service
public class MovieService {

	@Autowired
	private MovieRepository movieRepository;

	public List<Movie> allMovies() {
		return movieRepository.findAll();
	}

	public Optional<Movie> singleMovie(String imdbId) {
		return movieRepository.findMovieByImdbId(imdbId);
	}
}
