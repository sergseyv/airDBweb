<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Database "AVIA" - Add Company Page</title>
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
                        <h2><samp>Add company</samp></h2>
                    </td>
                    <td align="center" valign="bottom">
                        <h2><samp>Table "companies"</samp></h2>
                    </td>
                </tr>
                <tr>
                    <td align="right" valign="top">
                        <form method="post">
                            <label>company name:
                                <input type="text" name="name">
                            </label>
                            <br><br>
                            <label>country:
                                <input type="text" name="country">
                            </label>
                            <br><br>
                            <button type="submit">Add to database</button>
                            <button type="reset">Clear form</button>
                        </form>
                        <button onclick="location.href='showmainpage'">Return to Main Page</button>
                    </td>
                    <td valign="top" align="center">
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
                </tr>
            </table>
            <p>
            <hr>
        </td>
    </tr>
</table>
</body>
</html>
