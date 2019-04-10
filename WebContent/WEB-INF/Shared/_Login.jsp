<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@page import="TakaZada.Model.UserLogin"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div class="modal fade" id="myModal88" tabindex="-1" role="dialog" aria-labelledby="myModal88"
     aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">
                    &times;
                </button>
                <% 
                UserLogin user = (UserLogin)request.getSession().getAttribute("USER_SESSION");
                if (user != null)
                {
                    out.print("<h4 class=\"modal-title\" id=\"myModalLabel\">");
                        out.print("Hello," + user.Name + " !");
                    out.print("</h4>");
                    
                    out.print("<form method=\"get\" action=\"\">");
                    	out.print("<div class=\"sign-up\">");
                        	out.print("<button class=\"btn btn-default form-control\">Kiểm tra đơn hàng</button>");
                        	out.print("<button class=\"btn btn-default form-control\">Log out</button>");
                    out.print("</div>");
                out.print("</form>");
                }
                else
                {
                 	out.print("<h4 class=\"modal-title\" id=\"myModalLabel\">");
                 	out.print("Don't Wait, Login now!");
                 	out.print("</h4>");
                } %>
                 
                        
                   
            </div>
             <div class="modal-body modal-body-sub">
                    <div class="row">
                        <div class="col-md-8 modal_body_left modal_body_left1" style="border-right: 1px dotted #C2C2C2;padding-right:3em;">
                            <div class="sap_tabs">
                                <div id="horizontalTab" style="display: block; width: 100%; margin: 0px;">
                                    <ul>
                                        <li class="resp-tab-item" aria-controls="tab_item-0"><span>Sign in</span></li>
                                        <li class="resp-tab-item" aria-controls="tab_item-1"><span>Sign up</span></li>
                                    </ul>
                                    <div class="tab-1 resp-tab-content" aria-labelledby="tab_item-0">
                                        <div class="facts">
                                            <div class="register">
                                                <form method="post" action="/TakaZada/Login">
                                                    <input name="Email" placeholder="Email Address" id="Email" type="text" required="">
                                                    <input name="Password" placeholder="Password" id="Password" type="password" required="">
                                                    <div class="sign-up">
                                                        <input type="submit" value="Sign in" />
                                                    </div>
                                                </form>
                                            </div>
                                        </div>
                                    </div>

                                    <div class="tab-2 resp-tab-content" aria-labelledby="tab_item-1">
                                        <div class="facts">
                                            <div class="register">
                                                <form action="/TakaZada/Register" method="post">
                                                    <div class="form-group">
                                                        <input placeholder="First Name" name="FirstName" id="FirstName" type="text" required="">
                                                    </div>
                                                    <input placeholder="Last Name" name="LastName" id="LastName" type="text" required="">

                                                    <input placeholder="Email Address" name="EmailRes" id="EmailRes" type="email" required="">
                                                    <input placeholder="Password" name="PasswordPes" id="PasswordPes" type="password" required="">

                                                    <div class="form-group">
                                                        <input placeholder="Confirm Password" name="ComfirmPassword" id="ComfirmPassword" type="password" required="">
                                                    </div>
                                                    <div class="form-group">
                                                        <input placeholder="Phonenumber" name="Phonenumber" id="Phonenumber" type="text">
                                                    </div>
                                                    <div class="form-group">
                                                        <input placeholder="Address" name="Address" id="Address" type="text">
                                                    </div>
                                                    <div class="form-group">
                                                        <select class="form-control" id="Sex" name="Sex">
                                                            <option>Male</option>
                                                            <option>Female</option>
                                                        </select>
                                                    </div>
                                                    <div class="form-group">
                                                        <div class="input-group date margin-bottom-5 date-picker" data-date-format="dd/mm/yyyy">
                                                            <input type="text" class="form-control form-filter input-sm" name="DateOfBirth" id="DateOfBirth" placeholder="Date Of Birth" value="">
                                                            <span class="input-group-btn">
                                                                <button class="btn btn-sm default form-control" type="button">
                                                                    <i class="fa fa-calendar"></i>
                                                                </button>
                                                            </span>
                                                        </div>
                                                    </div>
                                                    <div class="sign-up">
                                                        <input type="submit" value="Create Account" />
                                                    </div>
                                                </form>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <script src="<c:url value="/Resources/Scripts/js/easyResponsiveTabs.js"/>"></script>
                            <script type="text/javascript">
                                $(document).ready(function () {
                                    $('#horizontalTab').easyResponsiveTabs({
                                        type: 'default', //Types: default, vertical, accordion
                                        width: 'auto', //auto or any width like 600px
                                        fit: true   // 100% fit in a container
                                    });
                                });
                            </script>
                            <div id="OR" class="hidden-xs">
                                OR
                            </div>
                        </div>
                        <div class="col-md-4 modal_body_right modal_body_right1">
                            <div class="row text-center sign-with">
                                <div class="col-md-12">
                                    <h3 class="other-nw">
                                        Sign in with
                                    </h3>
                                </div>
                                <div class="col-md-12">
                                    <ul class="social">
                                        <li class="social_facebook"><a href="#" class="entypo-facebook"></a></li>
                                        <li class="social_dribbble"><a href="#" class="entypo-dribbble"></a></li>
                                        <li class="social_twitter"><a href="#" class="entypo-twitter"></a></li>
                                        <li class="social_behance"><a href="#" class="entypo-behance"></a></li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
          <!--   @if (user != null)
            {
            <form method="get" action="@Url.Action("Logout","Home")">
                <div class="sign-up">
                    <button class="btn btn-default form-control">Kiểm tra đơn hàng</button>
                    <button class="btn btn-default form-control">Log out</button>
                </div>
            </form>
            }
            else
            { -->
               
            <!-- } -->
        </div>
    </div>
</div>
<script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-datepicker/1.3.0/js/bootstrap-datepicker.js"></script>
<script>
    $('.date-picker').datepicker({
        autoclose: true
    });
</script>