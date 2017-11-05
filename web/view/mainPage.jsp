<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- Created by Seyvach Serg on 01.11.2017 -->
<html>
<head>
    <title>Database "AVIA" - Main Page</title>
</head>

<body bgcolor="#ffff80">

<div align="center">
    <hr width="50%">
    <p><b>Great, it's done!</b>
    <p>Now we have 3 tables: <samp><b>"aircrafts"</b></samp>, <samp><b>"companies"</b></samp> and <samp><b>"ownership"</b></samp>.
    <p>You can <b>insert</b>, <b>update</b>, and <b>delete</b> records from tables.
    <p>Also, you can scroll down the page and see some JOIN-queries.
    <p>
    <hr width="50%">
</div>


<table width="100%" border="0" bgcolor="#ffff80">
    <tr align="center">
        <td valign="top" width="40%">
            <hr width="90%">
            <samp><h2>aircrafts</h2></samp>
            <table border="2" width="90%"  bgcolor="#ffcccc">
                <tr align="center">
                    <td><b><samp>insert</samp></b></td>
                    <td><b><samp>update</samp></b></td>
                    <td><b><samp>delete</samp></b></td>
                </tr>
            </table>
            <hr width="50%">

            <table border="0" width="90%"  bgcolor="#00331a">
                <thead>
                <tr align="center" bgcolor="#b3ffd9">
                    <td><samp> <b>idAircraft</b>    <br>    <small>aircraft ID</small>              </samp></td>
                    <td><samp> <b>name</b>          <br>    <small>aircraft name</small>            </samp></td>
                    <td><samp> <b>passengers</b>    <br>    <small>number of passengers</small>     </samp></td>
                    <td><samp> <b>maxWeightKg</b>   <br>    <small>maximum weight, kg</small>       </samp></td>
                    <td><samp> <b>maxRangeKm</b>    <br>    <small>maximum flight range, km</small> </samp></td>
                </tr>
                </thead>
                <c:forEach var="aircraftsTable" items="${aircraftsArrayList}">
                    <tr bgcolor="#ccffe6">
                        <td><samp><small> <c:out value="${aircraftsTable.idAircraft}" />   </small></samp></td>
                        <td><samp><small> <c:out value="${aircraftsTable.name}" />         </small></samp></td>
                        <td><samp><small> <c:out value="${aircraftsTable.passengers}" />   </small></samp></td>
                        <td><samp><small> <c:out value="${aircraftsTable.maxWeightKg}" />  </small></samp></td>
                        <td><samp><small> <c:out value="${aircraftsTable.maxRangeKm}" />   </small></samp></td>
                    </tr>
                </c:forEach>
            </table>

        </td>
        <td valign="top" width="30%">
            <hr width="90%">
            <samp><h2>companies</h2></samp>

            <table border="2" width="90%"  bgcolor="#ffcccc">
                <tr align="center">
                    <td><b><samp>insert</samp></b></td>
                    <td><b><samp>update</samp></b></td>
                    <td><b><samp>delete</samp></b></td>
                </tr>
            </table>
            <hr width="50%">

            <table border="0" width="90%" bgcolor="#00331a">
                <thead>
                <tr align="center" bgcolor="#b3ffd9">
                    <td><samp> <b>idCompanies</b> <br>    <small>company ID</small>             </samp></td>
                    <td><samp> <b>name</b>        <br>    <small>company name</small>           </samp></td>
                    <td><samp> <b>country</b>     <br>    <small>country of the company</small> </samp></td>
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
        <td valign="top" width="30%">
            <hr width="90%">
            <samp><h2>ownership</h2></samp>

            <table border="2" width="90%"  bgcolor="#ffcccc">
                <tr align="center">
                    <td><b><samp>insert</samp></b></td>
                    <td><b><samp>update</samp></b></td>
                    <td><b><samp>delete</samp></b></td>
                </tr>
            </table>
            <hr width="50%">

            <table border="0" width="90%"  bgcolor="#00331a">
                <thead>
                <tr align="center" bgcolor="#b3ffd9">
                    <td><samp> <b>id_ownership</b>  <br>    <small>ownership ID</small>                         </samp></td>
                    <td><samp> <b>id_companies</b>  <br>    <small>company ID</small>                           </samp></td>
                    <td><samp> <b>id_aircraft</b>   <br>    <small>aircraft ID</small>                          </samp></td>
                    <td><samp> <b>quantity</b>      <br>    <small>number of aircrafts in the company</small>   </samp></td>
                </tr>
                </thead>
                <c:forEach var="ownershipsTable" items="${ownershipsArrayList}">
                    <tr bgcolor="#ccffe6">
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

<p>
<hr>
<p>
<div align="center">
<hr width="50%">
<p><b>Some JOIN-queries</b>
<p>
<hr width="50%">
</div>

<table border="0" width="70%"  bgcolor="#00331a">
    <tr align="left" bgcolor="#ffffff">
        <td>
          <b><samp>
            SELECT companies.name, companies.country, aircrafts.name,  ownership.quantity<br>
            FROM ownership<br>
            JOIN companies ON ownership.id_companies = companies.id_companies<br>
            JOIN aircrafts ON ownership.id_aircraft= aircrafts.id_aircraft<br>
          </samp></b>
        </td>
    </tr>
</table>
<table border="0" width="70%" bgcolor="#00331a">
    <thead>
    <tr align="center" bgcolor="#b3ffd9">
        <td><samp> <b>name</b>      <br>    <small>company name</small>                         </samp></td>
        <td><samp> <b>country</b>   <br>    <small>country of the company</small>               </samp></td>
        <td><samp> <b>name</b>      <br>    <small>aircraft name</small>                        </samp></td>
        <td><samp> <b>quantity</b>  <br>    <small>number of aircrafts in the company</small>   </samp></td>
    </tr>
    </thead>
    <c:forEach var="select1" items="${select1ArrayList}">
      <tr bgcolor="#ccffe6">
        <td><samp><small>  <c:out value="${select1.nameCompany}" />     </small></samp></td>
        <td><samp><small>  <c:out value="${select1.countryCompany}" />  </small></samp></td>
        <td><samp><small>  <c:out value="${select1.nameAircraft}" />    </small></samp></td>
        <td><samp><small>  <c:out value="${select1.quantity}" />        </small></samp></td>
      </tr>
    </c:forEach>
</table>



</body>
</html>
