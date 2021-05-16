<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="t" tagdir="/WEB-INF/tags" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<t:genericpage>
    <jsp:attribute name="header">
         Demo Page for Employee Roles
    </jsp:attribute>
    <jsp:attribute name="footer">
    </jsp:attribute>
    <jsp:body>
        <h1>Hello ${sessionScope.email} </h1>
        You are now logged in as a EMPLOYEE of our wonderful FOG site.


        <form action="${pageContext.request.contextPath}/fc/employeeorders" method="POST">
            <label for="sortBy"> Choose status for orders </label>
            <select name="sortBy" id="sortBy">
                <option value="all orders" selected="all orders" >all orders</option>
                <option value="request">Request</option>
                <option value="offer sent">Offer sent</option>
                <option value="accepted">Accepted</option>
                <option value="paid">Paid</option>
                <option value="declined">Declined</option>
                <option value="finished">Finished</option>
            </select>
            <br><br>
            <input type="submit" value="Submit">
           <!-- <button name="customerorder" class="btn btn-primary" type="submit" value="${ordre.orderId}">${ordre.orderId}</button>-->
        </form>


        <p>Her er alle ordrer:</p>
        <div class="table-responsive">
        <table class="table table-bordered">
        <thead>
        <tr>
            <th>ID</th>
            <th>Dato</th>
            <th>E-mail</th>
            <th>Pris</th>
            <th>Status</th>
        </tr>
        </thead>
            <c:if test="${requestScope.sortedList != null}">


        <c:forEach var="ordre" items="${requestScope.sortedList}">
            <tbody>
            <tr>
                <td class="text-center">${ordre.orderId}</td>
                <td class="text-center">${ordre.date}</td>
                <td class="text-center">${ordre.deliveryInfoId}</td>
                <td class="text-center">${ordre.totalprice}</td>
                <td class="text-center">${ordre.status}</td>
            </tr>
            </tbody>

        </c:forEach>
            </c:if>
        </table>
        </div>

    </jsp:body>
</t:genericpage>
