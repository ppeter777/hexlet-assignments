<!-- BEGIN -->
@import exercise.dto.users.UserPage
@param UserPage page

@template.layout.page(
content = @`
<html>
    <head>
        <title>User page</title>
    </head>
    <body>
            <div>
                <p>Id: ${page.getUser().getId()}</p>
                <p>Name: ${page.getUser().getFirstName()} ${page.getUser().getLastName()}</p>
                <p>Email: ${page.getUser().getEmail()}</p>
                <p><a href="/users">Пользователи</a></p>
            </div>
    </body>
</html>
`,
header = @`
    <p><a href="/">Main page</a></p>
`,
footer = @`
    <p>Thanks for visiting, come again soon!</p>
`)
<!-- END -->
