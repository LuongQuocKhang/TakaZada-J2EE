<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%@ page import="java.util.ArrayList,TakaZada.Model.*" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%
	CPU _cpu = (CPU)request.getAttribute("CPU");
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
            <li><a href="index.html"><span class="glyphicon glyphicon-home" aria-hidden="true"></span> Home</a> <i>/</i></li>
            <li>Details</li>
        </ul>
    </div>
</div>
<!-- //breadcrumbs -->
<!-- single -->
<div class="single">
    <div class="container">
       	<h3 class='success-mesage font-green-sharp' style='display: none;font-size: 20px;color: #00db00!important;font-weight: bold;'>
            Cập nhật giỏ hàng thành công
        </h3>
        <h3 class='error-mesage font-green-sharp' style='display: none;font-size: 20px;color: #f44141!important;font-weight: bold;'>
            Lỗi xảy ra khi cập nhật giỏ hàng !!
        </h3> 
        <div class="col-md-4 single-left">
            <div class="flexslider">
                <ul class="slides">
                    <% out.print("<li data-thumb=\"" + request.getAttribute("domainname") + "/Resources/Content/Pictures/CPU/" + _cpu.Image.replace(" ", "%20") + "\"" + ">"); %>
                        <div class="thumb-image">
                        	<% out.print("<img src=\""+ request.getAttribute("domainname") + "/Resources/Content/Pictures/CPU/" + _cpu.Image.replace(" ", "%20") + "\"" + "data-imagezoom=\"true\" class=\"img-responsive\"> "); %>
                        </div>
                    </li>
                    <% out.print("<li data-thumb=\"" + request.getAttribute("domainname") + "/Resources/Content/Pictures/CPU/" + _cpu.Image.replace(" ", "%20") + "\"" + ">"); %>
                        <div class="thumb-image"> 
                        	<% out.print("<img scr=\""+ request.getAttribute("domainname") + "/Resources/Content/Pictures/CPU/" + _cpu.Image.replace(" ", "%20") + "\"" + "data-imagezoom=\"true\" class=\"img-responsive\"> "); %>
                        </div>
                    </li>
                    <% out.print("<li data-thumb=\"" + request.getAttribute("domainname") + "/Resources/Content/Pictures/CPU/" + _cpu.Image.replace(" ", "%20") + "\"" + ">"); %>
                        <div class="thumb-image"> 
                        	<% out.print("<img scr=\""+ request.getAttribute("domainname") + "/Resources/Content/Pictures/CPU/" + _cpu.Image.replace(" ", "%20") + "\"" + "data-imagezoom=\"true\" class=\"img-responsive\"> "); %> 
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
            <h3><% out.print(_cpu.Name); %></h3>
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
                <p><i class="item_price"></i><% out.print(_cpu.Price); %></p>
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
                    <% out.print(_cpu.Name); %>
                    <p>
                        <% out.print(_cpu.Description); %>
                    </p>
                </div>
                <input type="hidden" name="Name" id="Name" value="<% out.print(_cpu.Name); %>" />
                <input type="hidden" name="Image" id="Image" value="<% out.print(_cpu.Image); %>" />
                <div class="tab-2 resp-tab-content additional_info_grid" aria-labelledby="tab_item-1">
                    <h4>Chi tiết sản phẩm</h4>
                    <h3><% out.print(_cpu.Name); %></h3>
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
                                    <% out.print(_cpu.Name); %>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    TradeMark
                                </td>
                                <td style="column-span:all;">
                                    <% out.print(_cpu.TradeMark); %>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    CPUType
                                </td>
                                <td style="column-span:all;">
                                    <% out.print(_cpu.CPUType); %>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    CPULine
                                </td>
                                <td style="column-span:all;">
                                    <% out.print(_cpu.CPULine); %>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    CoreNum
                                </td>
                                <td style="column-span:all;">
                                    <% out.print(_cpu.CoreNum); %>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    ThreadNum
                                </td>
                                <td style="column-span:all;">
                                    <% out.print(_cpu.ThreadNum); %>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    CoreCPU
                                </td>
                                <td style="column-span:all;">
                                    <% out.print(_cpu.CoreCPU); %>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    CacheCPU
                                </td>
                                <td style="column-span:all;">
                                    <% out.print(_cpu.CacheCPU); %>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    BasicPulse
                                </td>
                                <td style="column-span:all;">
                                    <% out.print(_cpu.BasicPulse); %>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    MaxPulse
                                </td>
                                <td style="column-span:all;">
                                    <% out.print(_cpu.MaxPulse); %>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    Size
                                </td>
                                <td style="column-span:all;">
                                    <% out.print(_cpu.Size); %>
                                </td>
                            </tr>
                            <tr>
                                <td>
                                    WarrantyPeriod
                                </td>
                                <td style="column-span:all;">
                                    <% out.print(_cpu.WarrantyPeriod); %>
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
        	ArrayList<CPU> TheSameTrademark = (ArrayList<CPU>)request.getAttribute("TheSameTrademark");
        	for( int i = 0 ; i < TheSameTrademark.size() ; i++)
        	{
        		out.print("<li>");
        			out.print("<div class=\"w3l_related_products_grid\">");
        				out.print("<div class=\"agile_ecommerce_tab_left dresses_grid\">");
        					out.print("<div class=\"hs-wrapper3\">");
        						out.print("<img src=\"" + request.getAttribute("domainname") + "/Resources/Content/Pictures/CPU/" + TheSameTrademark.get(i).Image + "\"" + "alt=\" \" class=\"img-responsive\">");
        					out.print("</div>");
        					out.print("<h5>" + "<a href=\"" + request.getAttribute("domainname") + "/CPUDetail/" + TheSameTrademark.get(i).Id + "\"> " +  TheSameTrademark.get(i).Name + "</a></h5>");
        					out.print("<div class=\"simpleCart_shelfItem\">");
        						out.print(" <p class=\"flexisel_ecommerce_cart\"><i class=\"item_price\">" + TheSameTrademark.get(i).Price + "</i></p>");
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
<script>
$("#btnBuy").on('click', function () {
    $.ajax(
        {
            url: "<% out.print(request.getAttribute("domainname")); %>" + "/AddToCart/",
            method: "POST",
            data: { "type": "CPU", "ItemId": "<% out.print(_cpu.Id); %>", "Quantity": $(".value1").text(), "price": "<% out.print(_cpu.Price); %>", "Id": "<% out.print(_cpu.Id); %>", "Name": $("#Name").val(), "Image": $("#Image").val() },
            success: function (response) {
                if (response == true) {
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