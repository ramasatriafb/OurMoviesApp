package ramasatriafb.dicoding.ourmoviesapp;

import android.os.Parcel;
import android.os.Parcelable;

public class MoviesData implements Parcelable {
    //Inisialisasi data
    public String Title;
    public int Poster;
    public String Genre;
    public String Rating;
    public String ReleaseDate;
    public String Synopsis;

    //getter Title
    public String getTitle() {
        return Title;
    }

    //setter Title
    public void setTitle(String title) {
        Title = title;
    }

    //getter Poster
    public int getPoster() {
        return Poster;
    }
    //setter Poster
    public void setPoster(int poster) {
        Poster = poster;
    }

    //getter Genre
    public String getGenre() {
        return Genre;
    }
    //setterGenre
    public void setGenre(String genre) {
        Genre = genre;
    }

    //getter Rating
    public String getRating() {
        return Rating;
    }
    //setter Rating
    public void setRating(String rating) {
        Rating = rating;
    }

    //getter ReleaseDate
    public String getReleaseDate() {
        return ReleaseDate;
    }
    //setter ReleaseDate
    public void setReleaseDate(String releaseDate) {
        ReleaseDate = releaseDate;
    }

    //getter Synopsis
    public String getSynopsis() {
        return Synopsis;
    }

    //setter Synopsis
    public void setSynopsis(String synopsis) {
        Synopsis = synopsis;
    }


    //implementasi Parcelable pada Obyek MoviesData
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.Title);
        dest.writeInt(this.Poster);
        dest.writeString(this.Genre);
        dest.writeString(this.Rating);
        dest.writeString(this.ReleaseDate);
        dest.writeString(this.Synopsis);
    }

    public MoviesData() {
    }

    protected MoviesData(Parcel in) {
        this.Title = in.readString();
        this.Poster = in.readInt();
        this.Genre = in.readString();
        this.Rating = in.readString();
        this.ReleaseDate = in.readString();
        this.Synopsis = in.readString();
    }

    public static final Creator<MoviesData> CREATOR = new Creator<MoviesData>() {
        @Override
        public MoviesData createFromParcel(Parcel source) {
            return new MoviesData(source);
        }

        @Override
        public MoviesData[] newArray(int size) {
            return new MoviesData[size];
        }
    };
}
