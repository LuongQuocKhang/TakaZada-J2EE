<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ page import="java.util.ArrayList,TakaZada.Model.Computer" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
	Computer _computer = (Computer)request.getAttribute("Computer");
%>
<style>
    table td {
        color: black;
    }
</style>
<!-- breadcrumbs -->
<script src="<c:url value="/Resources/Scripts/jquery-migrate-3.0.0.js"/>"></script>
<div class="breadcrumb_dress">
    <div class="container">
        <ul>
            <li><a href="/TakaZada"><span class="glyphicon glyphicon-home" aria-hidden="true"></span> Home </a> <i>/</i></li>
            <li>Details</li>
        </ul>
    </div>
</div>
<!-- //breadcrumbs -->
<!-- single -->
<div class="single">
    
    <div class="container">
        <h3 class='success-mesage font-green-sharp' style='display: none;font-size: 20px;color: #000000!important;font-weight: bold;'>
            Cập nhật giỏ hàng thành công
        </h3>
        <h3 class='error-mesage font-green-sharp' style='display: none;font-size: 20px;color: #000000!important;font-weight: bold;'>
            Lỗi xảy ra khi cập nhật giỏ hàng !!
        </h3>
        <!-- @{
            if (null != Session["submit_message"])
            {
                @Html.Raw("<h3 class='error-mesage' style='display: none;'>" + Session["submit_message"] + "</h3>");
                <script type="text/javascript">
                    $(function () {
                        $('.error-mesage').delay(500).fadeIn('normal', function () {
                            $(this).delay(2500).fadeOut();
                        });
                    });
                </script>
                Session["submit_message"] = null;
            }
        } -->
        <div class="col-md-4 single-left">
            <div class="flexslider">
                <ul class="slides">
                    <% out.print("<li data-thumb=\"" + request.getAttribute("domainname") + "/Resources/Content/Pictures/Computer/" + _computer.Image.replace(" ", "%20") + "\"" + ">"); %>
                        <div class="thumb-image">
                        	<% out.print("<img src=\""+ request.getAttribute("domainname") + "/Resources/Content/Pictures/Computer/" + _computer.Image.replace(" ", "%20") + "\"" + "data-imagezoom=\"true\" class=\"img-responsive\"> "); %>
                        </div>
                    </li>
                    <% out.print("<li data-thumb=\"" + request.getAttribute("domainname") + "/Resources/Content/Pictures/Computer/" + _computer.Image.replace(" ", "%20") + "\"" + ">"); %>
                        <div class="thumb-image"> 
                        	<% out.print("<img scr=\""+ request.getAttribute("domainname") + "/Resources/Content/Pictures/Computer/" + _computer.Image.replace(" ", "%20") + "\"" + "data-imagezoom=\"true\" class=\"img-responsive\"> "); %>
                        </div>
                    </li>
                    <% out.print("<li data-thumb=\"" + request.getAttribute("domainname") + "/Resources/Content/Pictures/Computer/" + _computer.Image.replace(" ", "%20") + "\"" + ">"); %>
                        <div class="thumb-image"> 
                        	<% out.print("<img scr=\""+ request.getAttribute("domainname") + "/Resources/Content/Pictures/Computer/" + _computer.Image.replace(" ", "%20") + "\"" + "data-imagezoom=\"true\" class=\"img-responsive\"> "); %> 
                        </div>
                    </li>
                </ul>
            </div>
            <!-- flixslider -->
            <script src="<c:url value="/Resources/Scripts/js/jquery.flexslider.js"/>"></script>
            <link href="<c:url value="/Resources/Content/css/flexslider.css"/>" rel="stylesheet" />
            <script>
                // Can also be used with $(document).ready()
                $(window).load(function () {
                    $('.flexslider').flexslider({
                        animation: "slide",
                        controlNav: "thumbnails"
                    });
                });
            </script>
            <!-- flixslider -->
            <!-- zooming-effect -->
            <script src="<c:url value="/Resources/Scripts/js/imagezoom.js"/>"></script>
            <!-- //zooming-effect -->
        </div>
        <div class="col-md-8 single-right">
            <% out.print("<h3>" + _computer.Name + "</h3>"); %>
            <div class="rating1">
                <span class="starRating">
                    <input id="rating5" type="radio" name="rating" value="5">
                    <label for="rating5">5</label>
                    <input id="rating4" type="radio" name="rating" value="4">
                    <label for="rating4">4</label>
                    <input id="rating3" type="radio" name="rating" value="3" checked>
                    <label for="rating3">3</label>
                    <input id="rating2" type="radio" name="rating" value="2">
                    <label for="rating2">2</label>
                    <input id="rating1" type="radio" name="rating" value="1">
                    <label for="rating1">1</label>
                </span>
            </div>
            <div class="color-quality">
                <div class="color-quality-left">
                    <h5>Color : </h5>
                    <ul>
                        <li><a href="#"><span></span>Red</a></li>
                        <li><a href="#" class="brown"><span></span>Yellow</a></li>
                        <li><a href="#" class="purple"><span></span>Purple</a></li>
                        <li><a href="#" class="gray"><span></span>Violet</a></li>
                    </ul>
                </div>
                <div class="color-quality-right">
                    <h5>Quality :</h5>
                    <div class="quantity">
                        <div class="quantity-select">
                            <div class="entry value-minus1">&nbsp;</div>
                            <div class="entry value1"><span>1</span></div>
                            <div class="entry value-plus1 active">&nbsp;</div>
                        </div>
                    </div>
                    <!--quantity-->
                    <script>
                        $('.value-plus1').on('click', function () {
                            var divUpd = $(this).parent().find('.value1'), newVal = parseInt(divUpd.text(), 10) + 1;
                            divUpd.text(newVal);
                        });

                        $('.value-minus1').on('click', function () {
                            var divUpd = $(this).parent().find('.value1'), newVal = parseInt(divUpd.text(), 10) - 1;
                            if (newVal >= 1) {
                                divUpd.text(newVal);
                            }
                        });
                    </script>
                    <!--quantity-->

                </div>
                <div class="clearfix"> </div>
            </div>
            <div class="simpleCart_shelfItem">
                <p><i class="item_price">
                	</i> <% out.print(_computer.Price); %>
                </p>
                <p><a class="item_add" id="btnBuy" href="#">Add to cart</a></p>
            </div>

        </div>
        <div class="clearfix"> </div>
    </div>
