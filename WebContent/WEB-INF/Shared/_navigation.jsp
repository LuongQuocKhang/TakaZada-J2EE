<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="navigation">
        <div class="container">
            <nav class="navbar navbar-default">
                <!-- Brand and toggle get grouped for better mobile display -->
                <div class="navbar-header nav_2">
                    <button type="button" class="navbar-toggle collapsed navbar-toggle1" data-toggle="collapse" data-target="#bs-megadropdown-tabs">
                        <span class="sr-only">Toggle navigation</span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                </div>
                <div class="collapse navbar-collapse" id="bs-megadropdown-tabs">
                    <ul class="nav navbar-nav">
                        <li class="active"><a href="" class="act">Home</a></li>
                        <!-- Mega Menu -->
                        <li class="dropdown">
                            <a href="#" class="dropdown-toggle" data-toggle="dropdown">Linh kiện <b class="caret"></b></a>
                            <ul class="dropdown-menu multi-column columns-3">
                                <div class="row">
                                    <div class="col-sm-3">
                                        <ul class="multi-column-dropdown">
                                            <h6>CPU - bộ vi xử lý</h6>
                                            <li><a href="">Core i3</a></li>
                                            <li><a href="">Core i5</a></li>
                                            <li><a href="">Core i7</a></li>
                                            <li><a href="">Ryzen</a></li>
                                            <li><a href="">Tất cả</a></li>
                                        </ul>
                                    </div>
                                    <div class="col-sm-2">
                                        <ul class="multi-column-dropdown">
                                            <h6>RAM</h6>
                                            <li><a href=")">ADATA<span>Mới</span></a></li>
                                            <li><a href="">Kingmax</a></li>
                                            <li><a href="">G.Skill </a></li>
                                            <li><a href="">Kingston</a></li>
                                            <li><a href="">APACER</a></li>
                                            <li><a href="">Tất cả</a></li>
                                        </ul>
                                    </div>
                                    <div class="col-sm-2">
                                        <ul class="multi-column-dropdown">
                                            <h6>VGA</h6>
                                            <li><a href="">GIGABYTE<span>Mới</span></a></li>
                                            <li><a href="">Asus</a></li>
                                            <li><a href="">MSI</a></li>
                                            <li><a href="">Galax</a></li>
                                            <li><a href="">Tất cả</a></li>

                                        </ul>
                                    </div>
                                    <div class="col-sm-2">
                                        <ul class="multi-column-dropdown">
                                            <h6>Case</h6>
                                            <li><a href="">Corsair</a></li>
                                            <li><a href="">Cooler Master</a></li>
                                            <li><a href="">Golden Field</a></li>
                                            <li><a href="">Sahara</a></li>
                                            <li><a href="/TakaZada/ListCase">Tất cả</a></li>
                                        </ul>
                                    </div><div class="col-sm-2">
                                        <ul class="multi-column-dropdown">
                                            <h6>Mainboard</h6>
                                            <li><a href="">MSI</a></li>
                                            <li><a href="">Cooler Master</a></li>
                                            <li><a href="">Golden Field</a></li>
                                            <li><a href="">Sahara</a></li>
                                            <li><a href="">Tất cả</a></li>
                                        </ul>
                                    </div>
                                    <div class="clearfix"></div>
                                </div>
                            </ul>
                        </li>
                        <li>
                        <%
                        	out.print("<a href=" + request.getAttribute("domainname") + "/ListComputer" + " > Máy tính </a>");
                        %>
                        </li>
                        <li class="dropdown">
                            <a href="/ListComputer>" class="dropdown-toggle" data-toggle="dropdown">Phụ kiện <b class="caret"></b></a>
                            <ul class="dropdown-menu multi-column columns-3">
                                <div class="row">
                                    <div class="col-sm-3">
                                        <ul class="multi-column-dropdown">
                                            <h6>Hardware</h6>
                                            <li><a href="">Western Digital<span>New</span></a></li>
                                            <li><a href="">Seagate</a></li>
                                            <li><a href="">Western</a></li>
                                            <li><a href="">IBM </a></li>
                                            <li><a href="">Seagate </a></li>
                                            <li><a href="">HP </a></li>
                                            <li><a href="">Corsair </a></li>
                                            <li><a href="">Samsung </a></li>
                                            <li><a href="">Tất cả</a></li>
                                        </ul>
                                    </div>
                                    <div class="col-sm-3">
                                        <ul class="multi-column-dropdown">
                                            <h6>Keyboard</h6>
                                            <li><a href="">Logitech</a></li>
                                            <li><a href="">Zidli</a></li>
                                            <li><a href="">Zic </a></li>
                                            <li><a href="">Sumtax </a></li>
                                            <li><a href="">Tất cả</a></li>

                                        </ul>
                                    </div> <div class="col-sm-3">
                                        <ul class="multi-column-dropdown">
                                            <h6>Radiator</h6>
                                            <li><a href="">Gigabyte</a></li>
                                            <li><a href="">Deepcool</a></li>
                                            <li><a href="">Corsair </a></li>
                                            <li><a href="">Aigo </a></li>
                                            <li><a href="">Tất cả</a></li>

                                        </ul>
                                    </div>
                                    <div class="clearfix"></div>
                                </div>
                            </ul>
                        </li>
                        <li><a href="#">Thông tin</a></li>
                        <li><a href="">Vấn đề máy tính</a></li>
                        <li><a href="">Tư vấn</a></li>
                    </ul>
                </div>
            </nav>
        </div>
    </div>
