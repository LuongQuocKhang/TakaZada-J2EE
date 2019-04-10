<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page isELIgnored ="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="java.util.ArrayList,TakaZada.Model.*" %>
<body>
<link href="<c:url value="/Resources/Content/css/Carousel.css"/>" rel="stylesheet" />
<script src="<c:url value="/Resources/Scripts/js/Carousel.js"/>" ></script>
<div class="banner" id="home1">
    <div class="container">
        <h3>TakaZada <span>Computer world</span></h3>
    </div>
</div>
<!-- //banner -->
<!-- banner-bottom -->
<div class="banner-bottom">
    <div class="container">
        <div class="col-md-5 wthree_banner_bottom_left">
            <div class="video-img">

            </div>
        </div>
        <div class="col-md-7 wthree_banner_bottom_right">
            <div class="bs-example bs-example-tabs" role="tabpanel" data-example-id="togglable-tabs">
                <ul id="myTab" class="nav nav-tabs" role="tablist">
                    <li role="presentation" class="active"><a href="#RAM" id="RAM-tab" role="tab" data-toggle="tab" aria-controls="RAM">RAM</a></li>
                    <li role="presentation"><a href="#VGA" role="tab" id="VGA-tab" data-toggle="tab" aria-controls="VGA">VGA</a></li>
                    <li role="presentation"><a href="#CPU" role="tab" id="CPU-tab" data-toggle="tab" aria-controls="watches">CPU</a></li>
                    <li role="presentation"><a href="#Case" role="tab" id="Case-tab" data-toggle="tab" aria-controls="Case">Case</a></li>
                </ul>
                <div id="myTabContent" class="tab-content">
                    <div role="tabpanel" class="tab-pane fade active in" id="RAM" aria-labelledby="RAM-tab">
                        <div class="agile_ecommerce_tabs">
                        <%
                        	ArrayList<RAM> listram = (ArrayList<RAM>)request.getAttribute("ListRAM");
                            
                            for ( int i = 0 ; i < 3 ; i++)
                            {
                            	out.print("<div class=\"col-md-4 agile_ecommerce_tab_left\">");
                            		out.print("<div class=\"card\" style=\"width:215px;height: 385px;margin:10px;\">");
	                            		out.print(" <a href=\"/TakaZada/RAMDetail/" + listram.get(i).Id + "\"" + ">\"");
	                            			out.print("<img class=\"card-img-top itemImage\" src=" + request.getAttribute("domainname") + "/Resources/Content/Pictures/Ram/" + listram.get(i).Image.replace(" ", "%20") + " \"" + "alt=\"Card image cap\">");
	                           			out.print(" </a>");
	                            		out.print("<div class=\"card-body\">");
	                            			out.print("<h5 class=\"card-title\">");  
	                            				out.print(" <a href=\"/TakaZada/RAMDetail/" + listram.get(i).Id + "\"" + ">");
	                            					out.print(listram.get(i).Name);
	                            				out.print("</a>");
	                            			out.print("</h5>");
	                           				out.print("<div class=\"simpleCart_shelfItem\">");
		                           				out.print("<p> <i class=\"item_price\">" + listram.get(i).Price + "</i></p>");
		                           				out.print("<p><a class=\"item_add\" href=\"/TakaZada/AddToCart/" 
		                           				+  "RAM" + "/" 
		                           				+ listram.get(i).Id + "/"
		                           				+ "1" + "/"
		                           				+ listram.get(i).Price + "/"
		                           				+ listram.get(i).Id + "/"
		                           				+ listram.get(i).Name + "/"
		                           				+ listram.get(i).Image + "/"
		                           				+ "\" >Add to cart</a></p>");
	                           				out.print("</div>");
	                           			out.print("</div>");
                           			out.print("</div>");
                           		out.print("</div>");
                            }
                           %>
						
                            <div class="clearfix"> </div>
                        </div>
                    </div>
                    <div role="tabpanel" class="tab-pane fade" id="VGA" aria-labelledby="VGA-tab">
                        <div class="agile_ecommerce_tabs">
                           <%ArrayList<VGA> listvga = (ArrayList<VGA>)request.getAttribute("ListVGA");
	                            for ( int i = 0 ; i < 3 ; i++)
	                            {
	                            	out.print("<div class=\"col-md-4 agile_ecommerce_tab_left\">");
	                            		out.print("<div class=\"card\" style=\"width:215px;height: 385px;margin:10px;\">");
	                            			out.print(" <a href=\"/TakaZada/VGADetail/" + listvga.get(i).Id + "\"" + ">\"");
		                            			out.print("<img class=\"card-img-top itemImage\" src=" + request.getAttribute("domainname") + "/Resources/Content/Pictures/VGA/" + listvga.get(i).Image.replace(" ", "%20") + " \"" + "alt=\"Card image cap\">");
		                           			out.print(" </a>");
		                            		out.print("<div class=\"card-body\">");
			                            		out.print("<h5 class=\"card-title\">");  
	                            					out.print(" <a href=\"/TakaZada/VGADetail/" + listvga.get(i).Id + "\"" + ">");
	                            						out.print(listvga.get(i).Name);
	                            					out.print("</a>");
	                            				out.print("</h5>");
		                           				out.print("<div class=\"simpleCart_shelfItem\">");
			                           				out.print("<p> <i class=\"item_price\">" + listvga.get(i).Price + "</i></p>");
			                           				out.print("<p><a class=\"item_add\" href=\"/TakaZada/AddToCart/" 
					                           				+  "VGA" + "/" 
					                           				+ listvga.get(i).Id + "/"
					                           				+ "1" + "/"
					                           				+ listvga.get(i).Price + "/"
					                           				+ listvga.get(i).Id + "/"
					                           				+ listvga.get(i).Name + "/"
					                           				+ listvga.get(i).Image + "/"
					                           				+ "\" >Add to cart</a></p>");
		                           				out.print("</div>");
		                           			out.print("</div>");
	                           			out.print("</div>");
	                           		out.print("</div>");
                           	 	}
                           	%>
                            <div class="clearfix"> </div>
                        </div>
                    </div>
                    <div role="tabpanel" class="tab-pane fade" id="CPU" aria-labelledby="CPU-tab">
                        <div class="agile_ecommerce_tabs">
                           <%ArrayList<CPU> listcpu = (ArrayList<CPU>)request.getAttribute("ListCPU");
	                            for ( int i = 0 ; i < 3 ; i++)
	                            {
	                            	out.print("<div class=\"col-md-4 agile_ecommerce_tab_left\">");
	                            		out.print("<div class=\"card\" style=\"width:215px;height: 385px;margin:10px;\">");
	                            			out.print(" <a href=\"/TakaZada/CPUDetail/" + listcpu.get(i).Id + "\"" + ">\"");
		                            			out.print("<img class=\"card-img-top itemImage\" src=" + request.getAttribute("domainname") + "/Resources/Content/Pictures/CPU/" + listcpu.get(i).Image.replace(" ", "%20") + " \"" + "alt=\"Card image cap\">");
		                           			out.print(" </a>");
		                            		out.print("<div class=\"card-body\">");
			                            		out.print("<h5 class=\"card-title\">");  
		                        					out.print(" <a href=\"/TakaZada/CPUDetail/" + listcpu.get(i).Id + "\"" + ">");
		                        						out.print(listcpu.get(i).Name);
		                        					out.print("</a>");
		                        				out.print("</h5>");
		                           				out.print("<div class=\"simpleCart_shelfItem\">");
			                           				out.print("<p> <i class=\"item_price\">" + listcpu.get(i).Price + "</i></p>");
			                           				out.print("<p><a class=\"item_add\" href=\"/TakaZada/AddToCart/" 
					                           				+  "CPU" + "/" 
					                           				+ listcpu.get(i).Id + "/"
					                           				+ "1" + "/"
					                           				+ listcpu.get(i).Price + "/"
					                           				+ listcpu.get(i).Id + "/"
					                           				+ listcpu.get(i).Name + "/"
					                           				+ listcpu.get(i).Image + "/"
					                           				+ "\" >Add to cart</a></p>");
		                           				out.print("</div>");
		                           			out.print("</div>");
	                           			out.print("</div>");
	                           		out.print("</div>");
                           	 	}
                           	%>
                            <div class="clearfix"> </div>
                        </div>
                    </div>
                    <div role="tabpanel" class="tab-pane fade" id="Case" aria-labelledby="Case-tab">
                        <div class="agile_ecommerce_tabs">
                            <%ArrayList<Case> listcase = (ArrayList<Case>)request.getAttribute("ListCase");
	                            for ( int i = 0 ; i < 3 ; i++)
	                            {
	                            	out.print("<div class=\"col-md-4 agile_ecommerce_tab_left\">");
	                            		out.print("<div class=\"card\" style=\"width:215px;height: 385px;margin:10px;\">");
		                            		out.print(" <a href=\"" + request.getAttribute("domainname") + "/CaseDetail/" + listcase.get(i).Id + "\">");
		                            			out.print("<img class=\"card-img-top itemImage\" src=" + request.getAttribute("domainname") + "/Resources/Content/Pictures/Case/" + listcase.get(i).Image.replace(" ", "%20") + " \"" + "alt=\"Card image cap\">");
		                           			out.print(" </a>");
		                            		out.print("<div class=\"card-body\">");
			                            		out.print("<h5 class=\"card-title\">");  
		                        					out.print(" <a href=\"/TakaZada/CaseDetail/" + listcase.get(i).Id + "\"" + ">");
		                        						out.print(listcase.get(i).Name);
		                        					out.print("</a>");
	                        					out.print("</h5>");
		                           				out.print("<div class=\"simpleCart_shelfItem\">");
			                           				out.print("<p> <i class=\"item_price\">" + listcase.get(i).Price + "</i></p>");
			                           				out.print("<p><a class=\"item_add\" href=\"/TakaZada/AddToCart/" 
					                           				+  "Case" + "/" 
					                           				+ listcase.get(i).Id + "/"
					                           				+ "1" + "/"
					                           				+ listcase.get(i).Price + "/"
					                           				+ listcase.get(i).Id + "/"
					                           				+ listcase.get(i).Name + "/"
					                           				+ listcase.get(i).Image + "/"
					                           				+ "\" >Add to cart</a></p>");
		                           				out.print("</div>");
		                           			out.print("</div>");
	                           			out.print("</div>");
	                           		out.print("</div>");
                           	 	}
                           	%>
                            <div class="clearfix"> </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="clearfix"> </div>
    </div>
