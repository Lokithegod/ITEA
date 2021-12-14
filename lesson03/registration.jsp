<%@ page import="java.util.Objects" %>
<%@ page import="java.util.regex.Matcher" %>
<%@ page import="java.util.regex.Pattern" %>
<%@ page import="java.nio.charset.StandardCharsets" %>
<a href='registration.jsp'> registration</a>--
<a href='login.jsp'> login</a>
<%
boolean isShowForm = true;
String login = request.getParameter("login");
String password = request.getParameter("password");
String rePassword = request.getParameter("re-password");
String name = request.getParameter("name");
String gender = request.getParameter("gender");
String address = request.getParameter("address");
String comment = request.getParameter("comment");
String agree = request.getParameter("agree");
String errorText = "<ul>";
Pattern patlatletter = Pattern.compile("[a-zA-Z]{1}");
Matcher matlatletter ;
Matcher matcher ;
String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@" + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
Pattern emailPattern=  Pattern.compile(EMAIL_PATTERN);

int uperFlag =0;
int lowerFlag =0;
int digitFlag =0;
boolean onlyLatinAlphabet = true;

Character ch ;
errorText += "</ul>";
boolean isError = false;

if(!Objects.isNull(login)){
	if(login.length() < 1){
		isError = true;
		errorText += "<li> login is empty </li>";
	}
	matcher = emailPattern.matcher(login);
	if(!matcher.matches()){
		isError = true;
		errorText += "<li> invalid login name </li>";
	}
	if(password.length() < 1) {
		isError = true;
		errorText += "<li> password is empty </li>";
	}
		if (password.length() <= 8) {
			isError = true;
			errorText += "<li> password must contain 8+ symblos </li>";
		}
		char[]character = password.toCharArray();

		for (int i = 0; i < character.length; i++) {
			ch = character[i];
			if (Character.isUpperCase(ch)) {
				isError = true;
				uperFlag =+1;
			}
			if (Character.isLowerCase(ch)) {
				isError = true;
				lowerFlag =+1;
			}
			if (Character.isDigit(ch)) {
				isError = true;
				digitFlag = +1;
			}
		}
		if (uperFlag == 0){
			errorText += "<li> password must contain Upper case character </li>";
		}
		if (lowerFlag == 0){
			errorText += "<li> password must contain Lower case character  </li>";
		}
		if (digitFlag == 0){
			errorText += "<li> password must contain digit character </li>";
		}
	matlatletter = patlatletter.matcher(password);
	//if (!Character.UnicodeBlock.of(ch).equals(Character.UnicodeBlock.BASIC_LATIN)) {
	if(matlatletter.matches()){
		isError = true;
		errorText += "<li> password must contain only lat character </li>";
		//errorText += "<li>"+ ch +" - is not lat character </li>";

	}
//		onlyLatinAlphabet= password.matches("^[a-zA-Z0-9]+$");
//		if (onlyLatinAlphabet = false ){
//			errorText += "<li> password must contain only lat character </li>";
//		}



	if(rePassword.length() < 1){
		isError = true;
		errorText += "<li> re-password is empty </li>";
	}
	if(!Objects.equals(password,rePassword)){
		isError = true;
		errorText += "<li> Those passwords do not match. Try again:  </li>";
	}
	if(name.length() < 1){
		isError = true;
		errorText += "<li> name is empty </li>";
	}
	if(Objects.isNull(gender) || gender.length() < 1 ){
		isError = true;
		errorText += "<li> gender is empty </li>";
	}
	if(address.length() < 1){
		isError = true;
		errorText += "<li> address is empty </li>";
	}
	if(comment.length() < 1){
		isError = true;
		errorText += "<li> comment is empty </li>";
	}
	if(Objects.isNull(agree)){
		isError = true;
		errorText += "<li> agree is empty </li>";
	}
	if(!isError){
	out.write("registration success");
	isShowForm = false;
	}
}


if(isShowForm){
	%><center>
<table><tr><td>
<form action='' method='post'>
<table>
<tr><td>login</td><td><input type='text' name='login' value='<%=(login==null?"":login)%>' /></td></tr>
<tr><td>password</td><td><input type='password' name='password' value='<%=(password==null?"":password)%>'/></td></tr>
<tr><td>re-password</td><td><input type='password' name='re-password' value='<%=(rePassword==null?"":rePassword)%>'/></td></tr>
<tr><td>name</td><td><input type='text' name='name' value='<%=(name==null?"":name)%>'/></td></tr>
<tr><td>gender</td><td>M<input type='radio' name='gender' value='male' <%=(Objects.equals(gender, "male")?"checked":"")%>/>F<input type='radio' name='gender' value='female'  <%=(Objects.equals(gender, "female")?"checked":"")%> /></td></tr>
<tr><td>address</td><td><select  name='address' > 
<option value='DNR' <%=(Objects.equals(address, "DNR")?"selected":"")%>>DNR</option>
<option value='LNR' <%=(Objects.equals(address, "LNR")?"selected":"")%>>LNR</option>
<option value='Crimea' <%=(Objects.equals(address, "Crimea")?"selected":"")%>>Crimea</option>
</select>
</td></tr>
<tr><td>comment</td><td><textarea rows='10' cols='25' name='comment'><%=(comment==null?"":comment)%></textarea></td></tr>
<tr><td>i agree to instal amigobrowser</td><td><input type='checkbox' name='agree' /></td></tr>
<tr><td></td><td><input type='submit' value='SEND' /></td></tr>

<!--<tr><td>name</td><td><input type='text' name='name' /></td></tr>
	
	
	<input type='submit' value='SEND' />-->
</table>
</form>
</td><td><%out.write(errorText);%></td>
</tr></table>
	<%
}
//out.write(result);
//out.write("<br>attempts: " + number);
%>