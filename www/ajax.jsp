<!DOCTYPE HTML PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" 
	"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
<head>
 <meta http-equiv="content-type" content="text/html;charset=UTF-8" />
	<title>Prototype Beispiel</title>
	<script src="/m151/javascripts/prototype.js" type="text/javascript"></script>
	<script>
		zaehlen=function(page) {
			$('indicator').show();
			new Ajax.Updater(
				"eineID",
				page,
				{
					method: "post",
					parameters: $('form').serialize(true),
			    onComplete:function(request){$('indicator').hide()},
					onFailure: function(){ alert('Etwas ist schiefgelaufen...') }
				}
			);
		}
	</script>
</head>
<body>
	<span id="indicator" style="display: none;">Laden ...</span>
	<span id="eineID">Hier erscheint später der dynamische Teil</span>
	<hr/>
	<form id="form"">
		<input type="text" size="40" name="eingabe" id="eingabe"><br />
		<input type="text" size="40" name="eingabe2" id="eingabe2"><br />
		<input type="button"  onclick="zaehlen('formElements.jsp');" value="Formularelemente anzeigen" >
	 </form>
	 <p><a href="#" onclick="zaehlen('counter.jsp');">Hochzählen</a></p>
</body>
</html>	