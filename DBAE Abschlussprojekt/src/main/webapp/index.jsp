<!DOCTYPE>
<html>
    <head>
        <!--Auflistung der Autoren-->
        <meta name="authorOne" content="Dennis Hasselbusch">
        <meta name="authorTwo" content="Marten Kracke">
        <meta name="authorThree" content="Clemens Beck">

        <!--Beschreibung der Seite-->
        <meta name="description" content="DBAE Abschlussprojekt">

        <!--Kleines Icon-->
        <link rel="shortcut icon" href= "Iconsmind-Outline-Eci-Icon.ico" type="image/x-icon">

        <!--Viewport auf Basis des verw. Geräts mit Skalierung 10-->
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta charset="UTF-8">
        <title>Elektrotechnik MaClDe GmbH</title>

        <!--Bootstrap via CDN hinzugefügt-->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.1/css/bootstrap.min.css">      
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.1/dist/js/bootstrap.min.js" integrity="undefined" crossorigin="anonymous"></script>
    </head>
    <body>
          <!--Menu Bar-->
          <div class="shadow-sm">
            <nav class="container navbar justify-content-between navbar-toggleable-md" id="mainnav">    
            <img class="img-fluid header-logo" src="pictures/pig.png" height="50" width="50" alt="companyName"></a>
        <form method="get" action="/listing.xhtml" class="form-inline w-50 mx-2 d-none d-md-inline searchbar" enctype="application/x-www-form-urlencoded" autocomplete="off" name="search_word_inc" accept-charset="utf-8">
          <div class="input-group">
            <input type="text" name="q" class="form-control" onkeyup="global.handleSuggestLayer(event, this, {})" inputmode="search" placeholder="Shop durchsuchen...">
            <div class="input-group-append">
              <input type="submit" value="suchen" class="font-awesome btn btn-black">
            </div>
          </div>
        </form>
                <ul class="navbar-nav d-none d-lg-block mx-lg-1" id="b2b-nav">
                  <li class="nav-item dropdown">
                    <div class="dropdown-arrow"></div>
                    <a class="nav-link dropdown-toggle d-block text-center" href="#" title="Administrator" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                      <img src="pictures/adminLog.png" Administrator" width="20" height="20"><span class="d-none d-lg-inline ml-1"> Administrator</span>
                    </a>
                  </li>
                </ul>
              
              <ul class="navbar-nav mx-lg-1" id="my-account">
                <li class="nav-item dropdown">
                  <div class="dropdown-arrow"></div>
                  <a class="nav-link dropdown-toggle d-block text-center" href="#" title="Käufer" data-toggle="dropdown" role="button" aria-haspopup="true" aria-expanded="false">
                    <img src="pictures/buyerIcon.png" alt="Käufer" width="20" height="20"><span class="d-none d-lg-inline ml-1"> Käufer</span>
                  </a>
                  <div class="dropdown-menu dropdown-menu-right shadow">
                  <form id="tle-header:j_idt75" name="tle-header:j_idt75" method="post" action="/mobile/index.xhtml" enctype="application/x-www-form-urlencoded">
                    <input type="hidden" name="tle-header:j_idt75" value="tle-header:j_idt75">
                    <div class="dropdown-item" id="dropdown-greeting"><a href="/login.xhtml" title="Anmelden" class="btn btn-primary btn-block mt-1">Anmelden</a>
                    </div>
                    <input type="hidden" name="javax.faces.ViewState" id="j_id1:javax.faces.ViewState:0" value="8924188837245122335:-7319436323382927890" autocomplete="off">
                    </form>
                </li>
              </ul>
              
              <ul class="navbar-nav ml-lg-1">
                <li class="nav-item"><a id="tle-header:header-cart-count" name="tle-header:header-cart-count" href="/cart.xhtml" title="Warenkorb" class="nav-link navbar-nav align-items-center d-block text-center position-relative">
                    <span class="position-relative">
                      <img src="pictures/warenkorb.jpeg" alt="Warenkorb" width="20" height="20">
                      <span id="cart-count" class="d-none">-1</span>
                      <span class="d-none d-lg-inline ml-1"> Warenkorb</span>
                    </span></a>
                </li>
              </ul>
            </nav>
          </div>
      <nav class="container d-none d-lg-flex" id="subnav">
        <ul class="nav">
          <li class="nav-item dropdown" id="all-categories">
            <a class="nav-link dropdown-toggle btn btn-black d-flex align-items-center collapsed" data-toggle="collapse" href="#collapse-navigation" role="button" aria-controls="collapse-navigation" aria-expanded="false">
              <alt="Alle Kategorien" width="30"> 
              <span class="mx-2">Menu</span>
            </a>
          </li>
            <li class="nav-item">
              <a class="nav-link" href="/Outlet" title="Outlet">Deals</a>
            </li>
            <li class="nav-item">
              <a class="nav-link" href="/promotions.xhtml" title="Aktionen">Aktionen</a>
            </li>
        </ul>
      </nav>

    <div class="container">
      

        <br>

        <h1>Inhalte, Inhalte, Inhalte...</h1>
        <button>CLICK ME!</button>
    
      </body>
 
</html>