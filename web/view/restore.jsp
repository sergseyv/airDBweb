<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>База восстановлена!</title>
</head>


<body>

  <table width="50%"  border="1" cellpadding="5">
      <caption><samp><h2>Таблица "Aircrafts"</h2></samp></caption>
      <thead>
      <tr align="center" bgcolor="#b3ffff">
          <td><samp> <b>idAircraft</b>    <br>    <small>идентификатор</small>                      </samp></td>
          <td><samp> <b>name</b>          <br>    <small>название самолета</small>                  </samp></td>
          <td><samp> <b>passengers</b>    <br>    <small>количество пассажиров</small>              </samp></td>
          <td><samp> <b>maxWeightKg</b>   <br>    <small>максимальная масса, кг</small>             </samp></td>
          <td><samp> <b>maxRangeKm</b>    <br>    <small>максимальная дальность полета, км</small>  </samp></td>
      </tr>
      </thead>
      <c:forEach var="aircraftsTable" items="${aircraftsArrayList}">
          <tr bgcolor="#ccffff">
            <td><samp>  <c:out value="${aircraftsTable.idAircraft}" />   </samp></td>
            <td><samp>  <c:out value="${aircraftsTable.name}" />         </samp></td>
            <td><samp>  <c:out value="${aircraftsTable.passengers}" />   </samp></td>
            <td><samp>  <c:out value="${aircraftsTable.maxWeightKg}" />  </samp></td>
            <td><samp>  <c:out value="${aircraftsTable.maxRangeKm}" />   </samp></td>
          </tr>
      </c:forEach>
  </table>


</body>
</html>
