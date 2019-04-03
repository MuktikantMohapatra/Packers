<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body><!-- https://securegw-stage.paytm.in/theia/processTransaction -->
<form action="https://securegw.paytm.in/theia/processTransaction" method= "post" name="f1">

<input type="hidden" name="MID" value="lNvCLO02480545533151">
                    <input type="hidden" name="WEBSITE" value="WEBSTAGING">
                    <input type="hidden" name="ORDER_ID" value="order1">
                    <input type="hidden" name="CUST_ID" value="cust123">
                    <input type="hidden" name="MOBILE_NO" value="9853270680">
                    <input type="hidden" name="EMAIL" value="username@emailprovider.com">
                    <input type="hidden" name="INDUSTRY_TYPE_ID" value="Retail">
                    <input type="hidden" name="CHANNEL_ID" value="WEB">
                    <input type="hidden" name="TXN_AMOUNT" value="100.12">
                    <input type="hidden" name="CALLBACK_URL" value="http://localhost:8090/packers/page">
                    <input type="hidden" name="CHECKSUMHASH" value="${paytmCheckSum}">
</form>
<script type="text/javascript">
document.f1.submit();
</script>
</body>
</html>