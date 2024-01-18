<!-- BEGIN -->
@import exercise.dto.users.UserPage
@param UserPage user

<html>
    <head>
        <title>User page</title>
    </head>
    <body>
            <div>
                <p>Id: ${user.getUser().getId()}</p>
                <p>FirstName: ${user.getUser().getFirstName()}</p>
                <p>Last Name: ${user.getUser().getLastName()}</p>
                <p>Email: ${user.getUser().getEmail()}</p>
            </div>
    </body>
</html>
<!-- END -->
