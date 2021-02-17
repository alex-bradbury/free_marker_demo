<#macro body>
<body>
    <#nested/>
</body>
</#macro>

<#macro header title>
<head>
    <#include "css/govuk_hack.css">
    <#include "css/styles.css">
    <title>${title}</title>
</head>
</#macro>

<#macro footer>
<footer>
</footer>
</#macro>