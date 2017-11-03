<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Restore DB</title>
</head>
<body>
  Database restored!<br>


  <c:forEach var="num" items="${st1}">
    <table><tr>
        <td> <c:out value="${num.idAircraft}" /> </td>
        <td> <c:out value="${num.name}" /> </td>
        <td> <c:out value="${num.passengers}" /> </td>
        <td> <c:out value="${num.maxWeightKg}" /> </td>
        <td> <c:out value="${num.maxRangeKm}" /> </td>
    </tr></table>
  </c:forEach>





</body>
</html>
