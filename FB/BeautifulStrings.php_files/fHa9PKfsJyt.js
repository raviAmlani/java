/*1359004174,173217823*/

if (self.CavalryLogger) { CavalryLogger.start_js(["0+yHt"]); }

__d("FeatureDetection",["UserAgent"],function(a,b,c,d,e,f){var g=b('UserAgent');e.exports={isFileAPISupported:function(){if(g.webkit()&&!g.chrome()&&g.windows())return false;return ('FileList' in window)&&('FormData' in window);}};});