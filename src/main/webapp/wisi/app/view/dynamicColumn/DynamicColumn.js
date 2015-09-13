Ext.define('wisi.view.dynamicColumn.DynamicColumn', {
	extend: 'Ext.panel.Panel',
    alias: 'widget.dynamicColumn',
    requires: [
               'Ext.form.Panel',
               'Ext.button.Button',
               'Ext.grid.Panel',
               'Ext.grid.column.Column',
               'Ext.grid.View',
               'Ext.toolbar.Paging'
           ],

    border: false,
    layout: 'border',
    title: '',

    initComponent: function() {
        var me = this;

        Ext.applyIf(me, {
            items: [
                {
                    xtype: 'form',
                    region: 'north',
                    height: 100,
                    layout: 'absolute',
                    bodyPadding: 10,
                    title: '',
                    items: [
                        {
                            xtype: 'button',
                            name: 'createGridColumnBtn',
                            height: 75,
                            //ui: 'menu-button-root-toolbar-large',
                            width: 130,
                            //icon: 'resource/images/common/add.gif',
                            iconAlign: 'top',
                            scale: 'large',
                            text: '动态创建Grid'
                        },
                        {
                        	xtype: 'checkboxgroup',
                        	x: 150,
                        	y: 40,
                        	id: 'userInfoGroup',
                        	width: 800,
                        	fieldLabel: '请选择要显示的列',
                        	labelWidth: 120,
                        	items: [
                        		{
                        			xtype: 'checkboxfield',
                        			name: 'userName',
                        			boxLabel: '姓名',
                        		},
                        		{
                        			xtype: 'checkboxfield',
                        			name: 'userId',
                        			boxLabel: '编号',
                        		},
                        		{
                        			xtype: 'checkboxfield',
                        			name: 'userDep',
                        			boxLabel: '部门',
                        		},
                        		{
                        			xtype: 'checkboxfield',
                        			name: 'userJob',
                        			boxLabel: '职务',
                        		},
                        		{
                        			xtype: 'checkboxfield',
                        			name: 'userInDate',
                        			boxLabel: '入职时间',
                        		},
                        		{
                        			xtype: 'checkboxfield',
                        			name: 'userSex',
                        			boxLabel: '性别',
                        		},
                        		{
                        			xtype: 'checkboxfield',
                        			name: 'userAge',
                        			boxLabel: '年龄',
                        		},
                        		{
                        			xtype: 'checkboxfield',
                        			name: 'userRemark',
                        			boxLabel: '备注',
                        		}
                        	]
                        }
                    ]
                },
                {
                    xtype: 'panel',
                    region: 'center',
                    layout: 'fit',
                    title: '个人主页',
                    items: [
                        {
                            xtype: 'gridpanel',
                            cls: 'grid-selected',
                            border: false,
                            id: 'createGridData',
                            title: '',
                            columns: [
                                {
                                    xtype: 'gridcolumn',
                                    cls: 'x-column-header-right',
                                    style: 'border-width: 2px',
                                    dataIndex: 'string',
                                    text: 'Loading...'
                                },
                                {
                                    xtype: 'gridcolumn',
                                    cls: 'x-column-header-right',
                                    text: 'MyColumn19'
                                },
                                {
                                    xtype: 'gridcolumn',
                                    text: 'MyColumn29'
                                }
                            ],
                            viewConfig: {
                                cls: 'x-grid-view-border'
                            }
                        }
                    ],
                    dockedItems: [
                        {
                            xtype: 'pagingtoolbar',
                            dock: 'bottom',
                            width: 360,
                            displayInfo: true
                        }
                    ]
                }
            ]
        });

        me.callParent(arguments);
    }
});