<%@ page language="java" contentType="text/html; charset=utf-8"%>

<%@ page import="java.util.ArrayList,TakaZada.Model.*" %>
<!-- breadcrumbs -->
<div class="breadcrumb_dress">
    <div class="container">
        <ul>
            <li><a href="/TakaZada"><span class="glyphicon glyphicon-home" aria-hidden="true"></span> Home </a> <i>/</i></li>
            <li>VGA</li>
        </ul>
    </div>
</div>
<!-- //breadcrumbs -->
<!-- dresses -->
<div class="dresses">
    <div class="container">
        <div class="w3ls_dresses_grids">
            <div class="col-md-4 w3ls_dresses_grid_left">
                <div class="w3ls_dresses_grid_left_grid">
                    <h3>Categories</h3>
                    <div class="w3ls_dresses_grid_left_grid_sub">
                        <div class="panel-group" id="accordion" role="tablist" aria-multiselectable="true">
                            <div class="panel panel-default">
                                <div class="panel-heading" role="tab" id="headingOne">
                                    <h4 class="panel-title asd">
                                        <a class="pa_italic" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseOne" aria-expanded="true" aria-controls="collapseOne">
                                            <span class="glyphicon glyphicon-plus" aria-hidden="true"></span><i class="glyphicon glyphicon-minus" aria-hidden="true"></i>New Arrivals
                                        </a>
                                    </h4>
                                </div>
                                <div id="collapseOne" class="panel-collapse collapse in" role="tabpanel" aria-labelledby="headingOne">
                                    <div class="panel-body panel_text">
                                        <ul>
                                            <li><a href="/TakaZada/ListVGA/Asus">Asus</a></li>
                                            <li><a href="/TakaZada/ListVGA/MSI">MSI</a></li>
                                            <li><a href="/TakaZada/ListVGA/GIGABYTE">GIGABYTE</a></li>
                                            <li><a href="/TakaZada/ListVGA/Galax">Galax</a></li>
                                            <li><a href="/TakaZada/ListVGA">Tất cả</a></li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                            <div class="panel panel-default">
                                <div class="panel-heading" role="tab" id="headingTwo">
                                    <h4 class="panel-title asd">
                                        <a class="pa_italic collapsed" role="button" data-toggle="collapse" data-parent="#accordion" href="#collapseTwo" aria-expanded="false" aria-controls="collapseTwo">
                                            <span class="glyphicon glyphicon-plus" aria-hidden="true"></span><i class="glyphicon glyphicon-minus" aria-hidden="true"></i>Foot Wear
                                        </a>
                                    </h4>
                                </div>
                               
                            </div>
                        </div>
                      
                    </div>
                </div>       
            </div>
            <div class="col-md-8 w3ls_dresses_grid_right">
                <div class="clearfix"> </div>
                <div class="w3ls_dresses_grid_right_grid2">
                    <div class="w3ls_dresses_grid_right_grid2_left">
                        <h3>Showing Results: 0-1</h3>
                    </div>
                    <div class="w3ls_dresses_grid_right_grid2_right">
                        <select name="select_item" class="select_item">
                            <option selected="selected">Default sorting</option>
                            <option>Sort by popularity</option>
                            <option>Sort by average rating</option>
                            <option>Sort by newness</option>
                            <option>Sort by price: low to high</option>
                            <option>Sort by price: high to low</option>
                        </select>
                    </div>
                    <div class="clearfix"> </div>
                </div>
               <%
                	ArrayList<VGA> listvga = (ArrayList<VGA>)request.getAttribute("ListVGA");
                	for ( int i = 1 ; i <= listvga.size() ; i++)
                	{
                		if ( i % 3 == 0 || i == 1)
                		{
                			out.print("<div class=\"w3ls_dresses_grid_right_grid3\">");
                		}
                				out.print("<div class=\"col-md-4 agileinfo_new_products_grid agileinfo_new_products_grid_dresses\">");
                					out.print("<div class=\"agile_ecommerce_tab_left dresses_grid\">");
                						out.print(" <img src=" + request.getAttribute("domainname") + "/Resources/Content/Pictures/VGA/" + listvga.get(i-1).Image.replace(" ", "%20") + " \"" + "alt=\"\" class=\"img-responsive\" style=\" width: 200px;height: 170px;\" />");
                						out.print("<h5><a href=\"" + request.getAttribute("domainname") + "/VGADetail/" + listvga.get(i-1).Id + "\">" + listvga.get(i-1).Name + "</a></h5>");
                						out.print("<div class=\"simpleCart_shelfItem\">");
                							out.print("<i class=\"item_price\">" + listvga.get(i-1).Price + "</i></p>");       							
                						out.print("</div>");
                					out.print("</div>");
                				out.print("</div>");
                		if ( i % 3 == 0)
                		{
                			out.print("</div>");
                			out.print("<div class=\"clearfix\"> </div>");
                		}
                	}
                %>
            </div>
            <div class="clearfix"> </div>
        </div>
    </div>
</div>