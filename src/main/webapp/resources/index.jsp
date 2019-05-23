<!DOCTYPE html>
<html>
<head>
    <title>Page name</title>
    <link type="text/css" rel="stylesheet"  href="${pageContext.request.contextPath}/resources/stylesheet/style.css">
</head>
<body>
<h1>Password Generator </h1><div id="sec_options">
    <form action = "/generator" method = "POST">
        <div class="container">

            <div class="chboxl">Password Length:</div>
            <div class="chboxr"><label><input type="number" name="passwordLength" min="1" max="150" value="${passLength}" required>  1 - 150</label></div>

            <div class="chboxl">Include Symbols:</div>
            <div class="chboxr"><label><input type="checkbox" name="Symbols" id="Symbols" value="yes">( e.g. @#$% )</label></div>

            <div class="chboxl">Include Numbers:</div>
            <div class="chboxr"><label><input type="checkbox" name="Numbers" id="Numbers" value="yes">( e.g. 123456 )</label></div>

            <div class="chboxl">Include Lowercase Characters:</div>
            <div class="chboxr"><label><input type="checkbox" name="Lowercase" id="Lowercase" value="yes">( e.g. abcdefgh )</label></div>

            <div class="chboxl">Include Uppercase Characters:</div>
            <div class="chboxr"><label><input type="checkbox" name="Uppercase" id="Uppercase" value="yes">( e.g. ABCDEFGH )</label></div>

            <div class="chboxl">Exclude Ambiguous Characters:</div>
            <div class="chboxr"><label><input type="checkbox" name="NoAmb" id="NoAmb" value="yes">( { } [ ] ( ) / \ ' " ` ~ , ; : . &lt; &gt; )</label></div>



            <input type = "submit" value = "Submit" />
            <div class="warning">${WARNING}</div>
        </div>
    </form>
    <div class="chboxl "><H2>Your new Password: </H2></div>
    <div class="showNewPassword chboxr warning"><h2> ${password}</h2></div>
</div>
</body>

</html>
