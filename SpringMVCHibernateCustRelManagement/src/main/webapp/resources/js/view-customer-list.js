function confirmDeleteDialog(custId) {
	if (confirm("Are you sure you want to delete?")) {
		window.location.replace("deleteCustomer/" + custId);
	}
}