</div>

<div class="additional_info">
    <div class="container">
        <div class="sap_tabs">
            <div id="horizontalTab1" style="display: block; width: 100%; margin: 0px;">
                <ul>
                    <li class="resp-tab-item" aria-controls="tab_item-0" role="tab"><span>Mô tả sản phẩm</span></li>
                    <li class="resp-tab-item" aria-controls="tab_item-1" role="tab"><span>Thông số kỹ thuật</span></li>
                </ul>
                <div class="tab-1 resp-tab-content additional_info_grid" aria-labelledby="tab_item-0">
                    <% out.print("<h3>" + _computer.Name + "</h3>"); %>
                    <% out.print("<p>" + _computer.Description + "</p>"); %>
                </div>
                <input type="hidden" name="Name" id="Name" value="@SelectedComputer.Name" />
                <input type="hidden" name="Image" id="Image" value="@SelectedComputer.Image" />
                <div class="tab-2 resp-tab-content additional_info_grid" aria-labelledby="tab_item-1">
                    <h4>Chi tiết sản phẩm</h4>
                    <% out.print("<h3>" + _computer.Name + "</h3>"); %>
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th>Thông số</th>
                                <th>Chi tiết</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>
                                    Name
                                </td>
                                <td style="column-span:all;">
                                    <% out.print(_computer.Name);  %>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    CPU
                                </td>
                                <td style="column-span:all;">
                                    <% out.print(_computer.CPU); %>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    RAM
                                </td>
                                <td style="column-span:all;">
                                    <% out.print(_computer.RAM); %>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    Hardware
                                </td>
                                <td style="column-span:all;">                                   
                                    <% out.print(_computer.Hardware); %>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    VideoCard
                                </td>
                                <td style="column-span:all;">
                                    <% out.print(_computer.VideoCard); %>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    Display
                                </td>
                                <td style="column-span:all;">
                                    <% out.print(_computer.Display); %>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    SlotSupport
                                </td>
                                <td style="column-span:all;">
                                    <% out.print(_computer.SlotSupport); %>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    OS
                                </td>
                                <td style="column-span:all;">
                                    <% out.print(_computer.OS); %>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    Type
                                </td>
                                <td style="column-span:all;">
                                    <% out.print(_computer.Type); %>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    Trademark
                                </td>
                                <td style="column-span:all;">
                                    <% out.print(_computer.Trademark); %>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    CPUSeries
                                </td>
                                <td style="column-span:all;">
                                     <% out.print(_computer.CPUSeries); %>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    ScreenSize
                                </td>
                                <td style="column-span:all;">
                                     <% out.print(_computer.ScreenSize); %>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    Feature
                                </td>
                                <td style="column-span:all;">
                                      <% out.print(_computer.Feature); %>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    Size
                                </td>
                                <td style="column-span:all;">
                                     <% out.print(_computer.Size); %>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    StandardOfScreen
                                </td>
                                <td style="column-span:all;">
                                     <% out.print(_computer.StandardOfScreen); %>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    Mass
                                </td>
                                <td style="column-span:all;">
                                     <% out.print(_computer.Mass); %>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    Color
                                </td>
                                <td style="column-span:all;">
                                     <% out.print(_computer.Color); %>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        <script src="<c:url value="/Resources/Scripts/js/easyResponsiveTabs.js"/>"></script>
        <script type="text/javascript">
            $(document).ready(function () {
                $('#horizontalTab1').easyResponsiveTabs({
                    type: 'default', //Types: default, vertical, accordion
                    width: 'auto', //auto or any width like 600px
                    fit: true   // 100% fit in a container
                });
            });
        </script>
    </div>
