<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- Created by Seyvach Serg on 01.11.2017 -->
<html>
  <head>
    <title>Database "AVIA" - Welcome Page</title>
  </head>

  <body bgcolor="#ffff80">

  <table border="0" bgcolor="#ffff80" width="100%">
    <tr>
      <td><p><hr><p></td>
    </tr>
    <tr align="center">
      <td>
        <table width="50%" border="0">
          <tr align="center">
            <td>
              <p>
                <h1><samp>Welcome!</samp></h1>
              <p>
                <h2><samp>Now database is empty.</samp></h2>
              <p>
                <h2><samp>Click <b>"Start"</b> to create and fill tables.</samp></h2>
              <p>
            </td>
          </tr>
          <tr>
            <td><p></td>
          </tr>
          <tr align="center">
            <td>
              <h2><a href="${pageContext.request.contextPath}/restore">Start</a></h2>
            </td>
          </tr>
        </table>
      </td>
    </tr>
    <tr>
      <td><p><hr><p></td>
    </tr>
  </table>

  </body>

</html>
