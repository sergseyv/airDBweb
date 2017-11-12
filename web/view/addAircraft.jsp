<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Database "AVIA" - Add Aircraft Page</title>
</head>

<body bgcolor="#ffff80">
<table border="0" width="100%">
    <tr>
        <td>
            <p>
            <hr>
            <p>
            <table border="0" cellpadding="5" width="90%" align="center">
                <tr>
                    <td align="right" width="40%">
                        <h2><samp>Add aircraft</samp></h2>
                    </td>
                    <td align="center" valign="bottom">
                        <h2><samp>Table "aircrafts"</samp></h2>
                    </td>
                </tr>
                <tr>
                    <td align="right" valign="top">
                        <form method="post">
                            <label>aircraft name:
                                <input type="text" name="name">
                            </label>
                            <br><br>
                            <label>number of passengers: <small>(numbers only!)</small>
                                <input type="text" name="passengers" pattern="^[0-9]+">
                            </label>
                            <br><br>
                            <label>maximum weight: <small>(numbers only!)</small>
                                <input type="text" name="maxweight" pattern="^[0-9]+">
                            </label>
                            <br><br>
                            <label>maximum flight range, km: <small>(numbers only!)</small>
                                <input type="text" name="maxrange" pattern="^[0-9]+">
                            </label>
                            <br><br>
                            <button type="submit">Add to database</button>
                            <button type="reset">Clear form</button>
                        </form>
                        <button onclick="location.href='showmainpage'">Return to Main Page</button>
                    </td>
                    <td valign="top" align="center">
                        <table border="0" width="90%"  bgcolor="#00331a" align="center">
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
                </tr>
            </table>
            <p>
            <hr>
        </td>
    </tr>
</table>
</body>
</html>
