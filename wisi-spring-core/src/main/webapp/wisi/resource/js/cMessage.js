
Ext.cMessage = function(){
    var msgCt;

    function createBox(t, s,c,icon){
		return '<div class="'+c+'"><h3>' + t + '</h3><p>' + s + '</p></div>';
		//return '<div class="'+c+'"><table border="0"><tr><td rowspan="2" width="40"><img src="'+icon+'"/></td><td><h3>' + t + '</h3></td><tr><td><p>' + s + '</p></td></tr></table></div>';
	}
    return {
        info : function(title, format){
            if(!msgCt){
                msgCt = Ext.DomHelper.insertFirst(document.body, {id:'msg-div'}, true);
            }
            var s = Ext.String.format.apply(String, Array.prototype.slice.call(arguments, 1));
            var m = Ext.DomHelper.append(msgCt, createBox(title, s,'info','resource/images/common/message_info.png'), true);
            m.hide();
            m.slideIn('t').ghost("t", { delay: 2000, remove: true});
        },
		warning : function(title, format){
            if(!msgCt){
                msgCt = Ext.DomHelper.insertFirst(document.body, {id:'msg-div'}, true);
            }
            var s = Ext.String.format.apply(String, Array.prototype.slice.call(arguments, 1));
            var m = Ext.DomHelper.append(msgCt, createBox(title, s,'warning','resource/images/common/message_warning.png'), true);
            m.hide();
            m.slideIn('t').ghost("t", { delay: 3000, remove: true});
        },
		error : function(title, format){
            if(!msgCt){
                msgCt = Ext.DomHelper.insertFirst(document.body, {id:'msg-div'}, true);
            }
            var s = Ext.String.format.apply(String, Array.prototype.slice.call(arguments, 1));
            var m = Ext.DomHelper.append(msgCt, createBox(title, s,'error','resource/images/common/message_error.png'), true);
            m.hide();
            m.slideIn('t').ghost("t", { delay: 4000, remove: true});
        },
        init : function(){
            if(!msgCt){
                msgCt = Ext.DomHelper.insertFirst(document.body, {id:'msg-div'}, true);
            }

        }
    };
}();

Ext.onReady(Ext.cMessage.init, Ext.cMessage);