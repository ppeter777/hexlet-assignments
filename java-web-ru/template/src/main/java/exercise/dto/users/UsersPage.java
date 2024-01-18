package exercise.dto.users;

import exercise.model.User;

import java.util.LinkedList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

// BEGIN
@AllArgsConstructor
@Getter
public class UsersPage {
//    private User user;
    private List<User> users;
}
// END
