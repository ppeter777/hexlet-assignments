<!-- BEGIN -->
@import exercise.dto.users.UsersPage
@param UsersPage page

@template.layout.page(
content = @`
<html>
    <head>
        <title>Users page</title>
    </head>
    <body>
        <form action="/users" method="get">
            <input type="search" name="term" value="${page.getTerm()}" />
            <input type="submit" value="Search" />
        </form>
        <table>
            <th>Id</th>
            <th>Name</th>
            <th>Email</th>
            @for (var user : page.getUsers())
                <tr>
                    <td><a href="/users/${user.getId()}">${user.getId()}</a></td>
                    <td>${user.getFirstName()} ${user.getLastName()}</td>
                    <td>${user.getEmail()}</td>
                </tr>
            @endfor
        </table>
    </body>
</html>
`)
<!-- END -->
