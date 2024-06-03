import DAO.FilmsDAO;
import Services.*;
import Models.*;


import java.util.*;
import java.sql.SQLException;
import java.util.Scanner;


public class Main {
    public Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
//        FilmsServices filmService = new FilmsServices();
//        ActorsServices actorService = new ActorsServices();
//        RolesServices roleService = new RolesServices();
//        DirectorsServices directorService = new DirectorsServices();
//        StudiosServices studioService = new StudiosServices();
//        AwardsServices awardService = new AwardsServices();
//        ReviewsServices reviewService = new ReviewsServices();
//        UsersServices userService = new UsersServices();
//        Scanner scanner = new Scanner(System.in);
//
//        while (true) {
//            System.out.println("1. Add Film");
//            System.out.println("2. List Films");
//            System.out.println("3. Search Film by Title");
//            System.out.println("4. List Films by Genre");
//            System.out.println("5. Add Actor");
//            System.out.println("6. List Actors");
//            System.out.println("7. Search Actor by Name");
//            System.out.println("8. List Actors by Nationality");
//            System.out.println("9. Update Actor Nationality");
//            System.out.println("10. Delete Actor");
//            System.out.println("11. Add Role");
//            System.out.println("12. List Roles by Film");
//            System.out.println("13. Add Director");
//            System.out.println("14. List Directors");
//            System.out.println("15. Search Director by Name");
//            System.out.println("16. Update Director");
//            System.out.println("17. Delete Director");
//            System.out.println("18. Add Studio");
//            System.out.println("19. List Studios");
//            System.out.println("20. Search Studio by Name");
//            System.out.println("21. Update Studio");
//            System.out.println("22. Delete Studio");
//            System.out.println("23. Add Award");
//            System.out.println("24. List Awards");
//            System.out.println("25. Search Award by Name");
//            System.out.println("26. Update Award");
//            System.out.println("27. Delete Award");
//            System.out.println("28. Add Review");
//            System.out.println("29. List Reviews");
//            System.out.println("30. Search Review by ID");
//            System.out.println("31. Update Review");
//            System.out.println("32. Delete Review");
//            System.out.println("33. Add User");
//            System.out.println("34. List Users");
//            System.out.println("35. Search User by Username");
//            System.out.println("36. Update User");
//            System.out.println("37. Delete User");
//            System.out.println("38. Exit");
//
//            int choice = scanner.nextInt();
//            scanner.nextLine();  // Consume newline
//
//            try {
//                switch (choice) {
//                    case 1:
//                        System.out.println("Enter title:");
//                        String title = scanner.nextLine();
//                        System.out.println("Enter genre:");
//                        String genre = scanner.nextLine();
//                        System.out.println("Enter release year:");
//                        int year = scanner.nextInt();
//                        System.out.println("Enter director ID:");
//                        int directorId = scanner.nextInt();
//                        System.out.println("Enter studio ID:");
//                        int studioId = scanner.nextInt();
//                        Films film = new Films();
//                        film.setTitle(title);
//                        film.setGenre(genre);
//                        film.setRelease_year(year);
//                        film.setDirector_id(directorId);
//                        film.setStudio_id(studioId);
//                        filmService.addFilm(film);
//                        break;
//                    case 2:
//                        for (Films f : filmService.getAllFilms()) {
//                            System.out.println(f.getTitle() + " (" + f.getRelease_year() + ")");
//                        }
//                        break;
//                    case 3:
//                        System.out.println("Enter film title:");
//                        String searchTitle = scanner.nextLine();
//                        Films searchFilm = filmService.searchFilmByTitle(searchTitle);
//                        if (searchFilm != null) {
//                            System.out.println("Film Found: " + searchFilm.getTitle() + " (" + searchFilm.getRelease_year() + ")");
//                        } else {
//                            System.out.println("Film not found");
//                        }
//                        break;
//                    case 4:
//                        System.out.println("Enter genre:");
//                        String searchGenre = scanner.nextLine();
//                        for (Films f : filmService.getFilmsByGenre(searchGenre)) {
//                            System.out.println(f.getTitle() + " (" + f.getRelease_year() + ")");
//                        }
//                        break;
//                    // Implement other cases similarly...
//
//
//                    case 5:
//                        System.out.println("Enter actor name:");
//                        String actorName = scanner.nextLine();
//                        System.out.println("Enter actor nationality:");
//                        String actorNationality = scanner.nextLine();
//                        Actors actor = new Actors();
//                        actor.setName(actorName);
//                        actor.setNationality(actorNationality);
//                        actorService.addActor(actor);
//                        break;
//                    case 6:
//                        for (Actors a : actorService.getAllActors()) {
//                            System.out.println(a.getName() + " (" + a.getNationality() + ")");
//                        }
//                        break;
//                    case 7:
//                        System.out.println("Enter actor name:");
//                        String searchActorName = scanner.nextLine();
//                        Actors searchActor = actorService.searchActorByName(searchActorName);
//                        if (searchActor != null) {
//                            System.out.println("Actor Found: " + searchActor.getName() + " (" + searchActor.getNationality() + ")");
//                        } else {
//                            System.out.println("Actor not found");
//                        }
//                        break;
//                    case 8:
//                        System.out.println("Enter nationality:");
//                        String nationality = scanner.nextLine();
//                        for (Actors a : actorService.getActorsByNationality(nationality)) {
//                            System.out.println(a.getName() + " (" + a.getNationality() + ")");
//                        }
//                        break;
////                    case 9:
////                        System.out.println("Enter actor ID:");
////                        int actorId = scanner.nextInt();
////                        scanner.nextLine(); // Consume newline
////                        System.out.println("Enter new nationality:");
////                        String newNationality = scanner.nextLine();
////                        actorService.updateActorNationality(actorId, newNationality);
////                        break;
//                    case 10:
//                        System.out.println("Enter actor ID:");
//                        int deleteActorId = scanner.nextInt();
//                        actorService.deleteActors(deleteActorId);
//                        break;
//                    case 11:
//                        System.out.println("Enter film ID:");
//                        int filmId = scanner.nextInt();
//                        System.out.println("Enter actor ID:");
//                        int roleActorId = scanner.nextInt();
//                        scanner.nextLine(); // Consume newline
//                        System.out.println("Enter role name:");
//                        String roleName = scanner.nextLine();
//                        Roles role = new Roles();
//                        role.setFilm_id(filmId);
//                        role.setActor_id(roleActorId);
//                        role.setRole_name(roleName);
//                        roleService.addRole(role);
//                        break;
//                    case 12:
//                        System.out.println("Enter film ID:");
//                        int roleFilmId = scanner.nextInt();
//                        for (Roles r : roleService.getRolesByFilmId(roleFilmId)) {
//                            System.out.println(r.getRole_name() + " (Actor ID: " + r.getActor_id() + ")");
//                        }
//                        break;
//                    case 13:
//                        System.out.println("Enter director name:");
//                        String directorName = scanner.nextLine();
//                        System.out.println("Enter director dob:");
//                        String directorDob = scanner.nextLine();
//                        System.out.println("Enter director nationality:");
//                        String directorNationality = scanner.nextLine();
//                        Directors director = new Directors();
//                        director.setName(directorName);
//                        director.setDob(directorDob);
//                        director.setNationality(directorNationality);
//                        directorService.addDirector(director);
//                        break;
//                    case 14:
//                        for (Directors d : directorService.getAllDirectors()) {
//                            System.out.println(d.getName());
//                        }
//                        break;
//                    case 15:
//                        System.out.println("Enter director name:");
//                        String searchDirectorName = scanner.nextLine();
//                        Directors searchDirector = directorService.searchDirectorByName(searchDirectorName);
//                        if (searchDirector != null) {
//                            System.out.println("Director Found: " + searchDirector.getName());
//                        } else {
//                            System.out.println("Director not found");
//                        }
//                        break;
//                    case 16:
//                        System.out.println("Enter director ID:");
//                        int updateDirectorId = scanner.nextInt();
//                        scanner.nextLine(); // Consume newline
//                        System.out.println("Enter new director name:");
//                        String updateDirectorName = scanner.nextLine();
//                        Directors updateDirector = new Directors();
//                        updateDirector.setId(updateDirectorId);
//                        updateDirector.setName(updateDirectorName);
//                        directorService.updateDirector(updateDirector);
//                        break;
//                    case 17:
//                        System.out.println("Enter director ID:");
//                        int deleteDirectorId = scanner.nextInt();
//                        directorService.deleteDirector(deleteDirectorId);
//                        break;
//                    case 18:
//                        System.out.println("Enter studio name:");
//                        String studioName = scanner.nextLine();
//
//                        System.out.println("Enter studio country:");
//                        String studioCountry = scanner.nextLine();
//                        Studios studio = new Studios();
//                        studio.setName(studioName);
//                        studio.setCountry(studioCountry);
//
//                        studioService.addStudio(studio);
//                        break;
//                    case 19:
//                        for (Studios s : studioService.getAllStudios()) {
//                            System.out.println(s.getName());
//                        }
//                        break;
//                    case 20:
//                        System.out.println("Enter studio name:");
//                        String searchStudioName = scanner.nextLine();
//                        Studios searchStudio = studioService.searchStudioByName(searchStudioName);
//                        if (searchStudio != null) {
//                            System.out.println("Studio Found: " + searchStudio.getName());
//                        } else {
//                            System.out.println("Studio not found");
//                        }
//                        break;
//                    case 21:
//                        System.out.println("Enter studio ID:");
//                        int updateStudioId = scanner.nextInt();
//                        scanner.nextLine(); // Consume newline
//                        System.out.println("Enter new studio name:");
//                        String updateStudioName = scanner.nextLine();
//                        Studios updateStudio = new Studios();
//                        updateStudio.setId(updateStudioId);
//                        updateStudio.setName(updateStudioName);
//                        studioService.updateStudio(updateStudio);
//                        break;
//                    case 22:
//                        System.out.println("Enter studio ID:");
//                        int deleteStudioId = scanner.nextInt();
//                        studioService.deleteStudio(deleteStudioId);
//                        break;
//                    case 23:
//                        System.out.println("Enter award name:");
//                        String awardName = scanner.nextLine();
//                        Awards award = new Awards();
//                        award.setName(awardName);
//                        awardService.addAward(award);
//                        break;
//                    case 24:
//                        for (Awards a : awardService.getAllAwards()) {
//                            System.out.println(a.getName());
//                        }
//                        break;
//                    case 25:
//                        System.out.println("Enter award name:");
//                        String searchAwardName = scanner.nextLine();
//                        Awards searchAward = awardService.searchAwardByName(searchAwardName);
//                        if (searchAward != null) {
//                            System.out.println("Award Found: " + searchAward.getName());
//                        } else {
//                            System.out.println("Award not found");
//                        }
//                        break;
//                    case 26:
//                        System.out.println("Enter award ID:");
//                        int updateAwardId = scanner.nextInt();
//                        scanner.nextLine(); // Consume newline
//                        System.out.println("Enter new award name:");
//                        String updateAwardName = scanner.nextLine();
//                        Awards updateAward = new Awards();
//                        updateAward.setId(updateAwardId);
//                        updateAward.setName(updateAwardName);
//                        awardService.updateAward(updateAward);
//                        break;
//                    case 27:
//                        System.out.println("Enter award ID:");
//                        int deleteAwardId = scanner.nextInt();
//                        awardService.deleteAward(deleteAwardId);
//                        break;
//                    case 28:
//                        System.out.println("Enter film ID:");
//                        int reviewFilmId = scanner.nextInt();
//                        System.out.println("Enter user ID:");
//                        int reviewUserId = scanner.nextInt();
//                        scanner.nextLine(); // Consume newline
//                        System.out.println("Enter review comment:");
//                        String reviewComment = scanner.nextLine();
//                        System.out.println("Enter rating:");
//                        int rating = scanner.nextInt();
//                        Reviews review = new Reviews();
//                        review.setFilmId(reviewFilmId);
//                        review.setUserId(reviewUserId);
//                        review.setComment(reviewComment);
//                        review.setRating(rating);
//                        reviewService.addReview(review);
//                        break;
//                    case 29:
//                        for (Reviews r : reviewService.getAllReviews()) {
//                            System.out.println(r.getComment() + " (Rating: " + r.getRating() + ")");
//                        }
//                        break;
//                    case 30:
//                        System.out.println("Enter review ID:");
//                        int searchReviewId = scanner.nextInt();
//                        Reviews searchReview = reviewService.searchReviewById(searchReviewId);
//                        if (searchReview != null) {
//                            System.out.println("Review Found: " + searchReview.getComment() + " (Rating: " + searchReview.getRating() + ")");
//                        } else {
//                            System.out.println("Review not found");
//                        }
//                        break;
//                    case 31:
//                        System.out.println("Enter review ID:");
//                        int updateReviewId = scanner.nextInt();
//                        scanner.nextLine(); // Consume newline
//                        System.out.println("Enter new review content:");
//                        String updateReviewContent = scanner.nextLine();
//                        System.out.println("Enter new rating:");
//                        int updateReviewRating = scanner.nextInt();
//                        Reviews updateReview = new Reviews();
//                        updateReview.setId(updateReviewId);
//                        updateReview.setComment(updateReviewContent);
//                        updateReview.setRating(updateReviewRating);
//                        reviewService.updateReview(updateReview);
//                        break;
//                    case 32:
//                        System.out.println("Enter review ID:");
//                        int deleteReviewId = scanner.nextInt();
//                        reviewService.deleteReview(deleteReviewId);
//                        break;
//                    case 33:
//                        System.out.println("Enter username:");
//                        String username = scanner.nextLine();
//                        System.out.println("Enter email:");
//                        String email = scanner.nextLine();
//                        Users user = new Users();
//                        user.setUsername(username);
//                        user.setEmail(email);
//                        userService.addUser(user);
//                        break;
//                    case 34:
//                        for (Users u : userService.getAllUsers()) {
//                            System.out.println(u.getUsername() + " (" + u.getEmail() + ")");
//                        }
//                        break;
//                    case 35:
//                        System.out.println("Enter username:");
//                        String searchUsername = scanner.nextLine();
//                        Users searchUser = userService.searchUserByUsername(searchUsername);
//                        if (searchUser != null) {
//                            System.out.println("User Found: " + searchUser.getUsername() + " (" + searchUser.getEmail() + ")");
//                        } else {
//                            System.out.println("User not found");
//                        }
//                        break;
//                    case 36:
//                        System.out.println("Enter user ID:");
//                        int updateUserId = scanner.nextInt();
//                        scanner.nextLine(); // Consume newline
//                        System.out.println("Enter new username:");
//                        String updateUsername = scanner.nextLine();
//                        System.out.println("Enter new email:");
//                        String updateEmail = scanner.nextLine();
//                        Users updateUser = new Users();
//                        updateUser.setId(updateUserId);
//                        updateUser.setUsername(updateUsername);
//                        updateUser.setEmail(updateEmail);
//                        userService.updateUser(updateUser);
//                        break;
//                    case 37:
//                        System.out.println("Enter user ID:");
//                        int deleteUserId = scanner.nextInt();
//                        userService.deleteUser(deleteUserId);
//                        break;
//
//                    case 38:
//                        System.exit(0);
//                }
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
        Main main = new Main();
        main.start();
    }

    public void start(){
            Main main = new Main();
            while(true){
                System.out.flush();
                System.out.println("**************** || WELCOME TO FILM CAST MANAGEMENT SYSTEM || ****************");
                System.out.println("\n\t\t\t\t\tLIST OF CHOICES:");
                System.out.println("\n\t\t\t\t\t1. User Options" +
                                    "\n\t\t\t\t\t2. Actor Options" +
//                                    "\n\t\t\t\t\t3. Award Options" +
                                    "\n\t\t\t\t\t3. Director Options" +
                                    "\n\t\t\t\t\t4. Film Options" +
//                                    "\n\t\t\t\t\t6. Role Options" +
                                    "\n\t\t\t\t\t5. Review Options" +
                                    "\n\t\t\t\t\t6. Studio Options" +
                                    "\n\t\t\t\t\t0. Exit");

                int choice = sc.nextInt();
                try {
                    switch (choice) {
                        case 1: main.userOptions();
                            break;
                        case 2: main.actorOptions();
                            break;
//                        case 3: main.awardOptions();
//                            break;
                        case 3: main.directorOptions();
                            break;
                        case 4: main.filmOptions();
                            break;
//                        case 6: main.roleOptions();
//                            break;
                        case 5: main.reviewOptions();
                            break;
                        case 6: main.studioOptions();
                            break;
                        case 0: System.exit(0);
                            break;
                        default:
                            System.out.println("Please enter a valid choice!!");
                            continue;
                    }
                }catch (Exception e){
                    System.out.println("Some error occured! Please continue");
                    continue;
                }
            }
    }

    public void userOptions() {
        UsersServices us = new UsersServices();
        while (true) {
            System.out.flush();
            System.out.println("**************** || WELCOME TO FILM CAST MANAGEMENT SYSTEM || ****************");
            System.out.println("\n\t\t\t\t\tUser Options:");
            System.out.println("\n\t\t\t\t\t1. Add User" +
                    "\n\t\t\t\t\t2. List Users" +
                    "\n\t\t\t\t\t3. Search User" +
                    "\n\t\t\t\t\t4. Update User" +
                    "\n\t\t\t\t\t5. Delete User" +
                    "\n\t\t\t\t\t0. Exit");

            int choice = sc.nextInt();
            try {
                switch (choice) {
                    case 1:
                        System.out.print("\nEnter username: ");
                        String username = sc.next();
                        sc.nextLine();
                        System.out.print("\nEnter email: ");
                        String email = sc.next();
                        sc.nextLine();
                        System.out.print("\nEnter Password: ");
                        String password = sc.next();
                        sc.nextLine();
                        Users user = new Users();
                        user.setUsername(username);
                        user.setEmail(email);
                        us.addUser(user);
                        System.out.println("User Added Successfully!!");
                        break;
                    case 2:
                        for (Users u : us.getAllUsers()) {
                            System.out.println(u.getUsername() + " (" + u.getEmail() + ")");
                        }
                        break;
                    case 3:
                        System.out.println("Enter username:");
                        String searchUsername = sc.next();
                        sc.nextLine();
                        Users searchUser = us.searchUserByUsername(searchUsername);
                        if (searchUser != null) {
                            System.out.println("User Found: " + searchUser.getUsername() + " (" + searchUser.getEmail() + ")");
                        } else {
                            System.out.println("User not found");
                        }
                        break;
                    case 4:
                        System.out.println("Enter user ID:");
                        int updateUserId = sc.nextInt();
                        sc.nextLine(); // Consume newline
                        System.out.println("Enter new username:");
                        String updateUsername = sc.next();
                        sc.nextLine();
                        System.out.println("Enter new email:");
                        String updateEmail = sc.next();
                        sc.nextLine();
                        Users updateUser = new Users();
                        updateUser.setId(updateUserId);
                        updateUser.setUsername(updateUsername);
                        updateUser.setEmail(updateEmail);
                        us.updateUser(updateUser);
                        System.out.println("User Updated Succesfully");
                        break;
                    case 5:
                        System.out.println("Enter user ID:");
                        int deleteUserId = sc.nextInt();
                        us.deleteUser(deleteUserId);
                        System.out.println("User Deleted successfully");
                        break;
                    case 0:
                        return;
                    default:
                        System.out.println("Please enter a valid choice!!");
                        continue;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void actorOptions(){
            ActorsServices as = new ActorsServices();
            while(true){
                System.out.flush();
                System.out.println("**************** || WELCOME TO FILM CAST MANAGEMENT SYSTEM || ****************");
                System.out.println("\n\t\t\t\t\tActor Options:");
                System.out.println("\n\t\t\t\t\t1. Add Actor" +
                        "\n\t\t\t\t\t2. List Actors" +
                        "\n\t\t\t\t\t3. Search Actor" +
                        "\n\t\t\t\t\t4. List Actors by Nationality" +
                        "\n\t\t\t\t\t5. Update Actor" +
                        "\n\t\t\t\t\t6. Delete Actor" +
                        "\n\t\t\t\t\t0. Exit");

                int choice = sc.nextInt();
                try {
                    switch (choice) {
                        case 1: System.out.println("Enter actor name:");
                            String actorName = sc.next();
                            sc.nextLine();
                            System.out.println("Enter DOB: ");
                            String dob = sc.next();
                            sc.nextLine();
                            System.out.println("Enter actor nationality:");
                            String actorNationality = sc.next();
                            sc.nextLine();
                            Actors actor = new Actors();
                            actor.setName(actorName);
                            actor.setDob(dob);
                            actor.setNationality(actorNationality);
                            as.addActor(actor);
                            System.out.println("Recorded Inserted Successfully!! ");
                            break;
                        case 2: for (Actors a : as.getAllActors()) {
                                System.out.println(a.getName() + " (" + a.getNationality() + ")");
                            }
                            break;
                        case 3: System.out.println("Enter actor name:");
                            String searchActorName = sc.next();
                            sc.nextLine();
                            Actors searchActor = as.searchActorByName(searchActorName);
                            if (searchActor != null) {
                                System.out.println("Actor Found: " + searchActor.getName() + " (" + searchActor.getNationality() + ")");
                            } else {
                                System.out.println("Actor not found");
                            }
                            break;
                        case 4: System.out.println("Enter nationality:");
                            String nationality = sc.next();
                            sc.nextLine();
                            for (Actors a : as.getActorsByNationality(nationality)) {
                                System.out.println(a.getName() + " (" + a.getNationality() + ")");
                            }
                            break;
                        case 5:
                            System.out.println("Enter Actor ID: ");
                            int id = sc.nextInt();
                            sc.nextLine();
                            System.out.println("Enter new Name: ");
                            String name = sc.nextLine();
                            sc.nextLine();
                            System.out.println("Enter new DOB: ");
                            String ndob = sc.next();
                            sc.nextLine();
                            System.out.println("Enter new Nationality: ");
                            String nnationality = sc.next();
                            sc.nextLine();
                            Actors act = new Actors();
                            act.setId(id);
                            act.setNationality(nnationality);
                            act.setName(name);
                            act.setDob(ndob);
                            as.updateActors(act);
                            System.out.println("Record Updated Successfully!!");
                            break;
                        case 6:
                            System.out.println("Enter actor ID:");
                            int aid = sc.nextInt();
                            as.deleteActors(aid);
                            System.out.println("Record deleted Successfully");
                            break;
                        case 0:
                            return;

                        default:
                            System.out.println("Please enter a valid choice!!");
                            continue;
                    }
                } catch(SQLException e) {
                    e.printStackTrace();
                }
            }
    }

    public void awardOptions(){
        AwardsServices as = new AwardsServices();
        while(true){
            System.out.flush();
            System.out.println("**************** || WELCOME TO FILM CAST MANAGEMENT SYSTEM || ****************");
            System.out.println("\n\t\t\t\t\tAward Options:");
            System.out.println("\n\t\t\t\t\t1. Add Award" +
                    "\n\t\t\t\t\t2. List Award" +
                    "\n\t\t\t\t\t3. Search Award" +
                    "\n\t\t\t\t\t4. Update Award" +
                    "\n\t\t\t\t\t5. Delete Award" +
                    "\n\t\t\t\t\t0. Exit");

            int choice = sc.nextInt();
            try {
                switch (choice) {
                    case 1:
                        sc.nextLine();
                        System.out.println("Enter name:");
                        String name = sc.nextLine();
                        System.out.println("Enter category: ");
                        String category = sc.nextLine();
                        System.out.println("Enter year:");
                        String year = sc.nextLine();
                        Awards award = new Awards();
                        award.setName(name);
                        award.setCategory(category);
                        award.setYear(year);
                        as.addAward(award);
                        System.out.println("Record Inserted Successfully!!");
                        break;
                    case 2: for (Awards a : as.getAllAwards()) {
                        System.out.println(a.getName() + " (" + a.getCategory() + ")");
                    }
                        break;
                    case 3: System.out.println("Enter actor name:");
                        String searchActorName = sc.nextLine();
                        Awards awards= as.searchAwardByName(searchActorName);
                        if (awards != null) {
                            System.out.println("Actor Found: " + awards.getName() + " (" + awards.getCategory() + ")");
                        } else {
                            System.out.println("Award not found");
                        }
                        break;
                    case 4:
                        System.out.println("Enter award ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Enter new award Name: ");
                        String nname = sc.nextLine();
                        sc.nextLine();
                        System.out.println("Enter new Category: ");
                        String ncategory = sc.nextLine();
                        sc.nextLine();
                        System.out.println("Enter new Year: ");
                        String nyear = sc.nextLine();
                        Awards award1 = new Awards();
                        award1.setId(id);
                        award1.setName(nname);
                        award1.setCategory(ncategory);
                        award1.setYear(nyear);
                        as.updateAward(award1);
                        System.out.println("Record Updated Successfully!!");
                        break;
                    case 5:
                        System.out.println("Enter award ID:");
                        int did = sc.nextInt();
                        as.deleteAward(did);
                        System.out.println("Record deleted Successfully");
                        break;
                    case 0: return;
                    default:
                        System.out.println("Please enter a valid choice!!");
                        continue;
                }
            } catch(SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void directorOptions(){
        DirectorsServices ds = new DirectorsServices();
        while(true){
            System.out.flush();
            System.out.println("**************** || WELCOME TO FILM CAST MANAGEMENT SYSTEM || ****************");
            System.out.println("\n\t\t\t\t\tDirectors Options:");
            System.out.println("\n\t\t\t\t\t1. Add Director" +
                    "\n\t\t\t\t\t2. List Director" +
                    "\n\t\t\t\t\t3. Search Director" +
                    "\n\t\t\t\t\t4. Update Director" +
                    "\n\t\t\t\t\t5. Delete Director" +
                    "\n\t\t\t\t\t0. Exit");

            int choice = sc.nextInt();
            try {
                switch (choice) {
                    case 1: System.out.println("Enter Director name:");
                        String dirName = sc.next();
                        sc.nextLine();
                        System.out.println("Enter DOB: ");
                        String dob = sc.next();
                        sc.nextLine();
                        System.out.println("Enter Director nationality:");
                        String dirNationality = sc.next();
                        sc.nextLine();
                        Directors dir = new Directors();
                        dir.setName(dirName);
                        dir.setDob(dob);
                        dir.setNationality(dirNationality);
                        ds.addDirector(dir);
                        System.out.println("Record Inserted Successfully!!");
                        break;
                    case 2: for (Directors d : ds.getAllDirectors()) {
                        System.out.println(d.getName() + " (" + d.getNationality() + ")");
                    }
                        break;
                    case 3: System.out.println("Enter Director name:");
                        String dName = sc.next();
                        sc.nextLine();
                        Directors searchDir = ds.searchDirectorByName(dName);
                        if (searchDir != null) {
                            System.out.println("Director Found: " + searchDir.getName() + " (" + searchDir.getNationality() + ")");
                        } else {
                            System.out.println("Director not found");
                        }
                        break;
                    case 4:
                        System.out.println("Enter Director ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Enter new Name: ");
                        String name = sc.next();
                        sc.nextLine();
                        System.out.println("Enter new DOB: ");
                        String ndob = sc.next();
                        sc.nextLine();
                        System.out.println("Enter new Nationality: ");
                        String nnationality = sc.next();
                        sc.nextLine();
                        Directors directors = new Directors();
                        directors.setId(id);
                        directors.setNationality(nnationality);
                        directors.setName(name);
                        directors.setDob(ndob);
                        ds.updateDirector(directors);
                        System.out.println("Record Updated Successfully!!");
                        break;
                    case 5:
                        System.out.println("Enter Director ID:");
                        int dirId = sc.nextInt();
                        ds.deleteDirector(dirId);
                        System.out.println("Record deleted Successfully");
                        break;
                    case 0:return;
                    default:
                        System.out.println("Please enter a valid choice!!");
                        continue;
                }
            } catch(SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void filmOptions(){
        FilmsServices fs = new FilmsServices();
        while(true){
            System.out.flush();
            System.out.println("**************** || WELCOME TO FILM CAST MANAGEMENT SYSTEM || ****************");
            System.out.println("\n\t\t\t\t\tFilm Options:");
            System.out.println("\n\t\t\t\t\t1. Add Film" +
                    "\n\t\t\t\t\t2. List Films" +
                    "\n\t\t\t\t\t3. Search Film" +
                    "\n\t\t\t\t\t4. Update Film" +
                    "\n\t\t\t\t\t5. Delete Film" +
                    "\n\t\t\t\t\t0. Exit");

            int choice = sc.nextInt();
            try {
                switch (choice) {
                    case 1:
                        sc.nextLine();
                        System.out.println("Enter Title:");
                        String title = sc.nextLine();
                        sc.nextLine();
                        System.out.println("Enter Genre: ");
                        String genre = sc.next();
                        sc.nextLine();
                        System.out.println("Enter Release year:");
                        int ryear = sc.nextInt();
                        System.out.println("Enter Director Id: ");
                        int did = sc.nextInt();
                        System.out.println("Enter Studio ID: ");
                        int sid = sc.nextInt();

                        Films film = new Films();
                        film.setTitle(title);
                        film.setGenre(genre);
                        film.setRelease_year(ryear);
                        film.setDirector_id(did);
                        film.setStudio_id(sid);
                        fs.addFilm(film);
                        System.out.println("Record Inserted Successfully!!");
                        break;
                    case 2: for (Films f : fs.getAllFilms()) {
                        System.out.println(f.getTitle() + " (" + f.getGenre() + ")");
                    }
                        break;
                    case 3: System.out.println("Enter Film Title:");
                        sc.nextLine();
                        String filmTitle = sc.next();
                        Films films= fs.searchFilmByTitle(filmTitle);
                        if (films != null) {
                            System.out.println("Film Found: " + films.getTitle() + " (" + films.getGenre() + ")");
                        } else {
                            System.out.println("Film not found");
                        }
                        break;
//                    case 4:
//                        System.out.println("Enter Genre:");
//                        String filmgenre = sc.next();
//                        for (Films fm : fs.getFilmsByGenre(filmgenre)) {
//                            System.out.println(fm.getTitle() + " (" + fm.getGenre() + ")");
//                        }
//                        break;
                    case 4:
                        System.out.println("Enter Film ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Enter new Film Title: ");
                        String fname = sc.next();
                        sc.nextLine();
                        System.out.println("Enter new Category: ");
                        String fgenre = sc.next();
                        sc.nextLine();
                        System.out.println("Enter new Release Year: ");
                        int reyear = sc.nextInt();
                        System.out.println("Enter new Director ID: ");
                        int dirid = sc.nextInt();
                        System.out.println("Enter new Studio Id: ");
                        int stid = sc.nextInt();
                        Films film1 = new Films();
                        film1.setId(id);
                        film1.setTitle(fname);
                        film1.setGenre(fgenre);
                        film1.setRelease_year(reyear);
                        film1.setDirector_id(dirid);
                        film1.setStudio_id(stid);
                        fs.updateFilms(film1);
                        System.out.println("Record Updated Successfully!!");
                        break;
                    case 5:
                        System.out.println("Enter film ID:");
                        int fid = sc.nextInt();
                        fs.deleteFilms(fid);
                        System.out.println("Record deleted Successfully");
                        break;
                    case 0:return;
                    default:
                        System.out.println("Please enter a valid choice!!");
                        continue;
                }
            } catch(SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void roleOptions(){
        RolesServices rs = new RolesServices();
        FilmsDAO fd = new FilmsDAO();
        while(true){
            System.out.flush();
            System.out.println("**************** || WELCOME TO FILM CAST MANAGEMENT SYSTEM || ****************");
            System.out.println("\n\t\t\t\t\tRoles Options:");
            System.out.println("\n\t\t\t\t\t1. Add Roles" +
                    "\n\t\t\t\t\t2. List Roles" +
                    "\n\t\t\t\t\t3. List by Films" +
                    "\n\t\t\t\t\t4. Update Roles" +
                    "\n\t\t\t\t\t5. Delete Roles" +
                    "\n\t\t\t\t\t0. Exit");

            int choice = sc.nextInt();
            try {
                switch (choice) {
                    case 1: System.out.println("Enter Film ID:");
                        int filmid = sc.nextInt();
                        System.out.println("Enter Actor Id: ");
                        int actorid = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Enter Role name:");
                        String rolename = sc.next();
                        Roles role = new Roles();
                        role.setFilm_id(filmid);
                        role.setActor_id(actorid);
                        role.setRole_name(rolename);
                        rs.addRole(role);
                        System.out.println("Record Inserted Successfully!!");
                        break;
                    case 2: for (Roles r : rs.getAllRoles()) {
                        System.out.println(r.getRole_name() + " (" + fd.getFilmById(r.getFilm_id()) + ")");
                    }
                        break;
                    case 3: System.out.println("Enter Film ID: ");
                        int filmId = sc.nextInt();
                        for (Roles r : rs.getRolesByFilmId(filmId)) {
                            System.out.println(r.getRole_name() + " (" + fd.getFilmById(r.getFilm_id()) + ")");
                        }
                        break;
                    case 4:
                        System.out.println("Enter Role ID: ");
                        int id = sc.nextInt();
                        System.out.println("Enter new Film Id: ");
                        int fid = sc.nextInt();
                        System.out.println("Enter new Actor Id: ");
                        int aid = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Enter new Role Name: ");
                        String roleName = sc.next();
                        Roles rol = new Roles();
                        rol.setId(id);
                        rol.setFilm_id(fid);
                        rol.setActor_id(aid);
                        rol.setRole_name(roleName);
                        rs.updateRoles(rol);
                        System.out.println("Record Updated Successfully!!");
                        break;
                    case 5:
                        System.out.println("Enter Role ID:");
                        int rid = sc.nextInt();
                        rs.deleteRoles(rid);
                        System.out.println("Record deleted Successfully");
                        break;
                    case 0:return;
                    default:
                        System.out.println("Please enter a valid choice!!");
                        continue;
                }
            } catch(SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void studioOptions(){
        StudiosServices ss = new StudiosServices();
        while(true){
            System.out.flush();
            System.out.println("**************** || WELCOME TO FILM CAST MANAGEMENT SYSTEM || ****************");
            System.out.println("\n\t\t\t\t\tStudio Options:");
            System.out.println("\n\t\t\t\t\t1. Add Studio" +
                    "\n\t\t\t\t\t2. List Studio" +
                    "\n\t\t\t\t\t3. Search Studio" +
                    "\n\t\t\t\t\t4. Update Studio" +
                    "\n\t\t\t\t\t5. Delete Studio" +
                    "\n\t\t\t\t\t0. Exit");

            int choice = sc.nextInt();
            try {
                switch (choice) {
                    case 1:
                        sc.nextLine();
                        System.out.println("Enter name:");
                        String name = sc.next();
                        sc.nextLine();
                        System.out.println("Enter country: ");
                        String country = sc.next();
                        sc.nextLine();
                        Studios studio = new Studios();
                        studio.setName(name);
                        studio.setCountry(country);
                        ss.addStudio(studio);
                        System.out.println("Record Inserted Successfully!!");
                        break;
                    case 2: for (Studios s : ss.getAllStudios()) {
                        System.out.println(s.getName() + " (" + s.getCountry() + ")");
                    }
                        break;
                    case 3:
                        sc.nextLine();
                        System.out.println("Enter Studio name:");
                        String sName = sc.next();
                        sc.nextLine();
                        Studios st = ss.searchStudioByName(sName);
                        if (st != null) {
                            System.out.println("Studio Found: " + st.getName() + " (" + st.getCountry() + ")");
                        } else {
                            System.out.println("Studio not found");
                        }
                        break;
                    case 4:
                        System.out.println("Enter Studio ID: ");
                        int id = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Enter new Studio Name: ");
                        String sname = sc.next();
                        sc.nextLine();
                        System.out.println("Enter new Country: ");
                        String scountry = sc.next();
                        sc.nextLine();
                        Studios std = new Studios();
                        std.setId(id);
                        std.setName(sname);
                        std.setCountry(scountry);
                        ss.updateStudio(std);
                        System.out.println("Record Updated Successfully!!");
                        break;
                    case 5:
                        System.out.println("Enter Studio ID:");
                        int sid = sc.nextInt();
                        ss.deleteStudio(sid);
                        System.out.println("Record deleted Successfully");
                        break;
                    case 0:return;
                    default:
                        System.out.println("Please enter a valid choice!!");
                        continue;
                }
            } catch(SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void reviewOptions(){
        ReviewsServices rs = new ReviewsServices();
        FilmsDAO fd = new FilmsDAO();
        while(true){
            System.out.flush();
            System.out.println("**************** || WELCOME TO FILM CAST MANAGEMENT SYSTEM || ****************");
            System.out.println("\n\t\t\t\t\tReview Options:");
            System.out.println("\n\t\t\t\t\t1. Add Review" +
                    "\n\t\t\t\t\t2. List Reviews" +
                    "\n\t\t\t\t\t3. Search Review" +
                    "\n\t\t\t\t\t4. Update Review" +
                    "\n\t\t\t\t\t5. Delete Review" +
                    "\n\t\t\t\t\t0. Exit");

            int choice = sc.nextInt();
            try {
                switch (choice) {
                    case 1: System.out.println("Enter Film ID:");
                        int filmid = sc.nextInt();
                        System.out.println("Enter User ID: ");
                        int userid = sc.nextInt();
                        System.out.println("Enter Rating: ");
                        int rating = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Enter comment: ");
                        String comment = sc.next();
                        sc.nextLine();
                        System.out.println("Enter Review Date: ");
                        String reviewdate = sc.next();
                        Reviews review = new Reviews();
                        review.setFilmId(filmid);
                        review.setUserId(userid);
                        review.setRating(rating);
                        review.setReviewDate(reviewdate);
                        review.setComment(comment);
                        rs.addReview(review);
                        System.out.println("Record Inserted Successfully!!");
                        break;
                    case 2: for (Reviews r : rs.getAllReviews()) {
                        System.out.println(r.getRating() + "* (" + r.getComment() + ")");
                    }
                        break;
                    case 3: System.out.println("Enter Review ID : ");
                        int rid = sc.nextInt();
                        Reviews r = rs.searchReviewById(rid);
                        if (r != null) {
                            System.out.println("Review Found: " + r.getRating() + " (" + r.getComment() + ")");
                        } else {
                            System.out.println("Review not found");
                        }
                        break;
                    case 4:
                        System.out.println("Enter Review ID: ");
                        int id = sc.nextInt();
                        System.out.println("Enter new Film ID: ");
                        int fid = sc.nextInt();
                        System.out.println("Enter new User ID: ");
                        int uid = sc.nextInt();
                        System.out.println("Enter new Rating : ");
                        int ratin = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Enter new Comment: ");
                        String commento = sc.next();
                        sc.nextLine();
                        System.out.println("Enter new Review Date: ");
                        String rd = sc.next();
                        Reviews rv = new Reviews();
                        rv.setId(id);
                        rv.setFilmId(fid);
                        rv.setUserId(uid);
                        rv.setComment(commento);
                        rv.setRating(ratin);
                        rv.setReviewDate(rd);
                        rs.updateReview(rv);
                        System.out.println("Record Updated Successfully!!");
                        break;
                    case 5:
                        System.out.println("Enter Review ID:");
                        int reid = sc.nextInt();
                        rs.deleteReview(reid);
                        System.out.println("Record deleted Successfully");
                        break;
                    case 0:return;
                    default:
                        System.out.println("Please enter a valid choice!!");
                        continue;
                }
            } catch(SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
