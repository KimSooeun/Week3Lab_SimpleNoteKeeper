<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Note</title>
    </head>
    <body>
        <h1>Simple Note Keeper</h1>
        <h2>Edit Note</h2>
        <form method="post" action="note">
            Title: <input type="text" name="title_field" value="${title}"><br>
            Contents: <textarea name="content_field" rows="6" cols="25">${content}</textarea><br>
            <input type="submit" value="Save">
        </form>
    </body>
</html>