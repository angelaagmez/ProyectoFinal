function sortTable() {
	var table, i, x, y;
	table = document.getElementById("table");
	var switching = true;

	while (switching) {
		switching = false;
		var rows = table.rows;

		for (i = 1; i < (rows.length - 1); i++) {
			var Switch = false;

			x = rows[i].getElementsByTagName("TD")[0];
			y = rows[i + 1].getElementsByTagName("TD")[0];

			if (x.innerHTML.toLowerCase() > y.innerHTML.toLowerCase()) {

				Switch = true;
				break;
			}
		}
		if (Switch) {
			rows[i].parentNode.insertBefore(rows[i + 1], rows[i]);
			switching = true;
		}
	}
}