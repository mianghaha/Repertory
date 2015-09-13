Ext.define('wisi.controller.PageFrame', {
	extend: 'wisi.common.core.WisiController',
	views: [
		'frame.PageFrameContainer',
		'frame.PageFrameNorthContainer',
		'frame.PageFrameCenterPanel'
	],
	init: function(){
		this.control({
			"framePageFrameNorthContainer container[name='menuRootContainer']": {
				beforerender: this.onMenuRootContainerBeforeRender
			},
			"framePageFrameNorthContainer toolbar[id='systemMenuRootToolbar']": {
				beforerender: this.onMenuRootToolbarBeforeRender,
				afterrender: this.onMenuRootToolbarAfterRender
			},
			"framePageFrameNorthContainer toolbar[id='systemMenuRootToolbar'] button": {
				click: this.onMenuRootButtonClick,
				mouseover: this.onMenuRootButtonMouseover,
				mouseout: this.onMenuRootButtonMouseout
			},
			"framePageFrameCenterContainer panel[id='pageBodyLeftMenuPanel'] treepanel": {
				itemclick: this.onMenuTreepanelItemClick
			}
		});
	},
	onMenuRootContainerBeforeRender: function(component, eOpts){
		var bodyWidth = Ext.wisi.documentBody.getSize().width;
		//alert(component.width);
	},
	onMenuRootButtonClick: function(button, e, eOpts){
		// 点击更多按钮时直接返回
		if(button.name == 'moreButton'){return;}
		// 获取Toolbar对象
		var toolbar = button.up('toolbar');
		//var selectButtonNameField = toolbar.down('hiddenfield[name="selectButtonName"]');

		// 判断是否是初始点击的值
		if(button.name == selectedMenuButton){
		    return;
		}

		// 一级菜单样式赋值
		if(selectedMenuButton !== ""){
		    var selectButton = toolbar.down('button[name="' + selectedMenuButton +'"]');
		    selectButton.removeCls('north-menu-button-select-' + selectButton.width);
		}

		button.removeCls('north-menu-button-over-' + button.width);
		button.addCls('north-menu-button-select-' + button.width);
		
		// 将选中的菜单记录下来
		selectedMenuButton = button.name;
		
	    //Ext.getCmp('leftMenuContianerTop').setText(button.text);
	    // 设置一级菜单标题
	    Ext.getCmp('pageBodyLeftMenuPanel').setTitle(button.text);

	    // 加载左边树（加载节点）
	    var url = 'wisi/data/menu/'+button.name.replace('Button','')+'menutree.json';

	    var westPanel = Ext.getCmp("leftMenuTreePanel");

	    var onItemStoreload = function(store, node,records,successful,eOpts){
	        if(!successful){return;}
	        var treepanel = westPanel.down('treepanel');
	        var treeview = westPanel.down('treeview');
	        var record = records[0];

	        if(treepanel){
	            //this.getSelectionModel().select(0);
	            treepanel.getSelectionModel().select(records[0]);
	            //treepanel.fireEvent('itemclick',treepanel, record);
	        }

	    };
	    //Ext.getApplication().loadModule('home.HomePageController');
	    var itemStore = Ext.create('Ext.data.TreeStore', {
	        autoLoad: true,
	        fields: [
	        {
	            name: 'text'
	        },
	        {
	            name: 'menuid'
	        },
	        {
	            name: 'pageName'
	        },
	        {
	            name: 'menuUrl'
	        },
	        {
	            name: 'menuParent'
	        }
	        ],
	        proxy: {
	            type: 'ajax',
	            actionMethods: {read: 'POST'},
	            url: url,
	            reader: {
	                type: 'json',
	                root: 'listroot'
	            }
	        },
	        listeners:{
	            load:onItemStoreload
	        }
	    });

	    var itemPanel = Ext.create('Ext.tree.Panel', {
	        store: itemStore,
	        rootVisible: false,
	        useArrows: true,
	        cls: 'tree-selected',
	        bodyStyle: 'border-top:0px;',
	        border: false,
	        region: 'center'
	    });
	    westPanel.removeAll(true);
	    westPanel.add(itemPanel);
	},
	onMenuRootButtonMouseover: function(button, e, eOpts){
		if(selectedMenuButton == button.name){
            return;
        }
        button.addCls('north-menu-button-over-'+button.getWidth());
	},
	onMenuRootButtonMouseout: function(button, e, eOpts){
		if(selectedMenuButton == button.name){
            return;
        }
        button.removeCls('north-menu-button-over-'+button.getWidth());
        button.removeCls('north-menu-button-select-'+button.getWidth());
	},
	onMenuRootToolbarBeforeRender: function(component, eOpts){
		// 触发事件的对象
		var toolbar = component;
		// 菜单ToolBar的宽度
		var maxWidth;
		// 页面宽度
		var pageWidth = Ext.getBody().getSize().width;

		// 判断菜单ToolBar的合适宽度
		maxWidth = pageWidth - Constant.SYS_LOGO_WIDTH;
		
		var buttonData = [];
		// 提交请求获取一级菜单
		Ext.Ajax.request({
		    url: 'wisi/data/frame/RootMenu.json',
		    method: 'get',
		    async: false,
		    success: function(response){
		        var result = Ext.JSON.decode(response.responseText);
		        buttonData = result.records;
		    }
		});

		// 菜单按钮信息
		var buttonInfo;
		// 按钮
		var button;
		// 扩展按钮
		var expandButtons;
		// 按钮的长度是否超过ToolBar
		var isOverLine = false;
		// 按钮宽度
		var buttonWidth;

		// 遍历所有一级菜单信息
		for(var i = 0; i < buttonData.length; i++){
		    // 取得每一个菜单信息
		    buttonInfo = buttonData[i];

		    // 计算按钮宽度
		    var buttonNmLen = buttonInfo.text.length;
		    if(buttonNmLen <= Constant.BUTTON_NAME_LENGTH_4){
		        buttonWidth = Constant.MENU_BUTTON_WIDTH_80;
		    }else if(buttonNmLen > Constant.BUTTON_NAME_LENGTH_4 && buttonNmLen <= Constant.BUTTON_NAME_LENGTH_6){
		        buttonWidth = Constant.MENU_BUTTON_WIDTH_102;
		    }else{
		        buttonWidth = Constant.MENU_BUTTON_WIDTH_130;
		    }

		    maxWidth = maxWidth - buttonWidth - 2;

		    // 宽度不足时创建下拉菜单
		    if(maxWidth < Constant.MENU_BUTTON_WIDTH_80){
		        isOverLine = true;
		        button = Ext.create('Ext.menu.Item',{
		            name: buttonInfo.name,
		            text: buttonInfo.text,
		            icon:'wisi/resource/images/frame/'+buttonInfo.icon
		        });
		    }else{
		        button = Ext.create('Ext.button.Button',{
		            name: buttonInfo.name,
		            text: buttonInfo.text,
		            ui: 'menu-button-root',
		            height: 75,
		            width: buttonWidth,
		            iconAlign: 'top',
		            scale: 'large',
		            icon: 'wisi/resource/images/common/' + buttonInfo.icon
		        });
		    }
		    if(isOverLine){
		        if(!expandButtons){
		            expandButtons = Ext.create('Ext.button.Button',{
		                text:'更多',
		                name:'moreButton',
		                ui: 'menu-button-root',
		                width: Constant.MENU_BUTTON_WIDTH_80,
		                height: 75,
		                iconAlign: 'top',
		                scale: 'large',
		                icon: 'wisi/resource/images/common/calculatortool.png',
		                menu: {
		                    xtype: 'menu',
		                    id: 'moreMenuButton',
		                    border: 0
		                }
		            });
		            expandButtons.menu.add(button);
		            toolbar.add(expandButtons);
		        }else{
		            expandButtons.menu.add(button);
		        }

		    }else{
		        toolbar.add(button);
		    }
		}
	},
	onMenuRootToolbarAfterRender: function(component, eOpts){
		var button = null;
		
		var toolbar = Ext.getCmp("systemMenuRootToolbar");
		
		buttons = toolbar.query('button');

		buttons = toolbar.query('button');
		if(buttons.length>0){
		    for(var i=0; i<buttons.length; i++){
		        if(button){
		            break;
		        }
		        button = buttons[i];
		    }
		}

		var gotoView = function(){
		    if(button){
		        button.fireEvent('click',button,null,null,'start');
		    }
		};
		gotoView();
	},
	onMenuTreepanelItemClick: function(dataview, record, item, index, e, eOpts){
		// 点击菜单节点，显示页面
		if(record){
		    while(!record.data.leaf){
		        record = record.childNodes[0];
		        if(!record) return;
		    }
		}else{
		    return;
		}

		if(!index){
		    index = 0;
		}

		// 获取页面名称
		var pageName = record.data.pageName;
		if(!pageName || pageName === ""){
		    return;
		}

		// 取得菜单节点的URL地址
		var module = record.data.menuUrl;
		// 动态加载Controller
		//Ext.getApplication().loadModule(module+'Controller');


		// 加载Tab插件
		var scriptEls = document.getElementsByTagName('script');
		var path = scriptEls[scriptEls.length - 1].src;
		//alert(path);
		var i = 4;
		while (i--) {
	        path = path.substring(0, path.lastIndexOf('/'));
	        if(path.substring(path.length - 4, path.length) === 'wisi'){
	        	break;
	        }
	    }
		//alert(path);
		Ext.Loader.setPath('Ext.ux', path+'/extapi/ux');
		Ext.require([
		    'Ext.tab.*',
		    'Ext.ux.TabCloseMenu'
		]);

		// 获取TabPanel
		var tabsPanel = Ext.getCmp("bodyMainTabPanel");

		if(!tabsPanel){
		    tabsPanel = Ext.widget('tabpanel', {
		        region: 'center',
		        id: 'bodyMainTabPanel',
		        ui: 'tabbar-background',
		        plugins: Ext.create('Ext.ux.TabCloseMenu', {
		            extraItemsTail: [
		                '-',
		                {
		                    text: '允许是否关闭',
		                    checked: true,
		                    hideOnClick: true,
		                    handler: function (item) {
		                        currentItem.tab.setClosable(item.checked);
		                    }
		                },
		                '-',
		                {
		                    text: '允许是否可用',
		                    checked: true,
		                    hideOnClick: true,
		                    handler: function(item) {
		                        currentItem.tab.setDisabled(!item.checked);
		                    }
		                }
		            ],
		            listeners: {
		                beforemenu: function (menu, item) {
		                    var enabled = menu.child('[text="允许是否可用"]');
		                    menu.child('[text="允许是否关闭"]').setChecked(item.closable);
		                    if (item.tab.active) {
		                        enabled.disable();
		                    } else {
		                        enabled.enable();
		                        enabled.setChecked(!item.tab.isDisabled());
		                    }

		                    currentItem = item;
		                }
		            }
		        })
		    });

		    Ext.getCmp('bodyMainPanel').add(tabsPanel);
		}



		//创建Tab选项卡
		var tabWidth;
		var tabLength = record.data.text.length;

		if(tabLength <= 4){
		    tabWidth = 115;
		}else if(tabLength === 5){
		    tabWidth = 125;
		}else if(tabLength === 6){
		    tabWidth = 135;
		}else{
		    tabWidth = 160;
		}

		// 判断TabPanel是否已经创建
		var checktabs = Ext.getCmp(pageName + "TabPanel");
		if(checktabs){
		    checktabs.show();
		    return;
		}
		if(tabsPanel.items.length === 0){
		    tabSelected = pageName + "TabConfig";
		}
		tabsPanel.add({
		    closable: true,
		    html: '',
		    iconCls: 'tabs',
		    title: record.data.text,
		    id: pageName + "TabPanel",
		    tabConfig: {
		        xtype: 'tab',
		        id: pageName + "TabConfig",
		        ui: 'background-active',
		        height:28,
		        width:tabWidth,
		        icon: 'resource/images/common/calculatortool.png'
		    },
		    layout:'fit'
		}).show();

		//添加显示页面
		//var model = btn.name;
		var tabs = pageName + "TabPanel";
		var tabFind = Ext.getCmp(tabs);
		//Ext.getApplication().loadModule(module+'Controller');
		Ext.wisi.getController(module);
		var datagridPanel = Ext.create('wisi.view.'+module, {});

		tabFind.removeAll(true);
		tabFind.add(datagridPanel);
	}
});