</div>
<!-- //banner-bottom -->
<!-- banner-bottom1 -->
<div class="banner-bottom1">
    <div class="agileinfo_banner_bottom1_grids">
        <div class="col-md-7 agileinfo_banner_bottom1_grid_left" style="height: 265px;">
            <h3>Black friday<span>49% <i>Discount</i></span></h3>
            <a href="products.html">Shop Now</a>
        </div>
        <div class="col-md-5 agileinfo_banner_bottom1_grid_right" style="height: 265px;">
            <h4>hot deal</h4>
            <div class="timer_wrap">
                <div id="counter"> </div>
            </div>
            <script src="<c:url value="/Resources/Scripts/js/jquery.countdown.js"/>"></script>
            <script src="<c:url value="/Resources/Scripts/js/script.js"/>"></script>
        </div>
        <div class="clearfix"></div>
    </div>
</div>
<!-- //banner-bottom1 -->
<!-- special-deals -->
<div class="special-deals">
    <div class="container">
        <h2>Special Deals</h2>
        <div class="w3agile_special_deals_grids">
            <div class="col-md-7 w3agile_special_deals_grid_left">
                <div class="w3agile_special_deals_grid_left_grid">
                    <img src="<c:url value="/Resources/Content/Pictures/banner1.jpg"/>" style="object-fit: cover;height: 287px;" alt=" " class="img-responsive" />
                    <div class="w3agile_special_deals_grid_left_grid_pos1">
                        <h5>30%<span>Off/-</span></h5>
                    </div>
                    <div class="w3agile_special_deals_grid_left_grid_pos">
                        <h4 >We Offer <span style="color: #fff">Best Products</span></h4>
                    </div>
                </div>
                <div class="wmuSlider example1">
                    <div class="wmuSliderWrapper">
                        <article style="position: absolute; width: 100%; opacity: 0;">
                            <div class="banner-wrap">
                                <div class="w3agile_special_deals_grid_left_grid1">
                                    <img src="<c:url value="/Resources/Content/images/1.png"/>" alt=" " class="img-responsive" />
                                    <p>
                                        Quis autem vel eum iure reprehenderit qui in ea voluptate
                                        velit esse quam nihil molestiae consequatur, vel illum qui dolorem
                                        eum fugiat quo voluptas nulla pariatur
                                    </p>
                                    <h4>Laura</h4>
                                </div>
                            </div>
                        </article>
                        <article style="position: absolute; width: 100%; opacity: 0;">
                            <div class="banner-wrap">
                                <div class="w3agile_special_deals_grid_left_grid1">
                                    <img src="<c:url value="/Resources/Content/images/2.png"/>" alt=" " class="img-responsive" />
                                    <p>
                                        Quis autem vel eum iure reprehenderit qui in ea voluptate
                                        velit esse quam nihil molestiae consequatur, vel illum qui dolorem
                                        eum fugiat quo voluptas nulla pariatur
                                    </p>
                                    <h4>Michael</h4>
                                </div>
                            </div>
                        </article>
                        <article style="position: absolute; width: 100%; opacity: 0;">
                            <div class="banner-wrap">
                                <div class="w3agile_special_deals_grid_left_grid1">
                                    <img src="<c:url value="/Resources/Content/images/3.png"/>" alt=" " class="img-responsive" />
                                    <p>
                                        Quis autem vel eum iure reprehenderit qui in ea voluptate
                                        velit esse quam nihil molestiae consequatur, vel illum qui dolorem
                                        eum fugiat quo voluptas nulla pariatur
                                    </p>
                                    <h4>Rosy</h4>
                                </div>
                            </div>
                        </article>
                    </div>
                </div>
                <script src="<c:url value="/Resources/Scripts/js/jquery.wmuSlider.js"/>"></script>
                <script>
                    $('.example1').wmuSlider();
                </script>
            </div>
            <div class="col-md-5 w3agile_special_deals_grid_right">
                <div class="row">
                    <img src="<c:url value="/Resources/Content/Pictures/deal1.png"/>" style="object-fit: cover;margin-bottom: 5px;" alt=" " class="img-responsive" />
                </div>
                <div class="row">
                    <img src="<c:url value="/Resources/Content/Pictures/deal2.png"/>" style="object-fit: cover;margin-bottom: 5px;" alt=" " class="img-responsive" />
                </div>
                <div class="row">
                    <img src="<c:url value="/Resources/Content/Pictures/deal3.jpg"/>" style="object-fit: cover;" alt=" " class="img-responsive" />
                </div>
            </div>
            <div class="clearfix"> </div>
        </div>
    </div>
