  <!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1 ,user-scalable=no">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <link rel="stylesheet" href="bootstrap-3.3.7-dist/css/bootstrap.min.css">
    <link rel="stylesheet" href="style.css" type="text/css">
    <title>Banana APP</title>
</head>
<body>
<header>
/**NAVBAR**/
  <div class="container">
        <nav class="navbar navbar-default navbar-inverse">
            <div class="container-fluid">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header">
                    <a class="navbar-brand" href="paginaprincipal.html">Banana guest</a>
                </div>

                <!-- Nav Content -->
                <ul class="nav navbar-nav navbar-right">
                    <li class="dropdown">
                        <a href = 'imaginario.html' class="dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false" id='tit_menu'>Menu<span class="caret" ></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="pagina4.html">My Profile</a></li>
                            <li role="separator" class="divider"></li>
                            <li><a href="pagina2.html">Log out</a></li>
                        </ul>
                    </li>
                </ul>
            </div>
        </nav>
        <!-- /.navbar-collapse -->
    </div>
    <!-- /.container-fluid -->
    <div class="container">
        <div class="row profile">
            <div class="col-md-3">
                <div class="profile-sidebar">
                    <!-- SIDEBAR USERPIC -->
                    <div class="profile-userpic">
                        <img src="images/avatar.jpg" class="img-responsive" alt="Foto de perfil">
                    </div>
                    <!-- END SIDEBAR USERPIC -->
                    <!-- SIDEBAR USER TITLE -->
                    <div class="profile-usertitle">
                        <div class="profile-usertitle-name">
                            Arthur
                        </div>
                        <div class="profile-usertitle-job">
                            Developer
                        </div>
                    </div>
                    <!-- END SIDEBAR USER TITLE -->
                    <!-- SIDEBAR MENU -->
                    <div class="profile-usermenu">
                        <ul class="nav">
                            <li class="active">
                                <a href="paginaprincipal.html">
                                    <i class="glyphicon glyphicon-tasks"></i> Proyectos en curso </a>
                            </li>
                            <li>
                                <a href = 'imaginario.html'  id='btn_nuevoproyecto'>
                                    <i class="glyphicon glyphicon-file"></i> Nuevo proyecto </a>
                            </li>

                            <li>
                                <a href="tareas.html" target="_blank">
                                    <i class="glyphicon glyphicon-ok"></i> Menú de tareas</a>
                            </li>
                            <li>
                                <a href="pagina3.html">
                                    <i class="glyphicon glyphicon-user"></i> Crear usuario </a>
                            </li>
                        </ul>
                    </div>
                    <!-- END MENU -->
                </div>
            </div>
      </header>      
</body>