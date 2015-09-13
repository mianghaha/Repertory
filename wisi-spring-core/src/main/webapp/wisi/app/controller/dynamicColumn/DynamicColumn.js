Ext.define('wisi.controller.dynamicColumn.DynamicColumn', {
	extend: 'wisi.common.core.WisiController',
	
	models: [
		'wisi.model.dynamicColumn.DynamicColumn'
	],
	stores: [
 		'wisi.store.dynamicColumn.DynamicColumn'
 	],
	views: [
		'wisi.view.dynamicColumn.DynamicColumn'
	],
	
	init: function(){
		var me = this;
		
		me.control({
			"dynamicColumn button[name='createGridColumnBtn']": {
				click: this.onCreateGridColumnBtn
			}
		});
	},
	
	onCreateGridColumnBtn: function(button, e, eOpts){
		var me = this;
		
		var grid = Ext.getCmp('createGridData');
		
		var store = me.getStore('dynamicColumn.DynamicColumn');
		store.load();
		Ext.suspendLayouts();
		
		var checkboxGroup = Ext.getCmp('userInfoGroup');
		
		var arrText = [];
		/*
		arrText.push('City');
		arrText.push('Total Employess');
		arrText.push('Manager');
		arrText.push('City1');
		arrText.push('Total Employess1');
		arrText.push('Manager1');
		*/
		var arrDataIndex = [];
		/*
		arrDataIndex.push('userName');
		arrDataIndex.push('userId');
		arrDataIndex.push('userDep');
		arrDataIndex.push('userJob');
		arrDataIndex.push('userInDate');
		arrDataIndex.push('userSex');
		arrDataIndex.push('userAge');
		*/
		Ext.each(checkboxGroup.items.items, function(item){
			if(item.checked){
				arrText.push(item.boxLabel);
				arrDataIndex.push(item.name);
			}
		});
		
		grid.reconfigure(store, function(arrs, titles){
			var arr = [];
			var i = 0;
			var className = '';
			var columns = arrs.length;
			Ext.each(arrs, function(itm){
				if(i === columns - 1){
					className = '';
				}else{
					className = 'x-column-header-right';
				}
				arr.push({
					text: itm,
					dataIndex: titles[i],
					cls: className,
					flex: 1
				});
				i++;
			});
			return arr;
		}(arrText, arrDataIndex));
		
		Ext.resumeLayouts(true);
	}
});