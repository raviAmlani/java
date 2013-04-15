/*1359097443,178142495*/

if (self.CavalryLogger) { CavalryLogger.start_js(["q+xbW"]); }

__d("HackerCupInputDownloader",["AsyncRequest","Form","URI","copyProperties"],function(a,b,c,d,e,f){var g=b('AsyncRequest'),h=b('Form'),i=b('URI'),j=b('copyProperties');function k(l,m){l&&l.subscribe('confirm',this.onConfirm.bind(this,l,m));return this;}j(k.prototype,{onConfirm:function(l,m){new g('/ajax/hackercup/confirm_input').setData({pid:m}).setHandler(this.downloadInput.bind(this,m)).send();l.hide();return true;},downloadInput:function(l){h.post(i('/ajax/hackercup/input'),{pid:l});}});e.exports=k;});