# crep
Mock code for ReplayService

TEMP

CODE


LOGIN 2
-------------
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link rel="stylesheet" th:href="@{/styles.css}" />
</head>
<body>
    <h1>Login</h1>

    <div th:if="${error}" class="error-message" th:text="${error}"></div>

    <form th:action="@{/login}" method="post">
        <div>
            <label for="userId">User ID:</label>
            <input type="text" id="userId" name="userId" required>
        </div>
        <div>
            <label for="password">Password:</label>
            <input type="password" id="password" name="password" required>
        </div>
        <button type="submit">Login</button>
    </form>
</body>
</html>



LOGIN.HTML
------------------
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

---------
CSS
---------
.login-container {
    width: 300px;
    margin: 100px auto;
    text-align: center;
}

.login-container input {
    margin: 10px;
    padding: 10px;
    width: 90%;
}

.login-btn {
    padding: 10px 20px;
    margin-top: 20px;
}


--------
Controller
-----------
@GetMapping("/login")
public String login() {
    return "login";
}

@PostMapping("/login")
public String performLogin(@RequestParam String userId, @RequestParam String password, RedirectAttributes redirectAttributes) {
    if (userId.equals(password)) {
        return "redirect:/upload";
    } else {
        redirectAttributes.addFlashAttribute("error", "Invalid Credentials");
        return "redirect:/login";
    }
}


