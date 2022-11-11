<label for="my-modal-4" class="btn btn-primary">Add a promotion</label>
<!-- Put this part before </body> tag -->
<input type="checkbox" id="my-modal-4" class="modal-toggle"/>
<label for="my-modal-4" class="modal cursor-pointer">
    <label class="modal-box relative" for="my-modal-4">
        <p>
        <form class="w-full max-w-lg" action="createManager.center" method="post">
            <div class="flex flex-wrap -mx-3 mb-6">
                <div class="w-full md:w-1/2 px-3 mb-6 md:mb-0">
                    <label class="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2">
                        First Name
                    </label>
                    <input name="firstname"
                           class="appearance-none block w-full bg-gray-200 text-gray-700 border border-red-500 rounded py-3 px-4 mb-3 leading-tight focus:outline-none focus:bg-white"
                           type="text" placeholder="Jane">
                </div>
                <div class="w-full md:w-1/2 px-3">
                    <label class="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2"
                    >
                        Last Name
                    </label>
                    <input name="lastname"
                           class="appearance-none block w-full bg-gray-200 text-gray-700 border border-gray-200 rounded py-3 px-4 leading-tight focus:outline-none focus:bg-white focus:border-gray-500"
                           type="text" placeholder="Doe">
                </div>
                <div class="w-full md:w-1/2 px-3">
                    <label class="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2"
                    >
                        Email
                    </label>
                    <input name="email"
                           class="appearance-none block w-full bg-gray-200 text-gray-700 border border-gray-200 rounded py-3 px-4 leading-tight focus:outline-none focus:bg-white focus:border-gray-500"
                           type="email" placeholder="Points">
                </div>
                <div class="w-full md:w-1/2 px-3">
                    <label class="block uppercase tracking-wide text-gray-700 text-xs font-bold mb-2"
                    >
                        Password
                    </label>
                    <input name="password"
                           class="appearance-none block w-full bg-gray-200 text-gray-700 border border-gray-200 rounded py-3 px-4 leading-tight focus:outline-none focus:bg-white focus:border-gray-500"
                           type="password" placeholder="Points">
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