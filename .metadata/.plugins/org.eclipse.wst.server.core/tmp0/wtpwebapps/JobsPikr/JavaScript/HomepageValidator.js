function CandidateValidator(){		
	var email = document.candidateLogin.emailC.value;
	var password = document.candidateLogin.passwordC.value;
	var validemail = /[a-zA-Z0-9._-]+[@]{1}[a-z]+[.]{1}[a-zA-Z]{2,}$/;
	
	if(email == ""){
		alert("Enter E-mail");
		return false;
	}
	
	if(!(validemail.test(email))){
		alert("Incorrect E-mail");
		return false;
	}
	
	if(password == ""){
		alert("Enter Password");
		return false;
	}
	
	return true;
}
	
function RecruiterValidator(){
	var email = document.recruiterLogin.emailR.value;
	var password = document.recruiterLogin.passwordR.value;
	var validemail = /[a-zA-Z0-9._-]+[@]{1}[a-z]+[.]{1}[a-zA-Z]{2,3}$/;
	
	if(email == ""){
		alert("Enter E-mail");
		return false;
	}
	
	if(!(validemail.test(email))){
		alert("Incorrect E-mail");
		return false;
	}
		
	if(password == ""){
		alert("Enter Password");
		return false;
	}
	
	return true;
}