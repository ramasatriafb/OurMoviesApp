package ramasatriafb.dicoding.ourmoviesapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

//Menggunakan Base Adapter untuk customisasi adapter agar lebih fleksibel
public class MovieAdapter extends BaseAdapter {

    //Inisialisasi kebutuhan Base Adapter [butuh konstuktor kelas untuk mendapatkan Context dari obyek movie dan array list untuk menampung data movie]
    private final Context context;
    private ArrayList<MoviesData> moviesData;

    //Context Adapter menginisialisasi movies data sebgai obyek array list baru
    MovieAdapter(Context context) {
        this.context = context;
        moviesData = new ArrayList<>();
    }

    //setter untuk mengisi array data movie
    public void setMoviesData(ArrayList<MoviesData> moviesData) {
        this.moviesData = moviesData;
    }

    //getCount untuk mendapatkan informasi banyaknya item movie yang akan ditampilkan
    @Override
    public int getCount() {
        return moviesData.size();
    }

    //getItem untuk
    @Override
    public Object getItem(int i) {
        return moviesData.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    //getView() ini untuk memanggil item_movie untuk proses manipulasi komponen layoutnya untuk menampilkan data movie
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.item_movie, viewGroup, false);
        }
        ViewHolder viewHolder = new ViewHolder(view);
        MoviesData moviesData= (MoviesData) getItem(i);
        viewHolder.bind(moviesData);
        return view;
    }

    private class ViewHolder {

        private final ImageView imgPoster;
        private TextView txtTitle;
        private TextView txtReleaseDate;
        private TextView txtGenre;
        private TextView txtRating;

        ViewHolder(View view) {
            imgPoster = view.findViewById(R.id.img_poster);
            txtTitle = view.findViewById(R.id.txt_title);
            txtReleaseDate = view.findViewById(R.id.txt_releaseDate);
            txtGenre = view.findViewById(R.id.txt_genre);
            txtRating = view.findViewById(R.id.txt_rating);
        }
        void bind(MoviesData moviesData) {
            imgPoster.setImageResource(moviesData.getPoster());
            txtTitle.setText(moviesData.getTitle());
            txtReleaseDate.setText(moviesData.getReleaseDate());
            txtGenre.setText(moviesData.getGenre());
            txtRating.setText(moviesData.getRating());
        }
    }
}
