Ext.define('wisi.controller.chart.DynamicChart', {
	extend: 'wisi.common.core.WisiController',
	models: [
		'chart.DynamicChart',
		'chart.DynamicLineChart',
		'chart.DynamicPieChart'
	],
	stores: [
		'chart.DynamicChart',
		'chart.DynamicLineChart',
		'chart.DynamicPieChart'
	],
	views: [
		'chart.DynamicChart'
	],
	init: function(){
		this.control({
			"chartDynamicChartContainer button[name='createChartButton']": {
				click: this.onCreateChartButtonClick
			}
		});
	},
	onCreateChartButtonClick: function(button, e, eOpts){
		var chartType = Ext.getCmp('createChartType').value;
		
		if(chartType === '1'){
			this.createLineChart();
		}else if(chartType === '2'){
			this.createPieChart();
		}
		/*
		var chartPanel = Ext.getCmp('daynamicChartLeftPanel');
		chartPanel.removeAll(true);
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
		Ext.Loader.setPath('wisi.common.util', path+'/common/util');
		Ext.require([
			'wisi.common.util.WisiCreateLineChart'
		]);
		
		var chartStore = this.getStore('chart.DynamicLineChart');
		var lineChart = Ext.create('wisi.common.util.WisiCreateLineChart');
		
		var arrYFields = [];
		arrYFields.push('objValue');
		arrYFields.push('objValue1');
		arrYFields.push('objValue2');
		var arrLegendTitle = [];
		arrLegendTitle.push('测试1');
		arrLegendTitle.push('测试2');
		arrLegendTitle.push('测试3');
		
		lineChart.xFields = 'objTime';
		lineChart.yFields = arrYFields;
		lineChart.legends = arrLegendTitle;
		lineChart.dataStore = chartStore;
		chartPanel.add(lineChart.create());
		*/
		//alert(Ext.getCmp('createChartType').value);
	},
	createLineChart: function(){
		var chartPanel = Ext.getCmp('daynamicChartLeftPanel');
		chartPanel.removeAll(true);
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
		Ext.Loader.setPath('wisi.common.util', path+'/common/util');
		Ext.require([
			'wisi.common.util.WisiCreateLineChart'
		]);
		
		var chartStore = this.getStore('chart.DynamicLineChart');
		var lineChart = Ext.create('wisi.common.util.WisiCreateLineChart');
		
		var arrYFields = [];
		arrYFields.push('objValue');
		arrYFields.push('objValue1');
		arrYFields.push('objValue2');
		var arrLegendTitle = [];
		arrLegendTitle.push('测试1');
		arrLegendTitle.push('测试2');
		arrLegendTitle.push('测试3');
		/*
		chartPanel.add(lineChart.create(chartStore, {
		    xField: 'objTime',
		    yFields: arrYFields,
		    title: arrLegendTitle
		}));
		*/
		
		lineChart.xFields = 'objTime';
		lineChart.yFields = arrYFields;
		lineChart.legends = arrLegendTitle;
		lineChart.dataStore = chartStore;
		chartPanel.add(lineChart.create());
		
		//alert(Ext.getCmp('createChartType').value);
	},
	createPieChart: function(button, e, eOpts){
		var chartPanel = Ext.getCmp('daynamicChartLeftPanel');
		chartPanel.removeAll(true);
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
		Ext.Loader.setPath('wisi.common.chart', path+'/common/chart');
		Ext.require([
			'wisi.common.chart.WisiCreatePieChart'
		]);
		
		var chartStore = this.getStore('chart.DynamicPieChart');
		var pieChart = Ext.create('wisi.common.chart.WisiCreatePieChart');
		
		var arrYFields = [];
		arrYFields.push('objValue');
		var arrLegendTitle = [];
		arrLegendTitle.push('name');
		
		pieChart.donut = 35;
		pieChart.fields = arrYFields;
		pieChart.legends = arrLegendTitle;
		pieChart.dataStore = chartStore;
		chartPanel.add(pieChart.create());
		
		//alert(Ext.getCmp('createChartType').value);
	}
});