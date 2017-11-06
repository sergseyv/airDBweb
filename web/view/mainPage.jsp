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
    <p><h2>Great, it's done!</h2>
    <p>Now we have 3 tables: <samp><b>"aircrafts"</b></samp>, <samp><b>"companies"</b></samp> and <samp><b>"ownership"</b></samp>.
    <p>You can <b>insert</b>, <b>update</b>, and <b>delete</b> records from tables.
    <p>Also, you can scroll down the page and see several JOIN-queries.
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
                <c:forEach var="ownershipTable" items="${ownershipArrayList}">
                    <tr bgcolor="#ccffe6">
                        <td><samp><small>  <c:out value="${ownershipTable.idOwnership}" />    </small></samp></td>
                        <td><samp><small>  <c:out value="${ownershipTable.idCompany}" />      </small></samp></td>
                        <td><samp><small>  <c:out value="${ownershipTable.idAircraft}" />     </small></samp></td>
                        <td><samp><small>  <c:out value="${ownershipTable.quantity}" />       </small></samp></td>
                    </tr>
                </c:forEach>
            </table>

        </td>
    </tr>
</table>


<p>
<div align="center">
<hr width="50%">
<p><h2>Some JOIN-queries</h2>
<p>
<hr width="50%">
</div>

<table border="0" width="70%"  bgcolor="#00331a" cellpadding="5">
    <tr align="left" bgcolor="#ffcccc">
        <td>
            <samp>
            <b>Query 1.</b>
            List of all companies and all their aircrafts.
            </samp>
        </td>
    </tr>

    <tr align="left" bgcolor="#ffffff">
        <td>
          <b><samp>
            SELECT companies.name, companies.country, aircrafts.name,  ownership.quantity<br>
            FROM ownership<br>
            JOIN companies ON ownership.id_companies = companies.id_companies<br>
            JOIN aircrafts ON ownership.id_aircraft= aircrafts.id_aircraft
          </samp></b>
        </td>
    </tr>
</table>
<table border="0" width="70%" bgcolor="#00331a">
    <thead>
    <tr align="center" bgcolor="#b3ffd9">
        <td width="27%"><samp> <b>name</b>      <br>    <small>company name</small>             </samp></td>
        <td width="27%"><samp> <b>country</b>   <br>    <small>country of the company</small>   </samp></td>
        <td width="27%"><samp> <b>name</b>      <br>    <small>aircraft name</small>            </samp></td>
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

<p>
<hr width="50%" align="left">
<p>

<table border="0" width="70%"  bgcolor="#00331a" cellpadding="5">
    <tr align="left" bgcolor="#ffcccc">
        <td>
            <samp>
                <b>Query 2.</b>
                List of all Airbus airplanes with their companies, sorted in ascending maximum flight range.
            </samp>
        </td>
    </tr>
    <tr align="left" bgcolor="#ffffff">
        <td>
            <b><samp>
               SELECT companies.name, companies.country, aircrafts.name, aircrafts.max_range__km, ownership.quantity<br>
               FROM ownership<br>
               JOIN companies ON ownership.id_companies = companies.id_companies<br>
               JOIN aircrafts ON ownership.id_aircraft= aircrafts.id_aircraft<br>
               WHERE aircrafts.name LIKE '%Airbus%'<br>
               ORDER BY aircrafts.max_range__km ASC
            </samp></b>
        </td>
    </tr>
</table>
<table border="0" width="70%" bgcolor="#00331a">
    <thead>
    <tr align="center" bgcolor="#b3ffd9">
        <td width="25%"><samp> <b>name</b>      <br><small>company name</small>             </samp></td>
        <td width="25%"><samp> <b>country</b>   <br><small>country of the company</small>   </samp></td>
        <td width="20%"><samp> <b>name</b>      <br><small>aircraft name</small>            </samp></td>
        <td width="15%"><samp> <b>maxRangeKm</b><br><small>maximum flight range, km</small> </samp></td>
        <td><samp> <b>quantity</b>  <br><small>number of aircrafts in the company</small>   </samp></td>
    </tr>
    </thead>
    <c:forEach var="select2" items="${select2ArrayList}">
        <tr bgcolor="#ccffe6">
            <td><samp><small>  <c:out value="${select2.nameCompany}" />     </small></samp></td>
            <td><samp><small>  <c:out value="${select2.countryCompany}" />  </small></samp></td>
            <td><samp><small>  <c:out value="${select2.nameAircraft}" />    </small></samp></td>
            <td><samp><small>  <c:out value="${select2.maxRangeAircraft}" /></small></samp></td>
            <td><samp><small>  <c:out value="${select2.quantity}" />        </small></samp></td>
        </tr>
    </c:forEach>
