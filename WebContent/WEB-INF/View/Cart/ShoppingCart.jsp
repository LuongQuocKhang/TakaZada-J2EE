<%@page import="java.net.URLEncoder"%>
<%@page import="java.util.ArrayList"%>
<%@page import="TakaZada.Model.CartDetails"%>
<%@ page language="java" contentType="text/html; charset=utf-8"%>
<%  ArrayList<CartDetails> CartDetails = (ArrayList<CartDetails>)request.getAttribute("CartDetails");%>
<div class="checkout">
    <div class="container">
        <h3 class='success-mesage font-green-sharp' style='display: none;font-size: 20px;color: #000000!important;font-weight: bold;'>
            Thanh toán thành công
        </h3>
        <h3 class='error-mesage font-green-sharp' style='display: none;font-size: 20px;color: #000000!important;font-weight: bold;'>
            Lỗi xảy ra khi thanh toán !!
        </h3>
         <h3 class='font-green-sharp' id="success" style='display: none;font-size: 20px;color: #000000!important;font-weight: bold;'>
            Cập nhật thành công
        </h3>
        <h3 class='error-mesage font-green-sharp' id="error" style='display: none;font-size: 20px;color: #000000!important;font-weight: bold;'>
            Cập nhật không thành công !!
        </h3>

        <h3>Your shopping cart contains: <span>3 Products</span></h3>

        <div class="checkout-right">
            <table class="timetable_sub">
                <thead>
                    <tr>
                        <th>Item id</th>
                        <th>Image</th>
                        <th>Name</th>
                        <th>Type</th>
                        <th>Service Charges</th>
                        <th>Price</th>
                        <th>Remove</th>
                    </tr>
                </thead>
                <% for (int i = 0; i < CartDetails.size(); i++) 
                {
                	out.print("<tr class=" + "rem" + (i + 1) + ">");
                		out.print("<td class=\"invert\">" + CartDetails.get(i).ItemId + "</td>");
                		out.print("<td class=\"invert-image\">");
                			out.print("<a href=\"\">");
                				out.print("<img src=\"" + request.getAttribute("domainname") + "/Resources/Content/Pictures/" + CartDetails.get(i).type + "/" + CartDetails.get(i).Image.replace(" ", "%20") + "\"" + "alt=\" \" class=\"img-responsive\" style=\" width: 150px;height: 150px;\" />");
                			out.print("</a>");
                		out.print("</td>");
                		out.print("<td class=\"invert\">" + CartDetails.get(i).Name + "</td>");
                			out.print("<td class=\"invert\">");
                				out.print("<div class=\"quantity\">");
                					out.print("<div class=\"quantity-select\">");
                						out.print("<div class=\"entry value-minus\" id=\"" + (i + 1) + "\"" + ">&nbsp;</div>");
                						out.print("<div class=\"entry value\"><span>" + CartDetails.get(i).Quantity + "</span></div>");
                						out.print("<div class=\"entry value-plus active\" id=\"" + (i + 1) + "\"" + ">&nbsp;</div>");
                					out.print("</div>");
                				out.print("</div>");
                			out.print("</td>");
                			out.print("<td class=\"invert\">$5.00</td>");
                			out.print("<td class=\"invert\">" + CartDetails.get(i).price + "</td>");
                			out.print("<td class=\"invert\">");
                				out.print("<div class=\"" + "rem" + (i + 1) + " rem" + "\" " + "style=\"height: 164px;\">");
                					out.print("<div class=\"" + "close" + (i + 1) + " close" + "\" "  + "style=\"margin-right: 15px;margin-top: 65px;\"> </div>");
                				out.print("</div>");
                				/* còn script  */
                			out.print("</td>");
                				/* 2 đoạn script  */
                		out.print("</tr>");
                		out.println("<script>");
                			out.println(" $(document).ready(function (c) {");
                				out.println("$('.close" + (i + 1) + "').on('click', function (c) {");
                					out.println("$('.rem" + (i + 1) + "').fadeOut('slow', function (c) {");
                						out.println("$('.rem" + (i + 1) + "').remove();");
                					out.println("});");
                					out.println("$.ajax({");
                						out.println("url:" + "\"" + request.getAttribute("domainname") + "/RemoveCartDetails/\",");
                						out.println("method: \"POST\",");
                						out.println("data: { \"CartDetailId\": " + CartDetails.get(i).ID +  "},");
                						out.println("success: function (response) {");
                							out.println("location.reload();}");
                						out.println("})");
                					out.println("});");
                				out.println(" });");
                			out.println("</script>");
                			out.println("<script>");
                				out.println("$(\"" + "#" + (i + 1) + ".value-plus \").on('click', function () {");
                				out.println("var divUpd = $(this).parent().find('.value'), newVal = parseInt(divUpd.text(), 10) + 1;");
                				out.println("divUpd.text(newVal);");
                				out.println("$.ajax({");
                				out.println("url:" + "\"" + request.getAttribute("domainname") + "/IncreaseQuantity/\",");
                				out.println("method: \"POST\",");
                				out.println("data: { \"CartDetailId\":" + CartDetails.get(i).ID +  "},");
                				out.println("success: function (response) {");
                						out.println("location.reload();}");
                				out.println("})");
                			out.println(" });");
                			out.println("</script>");           			
            			out.println("<script>");
	        				out.println("$(\"" + "#" + (i + 1) + ".value-minus \").on('click', function () {");
	        				out.println("var divUpd = $(this).parent().find('.value'), newVal = parseInt(divUpd.text(), 10) - 1;");
	        				out.println("if (newVal >= 1) divUpd.text(newVal);");
	        				out.println("$.ajax({");
	        				out.println("url:" + "\"" + request.getAttribute("domainname") + "/DescreaseQuantity/\",");
	        				out.println("method: \"POST\",");
	        				out.println("data: { \"CartDetailId\":" + CartDetails.get(i).ID +  "},");
	        				out.println("success: function (response) {");
	        						out.println("location.reload();}");
	        				out.println("})");
	        				out.println(" });");
        			out.println("</script>");
                }
                %>     
            </table>
        </div>
        <div class="checkout-left">
            <div class="checkout-left-basket">

                <ul>
                    <%
                    	double price = 0;
                    	double total = 0.0;
                    	for ( int i = 0 ; i < CartDetails.size() ; i++)
                    	{
                    		price += Integer.parseInt(CartDetails.get(i).price.replace(".", "").replace("đ", ""));
                    		out.print("<li>" + CartDetails.get(i).Name + "<i>-</i> <span>" +  String.format ("%.0f", (price * CartDetails.get(i).Quantity)) +  " đ </span></li>");
                    		total += price * CartDetails.get(i).Quantity;
                    	}
                    %>
                    <li>Total Service Charges <i>-</i> <span>15.000 đ</span></li>
                    <li>Total <i>-</i> <span> <% out.print(String.format ("%.0f",total));%> đ</span></li>
                </ul>
            </div>
            <div class="checkout-right-basket">
                <a href=""><span class="glyphicon glyphicon-menu-left" aria-hidden="true"></span>Continue Shopping</a>
            </div>
            <div class="clearfix"> </div>
            <h4>
                <a href="#" id="btnBuy" style="background-color:#ff9b05;color:white;" class="btn">Thanh toán</a>
            </h4>
        </div>
    </div>
</div>
<script charset="utf-8">
    $("#btnBuy").on('click', function () {
        $.ajax(
            {
                url: "<% out.print(request.getAttribute("domainname"));%>" + "/Purchase/",
                method: "POST",
                data: { "Total": <% out.print(String.format ("%.0f", total)); %>},
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