</div>
<div class="w3l_related_products">
    <div class="container">
        <h3>Related Products</h3>
        <ul id="flexiselDemo2">
        <% 
        	ArrayList<Computer> RelatedComputerList = (ArrayList<Computer>)request.getAttribute("TheSameTrademark");
        	for( int i = 0 ; i < RelatedComputerList.size() ; i++)
        	{
        		out.print("<li>");
        			out.print("<div class=\"w3l_related_products_grid\">");
        				out.print("<div class=\"agile_ecommerce_tab_left dresses_grid\">");
        					out.print("<div class=\"hs-wrapper3\">");
        						out.print("<img src=\"" + request.getAttribute("domainname") + "/Resources/Content/Pictures/Computer/" + RelatedComputerList.get(i).Image + "\"" + "alt=\" \" class=\"img-responsive\">");
        					out.print("</div>");
        					out.print("<h5>" + "<a href=\"" + request.getAttribute("domainname") + "/ComputerDetail/" + RelatedComputerList.get(i).Id + "\"> " +  RelatedComputerList.get(i).Name + "</a></h5>");
        					out.print("<div class=\"simpleCart_shelfItem\">");
        						out.print(" <p class=\"flexisel_ecommerce_cart\"><i class=\"item_price\">" + RelatedComputerList.get(i).Price + "</i></p>");
        						out.print("<p><a class=\"item_add\" href=\"\">Add to cart</a></p>");
        					out.print("</div>");
        				out.print("</div>");
        			out.print("</div>");
        		out.print("</li>");
        	}
        %>      
        </ul>
        <script type="text/javascript">
            $(window).load(function () {
                $("#flexiselDemo2").flexisel({
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
<script charset="utf-8">
    $("#btnBuy").on('click', function () {
        $.ajax(
            {
                url: "",
                method: "POST",
                /* data: { }, */
                    success: function (response) {
                        if (response != null && response.result == true) {
                            $(function () {
                                $('.success-mesage').delay(500).fadeIn('normal', function () {
                                    $(this).delay(2500).fadeOut();
                                });
                            });
                        }
                        else {
                            $(function () {
                                $('.error-mesage').delay(500).fadeIn('normal', function () {
                                    $(this).delay(2500).fadeOut();
                                });
                            });
                        }
                    }
                })
        });
</script>