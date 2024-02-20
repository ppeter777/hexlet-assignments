<!-- BEGIN -->
@import exercise.dto.posts.PostPage
@import exercise.util.NamedRoutes
@param PostPage postPage

<html>
    <head>
        <title>Post page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    </head>
    <body>
            <h3>Name</h3>
            <p>${postPage.getPost().getName()}</p>
            <h3>Post</h3>
            <p>${postPage.getPost().getBody()}</p>
            <a href="${NamedRoutes.postsPath()}">All posts</a>
    </body>
</html>
<!-- END -->
