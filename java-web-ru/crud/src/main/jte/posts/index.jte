<!-- BEGIN -->
@import exercise.dto.posts.PostsPage
@param PostsPage postsPage

<html>
    <head>
        <title>Post page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    </head>
    <body>
        <table>
            <th>Name</th>
            <th>Post</th>
            @for (int i = (postsPage.getPage() - 1) * 5; i < (postsPage.getPage() - 1) * 5 + 5; ++i)
                <tr>
                    <td>${postsPage.getPostsPage().get(i).getName()}</td>
                    <td>${postsPage.getPostsPage().get(i).getBody()}</td>
                </tr>
            @endfor
        </table>

        <nav aria-label="Page navigation example">
          <ul class="pagination">
            <li class="page-item"><a class="page-link" href="#">Previous</a></li>
            <li class="page-item"><a class="page-link" href="/posts?page=1">1</a></li>
            <li class="page-item"><a class="page-link" href="/posts?page=2">2</a></li>
            <li class="page-item"><a class="page-link" href="/posts?page=3">3</a></li>
            <li class="page-item"><a class="page-link" href="#">Next</a></li>
          </ul>
        </nav>

    </body>
</html>
<!-- END -->
