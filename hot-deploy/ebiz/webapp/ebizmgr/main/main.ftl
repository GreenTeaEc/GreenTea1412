<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <title>Bootstrap Admin Theme</title>

    <!-- Bootstrap Core CSS -->
    <link href="/images/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="/images/assets/css/dashboard.css" rel="stylesheet">
    <link rel="stylesheet" href="/images/jquery-ui-bootstrap-1.0.0/css/custom-theme/jquery-ui-1.10.3.custom.css">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

	<!-- jQuery -->
    <script src="/images/jquery/jquery-1.11.0.min.js"></script>

    <!-- Bootstrap Core JavaScript -->
    <script src="/images/bootstrap/js/bootstrap.min.js"></script>
    <script src="/images/assets/js/vendor/holder.js"></script>
    <script src="/images/jquery-ui-bootstrap-1.0.0/assets/js/vendor/jquery-ui-1.10.3.custom.min.js" type="text/javascript"></script>
	<script src="/images/jquery-ui-bootstrap-1.0.0/assets/js/google-code-prettify/prettify.js" type="text/javascript"></script>	
</head>

<body>

<nav class="navbar navbar-default navbar-fixed-top">
      <div class="container-fluid">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#">${uiLabelMap.EbizProjectName}</a>
          <ul class="nav navbar-nav navbar-left">
            <li>
            	<button class="btn btn-default" type="button" data-toggle="collapse" data-target="#ebizMenuOrder" aria-expanded="false" aria-controls="collapseExample">订单</button>
            </li>
            <li>
				<button class="btn btn-primary" type="button" data-toggle="collapse" data-target="#ebizMenuProduct" aria-expanded="false" aria-controls="collapseExample">产品</button>
			</li>
          </ul>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
            <li class="dropdown">
                    <a class="dropdown-toggle" data-toggle="dropdown" href="#" aria-expanded="false">
                        <i class="fa fa-user fa-fw"></i>${userLogin.userLoginId}<span class="glyphicon glyphicon-menu-down" aria-hidden="true"></span>
                    </a>
                    <ul class="dropdown-menu dropdown-user">
                        <li><a href="#"><i class="fa fa-user fa-fw"></i> User Profile</a>
                        </li>
                        <li><a href="#"><i class="fa fa-gear fa-fw"></i> Settings</a>
                        </li>
                        <li class="divider"></li>
                        <li><a href="login.html"><i class="fa fa-sign-out fa-fw"></i> Logout</a>
                        </li>
                    </ul>
                    <!-- /.dropdown-user -->
                </li>
            <li><a href="#">Help</a></li>
          </ul>
        </div>
      </div>
    </nav>

    <div class="container-fluid">
      <div class="row">
        <div class="col-sm-2 col-md-2 sidebar">
        
		  <ul class="nav nav-list ebiz-left-nav" id="ebizMenuOrder">
		  	<li class="nav-header">订单管理</li>
		  	<li><a href="javascript:addGreenteaTab('订单查询','login','订单查询',true);">订单查询</a></li>
		  </ul>
		  <ul class="nav nav-list ebiz-left-nav" id="ebizMenuProduct">
		  	<li class="nav-header">产品管理</li>
		  	<li><a href="">产品查询</a></li>
		  </ul>
		  
		  <ul class="nav nav-list ebiz-left-nav" id="ebizMenuOrder">
		  	<li class="nav-header">订单管理</li>
		  	<li><a href="javascript:addGreenteaTab('订单查询','login','订单查询',true);">订单查询</a></li>
		  </ul>
		  <ul class="nav nav-list ebiz-left-nav" id="ebizMenuProduct">
		  	<li class="nav-header">产品管理</li>
		  	<li><a href="">产品查询</a></li>
		  </ul>
		  
		  <ul class="nav nav-list ebiz-left-nav" id="ebizMenuOrder">
		  	<li class="nav-header">订单管理</li>
		  	<li><a href="javascript:addGreenteaTab('订单查询','login','订单查询',true);">订单查询</a></li>
		  </ul>
		  <ul class="nav nav-list ebiz-left-nav" id="ebizMenuProduct">
		  	<li class="nav-header">产品管理</li>
		  	<li><a href="">产品查询</a></li>
		  </ul>
		  
		  <ul class="nav nav-list ebiz-left-nav" id="ebizMenuOrder">
		  	<li class="nav-header">订单管理</li>
		  	<li><a href="javascript:addGreenteaTab('订单查询','login','订单查询',true);">订单查询</a></li>
		  </ul>
		  <ul class="nav nav-list ebiz-left-nav" id="ebizMenuProduct">
		  	<li class="nav-header">产品管理</li>
		  	<li><a href="">产品查询</a></li>
		  </ul>
        </div>
        
          <div class="col-sm-10 col-sm-offset-3 col-md-10 col-md-offset-2 row" id="greenteaTabs">
	        <ul>
	            <li><a href="#tabs-1">First</a></li>
	        </ul>
	        <div id="tabs-1">
	            <p>
	            
	            
	            Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.

	            
	            </p>
	        </div>
	       </div>

 
      </div>
    </div>

<script>

//$(function () {

	//####### Tabs
    var gtTabs =  $('#greenteaTabs').tabs();

    // Dynamic tabs
    var tabCounter = 2;
        
	// actual addTab function: adds new tab using the input from the form above
	function addGreenteaTab(tabName,targetUrl, tabDesc, refreshIfExists) {
	    var label = tabDesc,
	        id = "tabs-" + tabCounter,
	        li = "<li><a href='#"+id+"'>"+label+"</a> <span class='ui-icon ui-icon-close'>Remove Tab</span></li>"; 
	        tabContentHtml = "<div id='"+id+"' class='container-fluid'><p><iframe src='"+targetUrl+"'  style='height:100%; width:100%; marginwidth:0; marginheight:0; scrolling:no'></iframe></p></div>";
	
	    gtTabs.find( ".ui-tabs-nav" ).append( li );
	    //gtTabs.append( "&lt;div id='" + id + "&gt;&lt;/div&gt;&lt;p&gt;" + tabContentHtml + "&lt;/p&gt;&lt;/div&gt;" );
	    gtTabs.append(tabContentHtml);
	    gtTabs.tabs( "refresh" );
	    var selecting = gtTabs.tabs( "length" ) - 1;  
        gtTabs.tabs( "option", "selected", index);  
	    tabCounter++;
	}

	// close icon: removing the tab on click
    $( "#greenteaTabs" ).on( "click",'span.ui-icon-close', function() {

        var panelId = $( this ).closest( "li" ).remove().attr( "aria-controls" );
        $( "#" + panelId ).remove();
        gtTabs.tabs( "refresh" );
    });

//});  
</script>
    

</body>

</html>
%