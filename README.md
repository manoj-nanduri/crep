# crep
Mock code for ReplayService

TEMP

CODE


<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link rel="stylesheet" th:href="@{/styles.css}" />
</head>
<body>
    <div class="login-container">
        <form th:action="@{/login}" method="post">
            <input type="text" placeholder="User ID" name="userId" required />
            <input type="password" placeholder="Password" name="password" required />
            <button type="submit" class="login-btn">Login</button>
        </form>
    </div>
</body>
</html>



