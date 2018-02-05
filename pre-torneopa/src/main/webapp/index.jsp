<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">

<html>
 <HEAD><TITLE>torneo pa</TITLE></HEAD>
  <BODY BGCOLOR="#CCCCFF">
  <P></P>
  <H2>Introduce tus datos por fi:</H2><BR>
    <HR></HR>
    <CENTER>
	 <FORM NAME="FORM1" METHOD="POST"
		ACTION="/ztorneopa/Torneopa">
	   <TABLE BORDER>
		<TR>
		  <TD><B>Nombre:</TD>
		  <TD><INPUT ENGINE=TEXTBOX NAME="NOM" SIZE="25" VALUE=""></TD>
		</TR>
		<TR>
		  <TD><B>Edad:</TD>
		  <TD><INPUT ENGINE=TEXTBOX NAME="EDA" SIZE="20" VALUE=""></TD>
		</TR>
	   </TABLE>
	   <P></P>
	  
	   <INPUT TYPE=SUBMIT VALUE="Enviar">
	   <HR></HR>
	   Formulario HTML que invocará a un servlet
         </FORM>
         
          <FORM NAME="Menu" METHOD="POST"
		ACTION="/ztorneopa/inicio.html">

	  
	   <INPUT TYPE=SUBMIT VALUE="Menu">
	   <HR></HR>
	   Formulario HTML que invocará a un servlet
         </FORM>
      </CENTER>
  </BODY>
</html>
