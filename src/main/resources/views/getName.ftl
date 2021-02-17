<#-- @ftlvariable name="" type="models.Name" -->
<#import "macros.ftl" as macros>
<!DOCTYPE html>
<html lang="en">
<@macros.header title="Enter Your Name"/>
<@macros.body>
    <h1>Please enter your name</h1>
    <form method="post" action="http://localhost:8095">
        <input type="text" id="name" name="name" placeholder="Name"/>
        <button type="submit">Submit</button>
    </form>
    <#if name.name != "">
        <p>Thank you for submitting ${name.name}!</p>
    </#if>
</@macros.body>
<@macros.footer/>
</html>