<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html data-theme="winter">
<head>
    <link href="https://cdn.jsdelivr.net/npm/daisyui@2.37.0/dist/full.css" rel="stylesheet" type="text/css"/>
    <script src="https://cdn.tailwindcss.com"></script>
    <%--    <link rel="stylesheet" href="https://demos.creative-tim.com/notus-js/assets/styles/tailwind.css">--%>
    <link rel="stylesheet"
          href="https://demos.creative-tim.com/notus-js/assets/vendor/@fortawesome/fontawesome-free/css/all.min.css">
    <title>Title</title>
</head>
<body>
<div class="navbar bg-base-100 drop-shadow">
    <div class="navbar-start">
        <div class="dropdown">
            <label tabindex="0" class="btn btn-ghost lg:hidden">
                <svg xmlns="http://www.w3.org/2000/svg" class="h-5 w-5" fill="none" viewBox="0 0 24 24"
                     stroke="currentColor">
                    <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                          d="M4 6h16M4 12h8m-8 6h16"></path>
                </svg>
            </label>
            <ul tabindex="0" class="menu menu-compact dropdown-content mt-3 p-2 shadow bg-base-100 rounded-box w-52">
                <li><a href="">Dashboard</a></li>
                <li><a href="">Promotions</a></li>
                <li><a href="">Admins</a></li>
            </ul>
        </div>
        <a class="btn btn-ghost normal-case text-xl">Marjane</a>
    </div>
    <div class="navbar-center hidden lg:flex">
        <ul class="menu menu-horizontal p-0">
            <li><a href="">Dashboard</a></li>
            <li><a href="">Promotions</a></li>
            <li><a href="">Admins</a></li>
        </ul>
    </div>
    <div class="navbar-end">
        <a class="btn">Logout</a>
    </div>
</div>
