Ext.define('Person', {
    extend: 'Ext.data.Model',
    fields: ['name', 'age']
});
var personStore = Ext.create("Ext.data.Store", {
	id: 'localSaveStore',
    model: 'Person'
});
