<!-- BEGIN -->
@import exercise.dto.users.UsersPage
@param UsersPage users

<html>
    <head>
        <title>Users page</title>
    </head>
    <body>
        <table>
            <th>Id</th>
            <th>First name</th>
            <th>Last name</th>
            <th>Email</th>
            @for (var user : users.getUsers())
                <tr>
                    <td>${user.getId()}</td>
                    <td>${user.getFirstName()}</td>
                    <td>${user.getLastName()}</td>
                    <td>${user.getEmail()}</td>
                </tr>
            @endfor
        </table>
    </body>
</html>

<!-- END -->
