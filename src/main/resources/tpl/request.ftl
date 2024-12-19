<html style="margin:10px">
<#-- @ftlvariable name="data" type="io.qameta.allure.attachment.http.HttpRequestAttachment" -->
<head>
    <meta http-equiv="content-type" content="text/html; charset = UTF-8">
    <style>
        pre {
            white-space: pre-wrap;
            padding-top: .1em;
            padding-bottom: .1em;
        }
        .hljs {
            padding-top: .3em;
            padding-bottom: .3em;
        }
    </style>
</head>
<body>
    <div>
        <pre><code><#if data.method??>${data.method}<#else>GET</#if>: <#if data.url??>${data.url}<#else>Unknown</#if></code></pre>
    </div>

    <#if data.body??>
        <h4>Body</h4>
        <div>
            <pre><code>${data.body}</code></pre>
        </div>
    </#if>

    <#if (data.headers)?has_content>
        <h4>Headers</h4>
        <div>
            <#list data.headers as name, value>
                <div>
                    <pre><code><b>${name}</b>: ${value}</code></pre>
                </div>
            </#list>
        </div>
    </#if>
</body>
</html>
