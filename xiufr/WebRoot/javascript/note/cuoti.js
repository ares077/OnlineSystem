function addAns() {
	var sans1 = document.getElementById("sans1");
	if (sans1 != null) {
		var s1 = document.getElementsByName("s1");
		for ( var i = 0; i < s1.length; i++) {
			if (s1[i].value == sans1.value) {
				var $s1 = $(s1[i]);
				$s1.next().css("color", "red");
				$s1.attr("checked", "checked");
			}
		}
	}
	var sans2 = document.getElementById("sans2");
	if (sans2 != null) {
		var s2 = document.getElementsByName("s2");
		for ( var i = 0; i < s2.length; i++) {
			if (s2[i].value == sans2.value) {
				var $s2 = $(s2[i]);
				$s2.next().css("color", "red");
				$s2.attr("checked", "checked");
			}
		}
	}
	var sans3 = document.getElementById("sans3");
	if (sans3 != null) {
		var s3 = document.getElementsByName("s3");
		for ( var i = 0; i < s3.length; i++) {
			if (s3[i].value == sans3.value) {
				var $s3 = $(s3[i]);
				$s3.next().css("color", "red");
				$s3.attr("checked", "checked");
			}
		}
	}
	var sans4 = document.getElementById("sans4");
	if (sans4 != null) {
		var s4 = document.getElementsByName("s4");
		for ( var i = 0; i < s4.length; i++) {
			if (s4[i].value == sans4.value) {
				var $s4 = $(s4[i]);
				$s4.next().css("color", "red");
				$s4.attr("checked", "checked");
			}
		}
	}
	var sans5 = document.getElementById("sans5");
	if (sans5 != null) {
		var s5 = document.getElementsByName("s5");
		for ( var i = 0; i < s5.length; i++) {
			if (s5[i].value == sans5.value) {
				var $s5 = $(s5[i]);
				$s5.next().css("color", "red");
				$s5.attr("checked", "checked");
			}
		}
	}
	var sans6 = document.getElementById("sans6");
	if (sans6 != null) {
		var s6 = document.getElementsByName("s6");
		for ( var i = 0; i < s6.length; i++) {
			if (s6[i].value == sans6.value) {
				var $s6 = $(s6[i]);
				$s6.next().css("color", "red");
				$s6.attr("checked", "checked");
			}
		}
	}
	var sans7 = document.getElementById("sans7");
	if (sans7 != null) {
		var s7 = document.getElementsByName("s7");
		for ( var i = 0; i < s7.length; i++) {
			if (s7[i].value == sans7.value) {
				var $s7 = $(s7[i]);
				$s7.next().css("color", "red");
				$s7.attr("checked", "checked");
			}
		}
	}
	var mans1 = document.getElementById("mans1");
	if (mans1 != null) {
		var m1 = document.getElementsByName("m1");
		var mans1Arr = mans1.value.toString().split(",", 7);
		for ( var i = 0; i < mans1Arr.length; i++) {
			for ( var j = 0; j < m1.length; j++) {
				if (mans1Arr[i] == m1[j].value) {
					var $m1 = $(m1[j]);
					$m1.next().css("color", "red");
					$m1.attr("checked", "checked");
				}
			}
		}
	}
	var mans2 = document.getElementById("mans2");
	if (mans2 != null) {
		var m2 = document.getElementsByName("m2");
		var mans2Arr = mans2.value.toString().split(",", 7);
		for ( var i = 0; i < mans2Arr.length; i++) {
			for ( var j = 0; j < m2.length; j++) {
				if (mans2Arr[i] == m2[j].value) {
					var $m2 = $(m2[j]);
					$m2.next().css("color", "red");
					$m2.attr("checked", "checked");
				}
			}
		}
	}
	var mans3 = document.getElementById("mans3");
	if (mans3 != null) {
		var m3 = document.getElementsByName("m3");
		var mans3Arr = mans3.value.toString().split(",", 7);
		for ( var i = 0; i < mans3Arr.length; i++) {
			for ( var j = 0; j < m3.length; j++) {
				if (mans3Arr[i] == m3[j].value) {
					var $m3 = $(m3[j]);
					$m3.next().css("color", "red");
					$m3.attr("checked", "checked");
				}
			}
		}
	}
	var mans4 = document.getElementById("mans4");
	if (mans4 != null) {
		var m4 = document.getElementsByName("m4");
		var mans4Arr = mans4.value.toString().split(",", 7);
		for ( var i = 0; i < mans4Arr.length; i++) {
			for ( var j = 0; j < m4.length; j++) {
				if (mans4Arr[i] == m4[j].value) {
					var $m4 = $(m4[j]);
					$m4.next().css("color", "red");
					$m4.attr("checked", "checked");
				}
			}
		}
	}
	var mans5 = document.getElementById("mans5");
	if (mans5 != null) {
		var m5 = document.getElementsByName("m5");
		var mans5Arr = mans5.value.toString().split(",", 7);
		for ( var i = 0; i < mans5Arr.length; i++) {
			for ( var j = 0; j < m5.length; j++) {
				if (mans5Arr[i] == m5[j].value) {
					var $m5 = $(m5[j]);
					$m5.next().css("color", "red");
					$m5.attr("checked", "checked");
				}
			}
		}
	}
}
addLoadEvent(addAns);