<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
	
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	
<!-- Header Area Start Here -->
        <header>
            <div class="header-area-style1" id="sticker">
                <div class="header-top">
                    <div class="header-top-inner-top">
                        <div class="container">
                            <div class="row">
                                <div class="col-lg-8 col-md-8 col-sm-12 col-xs-12">
                                    <div class="header-contact">
                                        <ul>
                                            <li><i class="fa fa-phone" aria-hidden="true"></i><a href="#"> + 55 11 2222.2222</a></li>
                                            <li><i class="fa fa-envelope" aria-hidden="true"></i><a href="#"> contato@smartfactory.com.br</a></li>
                                        </ul>
                                    </div>
                                </div>
                                <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12">
                                    <div class="account-wishlist">
                                        <ul>
                                            <li><a href="login-registration.jsp"><i class="fa fa-lock" aria-hidden="true"></i>${usuario.nomeCompleto}</a></li>
                                            <li><a href="login?opt=sair"><c:out value="${usuario != null ? 'Sair': 'Login'}"/></a></li>
                                        </ul>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="header-top-inner-bottom">
                        <div class="container">
                            <div class="row">
                                <div class="col-lg-3 col-md-3 col-sm-3 col-xs-12">
                                    <div class="logo-area">
                                        <a href="home"><img class="img-responsive" src="img/logo.png" alt="logo"></a>
                                    </div>
                                </div>
                                <div class="col-lg-7 col-md-7 col-sm-7 col-xs-12">
                                    <div class="search-area">
                                        <div class="input-group" id="adv-search">
                                            <input type="text" class="form-control" placeholder="Pesquisar" />
                                            <div class="input-group-btn">
                                                <div class="btn-group" role="group">

                                                    <button type="button" class="btn btn-metro-search"><span class="glyphicon glyphicon-search" aria-hidden="true"></span></button>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                                <div class="col-lg-2 col-md-2 col-sm-2 col-xs-12">
                                    <ul class="header-cart-area">
                                        <li>
                                            <div class="cart-area">
                                                <a href="cart.jsp"><i class="fa fa-shopping-cart" aria-hidden="true"></i></a>
                                            </div>
                                        </li>
                                    </ul>
                                </div>
                            </div>
                        </div>
                    </div>
                <div class="header-bottom">
                    <div class="container">
                        <div class="row">

                            <div class="col-lg-12 col-md-12 col-sm-12">
                                <div class="main-menu-area">
                                    <nav>
                                        <ul>
                                            <li class="active"><a href="home">Home</a></li>
                                            <li><a href="contact.jsp">Contato</a></li>
                                        </ul>
                                    </nav>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            </div>
        </header>
        <!-- Header Area End Here -->
        