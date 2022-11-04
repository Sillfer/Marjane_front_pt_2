<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<jsp:include page="../inc/headers/navbar.jsp">
    <jsp:param name="navbar" value="navbar"/>
</jsp:include>
<title>Central Admin Login</title>
<!-- component -->
<div class="bg-no-repeat bg-cover bg-center relative"
     style="background-image: url(https://www.moroccoworldnews.com/wp-content/uploads/2020/08/Marjane-Closes-2-Markets-in-Marrakech-After-COVID-19-Outbreaks-2.jpg);">
    <div class="absolute bg-gradient-to-b from-blue-800 to-blue-900 opacity-75 inset-0 z-0"></div>
    <div class="min-h-screen sm:flex sm:flex-row mx-0 justify-center">
        <div class="flex-col flex  self-center p-10 sm:max-w-5xl xl:max-w-2xl  z-10">
            <div class="self-start hidden lg:flex flex-col  text-white">
                <img src="" class="mb-3">
                <h1 class="mb-3 font-bold text-5xl">Welcome </h1>
                <p class="pr-3">We hope you have a nice day.
                    Marjane, I go, I win!</p>
            </div>
        </div>
        <div class="flex justify-center self-center  z-10">
            <div class="p-12 bg-white mx-auto rounded-2xl w-100 ">
                <div class="mb-4">
                    <h3 class="font-semibold text-2xl text-gray-800">Central Admin</h3>
                    <p class="text-gray-500">Please sign in to your account.</p>
                </div>
                <form action="loginCenter.center" method="post">
                    <div class="space-y-5">
                        <div class="space-y-2">
                            <label class="text-sm font-medium text-gray-700 tracking-wide">Email</label>
                            <input class=" w-full text-base px-4 py-2 border  border-gray-300 rounded-lg focus:outline-none focus:border-blue-400"
                                   type="email" name="email" placeholder="mail@gmail.com">
                        </div>
                        <div class="space-y-2">
                            <label class="mb-5 text-sm font-medium text-gray-700 tracking-wide">
                                Password
                            </label>
                            <input class="w-full content-center text-base px-4 py-2 border  border-gray-300 rounded-lg focus:outline-none focus:border-blue-400"
                                   type="password" name="password" placeholder="Enter your password">
                        </div>
                        <div class="form-control">
                            <label class="label cursor-pointer">
                                <span class="label-text">Remember me</span>
                                <input type="checkbox" class="toggle toggle-primary" checked/>
                            </label>
                        </div>
                        <div>
                            <button type="submit"
                                    class="w-full flex justify-center bg-blue-800  hover:bg-blue-900 text-gray-100 p-3  rounded-full tracking-wide font-semibold  shadow-lg cursor-pointer transition ease-in duration-500">
                                Sign in
                            </button>
                        </div>
                    </div>
                </form>
                <div class="pt-5 text-center text-gray-400 text-xs">
                </div>
            </div>
        </div>
    </div>
    <% if (request.getAttribute("errorMessage") != null) { %>
    <div class="toast">
        <div class="alert alert-info">
            <div>
                <span><%= request.getAttribute("errorMessage") %></span>
            </div>
        </div>
    </div>
    <% } %>
</div>
</body>
</html>
