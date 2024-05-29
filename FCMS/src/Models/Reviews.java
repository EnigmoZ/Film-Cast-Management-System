package Models;

public class Reviews {
    private int id;
    private int filmId;
    private int userId;
    private int rating;
    private String comment;
    private int reviewDate;

    public Reviews(){

    }
    public Reviews(int id, int filmId, int userId,int rating,String comment,int reviewDate){
        this.id = id;
        this.filmId = filmId;
        this.userId = userId;
        this.rating = rating;
        this.comment = comment;
        this.reviewDate = reviewDate;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getReviewDate() {
        return reviewDate;
    }

    public void setReviewDate(int reviewDate) {
        this.reviewDate = reviewDate;
    }

    @Override
    public String toString() {
        return "Reviews{" +
                "id=" + id +
                ", filmId=" + filmId +
                ", userId=" + userId +
                ", rating=" + rating +
                ", comment='" + comment + '\'' +
                ", reviewDate=" + reviewDate +
                '}';
    }
}
