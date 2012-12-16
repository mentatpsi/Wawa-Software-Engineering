<%-- check to see if user is logged in already --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<c:set var="reqUrl" value="${pageContext.request.requestURL}" />
<c:choose>
    <c:when test="${sessionScope.LOGIN}">
        <c:set var="isLoggedIn" value="true" />
        <c:set var="loginName" value="${sessionScope.USER}"/>
        <c:out value="Logged in as: ${sessionScope.USER}" /> <a href="logout?logout=y">[logout]</a><br/>
    </c:when>
    <c:when test="${fn:endsWith(reqUrl, 'login.jsp')}">
        <c:out value="Welcome!  Please log in." />
    </c:when>
    <c:otherwise>
        <c:redirect url="/login.jsp"/>
    </c:otherwise>

</c:choose>