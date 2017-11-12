<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Database "AVIA" - Delete Ownership Page</title>
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
                        <h2><samp>Delete ownership</samp></h2>
                        <table border="0", width="100%" >
                            <tr>
                                <td align="right">
                                    <small>
                                        Select ID of the record you want to delete.
                                    </small>
                                </td>
                            </tr>
                        </table>
                    </td>
                    <td align="center" valign="bottom">
                        <h2><samp>Table "ownerships"</samp></h2>
                    </td>
                </tr>
                <tr>
                    <td align="right" valign="top">
                        <form method="post">
                            <label>ownership ID:
                                <select name="id">
                                    <c:forEach var="ownershipTable" items="${ownershipArrayList}">
                                        <option value="${ownershipTable.idOwnership}">
                                                ${ownershipTable.idOwnership}
                                        </option>
                                    </c:forEach>
                                </select>
                            </label>
                            <br><br>
                            <button type="submit">Delete</button>
                            <button type="reset">Clear form</button>
                        </form>
                        <button onclick="location.href='showmainpage'">Return to Main Page</button>
                    </td>
                    <td valign="top" align="center">
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
            <hr>
        </td>
    </tr>
</table>
</body>
</html>