</div>
<!-- //special-deals -->
<!-- new-products -->
<div class="new-products">
    <div class="container">
        <h3>Computer</h3>
        <div class="agileinfo_new_products_grids">

            <div class="row">
                <div class="MultiCarousel" data-items="1,3,5,6" data-slide="1" id="MultiCarousel" data-interval="1000" style="height: 450px;">
                    <div class="MultiCarousel-inner">
                    <%
                   		 ArrayList<Computer> listcomputer = (ArrayList<Computer>)request.getAttribute("ListComputer");
	                    for ( int i = 0 ; i < 10 ; i++)
	                    {
	                   		out.print("<div class=\"item\" style=\"margin: 20px;\">");
	                   			out.print("<div class=\"col-md-4 agile_ecommerce_tab_left\" style=\"width:255px;height: 340px;background-color: transparent;\">");
	               	 				out.print("<div class=\"card\" style=\"width: 215px;\">");
	               	 					out.print("<a href=\"" + request.getAttribute("domainname") + "/ComputerDetail/" + listcomputer.get(i).Id + "\">");
	               	 						out.print(" <img class=\"card-img-top itemImage\" src=" + request.getAttribute("domainname") + "/Resources/Content/Pictures/Computer/" + listcomputer.get(i).Image.replace(" ", "%20") + " \"" + "alt=\"Card image cap\">");
	                   					out.print("</a>");
	                   					out.print("<div class=\"card-body\">");
		                   					out.print("<h5 class=\"card-title\">");  
	                    						out.print(" <a href=\"/TakaZada/ComputerDetail/" + listcomputer.get(i).Id + "\"" + ">");
	                    							out.print(listcomputer.get(i).Name);
	                    						out.print("</a>");
	                						out.print("</h5>");
	                   						out.print("<div class=\"simpleCart_shelfItem\">");
	                   							out.print("<p> <i class=\"item_price\">" + listcomputer.get(i).Price + "</i></p>");
	                   							out.print("<p><a class=\"item_add\" href=\"/TakaZada/AddToCart/" 
				                           				+  "Computer" + "/" 
				                           				+ listcomputer.get(i).Id + "/"
				                           				+ "1" + "/"
				                           				+ listcomputer.get(i).Price + "/"
				                           				+ listcomputer.get(i).Id + "/"
				                           				+ listcomputer.get(i).Name + "/"
				                           				+ listcomputer.get(i).Image + "/"
				                           				+ "\" >Add to cart</a></p>");
	                   						out.print("</div>");
	                   					out.print("</div>");
	                   				out.print("</div>");
	                   			out.print("</div>");
	                   		out.print("</div>");
	                    }
                    %>        
                    </div>
                    <button class="btn btn-primary leftLst"><</button>
                    <button class="btn btn-primary rightLst">></button>
                </div>
            </div>
            <div class="clearfix"> </div>
        </div>
    </div>
