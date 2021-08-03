<!DOCTYPE html>
<html>
<head>
<title>Create User</title>
</head>
<body>
    <div style="padding-left:50px;font-family:monospace;">
        <h2>Create User</h2>
        <form action="/UserTest/user/detail/createUser" method="POST">
            <div style="width: 100px; text-align:left;">
            	<div style="padding:15px;">
                    UserContent: <input style="height:150px;font-size:12pt;" name="userContent" />
                </div>
                <div style="padding:15px;">
                    Expiration: <input name="expiration" />
                </div>
                 <div style="padding:15px;">
                    Exposure: <input name="exposure" />
                </div>
                <div style="padding:10px;">
                    Name: <input name="name" />
                </div>
                <div style="padding:10px;">
                    Password: <input name="password" />
                </div>
                <div style="padding:20px;text-align:center">
                    <input type="submit" value="Submit" />
                </div>
            </div>
        </form>
    </div>
</body>
</html>