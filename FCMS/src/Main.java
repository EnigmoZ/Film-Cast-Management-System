import Services.*;
import Models.*;


import java.util.*;
import java.sql.SQLException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        FilmsServices filmService = new FilmsServices();
        ActorsServices actorService = new ActorsServices();
        RolesServices roleService = new RolesServices();
        DirectorsServices directorService = new DirectorsServices();
        StudiosServices studioService = new StudiosServices();
        AwardsServices awardService = new AwardsServices();
        ReviewsServices reviewService = new ReviewsServices();
        UsersServices userService = new UsersServices();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Film");
            System.out.println("2. List Films");
            System.out.println("3. Search Film by Title");
            System.out.println("4. List Films by Genre");
            System.out.println("5. Add Actor");
            System.out.println("6. List Actors");
            System.out.println("7. Search Actor by Name");
            System.out.println("8. List Actors by Nationality");
            System.out.println("9. Update Actor Nationality");
            System.out.println("10. Delete Actor");
            System.out.println("11. Add Role");
            System.out.println("12. List Roles by Film");
            System.out.println("13. Add Director");
            System.out.println("14. List Directors");
            System.out.println("15. Search Director by Name");
            System.out.println("16. Update Director");
            System.out.println("17. Delete Director");
            System.out.println("18. Add Studio");
            System.out.println("19. List Studios");
            System.out.println("20. Search Studio by Name");
            System.out.println("21. Update Studio");
            System.out.println("22. Delete Studio");
            System.out.println("23. Add Award");
            System.out.println("24. List Awards");
            System.out.println("25. Search Award by Name");
            System.out.println("26. Update Award");
            System.out.println("27. Delete Award");
            System.out.println("28. Add Review");
            System.out.println("29. List Reviews");
            System.out.println("30. Search Review by ID");
            System.out.println("31. Update Review");
            System.out.println("32. Delete Review");
            System.out.println("33. Add User");
            System.out.println("34. List Users");
            System.out.println("35. Search User by Username");
            System.out.println("36. Update User");
            System.out.println("37. Delete User");
            System.out.println("38. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            try {
                switch (choice) {
                    case 1:
                        System.out.println("Enter title:");
                        String title = scanner.nextLine();
                        System.out.println("Enter genre:");
                        String genre = scanner.nextLine();
                        System.out.println("Enter release year:");
                        int year = scanner.nextInt();
                        System.out.println("Enter director ID:");
                        int directorId = scanner.nextInt();
                        System.out.println("Enter studio ID:");
                        int studioId = scanner.nextInt();
                        Films film = new Films();
                        film.setTitle(title);
                        film.setGenre(genre);
                        film.setRelease_year(year);
                        film.setDirector_id(directorId);
                        film.setStudio_id(studioId);
                        filmService.addFilm(film);
                        break;
                    case 2:
                        for (Films f : filmService.getAllFilms()) {
                            System.out.println(f.getTitle() + " (" + f.getRelease_year() + ")");
                        }
                        break;
                    case 3:
                        System.out.println("Enter film title:");
                        String searchTitle = scanner.nextLine();
                        Films searchFilm = filmService.searchFilmByTitle(searchTitle);
                        if (searchFilm != null) {
                            System.out.println("Film Found: " + searchFilm.getTitle() + " (" + searchFilm.getRelease_year() + ")");
                        } else {
                            System.out.println("Film not found");
                        }
                        break;
                    case 4:
                        System.out.println("Enter genre:");
                        String searchGenre = scanner.nextLine();
                        for (Films f : filmService.getFilmsByGenre(searchGenre)) {
                            System.out.println(f.getTitle() + " (" + f.getRelease_year() + ")");
                        }
                        break;
                    // Implement other cases similarly...


                    case 5:
                        System.out.println("Enter actor name:");
                        String actorName = scanner.nextLine();
                        System.out.println("Enter actor nationality:");
                        String actorNationality = scanner.nextLine();
                        Actors actor = new Actors();
                        actor.setName(actorName);
                        actor.setNationality(actorNationality);
                        actorService.addActor(actor);
                        break;
                    case 6:
                        for (Actors a : actorService.getAllActors()) {
                            System.out.println(a.getName() + " (" + a.getNationality() + ")");
                        }
                        break;
                    case 7:
                        System.out.println("Enter actor name:");
                        String searchActorName = scanner.nextLine();
                        Actors searchActor = actorService.searchActorByName(searchActorName);
                        if (searchActor != null) {
                            System.out.println("Actor Found: " + searchActor.getName() + " (" + searchActor.getNationality() + ")");
                        } else {
                            System.out.println("Actor not found");
                        }
                        break;
                    case 8:
                        System.out.println("Enter nationality:");
                        String nationality = scanner.nextLine();
                        for (Actors a : actorService.getActorsByNationality(nationality)) {
                            System.out.println(a.getName() + " (" + a.getNationality() + ")");
                        }
                        break;
//                    case 9:
//                        System.out.println("Enter actor ID:");
//                        int actorId = scanner.nextInt();
//                        scanner.nextLine(); // Consume newline
//                        System.out.println("Enter new nationality:");
//                        String newNationality = scanner.nextLine();
//                        actorService.updateActorNationality(actorId, newNationality);
//                        break;
                    case 10:
                        System.out.println("Enter actor ID:");
                        int deleteActorId = scanner.nextInt();
                        actorService.deleteActors(deleteActorId);
                        break;
                    case 11:
                        System.out.println("Enter film ID:");
                        int filmId = scanner.nextInt();
                        System.out.println("Enter actor ID:");
                        int roleActorId = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        System.out.println("Enter role name:");
                        String roleName = scanner.nextLine();
                        Roles role = new Roles();
                        role.setFilm_id(filmId);
                        role.setActor_id(roleActorId);
                        role.setRole_name(roleName);
                        roleService.addRole(role);
                        break;
                    case 12:
                        System.out.println("Enter film ID:");
                        int roleFilmId = scanner.nextInt();
                        for (Roles r : roleService.getRolesByFilmId(roleFilmId)) {
                            System.out.println(r.getRole_name() + " (Actor ID: " + r.getActor_id() + ")");
                        }
                        break;
                    case 13:
                        System.out.println("Enter director name:");
                        String directorName = scanner.nextLine();
                        System.out.println("Enter director dob:");
                        String directorDob = scanner.nextLine();
                        System.out.println("Enter director nationality:");
                        String directorNationality = scanner.nextLine();
                        Directors director = new Directors();
                        director.setName(directorName);
                        director.setDob(directorDob);
                        director.setNationality(directorNationality);
                        directorService.addDirector(director);
                        break;
                    case 14:
                        for (Directors d : directorService.getAllDirectors()) {
                            System.out.println(d.getName());
                        }
                        break;
                    case 15:
                        System.out.println("Enter director name:");
                        String searchDirectorName = scanner.nextLine();
                        Directors searchDirector = directorService.searchDirectorByName(searchDirectorName);
                        if (searchDirector != null) {
                            System.out.println("Director Found: " + searchDirector.getName());
                        } else {
                            System.out.println("Director not found");
                        }
                        break;
                    case 16:
                        System.out.println("Enter director ID:");
                        int updateDirectorId = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        System.out.println("Enter new director name:");
                        String updateDirectorName = scanner.nextLine();
                        Directors updateDirector = new Directors();
                        updateDirector.setId(updateDirectorId);
                        updateDirector.setName(updateDirectorName);
                        directorService.updateDirector(updateDirector);
                        break;
                    case 17:
                        System.out.println("Enter director ID:");
                        int deleteDirectorId = scanner.nextInt();
                        directorService.deleteDirector(deleteDirectorId);
                        break;
                    case 18:
                        System.out.println("Enter studio name:");
                        String studioName = scanner.nextLine();

                        System.out.println("Enter studio country:");
                        String studioCountry = scanner.nextLine();
                        Studios studio = new Studios();
                        studio.setName(studioName);
                        studio.setCountry(studioCountry);

                        studioService.addStudio(studio);
                        break;
                    case 19:
                        for (Studios s : studioService.getAllStudios()) {
                            System.out.println(s.getName());
                        }
                        break;
                    case 20:
                        System.out.println("Enter studio name:");
                        String searchStudioName = scanner.nextLine();
                        Studios searchStudio = studioService.searchStudioByName(searchStudioName);
                        if (searchStudio != null) {
                            System.out.println("Studio Found: " + searchStudio.getName());
                        } else {
                            System.out.println("Studio not found");
                        }
                        break;
                    case 21:
                        System.out.println("Enter studio ID:");
                        int updateStudioId = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        System.out.println("Enter new studio name:");
                        String updateStudioName = scanner.nextLine();
                        Studios updateStudio = new Studios();
                        updateStudio.setId(updateStudioId);
                        updateStudio.setName(updateStudioName);
                        studioService.updateStudio(updateStudio);
                        break;
                    case 22:
                        System.out.println("Enter studio ID:");
                        int deleteStudioId = scanner.nextInt();
                        studioService.deleteStudio(deleteStudioId);
                        break;
                    case 23:
                        System.out.println("Enter award name:");
                        String awardName = scanner.nextLine();
                        Awards award = new Awards();
                        award.setName(awardName);
                        awardService.addAward(award);
                        break;
                    case 24:
                        for (Awards a : awardService.getAllAwards()) {
                            System.out.println(a.getName());
                        }
                        break;
                    case 25:
                        System.out.println("Enter award name:");
                        String searchAwardName = scanner.nextLine();
                        Awards searchAward = awardService.searchAwardByName(searchAwardName);
                        if (searchAward != null) {
                            System.out.println("Award Found: " + searchAward.getName());
                        } else {
                            System.out.println("Award not found");
                        }
                        break;
                    case 26:
                        System.out.println("Enter award ID:");
                        int updateAwardId = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        System.out.println("Enter new award name:");
                        String updateAwardName = scanner.nextLine();
                        Awards updateAward = new Awards();
                        updateAward.setId(updateAwardId);
                        updateAward.setName(updateAwardName);
                        awardService.updateAward(updateAward);
                        break;
                    case 27:
                        System.out.println("Enter award ID:");
                        int deleteAwardId = scanner.nextInt();
                        awardService.deleteAward(deleteAwardId);
                        break;
                    case 28:
                        System.out.println("Enter film ID:");
                        int reviewFilmId = scanner.nextInt();
                        System.out.println("Enter user ID:");
                        int reviewUserId = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        System.out.println("Enter review comment:");
                        String reviewComment = scanner.nextLine();
                        System.out.println("Enter rating:");
                        int rating = scanner.nextInt();
                        Reviews review = new Reviews();
                        review.setFilmId(reviewFilmId);
                        review.setUserId(reviewUserId);
                        review.setComment(reviewComment);
                        review.setRating(rating);
                        reviewService.addReview(review);
                        break;
                    case 29:
                        for (Reviews r : reviewService.getAllReviews()) {
                            System.out.println(r.getComment() + " (Rating: " + r.getRating() + ")");
                        }
                        break;
                    case 30:
                        System.out.println("Enter review ID:");
                        int searchReviewId = scanner.nextInt();
                        Reviews searchReview = reviewService.searchReviewById(searchReviewId);
                        if (searchReview != null) {
                            System.out.println("Review Found: " + searchReview.getComment() + " (Rating: " + searchReview.getRating() + ")");
                        } else {
                            System.out.println("Review not found");
                        }
                        break;
                    case 31:
                        System.out.println("Enter review ID:");
                        int updateReviewId = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        System.out.println("Enter new review content:");
                        String updateReviewContent = scanner.nextLine();
                        System.out.println("Enter new rating:");
                        int updateReviewRating = scanner.nextInt();
                        Reviews updateReview = new Reviews();
                        updateReview.setId(updateReviewId);
                        updateReview.setComment(updateReviewContent);
                        updateReview.setRating(updateReviewRating);
                        reviewService.updateReview(updateReview);
                        break;
                    case 32:
                        System.out.println("Enter review ID:");
                        int deleteReviewId = scanner.nextInt();
                        reviewService.deleteReview(deleteReviewId);
                        break;
                    case 33:
                        System.out.println("Enter username:");
                        String username = scanner.nextLine();
                        System.out.println("Enter email:");
                        String email = scanner.nextLine();
                        Users user = new Users();
                        user.setUsername(username);
                        user.setEmail(email);
                        userService.addUser(user);
                        break;
                    case 34:
                        for (Users u : userService.getAllUsers()) {
                            System.out.println(u.getUsername() + " (" + u.getEmail() + ")");
                        }
                        break;
                    case 35:
                        System.out.println("Enter username:");
                        String searchUsername = scanner.nextLine();
                        Users searchUser = userService.searchUserByUsername(searchUsername);
                        if (searchUser != null) {
                            System.out.println("User Found: " + searchUser.getUsername() + " (" + searchUser.getEmail() + ")");
                        } else {
                            System.out.println("User not found");
                        }
                        break;
                    case 36:
                        System.out.println("Enter user ID:");
                        int updateUserId = scanner.nextInt();
                        scanner.nextLine(); // Consume newline
                        System.out.println("Enter new username:");
                        String updateUsername = scanner.nextLine();
                        System.out.println("Enter new email:");
                        String updateEmail = scanner.nextLine();
                        Users updateUser = new Users();
                        updateUser.setId(updateUserId);
                        updateUser.setUsername(updateUsername);
                        updateUser.setEmail(updateEmail);
                        userService.updateUser(updateUser);
                        break;
                    case 37:
                        System.out.println("Enter user ID:");
                        int deleteUserId = scanner.nextInt();
                        userService.deleteUser(deleteUserId);
                        break;

                    case 38:
                        System.exit(0);
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }



    }
}