</div>
<!-- //new-products -->
<!-- top-brands -->
<div class="top-brands">
    <div class="container">
        <h3>Top Brands</h3>
        <div class="sliderfig">
            <ul id="flexiselDemo1">
                <li>
                    <img src="<c:url value="/Resources/Content/images/4.png"/>" alt=" " class="img-responsive" />
                </li>
                <li>
                    <img src="<c:url value="/Resources/Content/images/5.png"/>" alt=" " class="img-responsive" />
                </li>
                <li>
                    <img src="<c:url value="/Resources/Content/images/6.png"/>" alt=" " class="img-responsive" />
                </li>
                <li>
                    <img src="<c:url value="/Resources/Content/images/7.png"/>" alt=" " class="img-responsive" />
                </li>
                <li>
                    <img src="<c:url value="/Resources/Content/images/46.jpg"/>" alt=" " class="img-responsive" />
                </li>
            </ul>
        </div>
        <script type="text/javascript">
            $(window).load(function () {
                $("#flexiselDemo1").flexisel({
                    visibleItems: 4,
                    animationSpeed: 1000,
                    autoPlay: true,
                    autoPlaySpeed: 3000,
                    pauseOnHover: true,
                    enableResponsiveBreakpoints: true,
                    responsiveBreakpoints: {
                        portrait: {
                            changePoint: 480,
                            visibleItems: 1
                        },
                        landscape: {
                            changePoint: 640,
                            visibleItems: 2
                        },
                        tablet: {
                            changePoint: 768,
                            visibleItems: 3
                        }
                    }
                });

            });
        </script>
        <script src="<c:url value="/Resources/Scripts/js/jquery.flexisel.js"/>"></script>
    </div>
</div>
<!-- //top-brands -->
<!-- newsletter -->
<div class="newsletter">
    <div class="container">
        <div class="col-md-6 w3agile_newsletter_left">
            <h3>Newsletter</h3>
            <p>Excepteur sint occaecat cupidatat non proident, sunt.</p>
        </div>
        <div class="col-md-6 w3agile_newsletter_right">
            <form action="#" method="post">
                <input type="email" name="Email" value="Email" onfocus="this.value = '';" onblur="if (this.value == '') {this.value = 'Email';}" required="">
                <input type="submit" value="" />
            </form>
        </div>
        <div class="clearfix"> </div>
    </div>
</div>

	
</body>
