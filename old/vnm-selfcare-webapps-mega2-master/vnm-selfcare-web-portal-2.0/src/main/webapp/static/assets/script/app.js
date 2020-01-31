/** utility javascript functions **/


$(document).ready(function(){
	$zopim(function() {
		$zopim.livechat.bubble.hide();
	});	
});

function logout(logoutMsg, okTxt, cancelTxt){

	BootstrapDialog.confirm({
        title: '',
        message: logoutMsg,
        type: BootstrapDialog.TYPE_WARNING, // <-- Default value is BootstrapDialog.TYPE_PRIMARY
        closable: true, // <-- Default value is false
        draggable: true, // <-- Default value is false
        btnCancelLabel: cancelTxt, // <-- Default value is 'Cancel',
        btnCancelClass: 'btn btn-secondary btn-round',
        btnOKLabel: okTxt, // <-- Default value is 'OK',
        btnOKClass: 'btn btn-primary btn-round', // <-- If you didn't specify it, dialog type will be used,
        callback: function(result) {
            // result will be true if button was click, while it will be false if users close the dialog directly.
            if(result) {
            		$("#logoutForm").submit();
            }else { }
        }
    });
	
}

function getOS() {
	var userAgent = window.navigator.userAgent, platform = window.navigator.platform, macosPlatforms = [
			'Macintosh', 'MacIntel', 'MacPPC', 'Mac68K' ], windowsPlatforms = [
			'Win32', 'Win64', 'Windows', 'WinCE' ], iosPlatforms = [ 'iPhone',
			'iPad', 'iPod' ], os = null;

	if (macosPlatforms.indexOf(platform) !== -1) {
		os = 'Mac OS';
	} else if (iosPlatforms.indexOf(platform) !== -1) {
		os = 'iOS';
	} else if (windowsPlatforms.indexOf(platform) !== -1) {
		os = 'Windows';
	} else if (/Android/.test(userAgent)) {
		os = 'Android';
	} else if (!os && /Linux/.test(platform)) {
		os = 'Linux';
	}

	return os;
}

function downloadContent(iosURL, androURL){
	var os = getOS();
	var location = "";
	if (os == "iOS" || os == "Mac OS"){
		location = iosURL;
	} else {
		location = androURL;
	}
	if (location != "") window.open(location, "_blank");
}
