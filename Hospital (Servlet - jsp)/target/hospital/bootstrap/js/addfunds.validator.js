/**
 * 
 */
$(document).ready(function() {

	$("#addFundsForm").validate({
		rules : {
			accountId : {
				required : true,
			},
			amount : {
				required : true,
				number : true,
				min : 1
			},
		},
		messages : {
			accountId : {
				required : "This field is required",
			},
			amount : {
				required : "This field is required",
				number : "Enter valid number",
				min : "Use values greater than 0",
			},
		}
	});
});