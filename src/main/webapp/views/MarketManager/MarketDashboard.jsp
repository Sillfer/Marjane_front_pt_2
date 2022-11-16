<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<jsp:include page="../inc/headers/marketManagerHeader.jsp">
    <jsp:param name="navbar" value="navbar"/>
</jsp:include>
<title>Market Manager Dashboard</title>

<!-- component -->
<div class="min-h-screen flex flex-col flex-auto flex-shrink-0 antialiased bg-white text-black">
    <div class="hero h-1/2"
         style="background-image: url(https://i0.wp.com/leseco.ma/wp-content/uploads/2021/11/Marjane-Holding.jpg?fit=1200%2C600&ssl=1);">
        <div class="hero-overlay bg-opacity-60"></div>
        <div class="hero-content text-center text-neutral-content">
            <div class="max-w-md">
                <h1 class="mb-5 text-5xl font-bold">Welcome</h1>
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
                            <th class="px-4 py-3">Start Date</th>
                            <th class="px-4 py-3">End Date</th>
                            <th class="px-4 py-3">Status</th>
                            <th class="px-4 py-3">Points</th>
                            <th class="px-4 py-3">Actions</th>
                        </tr>
                        </thead>
                        <tbody class="bg-white divide-y">
                        <c:choose>
                            <c:when test="${empty promotions}">
                                <tr>
                                    <td colspan="4" class="text-center">No promotions found</td>
                                </tr>
                            </c:when>
                            <c:otherwise>
                                <c:forEach items="${promotions}" var="promotion">
                                    <tr class="bg-gray-50  hover:bg-gray-100  text-gray-700">
                                        <td class="px-4 py-3 text-sm">
                                            <c:out value="${promotion.getDateStart()}"/>
                                        </td>
                                        <td class="px-4 py-3 text-sm">
                                            <c:out value="${promotion.getDateEnd()}"/>
                                        </td>
                                        <td class="px-4 py-3 text-xs">
                                <span class="px-2 py-1 font-semibold leading-tight text-green-700 bg-green-100 status rounded-full">
                                    <c:out value="${promotion.getStatus()}"/>
                                </span>
                                        </td>
                                        <td class="px-4 py-3 text-sm">
                                                ${promotion.getPoints()}
                                        </td>
                                        <td>
                                            <c:choose>
                                                <c:when test="${promotion.getStatus() == 'ACCEPTED'}">

                                                </c:when>
                                                <c:when test="${promotion.getStatus() == 'REJECTED'}">
                                                    
                                                </c:when>
                                                <c:otherwise>
                                                        <label for="my-modal-3" class="btn">Accept</label>
                                                        <!-- Put this part before </body> tag -->
                                                        <input type="checkbox" id="my-modal-3" class="modal-toggle"/>
                                                        <div class="modal">
                                                            <div class="modal-box relative">
                                                                <label for="my-modal-3"
                                                                       class="btn btn-sm btn-circle absolute right-2 top-2">✕</label>
                                                                <h3>Are you sure you want to accept this promotion?</h3>
                                                                <form action="acceptPromotion.manager" method="post">
                                                                    <input type="hidden" name="id"
                                                                           value="${promotion.id}">
                                                                    <button type="submit"
                                                                            class="bg-blue-500 hover:bg-blue-700 text-white font-bold py-2 px-4 rounded focus:outline-none focus:shadow-outline"
                                                                    >
                                                                        Accept
                                                                    </button>
                                                                </form>

                                                            </div>
                                                        </div>
                                                </c:otherwise>
                                            </c:choose>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </c:otherwise>
                        </c:choose>
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
<script>
    const status = document.querySelectorAll('.status');
    status.forEach((status) => {
        if (status.innerText === 'ACCEPTED') {
            status.classList.add('bg-green-100', 'text-green-700')
        } else if (status.innerText === 'PENDING') {
            status.classList.add('bg-yellow-100', 'text-yellow-700')
        } else if (status.innerText === 'REJECTED') {
            status.classList.add('bg-red-100', 'text-red-700')
        }
    })

</script>


<jsp:include page="../inc/footer.jsp">
    <jsp:param name="footer" value="footer"/>
</jsp:include>