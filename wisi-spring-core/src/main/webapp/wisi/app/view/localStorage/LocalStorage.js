Ext.define('wisi.view.localStorage.LocalStorage', {
	extend: 'Ext.container.Container',
	alias: 'widget.localStorage',
	layout: {
		type: 'vbox',
		align: 'stretch'
	},
	
	items: [
		{
			xtype: 'container',
			layout: 'fit',
			height: 100,
			items: [
				{
					xtype: 'form',
					layout: 'absolute',
					bodyStyle: 'border-bottom: 0px;',
					height: 100,
					items: [
						{
							xtype: 'combobox',
							x: 10,
							y: 20,
							queryMode: 'local',
							displayField: 'userName',
							valueField: 'userId',
							store: 'localStorage.UserLocalStorage',
							fieldLabel: '姓名',
							labelWidth: 30							
						},
						{
							xtype: 'button',
							x: 210,
							y: 20,
							id: 'addUserBtn',
							name: 'addUserBtn',
							text: '添加',
							width: 50
						},
						{
							xtype: 'button',
							x: 280,
							y: 20,
							id: 'searchUserBtn',
							name: 'searchUserBtn',
							text: '查询',
							width: 150
						}
					]
				}
			]
		},
		{
			xtype: 'container',
			layout: 'fit',
			flex: 1,
			items: [
				{
					xtype: 'gridpanel',
					cls: 'grid-selected',
					store: 'localStorage.UserDetailLocalStorage',
					columns: [
						{
							xtype: 'gridcolumn',
							cls: 'x-column-header-right',
							dataIndex: 'userName',
							text: '姓名',
							flex: 1
						},
						{
							xtype: 'gridcolumn',
							cls: 'x-column-header-right',
							dataIndex: 'userId',
							text: '姓名ID',
							flex: 1
						},
						{
							xtype: 'gridcolumn',
							cls: 'x-column-header-right',
							dataIndex: 'userDep',
							text: '部门',
							flex: 1
						},
						{
							xtype: 'gridcolumn',
							cls: 'x-column-header-right',
							dataIndex: 'userJob',
							text: '职位',
							flex: 1
						},
						{
							xtype: 'gridcolumn',
							cls: 'x-column-header-right',
							dataIndex: 'userInDate',
							text: '入职时间',
							flex: 1
						},
						{
							xtype: 'gridcolumn',
							cls: 'x-column-header-right',
							dataIndex: 'userSex',
							text: '性别',
							flex: 1
						},
						{
							xtype: 'gridcolumn',
							cls: 'x-column-header-right',
							dataIndex: 'userAge',
							text: '年龄',
							flex: 1
						},
						{
							xtype: 'gridcolumn',
							dataIndex: 'userRemark',
							text: '备注',
							flex: 1
						}
					],
					viewConfig: {
						cls: 'x-grid-view-border'
					},
					dockedItems: [
		              	{
		              		xtype: 'pagingtoolbar',
		              		dock: 'bottom',
		              		displayInfo: true
		              	}
		            ]
				}
			]
		}
	]
});