<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<jsp:include page="../inc/headers/headerAdminGeneral.jsp">
    <jsp:param name="navbar" value="navbar"/>
</jsp:include>
<title>General Dashboard</title>

<!-- component -->
<div class="min-h-screen flex flex-col flex-auto flex-shrink-0 antialiased bg-white text-black">
    <div class="hero h-1/2"
         style="background-image: url(https://i0.wp.com/leseco.ma/wp-content/uploads/2021/11/Marjane-Holding.jpg?fit=1200%2C600&ssl=1);">
        <div class="hero-overlay bg-opacity-60"></div>
        <div class="hero-content text-center text-neutral-content">
            <div class="max-w-md">
                <h1 class="mb-5 text-5xl font-bold">Welcome</h1>
                <!-- The button to open modal -->
                <label for="my-modal-4" class="btn btn-primary">Add a promotion</label>
                <!-- Put this part before </body> tag -->
                <input type="checkbox" id="my-modal-4" class="modal-toggle"/>
                <label for="my-modal-4" class="modal cursor-pointer">
                    <label class="modal-box relative" for="my-modal-4">
                        <p>
                        <form class="w-full max-w-lg" action="createPromotion.center" method="post">
                            <div class="flex flex-wrap -mx-3 mb-6">
                                <div class="w-full md:w-1/2 px-3 mb-6 md:mb-0">
                                    <label class="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2">
                                        Start Date
                                    </label>
                                    <input name="dateStart"
                                           class="appearance-none block w-full bg-gray-200 text-gray-700 border border-red-500 rounded py-3 px-4 mb-3 leading-tight focus:outline-none focus:bg-white"
                                           type="date" placeholder="Jane">
                                    <p class="text-red-500 text-xs italic">Please fill out this field.</p>
                                </div>
                                <div class="w-full md:w-1/2 px-3">
                                    <label class="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2"
                                    >
                                        End Date
                                    </label>
                                    <input name="dateEnd"
                                           class="appearance-none block w-full bg-gray-200 text-gray-700 border border-gray-200 rounded py-3 px-4 leading-tight focus:outline-none focus:bg-white focus:border-gray-500"
                                           type="date" placeholder="Doe">
                                </div>
                                <div class="w-full md:w-1/2 px-3">
                                    <label class="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2"
                                    >
                                        Points
                                    </label>
                                    <input name="points"
                                           class="appearance-none block w-full bg-gray-200 text-gray-700 border border-gray-200 rounded py-3 px-4 leading-tight focus:outline-none focus:bg-white focus:border-gray-500"
                                           type="number" placeholder="Points" min="1">
                                </div>
                            </div>

                            <div class="flex flex-wrap -mx-3 mb-6">
                                <div class="w-full px-3">
                                    <select name="subCategory" class="select select-bordered w-full max-w-xs">
                                        <option disabled selected>Select a Category</option>
                                        <c:forEach items="${subCategories}" var="subCategories">
                                            <option value="${subCategories.id}">${subCategories.name}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <button type="submit"
                                    class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded focus:outline-none focus:shadow-outline"
                            >
                                Add
                            </button>
                        </form>
                    </label>
                </label>
                <label for="my-modal-5" class="btn btn-primary">Add a Manager</label>
                <!-- Put this part before </body> tag -->
                <input type="checkbox" id="my-modal-5" class="modal-toggle"/>
                <label for="my-modal-5" class="modal cursor-pointer">
                    <label class="modal-box relative" for="my-modal-5">
                        <p>
                        <form class="w-full max-w-lg" action="createManager.center" method="post">
                            <div class="flex flex-wrap -mx-3 mb-6">
                                <div class="w-full md:w-1/2 px-3 mb-6 md:mb-0">
                                    <label class="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2">
                                        First Name
                                    </label>
                                    <input name="firstname"
                                           class="appearance-none block w-full bg-gray-200 text-gray-700 border border-red-500 rounded py-3 px-4 mb-3 leading-tight focus:outline-none focus:bg-white"
                                           type="text" placeholder="First Name">
                                </div>
                                <div class="w-full md:w-1/2 px-3">
                                    <label class="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2"
                                    >
                                        Last Name
                                    </label>
                                    <input name="lastname"
                                           class="appearance-none block w-full bg-gray-200 text-gray-700 border border-gray-200 rounded py-3 px-4 leading-tight focus:outline-none focus:bg-white focus:border-gray-500"
                                           type="text" placeholder="Last Name">
                                </div>
                                <div class="w-full md:w-1/2 px-3">
                                    <label class="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2"
                                    >
                                        Email
                                    </label>
                                    <input name="email"
                                           class="appearance-none block w-full bg-gray-200 text-gray-700 border border-gray-200 rounded py-3 px-4 leading-tight focus:outline-none focus:bg-white focus:border-gray-500"
                                           type="email" placeholder="Email@gmail.com">
                                </div>
                                <div class="w-full md:w-1/2 px-3">
                                    <label class="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2"
                                    >
                                        Password
                                    </label>
                                    <input name="password"
                                           class="appearance-none block w-full bg-gray-200 text-gray-700 border border-gray-200 rounded py-3 px-4 leading-tight focus:outline-none focus:bg-white focus:border-gray-500"
                                           type="password" placeholder="******">
                                </div>
                            </div>

                            <div class="flex flex-wrap -mx-3 mb-6">
                                <div class="w-full px-3">
                                    <select name="subCategory" class="select select-bordered w-full max-w-xs">
                                        <option disabled selected>Select a Category</option>
                                        <c:forEach items="${subCategories}" var="subCategories">
                                            <option value="${subCategories.id}">${subCategories.name}</option>
                                        </c:forEach>
                                    </select>
                                </div>
                            </div>
                            <button type="submit"
                                    class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded focus:outline-none focus:shadow-outline"
                            >
                                Add
                            </button>
                        </form>
                    </label>
                </label>
            </div>
        </div>
    </div>
    <div class="h-full">
        <!-- Statistics Cards -->
        <div class="grid grid-cols-1 sm:grid-cols-2 lg:grid-cols-4 p-4 gap-4">
            <div class="bg-blue-800 shadow-lg rounded-md flex items-center justify-between p-3 border-b-4 border-blue-900 font-medium group">
                <div class="flex justify-center items-center w-14 h-14 bg-white rounded-full transition-all duration-300 transform group-hover:rotate-12">
                    <svg width="30" height="30" fill="none" viewBox="0 0 24 24" stroke="currentColor"
                         class="stroke-current text-blue-800  transform transition-transform duration-500 ease-in-out">
                        <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                              d="M17 20h5v-2a3 3 0 00-5.356-1.857M17 20H7m10 0v-2c0-.656-.126-1.283-.356-1.857M7 20H2v-2a3 3 0 015.356-1.857M7 20v-2c0-.656.126-1.283.356-1.857m0 0a5.002 5.002 0 019.288 0M15 7a3 3 0 11-6 0 3 3 0 016 0zm6 3a2 2 0 11-4 0 2 2 0 014 0zM7 10a2 2 0 11-4 0 2 2 0 014 0z"></path>
                    </svg>
                </div>
                <div class="text-right">
                    <p class="text-2xl text-white">1,257</p>
                    <p>Visitors</p>
                </div>
            </div>
            <div class="bg-blue-800  shadow-lg rounded-md flex items-center justify-between p-3 border-b-4 border-blue-900 font-medium group">
                <div class="flex justify-center items-center w-14 h-14 bg-white rounded-full transition-all duration-300 transform group-hover:rotate-12">
                    <svg width="30" height="30" fill="none" viewBox="0 0 24 24" stroke="currentColor"
                         class="stroke-current text-blue-800 transform transition-transform duration-500 ease-in-out">
                        <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                              d="M16 11V7a4 4 0 00-8 0v4M5 9h14l1 12H4L5 9z"></path>
                    </svg>
                </div>
                <div class="text-right">
                    <p class="text-2xl text-white">557</p>
                    <p>Orders</p>
                </div>
            </div>
            <div class="bg-blue-800 shadow-lg rounded-md flex items-center justify-between p-3 border-b-4 border-blue-900 font-medium group">
                <div class="flex justify-center items-center w-14 h-14 bg-white rounded-full transition-all duration-300 transform group-hover:rotate-12">
                    <svg width="30" height="30" fill="none" viewBox="0 0 24 24" stroke="currentColor"
                         class="stroke-current text-blue-800 transform transition-transform duration-500 ease-in-out">
                        <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                              d="M13 7h8m0 0v8m0-8l-8 8-4-4-6 6"></path>
                    </svg>
                </div>
                <div class="text-right">
                    <p class="text-2xl text-white">$11,257</p>
                    <p>Sales</p>
                </div>
            </div>
            <div class="bg-blue-800 shadow-lg rounded-md flex items-center justify-between p-3 border-b-4 border-blue-900 font-medium group">
                <div class="flex justify-center items-center w-14 h-14 bg-white rounded-full transition-all duration-300 transform group-hover:rotate-12">
                    <svg width="30" height="30" fill="none" viewBox="0 0 24 24" stroke="currentColor"
                         class="stroke-current text-blue-800 transform transition-transform duration-500 ease-in-out">
                        <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                              d="M12 8c-1.657 0-3 .895-3 2s1.343 2 3 2 3 .895 3 2-1.343 2-3 2m0-8c1.11 0 2.08.402 2.599 1M12 8V7m0 1v8m0 0v1m0-1c-1.11 0-2.08-.402-2.599-1M21 12a9 9 0 11-18 0 9 9 0 0118 0z"></path>
                    </svg>
                </div>
                <div class="text-right">
                    <p class="text-2xl text-white">$75,257</p>
                    <p>Balances</p>
                </div>
            </div>
        </div>
        <!-- ./Statistics Cards -->
        <div class="grid col-start-2 col-span-4 p-4 gap-4">

            <!-- Social Traffic -->
            <div class="flex flex-col min-w-0 mb-4 lg:mb-0 break-words bg-gray-50 w-full shadow-lg rounded">
                <div class="rounded-t mb-0 px-0 border-0">
                    <div class="flex flex-wrap items-center px-4 py-2">
                        <div class="w-full max-w-full flex-grow flex-1">
                            <h3 class="font-semibold text-base text-gray-900 ">Admins</h3>
                        </div>
                    </div>
                    <div class="block w-full overflow-x-auto">
                        <table class="items-center w-full bg-transparent border-collapse">
                            <thead>
                            <tr>
                                <th class="px-4 bg-gray-100  text-gray-500 align-middle border border-solid border-gray-200 py-3 text-xs uppercase border-l-0 border-r-0 whitespace-nowrap font-semibold text-left">
                                    FIRST NAME
                                </th>
                                <th class="px-4 bg-gray-100 text-gray-500 align-middle border border-solid border-gray-200 py-3 text-xs uppercase border-l-0 border-r-0 whitespace-nowrap font-semibold text-left">
                                    LAST NAME
                                </th>
                                <th class="px-4 bg-gray-100 text-gray-500 align-middle border border-solid border-gray-200 py-3 text-xs uppercase border-l-0 border-r-0 whitespace-nowrap font-semibold text-left">
                                    EMAIL
                                </th>
                                <th class="px-4 bg-gray-100 text-gray-500 align-middle border border-solid border-gray-200 py-3 text-xs uppercase border-l-0 border-r-0 whitespace-nowrap font-semibold text-left min-w-140-px"></th>
                            </tr>
                            </thead>
                            <tbody>
                            <%--                            <c:forEach items="${admins}" var="admin">--%>
                            <tr class="text-gray-700">
                                <th class="border-t-0 px-4 align-middle border-l-0 border-r-0 text-xs whitespace-nowrap p-4 text-left">
                                    <%--                                            ${admin.firstname}--%>
                                </th>
                                <td class="border-t-0 px-4 align-middle border-l-0 border-r-0 text-xs whitespace-nowrap p-4">
                                    <%--                                            ${admin.lastname}--%>
                                </td>
                                <td class="border-t-0 px-4 align-middle border-l-0 border-r-0 text-xs whitespace-nowrap p-4">
                                    <%--                                            ${admin.email}--%>
                                </td>
                            </tr>
                            <%--                            </c:forEach>--%>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
            <!-- ./Social Traffic -->
        </div>
        <!-- Client Table -->
        <div class="mt-4 mx-4">

            <div class="w-full overflow-hidden rounded-lg shadow-xs">
                <div class="flex flex-wrap items-center px-4 py-2">
                    <div class="w-full max-w-full flex-grow flex-1">
                        <h3 class="font-semibold text-base text-gray-900 ">Promotions</h3>
                    </div>
                </div>
                <div class="w-full overflow-x-auto">
                    <table class="w-full  bg-neutral text-neutral-content">
                        <thead>
                        <tr class="text-xs font-semibold tracking-wide text-left text-gray-500 uppercase border-b bg-gray-50">
                            <th class="px-4 py-3">Category</th>
                            <th class="px-4 py-3">Start Date</th>
                            <th class="px-4 py-3">End Date</th>
                            <th class="px-4 py-3">Status</th>
                        </tr>
                        </thead>
                        <tbody class="bg-white divide-y">
                        <tr class="bg-gray-50  hover:bg-gray-100  text-gray-700">
                            <td class="px-4 py-3">
                                <div class="flex items-center text-sm">
                                    <div>
                                        <p class="font-semibold">Food</p>
                                        <p class="text-xs text-gray-600 ">Bread</p>
                                    </div>
                                </div>
                            </td>
                            <td class="px-4 py-3 text-sm">2022-11-01</td>
                            <td class="px-4 py-3 text-sm">2022-11-05</td>
                            <td class="px-4 py-3 text-xs">
                                <span class="px-2 py-1 font-semibold leading-tight text-green-700 bg-green-100 rounded-full"> Approved </span>
                            </td>
                        </tr>
                        </tbody>
                    </table>
                </div>
                <div class="grid px-4 py-3 text-xs font-semibold tracking-wide text-gray-500 uppercase border-t bg-gray-50 sm:grid-cols-9 ">
                    <span class="flex items-center col-span-3"> Showing 21-30 of 100 </span>
                    <span class="col-span-2"></span>
                    <!-- Pagination -->
                    <span class="flex col-span-4 mt-2 sm:mt-auto sm:justify-end">
                <nav aria-label="Table navigation">
                  <ul class="inline-flex items-center">
                    <li>
                      <button class="px-3 py-1 rounded-md rounded-l-lg focus:outline-none focus:shadow-outline-purple"
                              aria-label="Previous">
                        <svg aria-hidden="true" class="w-4 h-4 fill-current" viewBox="0 0 20 20">
                          <path d="M12.707 5.293a1 1 0 010 1.414L9.414 10l3.293 3.293a1 1 0 01-1.414 1.414l-4-4a1 1 0 010-1.414l4-4a1 1 0 011.414 0z"
                                clip-rule="evenodd" fill-rule="evenodd"></path>
                        </svg>
                      </button>
                    </li>
                    <li>
                      <button class="px-3 py-1 rounded-md focus:outline-none focus:shadow-outline-purple">1</button>
                    </li>
                    <li>
                      <button class="px-3 py-1 rounded-md focus:outline-none focus:shadow-outline-purple">2</button>
                    </li>
                    <li>
                      <button class="px-3 py-1 text-white dark:text-gray-800 transition-colors duration-150 bg-blue-600 dark:bg-gray-100 border border-r-0 border-blue-600 dark:border-gray-100 rounded-md focus:outline-none focus:shadow-outline-purple">3</button>
                    </li>
                    <li>
                      <button class="px-3 py-1 rounded-md focus:outline-none focus:shadow-outline-purple">4</button>
                    </li>
                    <li>
                      <span class="px-3 py-1">...</span>
                    </li>
                    <li>
                      <button class="px-3 py-1 rounded-md focus:outline-none focus:shadow-outline-purple">8</button>
                    </li>
                    <li>
                      <button class="px-3 py-1 rounded-md focus:outline-none focus:shadow-outline-purple">9</button>
                    </li>
                    <li>
                      <button class="px-3 py-1 rounded-md rounded-r-lg focus:outline-none focus:shadow-outline-purple"
                              aria-label="Next">
                        <svg class="w-4 h-4 fill-current" aria-hidden="true" viewBox="0 0 20 20">
                          <path d="M7.293 14.707a1 1 0 010-1.414L10.586 10 7.293 6.707a1 1 0 011.414-1.414l4 4a1 1 0 010 1.414l-4 4a1 1 0 01-1.414 0z"
                                clip-rule="evenodd" fill-rule="evenodd"></path>
                        </svg>
                      </button>
                    </li>
                  </ul>
                </nav>
              </span>
                </div>
            </div>
        </div>
    </div>
</div>


<jsp:include page="../inc/footer.jsp">
    <jsp:param name="footer" value="footer"/>
</jsp:include>