</table>




<p>
<hr width="50%" align="left">
<p>

<table border="0" width="70%"  bgcolor="#00331a" cellpadding="5">
    <tr align="left" bgcolor="#ffcccc">
        <td>
            <samp>
                <b>Query 3.</b>
                List shows how many Boeings each company has, sorted in descending order.
            </samp>
        </td>
    </tr>
    <tr align="left" bgcolor="#ffffff">
        <td>
            <b><samp>
               SELECT companies.name, companies.country, SUM(ownership.quantity)<br>
               FROM ownership<br>
               JOIN companies ON ownership.id_companies = companies.id_companies<br>
               JOIN aircrafts ON ownership.id_aircraft= aircrafts.id_aircraft<br>
               WHERE aircrafts.name LIKE '%Boeing%'<br>
               GROUP BY ownership.id_companies<br>
               ORDER BY SUM(ownership.quantity) DESC
            </samp></b>
        </td>
    </tr>
</table>
<table border="0" width="70%" bgcolor="#00331a">
    <thead>
    <tr align="center" bgcolor="#b3ffd9">
        <td width="40%"><samp> <b>name</b>      <br><small>company name             </small></samp></td>
        <td width="40%"><samp> <b>country</b>   <br><small>country of the company   </small></samp></td>
        <td><samp> <b>quantity</b>  <br><small>number of Boeings in the company     </small></samp></td>
    </tr>
    </thead>
    <c:forEach var="select3" items="${select3ArrayList}">
        <tr bgcolor="#ccffe6">
            <td><samp><small>  <c:out value="${select3.nameCompany}" />     </small></samp></td>
            <td><samp><small>  <c:out value="${select3.countryCompany}" />  </small></samp></td>
            <td><samp><small>  <c:out value="${select3.quantity}" />        </small></samp></td>
        </tr>
    </c:forEach>
</table>

<p>
<hr width="50%" align="left">
<p>


<table border="0" width="70%"  bgcolor="#00331a" cellpadding="5">
    <tr align="left" bgcolor="#ffcccc">
        <td>
            <samp>
                <b>Query 4.</b>
                List shows how many aircrafts each company has and
                how many passengers each company can carry at the same time.
                Sorted in ascending order by number of passengers.
            </samp>
        </td>
    </tr>

    <tr align="left" bgcolor="#ffffff">
        <td>
            <b><samp>
                SELECT companies.name, companies.country,<br>
                SUM(ownership.quantity), SUM(ownership.quantity*aircrafts.passengers)<br>
                FROM ownership<br>
                JOIN companies ON ownership.id_companies = companies.id_companies<br>
                JOIN aircrafts ON ownership.id_aircraft= aircrafts.id_aircraft<br>
                GROUP BY ownership.id_companies<br>
                ORDER BY SUM(ownership.quantity*aircrafts.passengers) ASC
            </samp></b>
        </td>
    </tr>
</table>
<table border="0" width="70%" bgcolor="#00331a">
    <thead>
    <tr align="center" bgcolor="#b3ffd9">
        <td width="30%"><samp> <b>name</b>      <br><small>company name</small>     </samp></td>
        <td width="30%"><samp> <b>country</b>   <br><small>country of the company</small>    </samp></td>
        <td width="20%"><samp> <b>quantity</b>  <br><small>how many aircrafts in the company   </small>   </samp></td>
        <td><samp> <b>passengers</b><br><small>how many passengers can be transported at the same time  </small>   </samp></td>
    </tr>
    </thead>
    <c:forEach var="select4" items="${select4ArrayList}">
        <tr bgcolor="#ccffe6">
            <td><samp><small>  <c:out value="${select4.nameCompany}" />     </small></samp></td>
            <td><samp><small>  <c:out value="${select4.countryCompany}" />  </small></samp></td>
            <td><samp><small>  <c:out value="${select4.quantity}" />    </small></samp></td>
            <td><samp><small>  <c:out value="${select4.passengers}" />        </small></samp></td>
        </tr>
    </c:forEach>
</table>



</body>
</html>
