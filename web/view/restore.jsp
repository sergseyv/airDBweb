<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- Created by Seyvach Serg on 01.11.2017 -->
<html>
<head>
    <title>Database "AVIA" - Main Page</title>
</head>

<body bgcolor="#bfbfbf">

<table width="100%" border="0" bgcolor="#ffff80">
    <tr align="center">
        <td valign="top" width="45%">
            <table border="0" width="94%"  bgcolor="#003333">
                <caption><samp><h2>SELECT * from aircrafts;</h2></samp></caption>
                <thead>
                <tr align="center" bgcolor="#b3ffff">
                    <td><samp> <b>idAircraft</b>    <br>    <small>идентификатор самолета</small>                      </samp></td>
                    <td><samp> <b>name</b>          <br>    <small>название самолета</small>                  </samp></td>
                    <td><samp> <b>passengers</b>    <br>    <small>количество пассажиров</small>              </samp></td>
                    <td><samp> <b>maxWeightKg</b>   <br>    <small>максимальная масса, кг</small>             </samp></td>
                    <td><samp> <b>maxRangeKm</b>    <br>    <small>максимальная дальность полета, км</small>  </samp></td>
                </tr>
                </thead>
                <c:forEach var="aircraftsTable" items="${aircraftsArrayList}">
                    <tr bgcolor="#ccffff">
                        <td><samp><small> <c:out value="${aircraftsTable.idAircraft}" />   </small></samp></td>
                        <td><samp><small> <c:out value="${aircraftsTable.name}" />         </small></samp></td>
                        <td><samp><small> <c:out value="${aircraftsTable.passengers}" />   </small></samp></td>
                        <td><samp><small> <c:out value="${aircraftsTable.maxWeightKg}" />  </small></samp></td>
                        <td><samp><small> <c:out value="${aircraftsTable.maxRangeKm}" />   </small></samp></td>
                    </tr>
                </c:forEach>
            </table>
        </td>
        <td valign="top" width="20%">
            <table border="0" width="94%" bgcolor="#00331a">
                <caption><samp><h2>SELECT * from companies;</h2></samp></caption>
                <thead>
                <tr align="center" bgcolor="#b3ffd9">
                    <td><samp> <b>idCompanies</b> <br>    <small>идентификатор компании</small> </samp></td>
                    <td><samp> <b>name</b>        <br>    <small>название компании</small>      </samp></td>
                    <td><samp> <b>country</b>     <br>    <small>страна</small>                 </samp></td>
                </tr>
                </thead>
                <c:forEach var="companiesTable" items="${companiesArrayList}">
                    <tr bgcolor="#ccffe6">
                        <td><samp><small>  <c:out value="${companiesTable.idCompany}" />     </small></samp></td>
                        <td><samp><small>  <c:out value="${companiesTable.name}" />          </small></samp></td>
                        <td><samp><small>  <c:out value="${companiesTable.country}" />       </small></samp></td>
                    </tr>
                </c:forEach>
            </table>
        </td>
        <td valign="top" width="35%">
            <table border="0" width="94%"  bgcolor="#"003300>
                <caption><samp><h2>SELECT * from ownership;</h2></samp></caption>
                <thead>
                <tr align="center" bgcolor="#ccffcc">
                    <td><samp> <b>id_ownership</b>  <br>    <small>идентификатор собственности</small>      </samp></td>
                    <td><samp> <b>id_companies</b>  <br>    <small>идентификатор компании</small>           </samp></td>
                    <td><samp> <b>id_aircraft</b>   <br>    <small>идентификатор самолета</small>           </samp></td>
                    <td><samp> <b>quantity</b>      <br>    <small>количество самолетов у компании</small>  </samp></td>
                </tr>
                </thead>
                <c:forEach var="ownershipsTable" items="${ownershipsArrayList}">
                    <tr bgcolor="#e6ffe6">
                        <td><samp><small>  <c:out value="${ownershipsTable.idOwnership}" />    </small></samp></td>
                        <td><samp><small>  <c:out value="${ownershipsTable.idCompany}" />      </small></samp></td>
                        <td><samp><small>  <c:out value="${ownershipsTable.idAircraft}" />     </small></samp></td>
                        <td><samp><small>  <c:out value="${ownershipsTable.quantity}" />       </small></samp></td>
                    </tr>
                </c:forEach>
            </table>
        </td>
    </tr>
</table>









</body>
</html>
