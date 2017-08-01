var dataSet = [[ 'BCD-xxx', 'Installation of chrome', 'PASS', 'Installscreen.png', 'N/A' ],[ 'BCD-xxx', 'Login as admin into Ad Inspector', 'PASS', 'login.png', 'N/A' ],[ 'BCD-xxx', 'Report Issue with Plugin', 'PASS', 'report_issue_popup.png', 'N/A' ]]; $(document).ready(function() { 	$('#example').DataTable({ 		dom: 'Bfrtip', 		 		data: dataSet, 		columns: [{ 			title: "Testcase ID" 		}, { 			title: "TestCase summary" 		}, { 			title: "Testcase result pass /fail" 		}, { 			title: "Screenshot" 		}, { 			title: "Exception log" 		}, ], 		buttons: [ 			'copy', 'csv', 'excel', 'pdf', 'print' 		] 		 	}); });