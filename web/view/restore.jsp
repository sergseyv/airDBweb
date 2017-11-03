<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- Created by Seyvach Serg on 01.11.2017 -->
<html>
<head>
    <title>База восстановлена!</title>
</head>

<body>

<table width="100%" border="0">
    <tr align="center">
        <td valign="top" width="40%">
            <table border="1" cellpadding="1" width="94%">
                <caption><samp><h2>SELECT * from aircrafts;</h2></samp></caption>
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
        </td>
        <td valign="top" width="30%">
            <table border="1" cellpadding="1" width="94%">
                <caption><samp><h2>SELECT * from companies;</h2></samp></caption>
                <thead>
                <tr align="center" bgcolor="#ccffcc">
                    <td><samp> <b>idCompanies</b> <br>    <small>идентификатор</small>        </samp></td>
                    <td><samp> <b>name</b>        <br>    <small>название компании</small>    </samp></td>
                    <td><samp> <b>country</b>     <br>    <small>страна</small>               </samp></td>
                </tr>
                </thead>
                <c:forEach var="companiesTable" items="${companiesArrayList}">
                    <tr bgcolor="#e6ffe6">
                        <td><samp>  <c:out value="${companiesTable.idCompany}" />     </samp></td>
                        <td><samp>  <c:out value="${companiesTable.name}" />          </samp></td>
                        <td><samp>  <c:out value="${companiesTable.country}" />       </samp></td>
                    </tr>
                </c:forEach>
            </table>
        </td>
        <td valign="top" width="30%">
            <table border="1" cellpadding="1" width="94%">
                <caption><samp><h2>SELECT * from ownership;</h2></samp></caption>
                <thead>
                <tr align="center" bgcolor="#ffffb3">
                    <td><samp> <b>id_ownership</b>  <br>    <small>идентификатор собственности</small>      </samp></td>
                    <td><samp> <b>id_companies</b>  <br>    <small>идентификатор компании</small>           </samp></td>
                    <td><samp> <b>id_aircraft</b>   <br>    <small>идентификатор самолета</small>           </samp></td>
                    <td><samp> <b>quantity</b>      <br>    <small>количество самолетов у компании</small>  </samp></td>
                </tr>
                </thead>
                <c:forEach var="ownershipsTable" items="${ownershipsArrayList}">
                    <tr bgcolor="#ffffcc">
                        <td><samp>  <c:out value="${ownershipsTable.idOwnership}" />    </samp></td>
                        <td><samp>  <c:out value="${ownershipsTable.idCompany}" />      </samp></td>
                        <td><samp>  <c:out value="${ownershipsTable.idAircraft}" />     </samp></td>
                        <td><samp>  <c:out value="${ownershipsTable.quantity}" />       </samp></td>
                    </tr>
                </c:forEach>
            </table>
        </td>
    </tr>
</table>












</body>
</html>
