<%@page import="TakaZada.Model.UserLogin"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="header">
        <div class="container">
            <div class="w3l_login" >
                <a href="#" style="
                <% 
                	UserLogin user = (UserLogin)request.getSession().getAttribute("USER_SESSION");
                	if ( user != null )
                	{
                		out.print("background-color:#ff9b05");
                	}
                %>
                " data-toggle="modal" data-target="#myModal88"><span class="glyphicon glyphicon-user" aria-hidden="true"></span></a>
            </div>
            <div class="w3l_logo">
                <h1><a href="/TakaZada">TakaZada</a></h1>
            </div>
            <div class="search">
                <input class="search_box" type="checkbox" id="search_box">
                <label class="icon-search" for="search_box"><span class="glyphicon glyphicon-search" aria-hidden="true"></span></label>
                <div class="search_form">
                    <form action="" method="post" style="width: 100%; height: 100%">
                        <select id="SearchCondition" name="SearchCondition" class="col-md-3">
                            <option value="Case">Case</option>
                            <option value="Computer">Computer</option>
                            <option value="CPU">CPU</option>
                            <option value="Hardware">Hardware</option>
                            <option value="Keyboard">Keyboard</option>
                            <option value="Mainboard">Mainboard</option>
                            <option value="RAM">RAM</option>
                            <option value="Radiator">Radiator</option>
                            <option value="VGA">VGA</option>
                            <option value="Tất cả">Tất cả</option>
                        </select>
                        <input type="text" placeholder="Search..." class="col-md-4" style="width: 50%;" id="SearchResult" name="SearchResult">
                        <input type="submit" value="Send" class="col-md-2">
                    </form>
                </div>
            </div>
            <div class="cart box_1">
                <a href="/TakaZada/ShoppingCart">
                    <div class="total">
                        <span class="simpleCart_total"></span> (<span id="simpleCart_quantity" class="simpleCart_quantity"></span> items)
                    </div>
                    <img src="<c:url value="/Resources/Content/images/bag.png"/>"  alt=""/>
                </a>
                <p><a href="javascript:;" class="simpleCart_empty">Empty Cart</a></p>
                <div class="clearfix"> </div>
            </div>
            <div class="clearfix"> </div>
        </div>
    </div>
	