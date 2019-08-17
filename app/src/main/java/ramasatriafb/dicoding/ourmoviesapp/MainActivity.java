package ramasatriafb.dicoding.ourmoviesapp;

import android.content.Intent;
import android.content.res.TypedArray;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    //Inisialisasi atribut Data Movie dan Adapter Movie
    private String[] dataTitle;
    private String[] dataReleaseDate;
    private String[] dataGenre;
    private String[] dataRating;
    private String[] dataSynopsis;
    private TypedArray dataPoster;
    private MovieAdapter movieAdapter;

    //Inisialisasi ArrayList untuk menampung data resource dummy dari String.xml
    private ArrayList<MoviesData> movies;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //memanggil Movie Adapter
        movieAdapter = new MovieAdapter(this);
        ListView listView = findViewById(R.id.lv_list);
        listView.setAdapter(movieAdapter);

        //memanggil fungsi prepareDataMovies()
        prepareDataMovies();
        //memanggul fungsi prepareDataMovies()
        addMovie();


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            //Mengirim Obyek Movie Data dengan Intent Parceable ke Detail Activity
              Intent moveWithObjectIntent = new Intent(MainActivity.this, DetailMovieActivity.class);
              moveWithObjectIntent.putExtra(DetailMovieActivity.EXTRA_MOVIE, movies.get(i));
              startActivity(moveWithObjectIntent);
            }
        });
    }

    //method prepareDataMovies digunakan untuk inisialisasi setiap arraylist yang di awal telah di inisialisasi dari array  data dummy di String.xml
    private void prepareDataMovies() {
        dataPoster = getResources().obtainTypedArray(R.array.data_poster);
        dataTitle = getResources().getStringArray(R.array.data_title);
        dataReleaseDate = getResources().getStringArray(R.array.data_releasedate);
        dataGenre = getResources().getStringArray(R.array.data_genre);
        dataRating = getResources().getStringArray(R.array.data_rating);
        dataSynopsis = getResources().getStringArray(R.array.data_synopsis);

    }

    //method addMovie digunakan untuk menyimpan semua data yangg telah berisi data dummy dalam sebuah array list agar dapat diproses oleh MovieAdapter
    private void addMovie() {
    movies = new ArrayList<>();
        for (int i = 0; i < dataTitle.length; i++) {
            MoviesData moviesData = new MoviesData();
            moviesData.setPoster(dataPoster.getResourceId(i, -1));
            moviesData.setTitle(dataTitle[i]);
            moviesData.setReleaseDate(dataReleaseDate[i]);
            moviesData.setGenre(dataGenre[i]);
            moviesData.setRating(dataRating[i]+"%");
            moviesData.setSynopsis(dataSynopsis[i]);
            movies.add(moviesData);
        }
        movieAdapter.setMoviesData(movies);
    }
}
