$(document).ready(function() {
	var currentLang = $("#currentLang").val();
	if (currentLang == "en") {
		$("#langSwitcher1").prop("checked", true);
		$("#langSwitcher2").prop("checked", true);
	} else {
		$("#langSwitcher1").prop("checked", false);
		$("#langSwitcher2").prop("checked", false);
	}

	var lang = "";
	$(".langSwitch").change(function(e) {
		var ischecked = $(this).is(":checked");
		if (ischecked) {
			lang = "en";
		} else {
			lang = "vi";
		}
		
		/*
		var _location = window.location.href;
		var loc = location.split("#")[0];
		var idxq = loc.lastIndexOf("?");
		if (idxq >= 0) {
			var idx1 = loc.lastIndexOf("lang");
			if (idx1 >= 0) {
				loc = loc.substr(0, idx1 - 1);
				loc = loc + "&lang=" + lang;
			} else {
				loc = loc + "&lang=" + lang;
			}
		} else {
			loc = loc + "?lang=en";
		}
		window.location.replace(loc);
		*/
		
		/*
		var finalLoc = "";
		var _location = window.location.href;
		var regex = /(lang=)([a-z]{2})/gi;
		
		var pattern = new RegExp(regex);
		if (pattern.test(_location)) {
			finalLoc = _location.replace(regex, "lang=" + lang);
		} else {
			var values = _location.split("?");
			var v1 = values[0];
			var v2 = "";
			if (values.length > 1) {
				v2 = "&" + values[1];
			}
			finalLoc = v1 + "?lang=" + lang + v2;
		}	
		*/
		var finalLoc = "";
		var _location = window.location.href;
		var regex = /(lang=)([a-z]{2})/gi;
		var pattern = new RegExp(regex);
		
		if (pattern.test(_location)) {
			finalLoc = _location.replace(regex, "lang=" + lang);
		} else {
			var nvp0 = _location.split("#");
			if (nvp0.length > 1) {
				var nvp1 = nvp0[0].split("?");
				if (nvp1.length > 1) {
					finalLoc = nvp1[0] + "?lang=" + lang + "&" + nvp1[1];
				} else {
					finalLoc = nvp1[0] + "?lang=" + lang;
				}
			} else {
				var nvp2 = _location.split("?");
				var v1 = nvp2[0];
				var v2 = "";
				if (nvp2.length > 1) {
					v2 = "&" + nvp2[1];
				}
				finalLoc = v1 + "?lang=" + lang + v2;
			}
		}
		window.location.replace(finalLoc);
	});
});