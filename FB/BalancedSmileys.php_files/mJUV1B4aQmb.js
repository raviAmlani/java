/*1356755334,178142547*/

if (self.CavalryLogger) { CavalryLogger.start_js(["aezMX"]); }

function HackerCupAlertsController(a,b){copyProperties(this,{elem:$(a),round_id:b,timer_id:null});this.start();}copyProperties(HackerCupAlertsController.prototype,{start:function(){if(this.timer_id===null)this._runAlerts();return false;},_runAlerts:function(){var a=new AsyncRequest().setURI('/hackercup/ajax/alerts.php').setData({round_id:this.round_id}).send();this.timer_id=setTimeout(this._runAlerts.bind(this),60000);return false;}});