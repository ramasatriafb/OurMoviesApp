package ramasatriafb.dicoding.ourmoviesapp;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class GridMovieAdapter extends RecyclerView.Adapter<GridMovieAdapter.GridViewHolder>{

    private ArrayList<MoviesData> movieData;

    public GridMovieAdapter(ArrayList<MoviesData> movieData) {
        this.movieData = movieData;
    }
    @NonNull
    @Override
    public GridViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_grid_movie, viewGroup, false);
        return new GridViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final GridViewHolder holder, int position) {
        Glide.with(holder.itemView.getContext())
                .load(movieData.get(position).getPoster())
                .apply(new RequestOptions().override(350, 550))
                .into(holder.imgPosterMovie);
    }

    @Override
    public int getItemCount() {
        return movieData.size();
    }

    public class GridViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPosterMovie;

        public GridViewHolder(@NonNull View itemView) {
            super(itemView);
            imgPosterMovie = itemView.findViewById(R.id.img_poster_movie);
        }
    }
}
