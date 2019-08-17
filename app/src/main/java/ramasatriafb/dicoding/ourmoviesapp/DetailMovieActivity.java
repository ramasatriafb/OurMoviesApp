package ramasatriafb.dicoding.ourmoviesapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailMovieActivity extends AppCompatActivity {
    //Inisialisasi extra intent
    public static final String EXTRA_MOVIE = "extra_movie";

    //inisialisasi obyek detail activity
    private ImageView posterMovie;
    TextView titleMovie;
    TextView releaseDateMovie;
    TextView genreMovie;
    TextView ratingMovie;
    TextView synopsisMovie;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_movie);

        //mengaktifikan actionbar back home
        if (getSupportActionBar() !=null ){
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        posterMovie = findViewById(R.id.img_poster);
        titleMovie = findViewById(R.id.txt_title);
        releaseDateMovie = findViewById(R.id.txt_releaseDate);
        genreMovie = findViewById(R.id.txt_genre);
        ratingMovie = findViewById(R.id.txt_rating);
        synopsisMovie = findViewById(R.id.synopsis);

        //Menerima objek intent dari Main Activity
        MoviesData moviesData = getIntent().getParcelableExtra(EXTRA_MOVIE);

        //Menyeting nilai Obyek Detail Activity dengan nilai Obyek Movie Data dari obyek Intent
        posterMovie.setImageResource(moviesData.getPoster());
        titleMovie.setText(moviesData.getTitle());
        releaseDateMovie.setText(moviesData.getReleaseDate());
        genreMovie.setText(moviesData.getGenre());
        ratingMovie.setText(moviesData.getRating());
        synopsisMovie.setText(moviesData.getSynopsis());
    }
}
