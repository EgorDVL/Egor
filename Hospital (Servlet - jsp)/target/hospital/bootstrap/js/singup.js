$(document).ready(function() {
	$("#regForm").validate({
		rules : {
			username : {
				required : true,
			},
			Password : {
				required : true,
			},
			name : {
				required : true,
			},
			surname : {
				required : true,
			},
		},
		messages : {
			username : {
				required : "This field is required",
			},
			Password : {
				required : "This field is required",
			},
			name : {
				required : "This field is required",
			},
			surname : {
				required : "This field is required",
			},
		}
	});
});