<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>SV Techno</title>
    <link rel="stylesheet" href="Compopnent/style1.css">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css"
        integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
</head>

<body>
    <div class="con">
        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <a class="navbar-brand" href="#">Home</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav"
                aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav">
                    <li class="nav-item active">
                        <a class="nav-link" href="#">About <span class="sr-only">(current)</span></a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Contact Us</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Links</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link disabled" href="#">Owner</a>
                    </li>
                </ul>
            </div>
        </nav>
        <div class="container">
            <div class="card">
                <div class="card-header bg-dark text-light text-center">
                    <h2><b>SignUp Page!!</b> </h2>
                </div>
                <div class="card-body">
                    <form action="signUp" method="post">
                        <div class="form-group">
                            <label for="exampleInputEmail1"><h6>User Name</h6></label>
                            <input type="text" name="name" class="form-control" 
                                aria-describedby="emailHelp" placeholder="User name">

                        </div>
                        <div class="form-group">
                            <label for="exampleInputEmail1"><h6>Email address</h6></label>
                            <input type="email" name="email" class="form-control" id="exampleInputEmail1"
                                 placeholder="Enter email">

                        </div>
                        <div class="form-group">
                            <label for="exampleInputEmail1"><h6>Phone no.</h6></label>
                            <input type="text" name="phone" class="form-control" 
                                aria-describedby="emailHelp" placeholder="Phone no">

                        </div>
                        <div class="form-group">
                            <label for="exampleInputPassword1"><h6>Password</h6></label>
                            <input type="password" name="Password" class="form-control" id="exampleInputPassword1"
                                placeholder="Password">
                        </div>
                        <div class="form-group">
                            <label for="exampleInputPassword1"><h6>Confirm Password</h6></label>
                            <input type="password" name="cPassword" class="form-control" id="exampleInputPassword1"
                                placeholder="Password">
                        </div>

                        <!-- for checkbox -->
                        <% if (request.getAttribute("CheckBox") != null) { %>
                            <h5 style="color: red;">
                                <%= request.getAttribute("CheckBox") %>
                            </h5>
                        <% } %>

                        <!-- for Password not match -->
                        <% if (request.getAttribute("PnotMatch") != null) { %>
                            <h5 style="color: red;">
                                <%= request.getAttribute("PnotMatch") %>
                            </h5>
                        <% } %>


                       <!-- for DB_error -->
                        <% if (request.getAttribute("DB_error") != null) { %>
                            <h5 style="color: rgb(27, 145, 23);">
                                <%= request.getAttribute("DB_error") %>
                            </h5>
                        <% } %>

                        <div class="input-group mb-3">
                            <div class="custom-file">
                              <input type="file" name="img" class="custom-file-input" id="inputGroupFile01">
                              <label class="custom-file-label" for="inputGroupFile01">Choose file</label>
                            </div>
                          </div>

                        <div class="form-check">
                            <input type="checkbox" name="checkbox" class="form-check-input" id="exampleCheck1">
                            <label class="form-check-label" for="exampleCheck1">Check me out</label>
                        </div>
                        <div class="button">

                            <button type="submit" class="btn btn-primary">Submit</button>
                        </div>
                       
                    </form>

                </div>
                <div class="card-footer text-muted text-center">
                    SV Techno
                </div>
            </div>
        </div>
    </div>
</body>

</html>