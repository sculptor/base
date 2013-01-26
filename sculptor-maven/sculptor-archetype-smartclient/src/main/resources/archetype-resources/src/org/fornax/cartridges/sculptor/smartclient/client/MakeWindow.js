// Sample JavaScript pre decorator
var form=$wnd.isc.DynamicForm.create({
	autoDraw: false,
	height: 48,
	padding:4,
	fields: $wnd.Array.create([
		{name: "Select", type: "select", valueMap: $wnd.Array.create(["Ano", "Nie", "Mozno"])},
		{name: "DateFrom", type: "date"},
		{name: "DateTo", type: "date"},
		{name: "Mena", title:"Item", type:"select",
			optionDataSource:"currencyService",
			displayField:"name", 
			pickListWidth: 550,
			pickListFields: $wnd.Array.create([{name: "name"}, {name: "alias"}]),
			valueField:"id"
		},
		{type: "button", title: "Done", click: "modalWindow.hide()" }
	])
});

var wind=$wnd.isc.Window.create({
	ID: "modalWindow",
	title: "Modal Window",
	autoSize:true,
	isModal: true,
	width: 500,
	// height: 300,
	autoCenter: true,
	showModalMask: true,
	autoDraw: true,
	items: $wnd.Array.create([form])
});

wind.show();

